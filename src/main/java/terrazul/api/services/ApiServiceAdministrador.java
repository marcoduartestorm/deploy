package terrazul.api.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import terrazul.api.models.ApiModelAdministrador;
import terrazul.api.repositories.ApiRepositoryAdministrador;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApiServiceAdministrador {

    final ApiRepositoryAdministrador apiRepositoryAdministrador;

    public ApiServiceAdministrador(ApiRepositoryAdministrador apiRepositoryAdministrador) {
        this.apiRepositoryAdministrador = apiRepositoryAdministrador;
    }

    @Transactional
    public ApiModelAdministrador save(ApiModelAdministrador apiModelAdministrador) {
        return apiRepositoryAdministrador.save(apiModelAdministrador);
    }

    public boolean existsEmail(String email) {
        return apiRepositoryAdministrador.existsByEmail(email);
    }
    
    public List<ApiModelAdministrador> findAll() {
        return apiRepositoryAdministrador.findAll();
    }

    public Optional<ApiModelAdministrador> findById(UUID id) {
        return apiRepositoryAdministrador.findById(id);
    }

    @Transactional
    public void delete(ApiModelAdministrador apiModelAdministrador) {
        apiRepositoryAdministrador.delete(apiModelAdministrador);
    }
}
