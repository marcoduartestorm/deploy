package terrazul.api.dtos;

import jakarta.validation.constraints.NotBlank;

public class ApiDtoFatoresResiduos {
	
	@NotBlank
    private String janeiro;
	@NotBlank
    private String fevereiro;
	@NotBlank
    private String marco;
	@NotBlank
    private String abril;
	@NotBlank
	private String maio;
	@NotBlank
    private String junho;
	@NotBlank
    private String julho;
	@NotBlank
    private String agosto;
	@NotBlank
    private String setembro;
	@NotBlank
    private String outubro;
	@NotBlank
    private String novembro;
	@NotBlank
    private String dezembro;
	
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
}
