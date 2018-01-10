package TestCargaBatchV2;

import static org.junit.Assert.*;

import org.junit.Test;

import Archivo.CargaBatchV2.Contenedor;
import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.Cargadores.CargadorDeRepositorio;

public class TestCargadores extends RepositorioDePrueba {
	Contenedor contenedor;
	CargadorDeRepositorio cargador = new CargadorDeRepositorio();
	EmpresaToken token1 = new EmpresaToken("XD", "A", 2006, 105020);
	EmpresaToken token2 = new EmpresaToken("Khe", "Khe", 200, 20);
	
	@Test
	public void puedoDeterminarQueExisteUnaEmpresaDadaEnElRepo() {
		assertTrue(cargador.existeLaCarga(token1));
	}
	
	@Test
	public void puedoDeterminarQueNoExisteUnaEmpresaDadaEnElRepo() {
		assertFalse(cargador.existeLaCarga(token2));
	}
	
	@Test
	public void puedoAniadirUnaEmpresa() {
		cargador.realizarAlta(token2);

		assertTrue(cargador.existeLaCarga(token2));
	}
	
	@Test
	public void puedoModificarUnaEmpresa() {
		cargador.realizarModificacion(token1);
		
		assertEquals(repositorio.buscarObjeto("XD").getPeriodos().get(0).getCuentas().get(0).getValor(), new Integer(105020));
	}
	
	@Test
	public void puedoAniadirDosEmpresasQueNoExistan() {
		cargador.cargar(new EmpresaToken("KheKheKhe", "A", 2006, 105020));
		cargador.cargar(new EmpresaToken("YeahYeahYeah", "Khe", 200, 20));
		
		assertEquals(4, repositorio.buscarListaDeObjetos().size());
	}
	
	@Test
	public void puedoModificarDosEmpresasQueExistan() {
		cargador.cargar(new EmpresaToken("XD", "A", 2006, 105020));
		cargador.cargar(new EmpresaToken("DX", "Khe", 200, 20));
		
		assertEquals(2, repositorio.buscarListaDeObjetos().size());
	}
	
	@Test
	public void puedoAniadirUnaEmpresaQueNoExisteYModificarOtra() {
		cargador.cargar(new EmpresaToken("XD", "A", 2006, 105020));
		cargador.cargar(new EmpresaToken("KheKheKhe", "A", 2006, 105020));
		
		assertEquals(3, repositorio.buscarListaDeObjetos().size());
	}
	
	@Test
	public void puedoAniadirUnaEmpresaQueNoExistaPrimeroDandolaDeAltaYLuegoModificandola() {
		cargador.cargar(new EmpresaToken("Ah s� s�", "A", 2006, 105020));
		cargador.cargar(new EmpresaToken("Ah s� s�", "B", 2007, 11101));
		
		assertEquals(3, repositorio.buscarListaDeObjetos().size());
	}
}