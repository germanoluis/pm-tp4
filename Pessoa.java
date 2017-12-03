
public class Pessoa {
	protected String nome;
	protected String cpf;
	protected String rg;
	protected String endereço;
	protected String numero;
	protected String nascimento;
	
	public Pessoa(String nome) {
		this.nome=nome;
	}
	public Pessoa(String nome, String rg, String cpf, String endereço, String numero, String nascimento) {
		this.nome=nome;
		this.rg=rg;
		this.cpf=cpf;
		this.endereço=endereço;
		this.numero=numero;
		this.nascimento=nascimento;
	}
	
}
