package TestCargaBatchV2;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.Contenedores.ContenedorDeStrings;
import Archivo.CargaBatchV2.Excepciones.DeScaneo.NoFueEscaneadoException;
import Archivo.CargaBatchV2.FuentesDeStrings.MockArchivo;
import Archivo.CargaBatchV2.Scanners.CSV;

public class TestContenedorDeStrings {
	ContenedorDeStrings contenedor, contenedorMedioFallado, contenedorFallado, contenedorVacio;
	
	private ContenedorDeStrings inicioDeContenedor(String texto) {
		MockArchivo fuente  = new MockArchivo(texto);
		CSV scanner = new CSV(",");
		
		return new ContenedorDeStrings(fuente, scanner);
	}
	
	@Before
	public void iniciarContenedores() {
		contenedor = inicioDeContenedor("Rolito,EDITBA,2000,8000\nAxel's Consortium Bags,FCF,2017,6969");
		contenedorVacio = inicioDeContenedor("");
		contenedorMedioFallado = inicioDeContenedor("EDITBA,2000,8000\nAxel's Consortium Bags,FCF,2017,6969");
		contenedorFallado = inicioDeContenedor(",EDITBA,Lepra,8000\nAxel's Consortium Bags,FCF,2017,6969,Khe");
		
		contenedor.abrirse();
		contenedorVacio.abrirse();
		contenedorMedioFallado.abrirse();
		contenedorFallado.abrirse();
	}
	
	@After
	public void cerrarContenedores() {
		contenedor.cerrarse();
		contenedorVacio.cerrarse();
		contenedorMedioFallado.cerrarse();
		contenedorFallado.cerrarse();	
	}
	
	@Test
	public void sePuedeParsearExitosamente() {
		EmpresaToken empresa1 = new EmpresaToken("Rolito", "EDITBA", "2000", "8000");
		EmpresaToken empresa2 = new EmpresaToken("Axel's Consortium Bags", "FCF", "2017", "6969");
		
		List<EmpresaToken> escaneo = contenedor.serEscaneado();
		
		EmpresaToken[] esperado = {empresa1, empresa2};
		EmpresaToken[] actual = {escaneo.get(0), escaneo.get(1)};
		
		assertArrayEquals(esperado, actual);
	}
	
	@Test(expected = NoFueEscaneadoException.class)
	public void noPuedoDeterminarSiHayFallosEnUnContenedorSiNoLoEscaneo() {
		contenedor.tieneFallos();
	}
	
	@Test
	public void noHayFallosEnUnContenedorCorrecto() {
		contenedor.serEscaneado();
		
		assertFalse(contenedor.tieneFallos());
	}
	
	@Test
	public void noHayFallosSiNoHayNadaEnElContenedor() {
		contenedorVacio.serEscaneado();
		
		assertFalse(contenedorVacio.tieneFallos());
	}
	
	@Test
	public void hayFallosSiHayErroresEnElContenedor() {
		contenedorMedioFallado.serEscaneado();
		
		assertTrue(contenedorMedioFallado.tieneFallos());
	}
	
	@Test
	public void soloSeEscaneanLasCosasSinErroresDeUnContenedor() {
		EmpresaToken esperado = new EmpresaToken("Axel's Consortium Bags", "FCF", "2017", "6969");
		
		EmpresaToken actual = contenedorMedioFallado.serEscaneado().get(0);
		
		assertEquals(actual, esperado);
	}
	
	@Test
	public void siSoloHayErroresNoDeberiaEscanearseNada() {
		assertTrue(contenedorFallado.serEscaneado().isEmpty());
	}
	
	@Test
	public void noDeberiaEscanearseNadaSiNoHayNada() {
		assertTrue(contenedorVacio.serEscaneado().isEmpty());
	}
}