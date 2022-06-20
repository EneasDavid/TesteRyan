package Ryan.ipfe.cadastrar;

import java.util.Objects;

public class Produto {

	private String nft;
	private int id;
	private String nome;
	private double preco;
	private String descricao;
	
	
	public Produto(String nft, int id, String nome, double preco, String descricao) {
		super();
		this.nft = nft;
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao=descricao;
	}
	
	public String getNft() {
		return nft;
	}
	
	public void setNft(String nft) {
		this.nft = nft;
	}
	
	public String getNome() {
		return nome;
	}
	
	
	public double getPreco() {
		return preco;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Produto [NFT: " + nft + ", nome=" + nome + " #" + id + ", preco=" + preco + ", descricao=" + descricao + "]";
	}

	//Não será utilizado
	@Override
	public int hashCode() {
		return Objects.hash(descricao, nome, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
	}
	
	
	
	
	
	
}