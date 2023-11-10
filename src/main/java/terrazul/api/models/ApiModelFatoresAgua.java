package terrazul.api.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "fatores_agua")
public class ApiModelFatoresAgua implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(nullable = false, length = 50)
    private String fator;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFator() {
		return fator;
	}

	public void setFator(String fator) {
		this.fator = fator;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
