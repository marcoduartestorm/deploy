package terrazul.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import terrazul.api.models.ApiModelEmissao;
import java.util.UUID;

public interface ApiRepositoryEmissao extends JpaRepository<ApiModelEmissao, UUID> {
}

