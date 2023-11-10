package terrazul.api.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import terrazul.api.models.ApiModelFatoresAgua;
import terrazul.api.repositories.ApiRepositoryFatoresAgua;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApiServiceFatoresAgua {

    final ApiRepositoryFatoresAgua apiRepositoryFatoresAgua;

    public ApiServiceFatoresAgua(ApiRepositoryFatoresAgua apiRepositoryFatoresAgua) {
        this.apiRepositoryFatoresAgua = apiRepositoryFatoresAgua;
    }

    @Transactional
    public ApiModelFatoresAgua save(ApiModelFatoresAgua apiModelFatoresAgua) {
        return apiRepositoryFatoresAgua.save(apiModelFatoresAgua);
    }

    public List<ApiModelFatoresAgua> findAll() {
        return apiRepositoryFatoresAgua.findAll();
    }

    public Optional<ApiModelFatoresAgua> findById(UUID id) {
        return apiRepositoryFatoresAgua.findById(id);
    }

    @Transactional
    public void delete(ApiModelFatoresAgua apiModelFatoresAgua) {
        apiRepositoryFatoresAgua.delete(apiModelFatoresAgua);
    }
}
