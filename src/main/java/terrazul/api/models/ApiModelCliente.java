package terrazul.api.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "clientes")
public class ApiModelCliente implements Serializable, Comparable<ApiModelCliente> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(nullable = false, length = 50)
    private String data;

    @Column(nullable = false, length = 70)
	private String projeto;
	
    @Column(nullable = false, length = 100)
	private String nome;
	
    @Column(nullable = false, length = 50)
	private String cpf;
	
    @Column(nullable = false, length = 200)
	private String endereco;
	
    @Column(nullable = false, length = 50)
	private String email;
	
    @Column(nullable = false, length = 50)
	private String telefone;
	
    @Column(nullable = false, length = 50)
	private String matriculaDeEnergia;
	
    @Column(nullable = false, length = 100)
	private String titularEnergiaCpf;
	
    @Column(nullable = false, length = 50)
	private String matriculaDeAgua;
	
    @Column(nullable = false, length = 100)
	private String titularAguaCpf;
	
    @Column(nullable = false, length = 50)
	private String matriculaDeGas;
	
    @Column(nullable = false, length = 100)
	private String titularGasCpf;
	
    @Column(nullable = false, length = 10)
	private int habitantes;

    @Override
    public int compareTo(ApiModelCliente clientes) {
    	return projeto.compareToIgnoreCase(clientes.getProjeto());
    }
    
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

	public int getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
