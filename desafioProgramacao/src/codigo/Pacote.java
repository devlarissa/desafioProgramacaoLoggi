package codigo;

public class Pacote {

	@SuppressWarnings("unused")
	private String codigoDoPacote;
	private int numRegiaoOrigem;
	private int numRegiaoDestino;
	@SuppressWarnings("unused")
	private int codigoLoggi;
	private int codigoVendedor;
	private int numTipoProduto;

	private boolean pacoteValido = true;
	private String regiaoOrigem;
	private String regiaoDestino;
	private String tipoProduto;

	public Pacote(String codigo) {
		this.codigoDoPacote = codigo;
		
//		pega a string codigo, quebra ela em substrings a cada 3 elemntos e transforma em inteiros
		this.numRegiaoOrigem = Integer.parseInt(codigo.substring(0, 3));
		this.numRegiaoDestino = Integer.parseInt(codigo.substring(3, 6));
		this.codigoLoggi = Integer.parseInt(codigo.substring(6, 9));
		this.codigoVendedor = Integer.parseInt(codigo.substring(9, 12));
		this.numTipoProduto = Integer.parseInt(codigo.substring(12, 15));
		
//		setar a regiao de origem ou deve retornar pacote invalido e o numero = 0
		if(regiao(this.numRegiaoOrigem) == "invalido") {
			this.pacoteValido = false;
			this.numRegiaoOrigem = 0;
			 this.regiaoOrigem = regiao(numRegiaoOrigem);
		}
		else {
			 this.regiaoOrigem = regiao(numRegiaoOrigem);
		}
		
//		setar a regiao de destino ou deve retornar pacote invalido e o numero = 0
		if(regiao(this.numRegiaoDestino) == "invalido") {
			this.pacoteValido = false;
			this.numRegiaoDestino = 0;
			this.regiaoDestino = regiao(this.numRegiaoDestino);
		}
		else {
			 this.regiaoDestino = regiao(this.numRegiaoDestino);
		}

//		restriçoes

//		se o produto não for do tipo que a loggi vende deve retornar pacote invalido e o numero = 0
		if (tipodeproduto(this.numTipoProduto) == "invalido") {
			this.pacoteValido = false;
			this.numTipoProduto = 0;
			this.tipoProduto = tipodeproduto(this.numTipoProduto);
		}
		else {
			this.tipoProduto = tipodeproduto(this.numTipoProduto);
		}


//		se o tipo do produto for joias e a regiao for centro-oeste retorna pacote invalido
		if (this.tipoProduto == "joias" && this.regiaoOrigem == "centro-oeste") {
			this.pacoteValido = false;
		}

//		se o codigo do vendedor for 367 deve retornar invalido
		if (this.codigoVendedor == 367) {
			this.pacoteValido = false;
		}

	}

//	retorna a regiao ou invalido
	public String regiao(int regiao) {

		if (regiao > 000 && regiao < 501) {
			if (regiao < 100) {
				return "sudeste";
			} else if (regiao <= 200) {
				return "sul";
			} else if (regiao < 300) {
				return "centro-oeste";
			} else if (regiao < 400) {
				return "nordeste";
			} else {
				return "norte";
			}
		}
		return "invalido";
	}
	
//	retorna o tipo do produto ou invalido
	public String tipodeproduto(int tipo) {
		switch(tipo) {
		case 001:
			return "joias";
		case 111:
			return "livros";
		case 333:
			return "eletronicos";
		case 555:
			return "bebidas";
		case 888:
			return "brinquedos";
			
		}
		return "invalido";
	}
	
//	criados apenas gets para não ser possivel alterar nenhum dos valores

	public int getCodigoVendedor() {
		return codigoVendedor;
	}

	public boolean isPacoteValido() {
		return pacoteValido;
	}

	public String getRegiaoOrigem() {
		return regiaoOrigem;
	}

	public String getRegiaoDestino() {
		return regiaoDestino;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}
	
}
