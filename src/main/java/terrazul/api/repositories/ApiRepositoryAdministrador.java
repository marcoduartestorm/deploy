package terrazul.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import terrazul.api.models.ApiModelAdministrador;

import java.util.UUID;

public interface ApiRepositoryAdministrador extends JpaRepository<ApiModelAdministrador, UUID> {
    boolean existsByEmail(String email);
}

