package Modelo.Metodologias.Condiciones;

import DB.Repositorios.RepositorioIndicadores;
import Modelo.Empresa.Deserializa;
import Modelo.Empresa.Empresa;

public class Indicador implements Condiciones, Deserializa{

	private Modelo.Indicadores.Indicador indicador;

	public Indicador(Modelo.Indicadores.Indicador indicador) {
		this.indicador = indicador;
	}

	@Override
	public boolean cumple(Empresa empresa) {
		return RepositorioIndicadores.getInstancia().buscarListaDeObjetos("BD").contains(indicador);
	}
	
	@Override
	public String mostrarCadena() {
		return "El indicador " + indicador.getNombre() + "";
	}
}
