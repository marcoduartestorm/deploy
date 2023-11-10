package terrazul.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import terrazul.api.dtos.ApiDtoAdministrador;
import terrazul.api.models.ApiModelAdministrador;
import terrazul.api.services.ApiServiceAdministrador;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/administradores")

public class ApiControllerAdministrador {
    final ApiServiceAdministrador apiService;
    
    public ApiControllerAdministrador(ApiServiceAdministrador apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/salvar")
    public ResponseEntity<Object> saveAdministrador(@RequestParam String email, @RequestParam String senha, @RequestBody @Valid ApiDtoAdministrador apiDto) { 	
        List<ApiModelAdministrador> adm = apiService.findAll();
        for(ApiModelAdministrador adm2 : adm) {
        	if(adm2.getEmail().equals(email) && adm2.getSenha().equals(senha)) {
        		if (apiService.existsEmail(apiDto.getEmail())) {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: email já existe no banco de dados!");
                }
        		var apiModelAdministrador = new ApiModelAdministrador();
                BeanUtils.copyProperties(apiDto, apiModelAdministrador);
                return ResponseEntity.status(HttpStatus.CREATED).body(apiService.save(apiModelAdministrador));
        	}
        }
   
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso proibido!");
    }
    
    @PostMapping("/login")
    public boolean validateAdministrador(@RequestBody @Valid ApiDtoAdministrador apiDto) {
    	List<ApiModelAdministrador> users = apiService.findAll();
    	
    	for(ApiModelAdministrador u : users) {
    		if(u.getEmail().equals(apiDto.getEmail()) && u.getSenha().equals(apiDto.getSenha())) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    @PostMapping("/listar")
    public ResponseEntity<Object> getAdministradores(@RequestBody @Valid ApiDtoAdministrador apiDtoAdministrador) {
    	List<ApiModelAdministrador> users = apiService.findAll();
    	
    	for(ApiModelAdministrador u : users) {
    		if(u.getEmail().equals(apiDtoAdministrador.getEmail()) && u.getSenha().equals(apiDtoAdministrador.getSenha()) && u.getNome().equals(apiDtoAdministrador.getNome())) {
    			List<ApiModelAdministrador> adms = apiService.findAll();
    			Collections.sort(adms);
    			return ResponseEntity.status(HttpStatus.OK).body(adms);
    		}
    	}
    	
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso proibido!");
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable(value = "id") UUID id) {
    	Optional<ApiModelAdministrador> ApiModelOptional = apiService.findById(id);
        if (!ApiModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Administrador não encontrado no banco de dados!");
        }
    	
        return ResponseEntity.status(HttpStatus.OK).body(ApiModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOne(@PathVariable(value = "id") UUID id) {
        Optional<ApiModelAdministrador> apiModelOptional = apiService.findById(id);
        if (!apiModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Administrador não encontrado!");
        }
        apiService.delete(apiModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Administrador deletado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateOne(@PathVariable(value = "id") UUID id, @RequestBody @Valid ApiDtoAdministrador apiDto) {
        Optional<ApiModelAdministrador> apiModelOptional = apiService.findById(id);
        if (!apiModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Impossível atualizar: Administrador não encontrado!");
        }
        ApiModelAdministrador apiModel = apiModelOptional.get();
        BeanUtils.copyProperties(apiDto, apiModel);
        return ResponseEntity.status(HttpStatus.OK).body(apiService.save(apiModel));
    }
}