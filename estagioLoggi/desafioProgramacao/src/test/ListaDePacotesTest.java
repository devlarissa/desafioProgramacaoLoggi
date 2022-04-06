package test;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;

import codigo.ListaDePacotes;

public class ListaDePacotesTest {
	
	HashMap<String, String> dicionarioDePacotes = new HashMap<>();
	
	public void criarLista(){
		dicionarioDePacotes.put("pacote1", "288355555123888");
		dicionarioDePacotes.put("pacote2", "335333555584333");
		dicionarioDePacotes.put("pacote3", "223343555124001");
		dicionarioDePacotes.put("pacote4", "002111555874555");
		dicionarioDePacotes.put("pacote5", "111188555654777");
		dicionarioDePacotes.put("pacote6", "111333555123333");
		dicionarioDePacotes.put("pacote7", "432055555123888");
		dicionarioDePacotes.put("pacote8", "079333555584333");
		dicionarioDePacotes.put("pacote9", "155333555124001");
		dicionarioDePacotes.put("pacote10", "333188555584333");
		dicionarioDePacotes.put("pacote11", "555288555123001");
		dicionarioDePacotes.put("pacote12", "111388555123555");
		dicionarioDePacotes.put("pacote13", "288000555367333");
		dicionarioDePacotes.put("pacote14", "066311555874001");
		dicionarioDePacotes.put("pacote15", "110333555123555");
		dicionarioDePacotes.put("pacote16", "333488555584333");
		dicionarioDePacotes.put("pacote17", "455448555123001");
		dicionarioDePacotes.put("pacote18", "022388555123555");
		dicionarioDePacotes.put("pacote19", "432044555845333");
		dicionarioDePacotes.put("pacote20", "034311555874001");
	}
	

	@Test
	public void regiaoDeDestinoComTotalDePacotes() { // 1
		
		criarLista();
		ListaDePacotes listaDePacotes = new ListaDePacotes(dicionarioDePacotes);
		listaDePacotes.processamento();
		
//		o total de pacotes de cada regiao de destino validos e invalidos
		assertEquals(3, listaDePacotes.getPacotesDestinoDoSul().size());
		assertEquals(2, listaDePacotes.getPacotesDestinoDoSudeste().size());
		assertEquals(2, listaDePacotes.getPacotesDestinoDoNorte().size());
		assertEquals(11, listaDePacotes.getPacotesDestinoDoNordeste().size());
		assertEquals(1, listaDePacotes.getPacotesDestinoDoCentroOeste().size());
		
//		o total de pacotes validos e invalidos
		assertEquals(20, listaDePacotes.getLinkedListDePacotes().size());
	}

	
	@Test
	public void saberQuaisPacotesSaoValidos() { // 2

		criarLista();
		ListaDePacotes listaDePacotes = new ListaDePacotes(dicionarioDePacotes);
		listaDePacotes.processamento();
		
//		na lista dicionarioPacotes.getPacotesValidos() contém os pacotes validos
		assertEquals(16, listaDePacotes.getPacotesValidos().size());
	}
	
	@Test
	public void brinquedosDaRegiaoSul() { // 3

		criarLista();
		ListaDePacotes listaDePacotes = new ListaDePacotes(dicionarioDePacotes);
		listaDePacotes.processamento();
		
//		na lista dicionarioPacotes.getPacotesDeBrinquedosDaRegiaoSul() contém os pacotes de brinquedos da regiao sul
		assertEquals(0, listaDePacotes.getPacotesDeBrinquedosDeOrigemDaRegiaoSul().size());
	}
	
	@Test
	public void listarPacotesPorRegiaoDeDestino() { // 4

		criarLista();
		ListaDePacotes listaDePacotes = new ListaDePacotes(dicionarioDePacotes);
		listaDePacotes.processamento();
//		apos fazer o processamento de todos os dados, estes agora são sobrescritos apenas com os pacotes validos
		listaDePacotes.procesamentoPacotesValidos();
		
//		o listar pacotes de cada regiao de destino validos
		
		System.out.println(listaDePacotes.getPacotesDestinoDoSul().toString());
		System.out.println(listaDePacotes.getPacotesDestinoDoSudeste().toString());
		System.out.println(listaDePacotes.getPacotesDestinoDoNorte().toString());
		System.out.println(listaDePacotes.getPacotesDestinoDoNordeste().toString());
		System.out.println(listaDePacotes.getPacotesDestinoDoCentroOeste().toString());
	}

