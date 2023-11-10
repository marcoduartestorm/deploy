package terrazul.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import terrazul.api.dtos.ApiDtoAdministrador;
import terrazul.api.dtos.ApiDtoEmissao;
import terrazul.api.models.ApiModelAdministrador;
import terrazul.api.models.ApiModelEmissao;
import terrazul.api.models.ApiModelFatoresAgua;
import terrazul.api.models.ApiModelFatoresEnergiaEletrica;
import terrazul.api.models.ApiModelFatoresResiduos;
import terrazul.api.services.ApiServiceAdministrador;
import terrazul.api.services.ApiServiceEmissao;
import terrazul.api.services.ApiServiceFatoresAgua;
import terrazul.api.services.ApiServiceFatoresEnergiaEletrica;
import terrazul.api.services.ApiServiceFatoresResiduos;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/emissoes")
public class ApiControllerEmissao {
    final ApiServiceEmissao apiServiceEmissao;
    final ApiServiceFatoresAgua apiServiceFatoresAgua;
    final ApiServiceFatoresEnergiaEletrica apiServiceFatoresEnergiaEletrica;
    final ApiServiceFatoresResiduos apiServiceFatoresResiduos;
    final ApiServiceAdministrador apiServiceAdministrador;
    
    public ApiControllerEmissao(ApiServiceEmissao apiServiceEmissao, ApiServiceFatoresAgua apiServiceFatorAgua, ApiServiceFatoresEnergiaEletrica apiServiceFatoresEnergiaEletrica, ApiServiceFatoresResiduos apiServiceFatoresResiduos, ApiServiceAdministrador apiServiceAdministrador) {
        this.apiServiceEmissao = apiServiceEmissao;
        this.apiServiceFatoresAgua = apiServiceFatorAgua;
        this.apiServiceFatoresEnergiaEletrica = apiServiceFatoresEnergiaEletrica;
        this.apiServiceFatoresResiduos = apiServiceFatoresResiduos;
        this.apiServiceAdministrador = apiServiceAdministrador;
    }

