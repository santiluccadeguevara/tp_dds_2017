package Main;

import java.io.IOException;

import DB.Repositorios.RepositorioMetodologias;
import Modelo.Empresa.Empresa;
import Modelo.Indicadores.Indicador;
import Modelo.Metodologias.Metodologia;
import Archivo.Empresa.Instanciador_Bolsa_Empresas;
import DB.Proveedores.ProveedorBD;
import DB.Repositorios.RepositorioEmpresas;
import DB.Repositorios.RepositorioIndicadores;

public class Main {
	
	public static void main(String[] args) throws IOException {
		iniciarModelo();
		
		WebMain.iniciarInterfazWeb();
	}

	public static void iniciarModelo()  throws IOException {
		RepositorioEmpresas.getInstancia().setProveedor(new ProveedorBD<Empresa>());
		
		RepositorioIndicadores.getInstancia().setProveedor(new ProveedorBD<Indicador>());

		RepositorioMetodologias.getInstancia().setProveedor(new ProveedorBD<Metodologia>());

		new Instanciador_Bolsa_Empresas().instanciar();
	}
}