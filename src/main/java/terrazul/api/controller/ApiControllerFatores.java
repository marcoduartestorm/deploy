package terrazul.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import terrazul.api.dtos.ApiDtoAdministrador;
import terrazul.api.dtos.ApiDtoFatoresAgua;
import terrazul.api.dtos.ApiDtoFatoresEnergiaEletrica;
import terrazul.api.dtos.ApiDtoFatoresResiduos;
import terrazul.api.models.ApiModelAdministrador;
import terrazul.api.models.ApiModelFatoresAgua;
import terrazul.api.models.ApiModelFatoresEnergiaEletrica;
import terrazul.api.models.ApiModelFatoresResiduos;
import terrazul.api.services.ApiServiceAdministrador;
import terrazul.api.services.ApiServiceFatoresAgua;
import terrazul.api.services.ApiServiceFatoresEnergiaEletrica;
import terrazul.api.services.ApiServiceFatoresResiduos;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/fatores")
public class ApiControllerFatores {
    final ApiServiceFatoresAgua apiServiceFatoresAgua;
    final ApiServiceFatoresEnergiaEletrica apiServiceFatoresEnergiaEletrica;
    final ApiServiceFatoresResiduos apiServiceFatoresResiduos;
    final ApiServiceAdministrador apiServiceAdministrador;
    
    public ApiControllerFatores(ApiServiceFatoresAgua apiServiceFatoresAgua, ApiServiceFatoresEnergiaEletrica apiServiceFatoresEnergiaEletrica, ApiServiceFatoresResiduos apiServiceFatoresResiduos, ApiServiceAdministrador apiServiceAdministrador) {
        this.apiServiceFatoresAgua = apiServiceFatoresAgua;
        this.apiServiceFatoresEnergiaEletrica = apiServiceFatoresEnergiaEletrica;
        this.apiServiceFatoresResiduos = apiServiceFatoresResiduos;
        this.apiServiceAdministrador = apiServiceAdministrador;
    }

    @PostMapping("/agua/salvar")
    public ResponseEntity<Object> saveFatorAgua(@RequestParam String email, @RequestParam String senha, @RequestBody @Valid ApiDtoFatoresAgua apiDtoFatoresAgua) {
        List<ApiModelAdministrador> adms = apiServiceAdministrador.findAll();
        for(ApiModelAdministrador adm1 : adms) {
        	if(adm1.getEmail().equals(email) && adm1.getSenha().equals(senha)) {
        		var apiModelFatoresAgua = new ApiModelFatoresAgua();
                BeanUtils.copyProperties(apiDtoFatoresAgua, apiModelFatoresAgua);
                return ResponseEntity.status(HttpStatus.CREATED).body(apiServiceFatoresAgua.save(apiModelFatoresAgua));
        	}
        }
    	
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso proibido!");
    }
    
    @PostMapping("/agua/listar")
    public ResponseEntity<Object> getAdministradores(@RequestBody @Valid ApiDtoAdministrador apiDtoAdministrador) {
    	List<ApiModelAdministrador> users = apiServiceAdministrador.findAll();
    	
    	for(ApiModelAdministrador u : users) {
    		if(u.getEmail().equals(apiDtoAdministrador.getEmail()) && u.getSenha().equals(apiDtoAdministrador.getSenha()) && u.getNome().equals(apiDtoAdministrador.getNome())) {
    			return ResponseEntity.status(HttpStatus.OK).body(apiServiceFatoresAgua.findAll());
    		}
    	}
    	
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso proibido!");
    }
	
    @GetMapping("/agua/{id}")
    public ResponseEntity<Object> getOne(@PathVariable(value = "id") UUID id) {
    	Optional<ApiModelFatoresAgua> ApiModelOptional = apiServiceFatoresAgua.findById(id);
        if (!ApiModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fator não encontrado no banco de dados!");
        }
    	
        return ResponseEntity.status(HttpStatus.OK).body(ApiModelOptional.get());
    }

