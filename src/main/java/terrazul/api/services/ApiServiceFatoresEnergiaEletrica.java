package terrazul.api.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import terrazul.api.models.ApiModelFatoresEnergiaEletrica;
import terrazul.api.repositories.ApiRepositoryFatoresEnergiaEletrica;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApiServiceFatoresEnergiaEletrica {

    final ApiRepositoryFatoresEnergiaEletrica apiRepositoryFatoresEnergiaEletrica;

    public ApiServiceFatoresEnergiaEletrica(ApiRepositoryFatoresEnergiaEletrica apiRepositoryFatoresEnergiaEletrica) {
        this.apiRepositoryFatoresEnergiaEletrica = apiRepositoryFatoresEnergiaEletrica;
    }

    @Transactional
    public ApiModelFatoresEnergiaEletrica save(ApiModelFatoresEnergiaEletrica apiModelFatoresEnergiaEletrica) {
        return apiRepositoryFatoresEnergiaEletrica.save(apiModelFatoresEnergiaEletrica);
    }

    public List<ApiModelFatoresEnergiaEletrica> findAll() {
        return apiRepositoryFatoresEnergiaEletrica.findAll();
    }

    public Optional<ApiModelFatoresEnergiaEletrica> findById(UUID id) {
        return apiRepositoryFatoresEnergiaEletrica.findById(id);
    }

    @Transactional
    public void delete(ApiModelFatoresEnergiaEletrica apiModelFatoresEnergiaEletrica) {
        apiRepositoryFatoresEnergiaEletrica.delete(apiModelFatoresEnergiaEletrica);
    }
}
