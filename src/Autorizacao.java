public class Autorizacao {

	private static int pedidos_cortesia = 0;
	private static int pedidos_convenio = 0;

	public static boolean autorizaDinheiro() {
		return true;
	}

	public static boolean autorizaCartao() {
		return true;
	}

	public static boolean autorizaCortesia() {
		pedidos_cortesia++;
		if(pedidos_cortesia%5!=0) return true;
		else return false;
	}

	public static boolean autorizaCheque(String cpf) {
		if(Math.random()>0.75) return true;
		else return false;
	}

	public static boolean autorizaConvenio(String nome, String convenio) {
		pedidos_convenio++;
		if(pedidos_convenio%10!=0)return true;
		else if(Math.random()>0.5) return true;
		else return false;
	}

}