	@Test
	public void listarPacotesPorVendedor() { // 5

		criarLista();
		ListaDePacotes listaDePacotes = new ListaDePacotes(dicionarioDePacotes);
		listaDePacotes.processamento();
		listaDePacotes.procesamentoPacotesValidos();
		
//		o listar pacotes de cada vendedor
		listaDePacotes.numeroDePacotesPorVendedor();
	}
	
	@Test
	public void listarPacaoDeDestino() { // 6

		criarLista();
		ListaDePacotes listaDePacotes = new ListaDePacotes(dicionarioDePacotes);
		listaDePacotes.processamento();
		listaDePacotes.procesamentoPacotesValidos();
		
//		o listar pacotes de cada regiao de destino validos
		System.out.println("sul");
		
//		lista os pacotes com cada tipo de produto
		listaDePacotes.tipoDeProdutoPorDestino(listaDePacotes.getPacotesDestinoDoSul());
		
		System.out.println("sudeste");
		listaDePacotes.tipoDeProdutoPorDestino(listaDePacotes.getPacotesDestinoDoSudeste());
		
		System.out.println("norte");
		listaDePacotes.tipoDeProdutoPorDestino(listaDePacotes.getPacotesDestinoDoNorte());
		
		System.out.println("nordeste");
		listaDePacotes.tipoDeProdutoPorDestino(listaDePacotes.getPacotesDestinoDoNordeste());
		
		System.out.println("centro-oeste");
		listaDePacotes.tipoDeProdutoPorDestino(listaDePacotes.getPacotesDestinoDoCentroOeste());
	}
	
	@Test
	public void rotaDeEntregaParaONorte() { // 7
		criarLista();
		ListaDePacotes listaDePacotes = new ListaDePacotes(dicionarioDePacotes);
		listaDePacotes.processamento();
		listaDePacotes.procesamentoPacotesValidos();
	
//		printa os pacotes que devem ser carregados no mesmo caminhao (centro-oeste, nordeste, norte - respectivamente)
		System.out.println(listaDePacotes.carregamentoCaminhao("norte"));
		
	}
	
	@Test
	public void ordemDeCarregamentoNaRotaDeEntregaParaONorte() { // 8
		criarLista();
		ListaDePacotes listaDePacotes = new ListaDePacotes(dicionarioDePacotes);
		listaDePacotes.processamento();
		listaDePacotes.procesamentoPacotesValidos();
	
/**		printa os pacotes que devem ser carregados no mesmo caminhao (norte, nordeste, centro-oeste, 
 * - respectivamente), assim o que vai ser entregue por ultimo fica ao fundo do caminhao, e os que
 * forem sendo entregues asntes vao ficando na frente deles
		**/
		System.out.println(listaDePacotes.inverter(listaDePacotes.carregamentoCaminhao("norte")));
	}
	
	@Test
	public void ordemDeCarregamentoNaRotaDeEntregaParaONortePriorizandoJoias() { // 9
		criarLista();
		ListaDePacotes listaDePacotes = new ListaDePacotes(dicionarioDePacotes);
		listaDePacotes.processamento();
//		nessa parte do codigo, já adiciona as joias no comeco da lista
		listaDePacotes.procesamentoPacotesValidos();

		System.out.println(listaDePacotes.inverter(listaDePacotes.carregamentoCaminhao("norte")));
	}
	
	@Test
	public void listarOsPacotesInvalidos() { // 10

		criarLista();
		ListaDePacotes listaDePacotes = new ListaDePacotes(dicionarioDePacotes);
		listaDePacotes.processamento();
		
//		printa os elementos invalidos
		System.out.println(listaDePacotes.getPacotesInvalidos().toString());
	}
}
