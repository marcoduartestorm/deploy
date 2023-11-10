package terrazul.api.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "fatores_residuos")
public class ApiModelFatoresResiduos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(nullable = false, length = 10)
    private String janeiro;
    
    @Column(nullable = false, length = 10)
    private String fevereiro;
    
    @Column(nullable = false, length = 10)
    private String marco;
    
    @Column(nullable = false, length = 10)
    private String abril;
    
    @Column(nullable = false, length = 10)
    private String maio;
    
    @Column(nullable = false, length = 10)
    private String junho;
    
    @Column(nullable = false, length = 10)
    private String julho;
    
    @Column(nullable = false, length = 10)
    private String agosto;
    
    @Column(nullable = false, length = 10)
    private String setembro;
    
    @Column(nullable = false, length = 10)
    private String outubro;
    
    @Column(nullable = false, length = 10)
    private String novembro;
    
    @Column(nullable = false, length = 10)
    private String dezembro;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getJaneiro() {
		return janeiro;
	}

	public void setJaneiro(String janeiro) {
		this.janeiro = janeiro;
	}

	public String getFevereiro() {
		return fevereiro;
	}

	public void setFevereiro(String fevereiro) {
		this.fevereiro = fevereiro;
	}

	public String getMarco() {
		return marco;
	}

	public void setMarco(String marco) {
		this.marco = marco;
	}

	public String getAbril() {
		return abril;
	}

	public void setAbril(String abril) {
		this.abril = abril;
	}
	
	public String getMaio() {
		return maio;
	}

	public void setMaio(String maio) {
		this.maio = maio;
	}
	
	public String getJunho() {
		return junho;
	}

	public void setJunho(String junho) {
		this.junho = junho;
	}

	public String getJulho() {
		return julho;
	}

	public void setJulho(String julho) {
		this.julho = julho;
	}

	public String getAgosto() {
		return agosto;
	}

	public void setAgosto(String agosto) {
		this.agosto = agosto;
	}

	public String getSetembro() {
		return setembro;
	}

	public void setSetembro(String setembro) {
		this.setembro = setembro;
	}

	public String getOutubro() {
		return outubro;
	}

	public void setOutubro(String outubro) {
		this.outubro = outubro;
	}

	public String getNovembro() {
		return novembro;
	}

	public void setNovembro(String novembro) {
		this.novembro = novembro;
	}

	public String getDezembro() {
		return dezembro;
	}

	public void setDezembro(String dezembro) {
		this.dezembro = dezembro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
