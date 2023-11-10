package terrazul.api.services;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import terrazul.api.models.ApiModelCliente;
import terrazul.api.repositories.ApiRepositoryCliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApiServiceCliente {

    final ApiRepositoryCliente apiRepositoryCliente;

    public ApiServiceCliente(ApiRepositoryCliente apiRepositoryCliente) {
        this.apiRepositoryCliente = apiRepositoryCliente;
    }

    @Transactional
    public ApiModelCliente save(ApiModelCliente apiModelCliente) {
        return apiRepositoryCliente.save(apiModelCliente);
    }

    public boolean existsByCpf(String cpf) {
        return apiRepositoryCliente.existsByCpf(cpf);
    }

    public List<ApiModelCliente> findAll() {
        return apiRepositoryCliente.findAll();
    }

    public Optional<ApiModelCliente> findById(UUID id) {
        return apiRepositoryCliente.findById(id);
    }

    @Transactional
    public void delete(ApiModelCliente apiModelCliente) {
        apiRepositoryCliente.delete(apiModelCliente);
    }
}
