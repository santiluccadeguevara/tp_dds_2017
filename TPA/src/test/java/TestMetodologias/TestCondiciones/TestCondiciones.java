package TestMetodologias.TestCondiciones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Archivo.Empresa.Instanciador;
import DB.Proveedores.ProveedorMock;
import DB.Repositorios.RepositorioEmpresas;
import Modelo.Empresa.Empresa;


public abstract class TestCondiciones {
	
	@Before
	public void x() throws IOException{
		RepositorioEmpresas.getInstancia().setProveedor(new ProveedorMock<Empresa>(Instanciador.obtenerEmpresas("repositorioMetodologiasMock.csv")));
	}
	
	@Test
	public void aplicarMayorAListaVacia() {
		List<Integer> list = new ArrayList<Integer>();
		
		Assert.assertEquals(true, list.stream().allMatch(num -> num >2));			
	}
	
	@Test
	public void estaEntreDebeRetornar_UnaListaVacia_SiNotieneLaCantidadDePeriodosNecesariosParaEvaluar(){
		Empresa empresa = RepositorioEmpresas.getInstancia().buscarObjeto("Rolito");
		Assert.assertTrue(empresa.getPeriodos().stream().filter(periodo -> periodo.estaEntre(20, empresa.getPeriodos(), periodo)).collect(Collectors.toList()).size() == 0);
	}
	
	
}
		
