import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) throws Exception {
		/*
		Cliente.initializeList();
		Exame.initializeList();
		Medico.initializeList();
		Consulta.initializeList();

		//Instâncias
		//Medico d1 = new Medico("Roberto", "Urologista", true);
		//Medico d2 = new Medico("Roberto Justos", "Urologista", true);
		//Medico d3 = new Medico("Luiz", "Cardiologista", true);

		//Cria dois clientes
		Cliente c1 = new Cliente("Adilson", "MG-51.145.624", "521.845.681-96", "Rua Doutor Fimose", "3223-3333", "21/03/1990", true);
		Cliente c2 = new Cliente("Roberval", "SP-51.145.624", "632.487.521.98", "Avenida da Goiaba Podre", "3222-3224", "21/03/1990", true);

		//Cria Exame
		Exame e1 = new Exame("Raios X", "15", "09:30", "Lucas", "Cart�o", true);
		Exame e2 = new Exame("Raios X", "17", "19:30", "Lucas", "Cart�o", true);
		Exame e3 = new Exame("Raios Y", "15", "09:30", "Lucas", "Cart�o", true);
		Exame e4 = new Exame("Raios G", "10", "09:30", "Lucas", "Cart�o", true);

		//Cancela Exames
		Exame.cancelarExame(e1);
		Exame.cancelarExame(e2);

		//Cria Consulta
		Consulta con1 = new Consulta("Roberto", "15", "09:30", "Lucas", "Cart�o", true);
		Consulta con2 = new Consulta("Roberto", "17", "17:00", "Lucas", "Cart�o", true);
		Consulta con3 = new Consulta("Luiz", "15", "09:30", "Lucas", "Cart�o", true);
		Consulta con4 = new Consulta("Luiz", "10", "09:30", "Lucas", "Cart�o", true);

		//Cancela Consultas
		Consulta.cancelarConsulta(con1);
		Consulta.cancelarConsulta(con2);


		//Retorna lista de horarios disponiveis de exames de Raios Y
		ArrayList<Exame> horarios = Exame.horariosDiponiveis("Raios Y");

		//Printa todos os horarios disponiveis de exames de Raios Y
		for(Exame e : horarios)
			System.out.println(e.getNome() + ", " + e.getDia() + ", " + e.getHorario());

		//Retorna lista de medicos
		ArrayList<Medico> especialistas = Medico.getMedicosPorEspecialidade("Cardiologista");
		ArrayList<Medico> todos = Medico.getListaDeMedicos();
		for(Medico m : todos)
			System.out.println(m.getNome() + ", " + m.getEspecialidade());

		//Retorna consultas pelo nome do medico
		ArrayList<Consulta> lista = Consulta.getListaDeConsultas("Luiz");
		for(Consulta con : lista)
			System.out.println(con.getNome() + ", " + con.getDia() + ", " + con.getHorario() + ", " + con.getPaciente() + ", " + con.getPagamento());

		//Retorna lista de horarios disponiveis de consultas com Luiz
		ArrayList<Consulta> horarios2 = Consulta.horariosDiponiveis("Luiz");

		//Printa todos os horarios disponiveis de consultas com Luiz
		for(Consulta con : horarios2)
			System.out.println(con.getNome() + ", " + con.getDia() + ", " + con.getHorario());

		//Testes
		//System.out.println(d1.getListaDeMedicos().get(0).getNome());
		//System.out.println(Cliente.getListaDeClientes().get(0).getRG());
		*/

		GUI_Inicio inicio = new GUI_Inicio();
	}
}
