import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cliente extends Pessoa{

	private static ArrayList<Cliente> clientes = new ArrayList();

	public Cliente(String nome, String rg, String cpf, String endereco, String numero, String nascimento, boolean criar) throws Exception {
		super(nome, rg, cpf, endereco, numero, nascimento);
		if(criar)addCliente(this);
	}

	public static void initializeList() throws Exception {
		String str;
		try {
			BufferedReader br = new BufferedReader(new FileReader("Clientes.txt"));
			while ((str = br.readLine()) != null) {
				String[] dados = str.split(",");
				Cliente c = new Cliente(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], false);
				clientes.add(c);
			}
		}
			catch (Exception e) {}
	}


	public static boolean addCliente(Cliente cli) throws IOException {
		if(!verificaSeExiste(cli)) {
			clientes.add(cli);
			FileWriter writer = new FileWriter("Clientes.txt");
			for(Cliente c : clientes)
				try {
					writer.write(c.nome + "," + c.rg + "," + c.cpf + "," + c.endereco + "," + c.numero + "," + c.nascimento + "\n");
				} catch (IOException e) {}
			writer.close();
			return true;
		}
		else return false;
	}

	public static boolean verificaSeExiste(String cpf) {
		for(Cliente c: clientes)
			if(c.cpf.equals(cpf)) return true;
		return false;
	}

	public static boolean verificaSeExiste(Cliente cli) {
		for(Cliente c: clientes)
			if(c.rg.equals(cli.rg) || c.cpf.equals(cli.cpf)) return true;
		return false;
	}

	public String getDadosCliente(){
		return "Nome: " + this.nome + "\n"
				 + "RG: " + this.rg + "\n"
				 + "CPF: " + this.cpf + "\n"
				 + "Endereço: " + this.endereco + "\n"
				 + "Telefone: " + this.numero + "\n"
				 + "Data de nascimento: " + this.nascimento;
	}

	public String getNome() {
		return this.nome;
	}
	public String getEndereco() {
		return this.endereco;
	}
	public String getNumero() {
		return this.numero;
	}

	public String getRG() {
		return this.rg;
	}

	public String getCPF() {
		return this.cpf;
	}

	public static ArrayList<Cliente> getListaDeClientes() {
		return clientes;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setRG(String rg) {
		this.rg = rg;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
}
