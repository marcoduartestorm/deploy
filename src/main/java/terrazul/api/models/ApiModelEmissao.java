package terrazul.api.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emissoes")
public class ApiModelEmissao implements Serializable, Comparable<ApiModelEmissao> {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false, length = 30)
	private String tipoEmissao;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(nullable = false, length = 30)
	private String cpf;
	
	@Column(nullable = false, length = 30)
	private String mes;
	
	@Column(nullable = false, length = 30)
	private String ano;
	
	@Column(nullable = false, length = 20 )
	private String consumo;
	
	@Override
	public int compareTo(ApiModelEmissao emissao) {
		return nome.compareToIgnoreCase(emissao.getNome());
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
