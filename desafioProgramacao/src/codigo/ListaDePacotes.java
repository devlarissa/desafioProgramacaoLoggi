package codigo;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class ListaDePacotes {

//	pacotes de destino de cada regiao
	private LinkedList<Pacote> pacotesDestinoDoSul = new LinkedList<Pacote>();
	private LinkedList<Pacote> pacotesDestinoDoSudeste = new LinkedList<Pacote>();
	private LinkedList<Pacote> pacotesDestinoDoNorte = new LinkedList<Pacote>();
	private LinkedList<Pacote> pacotesDestinoDoNordeste = new LinkedList<Pacote>();
	private LinkedList<Pacote> pacotesDestinoDoCentroOeste = new LinkedList<Pacote>();
	
//	pacotes de origem de cada regiao
	private LinkedList<Pacote> pacotesOrigemDoSul = new LinkedList<Pacote>();
	private LinkedList<Pacote> pacotesOrigemDoSudeste = new LinkedList<Pacote>();
	private LinkedList<Pacote> pacotesOrigemDoNorte = new LinkedList<Pacote>();
	private LinkedList<Pacote> pacotesOrigemDoNordeste = new LinkedList<Pacote>();
	private LinkedList<Pacote> pacotesOrigemDoCentroOeste = new LinkedList<Pacote>();

// pacotes validos e invalidos
	private LinkedList<Pacote> pacotesValidos = new LinkedList<Pacote>();
	private LinkedList<Pacote> pacotesInvalidos = new LinkedList<Pacote>();
	
	private LinkedList<Pacote> pacotesDeBrinquedosDeOrigemDaRegiaoSul = new LinkedList<Pacote>();
	
//	pacotes de tipos de produto para cada regiao
	private LinkedList<Pacote> pacotesDeJoiasDeDestinoPorRegiao = new LinkedList<Pacote>();
	private LinkedList<Pacote> pacotesDeLivrosDeDestinoPorRegiao = new LinkedList<Pacote>();
	private LinkedList<Pacote> pacotesDeEletronicosDeDestinoPorRegiao = new LinkedList<Pacote>();
	private LinkedList<Pacote> pacotesDeBebidasDeDestinoPorRegiao = new LinkedList<Pacote>();
	private LinkedList<Pacote> pacotesDeBrinquedosDeDestinoPorRegiao = new LinkedList<Pacote>();
	
//	linkedList com todos os pacotes
	private LinkedList<Pacote> linkedListDePacotes = new LinkedList<Pacote>();
//	hashmap com todos os pacotes
	private HashMap<String, String> lista;
	
//	lista com a lista de pacotes por regiao
	private LinkedList<LinkedList<Pacote>> ordemEntregas = new LinkedList<LinkedList<Pacote>>();
	
//	numero de pacotes para cada codigo de vendedor
	private HashMap<Integer, Integer> vendedores = new HashMap<Integer, Integer>();
	
// constructor
	public ListaDePacotes(HashMap<String, String> lista) {
		this.lista = lista;
	}

	public void processamento() {

		this.lista.forEach((key, value) -> {

//			adiciona todos os pacotes num linkedlist
			Pacote pct = new Pacote(value);
			linkedListDePacotes.add(pct);
			
//			separa os pacotes validos e invalidos
			if(pct.isPacoteValido()) {
				pacotesValidos.add(pct);
			}
			else {
				pacotesInvalidos.add(pct);
			}

//			separa o destino dos pacotes por regiao 
			switch (pct.getRegiaoDestino()) {

			case "sul":
				pacotesDestinoDoSul.add(pct);
				break;
			case "sudeste":
				pacotesDestinoDoSudeste.add(pct);
				break;
			case "norte":
				pacotesDestinoDoNorte.add(pct);
				break;
			case "nordeste":
				pacotesDestinoDoNordeste.add(pct);
				break;
			case "centro-oeste":
				pacotesDestinoDoCentroOeste.add(pct);
				break;
			}
			
//			separa a origem dos pacotes por regiao 
			switch (pct.getRegiaoOrigem()) {

			case "sul":
				pacotesOrigemDoSul.add(pct);
				
//				se os pacotes forem de brinquedos de origem da regiao sul adiciona-se a lista
				if(pct.getTipoProduto() == "brinquedos") {
					pacotesDeBrinquedosDeOrigemDaRegiaoSul.add(pct);
				}
				break;
			case "sudeste":
				pacotesOrigemDoSudeste.add(pct);
				break;
			case "norte":
				pacotesOrigemDoNorte.add(pct);
				break;
			case "nordeste":
				pacotesOrigemDoNordeste.add(pct);
				break;
			case "centro-oeste":
				pacotesOrigemDoCentroOeste.add(pct);
				break;
			}
		});
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void procesamentoPacotesValidos() {
//		limpa as listas caso aja algum elemento dentro
		pacotesDestinoDoSul.clear();
		pacotesDestinoDoSudeste.clear();
		pacotesDestinoDoNorte.clear();
		pacotesDestinoDoNordeste.clear();
		
//		separa os pacotes validos por regiao
		for(int i = 0; i < pacotesValidos.size(); i++) {
			switch (pacotesValidos.get(i).getRegiaoDestino()) {

			case "sul":
//				se p tipo de produto for joias, esses produtos ficam no inicio da lista
				if(pacotesValidos.get(i).tipodeproduto(i) == "joias") {
					pacotesDestinoDoSul.addFirst(pacotesValidos.get(i));
				}else {
					pacotesDestinoDoSul.add(pacotesValidos.get(i));
				}
				break;
			case "sudeste":
				if(pacotesValidos.get(i).tipodeproduto(i) == "joias") {
					pacotesDestinoDoSudeste.addFirst(pacotesValidos.get(i));
				}else {
					pacotesDestinoDoSudeste.add(pacotesValidos.get(i));
				}
				break;
			case "norte":
				if(pacotesValidos.get(i).tipodeproduto(i) == "joias") {
					pacotesDestinoDoNorte.addFirst(pacotesValidos.get(i));
				}else {
					pacotesDestinoDoNorte.add(pacotesValidos.get(i));
				}
				break;
			case "nordeste":
				if(pacotesValidos.get(i).tipodeproduto(i) == "joias") {
					pacotesDestinoDoNordeste.addFirst(pacotesValidos.get(i));
				}else {
					pacotesDestinoDoNordeste.add(pacotesValidos.get(i));
				}
				break;
			case "centro-oeste":
				if(pacotesValidos.get(i).tipodeproduto(i) == "joias") {
					pacotesDestinoDoCentroOeste.addFirst(pacotesValidos.get(i));
				}else {
					pacotesDestinoDoCentroOeste.add(pacotesValidos.get(i));
				}
				break;
			}
			
//			adiciona a lista de vendedores o vendedor que ainda não estiver nela, sem repeticoes
			if(pacotesValidos.indexOf(pacotesValidos.get(i).getCodigoVendedor()) == -1) {
				vendedores.put(pacotesValidos.get(i).getCodigoVendedor(), 0);
			}
		}
	}
	
	public void numeroDePacotesPorVendedor() {
//		procura para cada codigo de vendedor
		for(Integer key : vendedores.keySet()) {
			
//			procura na lista de pacotes valicos
			for(int j = 0; j < pacotesValidos.size(); j++) {
//				se o pacote valido for daquele vendedor, adiciona-se 1 no numero de pacotes daquele vendedor
				if(key == pacotesValidos.get(j).getCodigoVendedor()) {
					vendedores.put(key,vendedores.get(key)+1);
				}
			}
//			printa o numero de pacotes de cada vendedor
			System.out.println("vendedor " + key + " tem " + vendedores.get(key)+ " pacotes" );
		}
	}
	
	public void tipoDeProdutoPorDestino(LinkedList<Pacote> listaDeUmaRegiao) {
//		limpa as listas caso aja algum elemento dentro
		pacotesDeJoiasDeDestinoPorRegiao.clear();
		pacotesDeLivrosDeDestinoPorRegiao.clear();
		pacotesDeEletronicosDeDestinoPorRegiao.clear();
		pacotesDeBebidasDeDestinoPorRegiao.clear();
		pacotesDeBrinquedosDeDestinoPorRegiao.clear();
		
//		separa cada pacote por tipo e segundo a lista da regiao passada pelo parametro
		for(int i = 0; i < listaDeUmaRegiao.size(); i++) {
			
			switch(listaDeUmaRegiao.get(i).getTipoProduto()) {
			case "joias":
				pacotesDeJoiasDeDestinoPorRegiao.add(listaDeUmaRegiao.get(i));
				break;
			case "livros":
				pacotesDeLivrosDeDestinoPorRegiao.add(listaDeUmaRegiao.get(i));
				break;
			case "eletronicos":
				pacotesDeEletronicosDeDestinoPorRegiao.add(listaDeUmaRegiao.get(i));
				break;
			case "bebidas":
				pacotesDeBebidasDeDestinoPorRegiao.add(listaDeUmaRegiao.get(i));
				break;
			case "brinquedos":
				pacotesDeBrinquedosDeDestinoPorRegiao.add(listaDeUmaRegiao.get(i));
				break;
			}
		}
//		printa as listas de pacotes de cada tipo
		System.out.println("pacotes de joias: " + pacotesDeJoiasDeDestinoPorRegiao);
		System.out.println("pacotes de livros: " + pacotesDeLivrosDeDestinoPorRegiao);
		System.out.println("pacotes de eletronicos: " + pacotesDeEletronicosDeDestinoPorRegiao);
		System.out.println("pacotes de bebidas: " + pacotesDeBebidasDeDestinoPorRegiao);
		System.out.println("pacotes de brinquedos: " + pacotesDeBrinquedosDeDestinoPorRegiao);
		
	}
	
	
	public LinkedList<LinkedList<Pacote>> carregamentoCaminhao(String regiao) {
//		lista da ordem de entrega de cada pacote
		String[] ordemDaRota = {"centro-oeste", "nordeste", "norte", "sudeste", "sul"};
		
//		pesquisa para cada regiao
		for(String reg: ordemDaRota) {
		
//			adiciona a ordem das entregas a lista de pacotes da regiao por onde sera passado o caminhao
			switch(reg) {
			case "centro-oeste":
				ordemEntregas.add(pacotesDestinoDoCentroOeste);
				break;
			case "nordeste":
				ordemEntregas.add(pacotesDestinoDoNordeste);
				break;
			case "norte":
				ordemEntregas.add(pacotesDestinoDoNorte);
				break;
			case "sudeste":
				ordemEntregas.add(pacotesDestinoDoSudeste);
				break;
			case "sul":
				ordemEntregas.add(pacotesDestinoDoSul);
				break;
			}
			
//			para caso a regiao de destino final seja a mesma do looop
			if(reg == regiao) {
				break;
			}
		}
		return ordemEntregas;
	}
	
	public LinkedList<LinkedList<Pacote>> inverter(LinkedList<LinkedList<Pacote>> lista){
		Collections.reverse(lista);
		return lista;
	}
	
	
//	criados apenas gets para não ser possivel alterar nenhum dos valores

	public LinkedList<Pacote> getPacotesDestinoDoSul() {
		return pacotesDestinoDoSul;
	}

	public LinkedList<Pacote> getPacotesDestinoDoSudeste() {
		return pacotesDestinoDoSudeste;
	}

	public LinkedList<Pacote> getPacotesDestinoDoNorte() {
		return pacotesDestinoDoNorte;
	}

	public LinkedList<Pacote> getPacotesDestinoDoNordeste() {
		return pacotesDestinoDoNordeste;
	}

	public LinkedList<Pacote> getPacotesDestinoDoCentroOeste() {
		return pacotesDestinoDoCentroOeste;
	}
	
	public LinkedList<Pacote> getPacotesOrigemDoSul() {
		return pacotesOrigemDoSul;
	}

	public LinkedList<Pacote> getPacotesOrigemDoSudeste() {
		return pacotesOrigemDoSudeste;
	}

	public LinkedList<Pacote> getPacotesOrigemDoNorte() {
		return pacotesOrigemDoNorte;
	}

	public LinkedList<Pacote> getPacotesOrigemDoNordeste() {
		return pacotesOrigemDoNordeste;
	}

	public LinkedList<Pacote> getPacotesOrigemDoCentroOeste() {
		return pacotesOrigemDoCentroOeste;
	}

	public LinkedList<Pacote> getLinkedListDePacotes() {
		return linkedListDePacotes;
	}
	
	public LinkedList<Pacote> getPacotesValidos() {
		return pacotesValidos;
	}
	
	public LinkedList<Pacote> getPacotesInvalidos() {
		return pacotesInvalidos;
	}
	
	public LinkedList<Pacote> getPacotesDeBrinquedosDeOrigemDaRegiaoSul() {
		return pacotesDeBrinquedosDeOrigemDaRegiaoSul;
	}

	public HashMap<Integer, Integer> getVendedores() {
		return vendedores;
	}
	
	public LinkedList<LinkedList<Pacote>> getOrdemEntregas() {
		return ordemEntregas;
	}
	
	
}