    @DeleteMapping("/agua/{id}")
    public ResponseEntity<Object> deleteOne(@PathVariable(value = "id") UUID id) {
        Optional<ApiModelFatoresAgua> apiModelOptional = apiServiceFatoresAgua.findById(id);
        if (!apiModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fator de água não encontrado!");
        }
        apiServiceFatoresAgua.delete(apiModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Fator deletado com sucesso!");
    }

    @PutMapping("/agua/{id}")
    public ResponseEntity<Object> updateOne(@PathVariable(value = "id") UUID id, @RequestBody @Valid ApiDtoFatoresAgua apiDtoFatoresAgua) {
        Optional<ApiModelFatoresAgua> apiModelOptional = apiServiceFatoresAgua.findById(id);
        if (!apiModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Impossível atualizar: Administrador não encontrado!");
        }
        ApiModelFatoresAgua apiModelFatoresAgua = apiModelOptional.get();
        BeanUtils.copyProperties(apiDtoFatoresAgua, apiModelFatoresAgua);
        return ResponseEntity.status(HttpStatus.OK).body(apiServiceFatoresAgua.save(apiModelFatoresAgua));
    }
    
    //Endpoints de Energia Eletrica
    
    @PostMapping("/energiaeletrica/salvar")
    public ResponseEntity<Object> saveFatoresEnergiaEletrica(@RequestParam String email, @RequestParam String senha, @RequestBody @Valid ApiDtoFatoresEnergiaEletrica apiDtoFatoresEnergiaEletrica) {
        List<ApiModelAdministrador> adms = apiServiceAdministrador.findAll();
        for(ApiModelAdministrador adm1 : adms) {
        	if(adm1.getEmail().equals(email) && adm1.getSenha().equals(senha)) {
        		var apiModelFatoresEnergiaEletrica = new ApiModelFatoresEnergiaEletrica();
                BeanUtils.copyProperties(apiDtoFatoresEnergiaEletrica, apiModelFatoresEnergiaEletrica);
                return ResponseEntity.status(HttpStatus.CREATED).body(apiServiceFatoresEnergiaEletrica.save(apiModelFatoresEnergiaEletrica));
        	}
        }
    	
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso proibido!");
    }
    
    @PostMapping("/energiaeletrica/listar")
    public ResponseEntity<Object> getEnergiaEletrica(@RequestBody @Valid ApiDtoAdministrador apiDtoAdministrador) {
    	List<ApiModelAdministrador> users = apiServiceAdministrador.findAll();
    	for(ApiModelAdministrador u : users) {
    		if(u.getEmail().equals(apiDtoAdministrador.getEmail()) && u.getSenha().equals(apiDtoAdministrador.getSenha()) && u.getNome().equals(apiDtoAdministrador.getNome())) {
    			return ResponseEntity.status(HttpStatus.OK).body(apiServiceFatoresEnergiaEletrica.findAll());
    		}
    	}
    	
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso proibido!");
    }
	
    @GetMapping("/energiaeletrica/{id}")
    public ResponseEntity<Object> getOneEnergiaEletrica(@PathVariable(value = "id") UUID id) {
    	Optional<ApiModelFatoresEnergiaEletrica> ApiModelOptional = apiServiceFatoresEnergiaEletrica.findById(id);
        if (!ApiModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fator não encontrado no banco de dados!");
        }
    	
        return ResponseEntity.status(HttpStatus.OK).body(ApiModelOptional.get());
    }

    @DeleteMapping("/energiaeletrica/{id}")
    public ResponseEntity<Object> deleteOneEnergiaEletrica(@PathVariable(value = "id") UUID id) {
        Optional<ApiModelFatoresEnergiaEletrica> apiModelOptional = apiServiceFatoresEnergiaEletrica.findById(id);
        if (!apiModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fator de água não encontrado!");
        }
        apiServiceFatoresEnergiaEletrica.delete(apiModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Fatores deletado com sucesso!");
    }

    @PutMapping("/energiaeletrica/{id}")
    public ResponseEntity<Object> updateOneEnergiaEletrica(@PathVariable(value = "id") UUID id, @RequestBody @Valid ApiDtoFatoresEnergiaEletrica apiDtoFatoresEnergiaEletrica) {
        Optional<ApiModelFatoresEnergiaEletrica> apiModelOptional = apiServiceFatoresEnergiaEletrica.findById(id);
        if (!apiModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Impossível atualizar: Fatores de Energia Elétrica não encontrado!");
        }
        ApiModelFatoresEnergiaEletrica apiModelFatoresEnergiaEletrica = apiModelOptional.get();
        BeanUtils.copyProperties(apiDtoFatoresEnergiaEletrica, apiModelFatoresEnergiaEletrica);
        return ResponseEntity.status(HttpStatus.OK).body(apiServiceFatoresEnergiaEletrica.save(apiModelFatoresEnergiaEletrica));
    }
    
    // Residuos
    
    @PostMapping("/residuos/salvar")
    public ResponseEntity<Object> saveFatorResiduos(@RequestParam String email, @RequestParam String senha, @RequestBody @Valid ApiDtoFatoresResiduos apiDtoFatoresResiduos) {
        List<ApiModelAdministrador> adms = apiServiceAdministrador.findAll();
        for(ApiModelAdministrador adm1 : adms) {
        	if(adm1.getEmail().equals(email) && adm1.getSenha().equals(senha)) {
        		var apiModelFatoresResiduos = new ApiModelFatoresResiduos();
                BeanUtils.copyProperties(apiDtoFatoresResiduos, apiModelFatoresResiduos);
                return ResponseEntity.status(HttpStatus.CREATED).body(apiServiceFatoresResiduos.save(apiModelFatoresResiduos));
        	}
        }
    	
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso proibido!");
    }
    
    @PostMapping("/residuos/listar")
    public ResponseEntity<Object> getResiduos(@RequestBody @Valid ApiDtoAdministrador apiDtoAdministrador) {
    	List<ApiModelAdministrador> users = apiServiceAdministrador.findAll();
    	
    	for(ApiModelAdministrador u : users) {
    		if(u.getEmail().equals(apiDtoAdministrador.getEmail()) && u.getSenha().equals(apiDtoAdministrador.getSenha()) && u.getNome().equals(apiDtoAdministrador.getNome())) {
    			return ResponseEntity.status(HttpStatus.OK).body(apiServiceFatoresResiduos.findAll());
    		}
    	}
    	
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso proibido!");
    }
	
    @GetMapping("/residuos/{id}")
    public ResponseEntity<Object> getOneResiduos(@PathVariable(value = "id") UUID id) {
    	Optional<ApiModelFatoresResiduos> ApiModelOptional = apiServiceFatoresResiduos.findById(id);
        if (!ApiModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fator não encontrado no banco de dados!");
        }
    	
        return ResponseEntity.status(HttpStatus.OK).body(ApiModelOptional.get());
    }

    @DeleteMapping("/residuos/{id}")
    public ResponseEntity<Object> deleteOneResiduos(@PathVariable(value = "id") UUID id) {
        Optional<ApiModelFatoresResiduos> apiModelOptional = apiServiceFatoresResiduos.findById(id);
        if (!apiModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fator de água não encontrado!");
        }
        apiServiceFatoresResiduos.delete(apiModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Fatores deletado com sucesso!");
    }

    @PutMapping("/residuos/{id}")
    public ResponseEntity<Object> updateOneResiduos(@PathVariable(value = "id") UUID id, @RequestBody @Valid ApiDtoFatoresResiduos apiDtoFatoresResiduos) {
        Optional<ApiModelFatoresResiduos> apiModelOptional = apiServiceFatoresResiduos.findById(id);
        if (!apiModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Impossível atualizar: Fator de resíduos não encontrado!");
        }
        ApiModelFatoresResiduos apiModelFatoresResiduos = apiModelOptional.get();
        BeanUtils.copyProperties(apiDtoFatoresResiduos, apiModelFatoresResiduos);
        return ResponseEntity.status(HttpStatus.OK).body(apiServiceFatoresResiduos.save(apiModelFatoresResiduos));
    }
}