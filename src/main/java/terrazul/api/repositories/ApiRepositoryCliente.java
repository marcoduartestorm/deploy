package terrazul.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import terrazul.api.models.ApiModelCliente;

import java.util.UUID;

public interface ApiRepositoryCliente extends JpaRepository<ApiModelCliente, UUID> {
    boolean existsByCpf(String cpf);
}