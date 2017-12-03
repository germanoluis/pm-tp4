import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Consulta {

	private String dia;
	private String nome;
	private String horario;
	private String paciente;
	private String pagamento;
	private static ArrayList<Consulta> consultas = new ArrayList();

	public Consulta(String nome, String dia, String horario, String paciente, String pagamento, boolean criar) throws Exception {
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
			BufferedReader br = new BufferedReader(new FileReader("Consultas.txt"));
			while ((str = br.readLine()) != null) {
				Consulta c = new Consulta(str, str = br.readLine(), str = br.readLine(), str = br.readLine(), str = br.readLine(), false);
				consultas.add(c);
			}
		}
			catch (Exception e) {}
	}

	public void marcar(String nome, String dia, String horario) throws Exception {
		if(verificaHorario(nome, dia, horario)) {
			addConsulta(this);
		}
	}

	public static void cancelarConsulta(Consulta c) throws Exception {
		for(Consulta ct: consultas) {
			if(ct.nome.equals(c.nome) && ct.dia.equals(c.dia) && ct.horario.equals(c.horario) && ct.paciente.equals(c.paciente)&& ct.pagamento.equals(c.pagamento)) {
				consultas.remove(ct);
				break;
			}

		}

		FileWriter writer = new FileWriter("Consultas.txt");
		for(Consulta consulta : consultas)
			try {
				writer.write(consulta.nome + "\n" + consulta.dia + "\n" + consulta.horario + "\n" + consulta.paciente + "\n" + consulta.pagamento + "\n");
			} catch (Exception e) {}
		writer.close();
	}

	public static void addConsulta(Consulta c) throws Exception {
		consultas.add(c);
		FileWriter writer = new FileWriter("Consultas.txt");
		for(Consulta consulta : consultas)
			try {
				writer.write(consulta.nome + "\n" + consulta.dia + "\n" + consulta.horario + "\n" + consulta.paciente + "\n" + consulta.pagamento + "\n");
			} catch (Exception e) {}
		writer.close();
	}

	public static boolean verificaHorario(String nome, String dia, String horario) throws Exception {
		String str;

		try {
			BufferedReader br = new BufferedReader(new FileReader("Consultas.txt"));

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

	public static ArrayList<Consulta> horariosDiponiveis(String nome) throws Exception {
		ArrayList<Consulta> h_disponiveis = new ArrayList<Consulta>();
		String[] dias = {"01", "02", "03", "04", "05", "08", "09", "10", "11", "12", "15", "16", "17", "18", "19", "20", "23", "24", "25", "26", "27", "28"};
		String[] horarios = {"08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00"};
		for(String d : dias) {
			for(String h : horarios) {
				if(verificaHorario(nome, d, h)) {
					Consulta c = new Consulta(nome, d, h, null, null, false);
					h_disponiveis.add(c);
				}
			}
		}
		return h_disponiveis;
	}

	public static ArrayList<Consulta> getListaDeConsultas(String nome) {
		ArrayList<Consulta> lista_consultas = new ArrayList<Consulta>();
		for(Consulta c : consultas)
			if(c.nome.equals(nome)) lista_consultas.add(c);
		return lista_consultas;
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
