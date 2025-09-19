package unicamp.brecho;

import org.junit.jupiter.api.Test;

import unicamp.brecho.AnuncioBean;
import unicamp.brecho.AnuncianteBean;
import unicamp.brecho.ProdutoBean;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class AnuncianteBeanTest {
    @Test
    void testAddRemoveAnuncio() {
        AnuncianteBean anunciante = new AnuncianteBean();
        AnuncioBean a1 = new AnuncioBean();
        AnuncioBean a2 = new AnuncioBean();
        anunciante.addAnuncio(a1);
        anunciante.addAnuncio(a2);
        assertEquals(2, anunciante.getAnuncios().size());
        anunciante.removeAnuncio(0);
        assertEquals(1, anunciante.getAnuncios().size());
    }

    @Test
    void testValorMedioAnuncios() {
        ProdutoBean p1 = new ProdutoBean("1", "A", "D", 100.0, "Novo");
        ProdutoBean p2 = new ProdutoBean("2", "B", "E", 200.0, "Novo");
        AnuncioBean a1 = new AnuncioBean(p1, new ArrayList<>(), 0.1); // 90
        AnuncioBean a2 = new AnuncioBean(p2, new ArrayList<>(), 0.2); // 160
        AnuncianteBean anunciante = new AnuncianteBean();
        anunciante.addAnuncio(a1);
        anunciante.addAnuncio(a2);
        assertEquals(125.0, anunciante.valorMedioAnuncios());
    }

    @Test
    void testValorMedioAnunciosVazio() {
        AnuncianteBean anunciante = new AnuncianteBean();
        assertEquals(0.0, anunciante.valorMedioAnuncios());
    }
}
