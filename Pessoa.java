
public class Pessoa {
	protected String nome;
	protected String cpf;
	protected String rg;
	protected String endereco;
	protected String numero;
	protected String nascimento;

	public Pessoa(String nome) {
		this.nome=nome;
	}
	public Pessoa(String nome, String rg, String cpf, String endereco, String numero, String nascimento) {
		this.nome=nome;
		this.rg=rg;
		this.cpf=cpf;
		this.endereco=endereco;
		this.numero=numero;
		this.nascimento=nascimento;
	}

}
