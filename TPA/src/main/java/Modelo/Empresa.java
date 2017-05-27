package Modelo;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


import org.uqbar.commons.utils.Observable;

@Observable
public class Empresa{
	
	private String nombre;
	private List<Periodo> periodos = new ArrayList<Periodo>();
	
	// Esto solo lo usa el Parser para crear la empresa r�pidamente
	public Empresa(String nuevoNombre, String nombreDeCuenta, String periodo, String valor) {
		nombre = nuevoNombre;		
		periodos.add(new Periodo(Integer.parseInt(periodo), new Cuenta(nombreDeCuenta, Integer.parseInt(valor))));
	}
	
	public Empresa(String nuevoNombre, List<Periodo> nuevosPeriodos) {
		nombre = nuevoNombre;
		periodos = nuevosPeriodos;
	}

	public Empresa(String nuevoNombre, Periodo nuevoPeriodo) { // Agregar un periodo
		nombre = nuevoNombre;
		periodos.add(nuevoPeriodo);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}
	
	public List<Integer> obtenerPeriodos(){
		List<Integer> periodosEmpresa = this.getPeriodos().stream().map(p -> p.getAnio()).collect(Collectors.toList());
		return periodosEmpresa;
	}
	
	public List<Cuenta> obtenerCuentasEnPeriodo(int periodo){
		Periodo periodoSeleccionado = this.getPeriodos().stream().filter(p -> p.getAnio() == periodo).findFirst().get();
		List<Cuenta> cuentas = periodoSeleccionado.getCuentas();
	    return cuentas;
	}
}