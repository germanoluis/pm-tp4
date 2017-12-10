import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String args[]) throws Exception {
		Cliente.initializeList();
		Medico.initializeList();
		Consulta.initializeList();
		Exame.initializeList();

		GUI_Inicio inicio = new GUI_Inicio();
	}

}
