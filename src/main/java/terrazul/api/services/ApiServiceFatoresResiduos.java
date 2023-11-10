package terrazul.api.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import terrazul.api.models.ApiModelFatoresResiduos;
import terrazul.api.repositories.ApiRepositoryFatoresResiduos;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApiServiceFatoresResiduos {

    final ApiRepositoryFatoresResiduos apiRepositoryFatoresResiduos;

    public ApiServiceFatoresResiduos(ApiRepositoryFatoresResiduos apiRepositoryFatoresResiduos) {
        this.apiRepositoryFatoresResiduos = apiRepositoryFatoresResiduos;
    }

    @Transactional
    public ApiModelFatoresResiduos save(ApiModelFatoresResiduos apiModelFatoresResiduos) {
        return apiRepositoryFatoresResiduos.save(apiModelFatoresResiduos);
    }

    public List<ApiModelFatoresResiduos> findAll() {
        return apiRepositoryFatoresResiduos.findAll();
    }

    public Optional<ApiModelFatoresResiduos> findById(UUID id) {
        return apiRepositoryFatoresResiduos.findById(id);
    }

    @Transactional
    public void delete(ApiModelFatoresResiduos apiModelFatoresResiduos) {
        apiRepositoryFatoresResiduos.delete(apiModelFatoresResiduos);
    }
}
