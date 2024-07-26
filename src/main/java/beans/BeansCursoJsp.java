package beans;

import java.util.Objects;

public class BeansCursoJsp {
	// Outros campos existentes
	private Long id;
	private String login;
	private String senha;
	private String nome;
	private String tel;
	private String cep;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String ibge;
	private String imagem;
	private String Pdf;// Campo para a imagem

	public String getPdf() {
		return Pdf;
	}

	public void setPdf(String pdf) {
		Pdf = pdf;
	}

	// Getters e setters para os campos existentes
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	// Getter e setter para o campo imagem
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Pdf, bairro, cep, cidade, estado, ibge, id, imagem, login, nome, rua, senha, tel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeansCursoJsp other = (BeansCursoJsp) obj;
		return Objects.equals(Pdf, other.Pdf) && Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(estado, other.estado)
				&& Objects.equals(ibge, other.ibge) && Objects.equals(id, other.id)
				&& Objects.equals(imagem, other.imagem) && Objects.equals(login, other.login)
				&& Objects.equals(nome, other.nome) && Objects.equals(rua, other.rua)
				&& Objects.equals(senha, other.senha) && Objects.equals(tel, other.tel);
	}

	@Override
	public String toString() {
		return "BeansCursoJsp [id=" + id + ", login=" + login + ", senha=" + senha + ", nome=" + nome + ", tel=" + tel
				+ ", cep=" + cep + ", rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado
				+ ", ibge=" + ibge + ", imagem=" + imagem + ", Pdf=" + Pdf + "]";
	}

}
