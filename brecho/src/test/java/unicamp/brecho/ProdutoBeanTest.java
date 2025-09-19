package unicamp.brecho;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import unicamp.brecho.ProdutoBean;

class ProdutoBeanTest {

	@Test
	void testDefaultConstructor() {
		var product = new ProdutoBean();
		assertNotNull(product.getCodigo());
		assertNotNull(product.getNome());
		assertNotNull(product.getDescricao());
		assertEquals(0.0, product.getValor());
		assertNotNull(product.getEstado());
	}

	@Test
	void testParameterizedConstructor() {
		var product = new ProdutoBean("123", "Produto", "Descricao", 10.0, "NOVO");
		assertEquals("123", product.getCodigo());
		assertEquals("Produto", product.getNome());
		assertEquals("Descricao", product.getDescricao());
		assertEquals(10.0, product.getValor());
		assertEquals("NOVO", product.getEstado());
	}

	@Test
	void testGettersAndSetters() {
		var product = new ProdutoBean();
		product.setCodigo("456");
		product.setNome("Outro");
		product.setDescricao("Outra descricao");
		product.setValor(20.0);
		product.setEstado("USADO");
		assertEquals("456", product.getCodigo());
		assertEquals("Outro", product.getNome());
		assertEquals("Outra descricao", product.getDescricao());
		assertEquals(20.0, product.getValor());
		assertEquals("USADO", product.getEstado());
	}

	@Test
	void testCompareToGreater() {
		var p1 = new ProdutoBean("1", "A", "D", 20.0, "NOVO");
		var p2 = new ProdutoBean("2", "B", "E", 10.0, "NOVO");
		assertEquals(1, p1.compareTo(p2));
	}

	@Test
	void testCompareToLess() {
		var p1 = new ProdutoBean("1", "A", "D", 5.0, "NOVO");
		var p2 = new ProdutoBean("2", "B", "E", 10.0, "NOVO");
		assertEquals(-1, p1.compareTo(p2));
	}

	@Test
	void testCompareToEqual() {
		var p1 = new ProdutoBean("1", "A", "D", 10.0, "NOVO");
		var p2 = new ProdutoBean("2", "B", "E", 10.0, "NOVO");
		assertEquals(0, p1.compareTo(p2));
	}
}