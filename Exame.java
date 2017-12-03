import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Exame {

	private String dia;
	private String nome;
	private String horario;
	private String paciente;
	private String pagamento;
	private static ArrayList<Exame> exames = new ArrayList();

	public Exame(String nome, String dia, String horario, String paciente, String pagamento, boolean criar) throws Exception {
		this.nome=nome;
		this.dia=dia;
		this.horario=horario;
		this.paciente=paciente;
		this.pagamento=pagamento;
		if(criar)marcar(nome, dia, horario);
	}

	public static void initializeList() throws Exception {
		String str;
		try {
			BufferedReader br = new BufferedReader(new FileReader("Exames.txt"));
			while ((str = br.readLine()) != null) {
				Exame ex = new Exame(str, str = br.readLine(), str = br.readLine(), str = br.readLine(), str = br.readLine(), false);
				exames.add(ex);
			}
		}
			catch (Exception e) {}
	}

	public void marcar(String nome, String dia, String horario) throws Exception {
		if(verificaHorario(nome, dia, horario)) {
			addExame(this);
		}
	}

	public static void cancelarExame(Exame ex) throws Exception {
		for(Exame exa: exames) {
			if(ex.nome.equals(exa.nome) && ex.dia.equals(exa.dia) && ex.horario.equals(exa.horario) && ex.paciente.equals(exa.paciente)&& ex.pagamento.equals(exa.pagamento)) {
				exames.remove(exa);
				break;
			}

		}

		FileWriter writer = new FileWriter("Exames.txt");
		for(Exame exame : exames)
			try {
				writer.write(exame.nome + "\n" + exame.dia + "\n" + exame.horario + "\n" + exame.paciente + "\n" + exame.pagamento + "\n");
			} catch (Exception e) {}
		writer.close();
	}

	public static void addExame(Exame ex) throws Exception {
		exames.add(ex);
		FileWriter writer = new FileWriter("Exames.txt");
		for(Exame exame : exames)
			try {
				writer.write(exame.nome + "\n" + exame.dia + "\n" + exame.horario + "\n" + exame.paciente + "\n" + exame.pagamento + "\n");
			} catch (Exception e) {}
		writer.close();
	}

	public static boolean verificaHorario(String nome, String dia, String horario) throws Exception {
		String str;

		try {
			BufferedReader br = new BufferedReader(new FileReader("Exames.txt"));

			while ((str = br.readLine()) != null) {
				if(str.equals(nome)) {
					str=br.readLine();
					if(str.equals(dia)) {
						str=br.readLine();
						if(str.equals(horario)) return false;
					}
				str = br.readLine();
				str = br.readLine();
				}
			}
		} catch (Exception e) {}
		return true;
	}

	public static ArrayList<Exame> horariosDiponiveis(String nome) throws Exception {
		ArrayList<Exame> h_disponiveis = new ArrayList<Exame>();
		String[] dias = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
		String[] horarios = {"08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00" };
		for(String d : dias) {
			for(String h : horarios) {
				if(verificaHorario(nome, d, h)) {
					Exame e = new Exame(nome, d, h, null, null, false);
					h_disponiveis.add(e);
				}
			}
		}
		return h_disponiveis;
	}

	public static ArrayList<Exame> getListaDeExames() {
		return exames;
	}

	public String getNome() {
		return this.nome;
	}

	public String getDia() {
		return this.dia;
	}

	public String getPaciente() {
		return this.paciente;
	}

	public String getPagamento() {
		return this.pagamento;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setdia(String dia) {
		this.dia = dia;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public void sethorario(String horario) {
		this.horario = horario;
	}

}
