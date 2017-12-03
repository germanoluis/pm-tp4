import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Medico extends Pessoa{

	private String especialidade;
	private static ArrayList<Medico> medicos = new ArrayList();

	public Medico(String nome, String especialidade, boolean criar) throws Exception {
		super(nome);
		this.especialidade = especialidade;
		if(criar)addMedico(this);
	}

	public static void initializeList() throws Exception {
		String str;
		try {
			BufferedReader br = new BufferedReader(new FileReader("Medicos.txt"));
			while ((str = br.readLine()) != null) {
				String[] dados = str.split(",");
				Medico m = new Medico(dados[0], dados[1], false);
				medicos.add(m);
			}
		}
			catch (Exception e) {}
	}

	public static void addMedico(Medico nome) throws Exception {
		medicos.add(nome);
		FileWriter writer = new FileWriter("Medicos.txt");
		for(Medico m : medicos)
			try {
				writer.write(m.nome + "," + m.especialidade + "\n");
			} catch (IOException e) {}
		writer.close();
	}

	public static ArrayList<Medico> getMedicosPorEspecialidade(String especialidade){
		ArrayList<Medico> especializados = new ArrayList<Medico>();
		for(Medico m : medicos) if(m.especialidade.equals(especialidade)) especializados.add(m);
		return especializados;
	}

	public String getNome() {
		return this.nome;
	}

	public String getEspecialidade() {
		return this.especialidade;
	}

	public static ArrayList<Medico> getListaDeMedicos() {
		return medicos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}
