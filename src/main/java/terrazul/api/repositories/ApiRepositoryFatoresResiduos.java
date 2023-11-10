package terrazul.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import terrazul.api.models.ApiModelFatoresResiduos;

import java.util.UUID;

public interface ApiRepositoryFatoresResiduos extends JpaRepository<ApiModelFatoresResiduos, UUID> {
}

