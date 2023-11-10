package terrazul.api.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "administradores")
public class ApiModelAdministrador implements Serializable, Comparable<ApiModelAdministrador> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(nullable = false, unique = true, length = 50)
    private String email;
    
    @Column(nullable = false, length = 50)
    private String senha;
    
    @Column(nullable = false, length = 100)
    private String nome;
    
    @Override
    public int compareTo(ApiModelAdministrador adms) {
    	return nome.compareToIgnoreCase(adms.getNome());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
