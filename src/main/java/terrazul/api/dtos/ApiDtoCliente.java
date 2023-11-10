package terrazul.api.dtos;

import jakarta.validation.constraints.NotBlank;

public class ApiDtoCliente {
	
	@NotBlank
	private String data;

	@NotBlank
	private String projeto;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String matriculaDeEnergia;
	
	@NotBlank
	private String titularEnergiaCpf;
	
	@NotBlank
	private String matriculaDeAgua;
	
	@NotBlank
	private String titularAguaCpf;
	
	@NotBlank
	private String matriculaDeGas;
	
	@NotBlank
	private String titularGasCpf;
	
	@NotBlank
	private String habitantes;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getMatriculaDeEnergia() {
		return matriculaDeEnergia;
	}

	public void setMatriculaDeEnergia(String matriculaDeEnergia) {
		this.matriculaDeEnergia = matriculaDeEnergia;
	}

	public String getTitularEnergiaCpf() {
		return titularEnergiaCpf;
	}

	public void setTitularEnergiaCpf(String titularEnergiaCpf) {
		this.titularEnergiaCpf = titularEnergiaCpf;
	}

	public String getMatriculaDeAgua() {
		return matriculaDeAgua;
	}

	public void setMatriculaDeAgua(String matriculaDeAgua) {
		this.matriculaDeAgua = matriculaDeAgua;
	}

	public String getTitularAguaCpf() {
		return titularAguaCpf;
	}

	public void setTitularAguaCpf(String titularAguaCpf) {
		this.titularAguaCpf = titularAguaCpf;
	}

	public String getMatriculaDeGas() {
		return matriculaDeGas;
	}

	public void setMatriculaDeGas(String matriculaDeGas) {
		this.matriculaDeGas = matriculaDeGas;
	}

	public String getTitularGasCpf() {
		return titularGasCpf;
	}

	public void setTitularGasCpf(String titularGasCpf) {
		this.titularGasCpf = titularGasCpf;
	}

	public String getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(String habitantes) {
		this.habitantes = habitantes;
	}
}
