package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import codigo.Pacote;

public class PacoteTest {
	Pacote leitor = new Pacote("033334555999000");
	
	@Test
	void criarPacoteTest() {
		assertEquals("sudeste", leitor.getRegiaoOrigem());
		assertEquals("nordeste", leitor.getRegiaoDestino());
		assertEquals(999, leitor.getCodigoVendedor() );
	}
	
}
