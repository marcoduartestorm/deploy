package terrazul.api.dtos;

import jakarta.validation.constraints.NotBlank;

public class ApiDtoEmissao {
	
	@NotBlank
	private String tipoEmissao;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String mes;
	
	@NotBlank
	private String ano;
	
	@NotBlank
	private String consumo;

	public String getTipoEmissao() {
		return tipoEmissao;
	}

	public void setTipoEmissao(String tipoEmissao) {
		this.tipoEmissao = tipoEmissao;
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

	public String getMes() {
		return mes;
	}
	
	public void setMes(String mes) {
		this.mes = mes;
	}
	
	public String getAno() {
		return ano;
	}
	
	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getConsumo() {
		return consumo;
	}

	public void setConsumo(String consumo) {
		this.consumo = consumo;
	}
}
