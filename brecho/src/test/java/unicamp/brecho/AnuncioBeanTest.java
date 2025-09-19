package unicamp.brecho;

import unicamp.brecho.AnuncianteBean;
import unicamp.brecho.ProdutoBean;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AnuncioBeanTest {

    @Test
    void testDefaultConstructor() {
        AnuncioBean anuncio = new AnuncioBean();
        assertNotNull(anuncio.getProduto());
        assertNotNull(anuncio.getFotosUrl());
        assertEquals(0.0, anuncio.getDesconto());
    }

    @Test
    void testParameterizedConstructor() throws MalformedURLException {
        ProdutoBean produto = new ProdutoBean("1", "Nome", "Desc", 100.0, "NOVO");
        ArrayList<URL> fotos = new ArrayList<>();
        fotos.add(new URL("http://example.com/foto1.jpg"));
        AnuncioBean anuncio = new AnuncioBean(produto, fotos, 0.2);
        assertEquals(produto, anuncio.getProduto());
        assertEquals(fotos, anuncio.getFotosUrl());
        assertEquals(0.2, anuncio.getDesconto());
    }

    @Test
    void testGettersAndSetters() throws MalformedURLException {
        AnuncioBean anuncio = new AnuncioBean();
        ProdutoBean produto = new ProdutoBean("2", "Outro", "Descricao", 50.0, "USADO");
        ArrayList<URL> fotos = new ArrayList<>();
        fotos.add(new URL("http://example.com/foto2.jpg"));
        anuncio.setProduto(produto);
        anuncio.setFotosUrl(fotos);
        anuncio.setDesconto(0.5);
        assertEquals(produto, anuncio.getProduto());
        assertEquals(fotos, anuncio.getFotosUrl());
        assertEquals(0.5, anuncio.getDesconto());
    }

    @Test
    void testGetValorSmallDiscount() {
        ProdutoBean produto = new ProdutoBean("3", "Teste", "Desc", 100.0, "NOVO");
        AnuncioBean anuncio = new AnuncioBean(produto, new ArrayList<>(), 0.2);
        assertEquals(80, anuncio.getValor());
    }
    
    @Test
    void testGetValorZeroDiscount() {
        ProdutoBean produto = new ProdutoBean("3", "Teste", "Desc", 100.0, "NOVO");
        AnuncioBean anuncio = new AnuncioBean(produto, new ArrayList<>(), 0.0);
        assertEquals(100, anuncio.getValor());
    }
}