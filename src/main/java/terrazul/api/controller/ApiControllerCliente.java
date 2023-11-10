package terrazul.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import terrazul.api.dtos.ApiDtoAdministrador;
import terrazul.api.dtos.ApiDtoCliente;
import terrazul.api.models.ApiModelAdministrador;
import terrazul.api.models.ApiModelCliente;
import terrazul.api.services.ApiServiceAdministrador;
import terrazul.api.services.ApiServiceCliente;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/clientes")
public class ApiControllerCliente {
    final ApiServiceCliente apiServiceCliente;
    final ApiServiceAdministrador apiService;
    
    public ApiControllerCliente(ApiServiceCliente apiServiceCliente, ApiServiceAdministrador apiService) {
        this.apiServiceCliente = apiServiceCliente;
        this.apiService = apiService;
    }

    @PostMapping("/salvar")
    public ResponseEntity<Object> saveCliente(@RequestParam String email, @RequestParam String senha, @RequestBody @Valid ApiDtoCliente apiDtoCliente) {
        List<ApiModelAdministrador> adms = apiService.findAll();
        for(ApiModelAdministrador adm1 : adms) {
        	if(adm1.getEmail().equals(email) && adm1.getSenha().equals(senha)) {
        		if (apiServiceCliente.existsByCpf(apiDtoCliente.getCpf())) {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: cpf já existe no banco de dados!");
                }
        		var apiModelCliente = new ApiModelCliente();
                BeanUtils.copyProperties(apiDtoCliente, apiModelCliente);
                return ResponseEntity.status(HttpStatus.CREATED).body(apiServiceCliente.save(apiModelCliente));
        	}
        }
        
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso proibido!");
    }
    
    @PostMapping("/listar")
    public ResponseEntity<Object> getClientes(@RequestBody @Valid ApiDtoAdministrador apiDtoAdministrador) {
    	List<ApiModelAdministrador> users = apiService.findAll();
    	
    	for(ApiModelAdministrador u : users) {
    		if(u.getEmail().equals(apiDtoAdministrador.getEmail()) && u.getSenha().equals(apiDtoAdministrador.getSenha()) && u.getNome().equals(apiDtoAdministrador.getNome())) {
    			List<ApiModelCliente> clientes = apiServiceCliente.findAll();
    			Collections.sort(clientes);
    			return ResponseEntity.status(HttpStatus.OK).body(clientes);
    		}
    	}
    	
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso proibido!");
    }
	
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable(value = "id") UUID id) {
    	Optional<ApiModelCliente> ApiModelOptional = apiServiceCliente.findById(id);
        if (!ApiModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado no banco de dados!");
        }
    	
        return ResponseEntity.status(HttpStatus.OK).body(ApiModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOne(@PathVariable(value = "id") UUID id) {
        Optional<ApiModelCliente> apiModelOptional = apiServiceCliente.findById(id);
        if (!apiModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado no banco de dados!");
        }
        apiServiceCliente.delete(apiModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateOne(@PathVariable(value = "id") UUID id, @RequestBody @Valid ApiDtoCliente apiDtoCliente) {
        Optional<ApiModelCliente> apiModelOptional = apiServiceCliente.findById(id);
        if (!apiModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Impossível atualizar: cliente não encontrado no banco de dados!");
        }
        ApiModelCliente apiModelCliente = apiModelOptional.get();
        BeanUtils.copyProperties(apiDtoCliente, apiModelCliente);
        return ResponseEntity.status(HttpStatus.OK).body(apiServiceCliente.save(apiModelCliente));
    }
}