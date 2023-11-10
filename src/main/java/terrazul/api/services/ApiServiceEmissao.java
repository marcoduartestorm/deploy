package terrazul.api.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import terrazul.api.models.ApiModelEmissao;
import terrazul.api.repositories.ApiRepositoryEmissao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApiServiceEmissao {

    final ApiRepositoryEmissao apiRepositoryEmissao;

    public ApiServiceEmissao(ApiRepositoryEmissao apiRepositoryEmissao) {
        this.apiRepositoryEmissao = apiRepositoryEmissao;
    }

    @Transactional
    public ApiModelEmissao save(ApiModelEmissao apiModelEmissao) {
        return apiRepositoryEmissao.save(apiModelEmissao);
    }
    
    public List<ApiModelEmissao> findAll() {
        return apiRepositoryEmissao.findAll();
    }

    public Optional<ApiModelEmissao> findById(UUID id) {
        return apiRepositoryEmissao.findById(id);
    }

    @Transactional
    public void delete(ApiModelEmissao apiModelEmissao) {
        apiRepositoryEmissao.delete(apiModelEmissao);
    }
}
