package terrazul.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import terrazul.api.models.ApiModelFatoresAgua;
import java.util.UUID;

public interface ApiRepositoryFatoresAgua extends JpaRepository<ApiModelFatoresAgua, UUID> {
}

