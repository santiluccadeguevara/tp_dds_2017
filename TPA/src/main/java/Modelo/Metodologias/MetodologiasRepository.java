package Modelo.Metodologias;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Modelo.Indicadores.IndicadoresRepository;
import Modelo.Metodologias.Condiciones.MayorAEnPeriodos;
import Excepciones.Metodologias.NoExisteLaMetodologiaException;
import Excepciones.Empresas.NoExisteLaEmpresaException;
import Modelo.Empresa.Empresa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Modelo.Indicadores.IndicadoresRepository;
import Modelo.Metodologias.Condiciones.MayorAEnPeriodos;


public class MetodologiasRepository {

	private static MetodologiasRepository instancia = null;

	private List<Metodologia> listaMetodologias = new ArrayList<Metodologia>();

	public static MetodologiasRepository getInstancia() {
		if (instancia == null) {
			instancia = new MetodologiasRepository();
			instancia.agregarMetodologia(new Metodologia("PRUEBA_MayorAEnPeriodos", new MayorAEnPeriodos(IndicadoresRepository.getInstancia().getIndicadores().get(0), new BigDecimal(500), 1)));
		}
		return instancia;
	}

	public List<Metodologia> getListaMetodologias() {
		return listaMetodologias;
	}
	
	public void setListaMetodologias(List<Metodologia> listaMetodologias) {
		this.listaMetodologias = listaMetodologias;
	}
	
	public void agregarMetodologia(Metodologia metodologia) {
		listaMetodologias.add(metodologia);
	}
	
	public void removerMetodologia(Metodologia metodologia) {
		listaMetodologias.remove(metodologia);
	}
	
	public void removerMetodologia(String metodologia) {
		this.removerMetodologia(this.obtenerMetodologia(metodologia));
	}
	
	public Metodologia obtenerMetodologia(String nombreDeMetodologia) {
		try{
			Metodologia metodologiaBuscada= instancia.getListaMetodologias().stream().filter( m -> m.getNombre().equals(nombreDeMetodologia)).findFirst().get();
			return metodologiaBuscada;
		} catch(RuntimeException e){
			throw new NoExisteLaMetodologiaException();
		}
	}
	
	public List<String> nombresDeMetodologias() {
		return listaMetodologias.stream().map(miMetodologia -> miMetodologia.getNombre()).collect(Collectors.toList());
	}
}
