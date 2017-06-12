package View.Indicadores;

import java.util.List;

import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import Modelo.Indicadores.CadenaActualDeMiIndicador;
import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.IndicadorBuilder;
import Modelo.Indicadores.IndicadoresRepository;

@Observable
public class VMAgregarIndicador extends VMAgregar  {
	
	public String nombreDeIndicadorElegido;
	public List<String> nombresDeIndicadoresExistentes;
	public IndicadorBuilder miIndicadorBuilder;
	
	public VMAgregarIndicador(IndicadorBuilder indicadorBuilder) {
		super(indicadorBuilder);
		nombresDeIndicadoresExistentes = IndicadoresRepository.getInstancia().getIndicadores().stream().map(i -> i.getNombre()).collect(Collectors.toList());
	}

	public IndicadorBuilder getMiIndicadorBuilder() {
		return miIndicadorBuilder;
	}

	public void setMiIndicadorBuilder(IndicadorBuilder miIndicadorBuilder) {
		this.miIndicadorBuilder = miIndicadorBuilder;
	}

	public String getNombreDeIndicadorElegido() {
		return nombreDeIndicadorElegido;
	}

	public void setNombreDeIndicadorElegido(String nombreDeIndicadorElegido) {
		this.nombreDeIndicadorElegido = nombreDeIndicadorElegido;
	}

	public List<String> getNombresDeIndicadoresExistentes() {
		return nombresDeIndicadoresExistentes;
	}

	public void setNombresDeIndicadoresExistentes(List<String> nombresDeIndicadoresExistentes) {
		this.nombresDeIndicadoresExistentes = nombresDeIndicadoresExistentes;
	}
	
	public Indicador devolverIndicador() {
		return IndicadoresRepository.getInstancia().getIndicador(nombreDeIndicadorElegido);	
	}
	
	public String getMiCadena() {
		return CadenaActualDeMiIndicador.instanciar().mostrarCadenaActual();
	}
	
	
	
	
}