package terrazul.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import terrazul.api.models.ApiModelFatoresEnergiaEletrica;
import java.util.UUID;

public interface ApiRepositoryFatoresEnergiaEletrica extends JpaRepository<ApiModelFatoresEnergiaEletrica, UUID> {
}