    @PostMapping("/salvar")
    public ResponseEntity<Object> saveEmissao(@RequestParam String email, @RequestParam String senha, @RequestBody @Valid ApiDtoEmissao apiDtoEmissao) {
       	List<ApiModelEmissao> lista = apiServiceEmissao.findAll();
       	ApiModelEmissao apiModelEmissao = new ApiModelEmissao();
       	float gastoReal = 0;
       	float fator = 0;
       	String str = apiDtoEmissao.getMes();
    	
    	List<ApiModelAdministrador> adms = apiServiceAdministrador.findAll();
    	for(ApiModelAdministrador adm1 : adms) {
    		if(adm1.getEmail().equals(email) && adm1.getSenha().equals(senha)) {
    			for(ApiModelEmissao e : lista) {
    	    		if(e.getCpf().equalsIgnoreCase(apiDtoEmissao.getCpf()) && e.getTipoEmissao().equalsIgnoreCase(apiDtoEmissao.getTipoEmissao()) && e.getMes().equalsIgnoreCase(apiDtoEmissao.getMes()) && e.getAno().equalsIgnoreCase(apiDtoEmissao.getAno())) {
    	    			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: tipo de emissão, cpf, mes e ano já existem no banco de dados!");
    	    		}
    	    	}
    			if(apiDtoEmissao.getTipoEmissao().equalsIgnoreCase("agua")) {
    	    		List<ApiModelFatoresAgua> apiModelFatoresAgua = apiServiceFatoresAgua.findAll();
    	    		for(ApiModelFatoresAgua a : apiModelFatoresAgua) {
    	    			fator = Float.parseFloat(a.getFator());
    	    		}
    	    	} else if(apiDtoEmissao.getTipoEmissao().equalsIgnoreCase("energiaeletrica")) {
    	    		List<ApiModelFatoresEnergiaEletrica> apiModelFatoresEnergiaEletrica = apiServiceFatoresEnergiaEletrica.findAll();
    	    		for(ApiModelFatoresEnergiaEletrica e : apiModelFatoresEnergiaEletrica) {
    	    			if(str.equalsIgnoreCase("janeiro")) {
    	    				fator = Float.parseFloat(e.getJaneiro());
    	        		} else if(str.equalsIgnoreCase("fevereiro")) {
    	        			fator = Float.parseFloat(e.getFevereiro());
    	        		} else if(str.equalsIgnoreCase("março")) {
    	        			fator = Float.parseFloat(e.getMarco());
    	        		} else if(str.equalsIgnoreCase("abril")) {
    	        			fator = Float.parseFloat(e.getAbril());
    	        		}else if(str.equalsIgnoreCase("maio")) {
    	        			fator = Float.parseFloat(e.getMaio());
    	        		}else if(str.equalsIgnoreCase("junho")) {
    	        			fator = Float.parseFloat(e.getJunho());
    	        		}else if(str.equalsIgnoreCase("julho")) {
    	        			fator = Float.parseFloat(e.getJulho());
    	        		}else if(str.equalsIgnoreCase("agosto")) {
    	        			fator = Float.parseFloat(e.getAgosto());
    	        		}else if(str.equalsIgnoreCase("setembro")) {
    	        			fator = Float.parseFloat(e.getSetembro());
    	        		}else if(str.equalsIgnoreCase("outubro")) {
    	        			fator = Float.parseFloat(e.getOutubro());
    	        		}else if(str.equalsIgnoreCase("novembro")) {
    	        			fator = Float.parseFloat(e.getNovembro());
    	        		}else if(str.equalsIgnoreCase("dezembro")) {
    	        			fator = Float.parseFloat(e.getDezembro());
    	        		}
    	    		}
    	    	} else if(apiDtoEmissao.getTipoEmissao().equalsIgnoreCase("residuos")) {
    	    		List<ApiModelFatoresResiduos> apiModelFatoresResiduos = apiServiceFatoresResiduos.findAll();
    	    		for(ApiModelFatoresResiduos e : apiModelFatoresResiduos) {
    	    			if(str.equalsIgnoreCase("janeiro")) {
    	    				fator = Float.parseFloat(e.getJaneiro());
    	        		} else if(str.equalsIgnoreCase("fevereiro")) {
    	        			fator = Float.parseFloat(e.getFevereiro());
    	        		} else if(str.equalsIgnoreCase("março")) {
    	        			fator = Float.parseFloat(e.getMarco());
    	        		} else if(str.equalsIgnoreCase("abril")) {
    	        			fator = Float.parseFloat(e.getAbril());
    	        		}else if(str.equalsIgnoreCase("maio")) {
    	        			fator = Float.parseFloat(e.getMaio());
    	        		}else if(str.equalsIgnoreCase("junho")) {
    	        			fator = Float.parseFloat(e.getJunho());
    	        		}else if(str.equalsIgnoreCase("julho")) {
    	        			fator = Float.parseFloat(e.getJulho());
    	        		}else if(str.equalsIgnoreCase("agosto")) {
    	        			fator = Float.parseFloat(e.getAgosto());
    	        		}else if(str.equalsIgnoreCase("setembro")) {
    	        			fator = Float.parseFloat(e.getSetembro());
    	        		}else if(str.equalsIgnoreCase("outubro")) {
    	        			fator = Float.parseFloat(e.getOutubro());
    	        		}else if(str.equalsIgnoreCase("novembro")) {
    	        			fator = Float.parseFloat(e.getNovembro());
    	        		}else if(str.equalsIgnoreCase("dezembro")) {
    	        			fator = Float.parseFloat(e.getDezembro());
    	        		}
    	    		}
    	    	}
    	    	
    	    	gastoReal = Float.parseFloat(apiDtoEmissao.getConsumo()) * fator;
    	    	BeanUtils.copyProperties(apiDtoEmissao, apiModelEmissao);
    			String gastoStr = gastoReal + "";
    			apiModelEmissao.setConsumo(gastoStr);
    			
    	        return ResponseEntity.status(HttpStatus.CREATED).body(apiServiceEmissao.save(apiModelEmissao));
    		}
    	}
    	
    	return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso proibido!");
    }
   
    
    @PostMapping("/listar")
    public ResponseEntity<Object> getClientes(@RequestBody @Valid ApiDtoAdministrador apiDtoAdministrador) {
    	List<ApiModelAdministrador> users = apiServiceAdministrador.findAll();
    	
    	for(ApiModelAdministrador u : users) {
    		if(u.getEmail().equals(apiDtoAdministrador.getEmail()) && u.getSenha().equals(apiDtoAdministrador.getSenha()) && u.getNome().equals(apiDtoAdministrador.getNome())) {
    			List<ApiModelEmissao> emissoes = apiServiceEmissao.findAll();
    			Collections.sort(emissoes);
    			return ResponseEntity.status(HttpStatus.OK).body(emissoes);
    		}
    	}
    	
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso proibido!");
    }
     
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable(value = "id") UUID id) {
    	Optional<ApiModelEmissao> ApiModelOptional = apiServiceEmissao.findById(id);
        if (!ApiModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emissão não encontrada no banco de dados!");
        }
    	
        return ResponseEntity.status(HttpStatus.OK).body(ApiModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOne(@PathVariable(value = "id") UUID id) {
        Optional<ApiModelEmissao> apiModelOptional = apiServiceEmissao.findById(id);
        if (!apiModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emissão não encontrada no banco de dados!");
        }
        apiServiceEmissao.delete(apiModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Emissao deletada com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateOne(@PathVariable(value = "id") UUID id, @RequestBody @Valid ApiDtoEmissao apiDtoEmissao) {
        Optional<ApiModelEmissao> apiModelOptional = apiServiceEmissao.findById(id);
        if (!apiModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Impossível atualizar: emissão não encontrado no banco de dados!");
        }
        ApiModelEmissao apiModelEmissao = apiModelOptional.get();
        BeanUtils.copyProperties(apiDtoEmissao, apiModelEmissao);
        return ResponseEntity.status(HttpStatus.OK).body(apiServiceEmissao.save(apiModelEmissao));
    }
}