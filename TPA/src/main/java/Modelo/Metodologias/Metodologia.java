package Modelo.Metodologias;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import DB.TipoDeRepositorio;
import Modelo.Empresa.Empresa;
import Modelo.Metodologias.Condiciones.Condiciones;

import javax.persistence.*;

@Entity
@Table(name = "metodologia")
public class Metodologia implements TipoDeRepositorio {

	@Id
	@GeneratedValue
	@Column(name = "metolodogia_id")
	private long id_metodologia;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "metodologia_fk_id",  referencedColumnName = "metolodogia_id")
	private List<Condiciones> listaCondiciones = new ArrayList<Condiciones>();
	
	//Para crearse debe tener al menos una condicion, no se como afectara esto en la vista
	//Supongo que haran un builder, seria lo mas logico asi no cambian el modelo
	public Metodologia(String nombre, Condiciones condicion) {
		this.nombre = nombre;
		this.addCondicion(condicion);
	}
	
	public Metodologia(String nombre, List<Condiciones> condiciones){
		this.nombre = nombre;
		this.listaCondiciones = condiciones;
	}

	public Metodologia() {
	}

	public void addCondicion(Condiciones condicion){
		listaCondiciones.add(condicion);
	}
	
	public boolean cumple(Empresa empresa){
		return listaCondiciones.stream().allMatch(condicion -> condicion.cumple(empresa));
	}
	
	public String getCadena() {
		return String.join(" && ", listaCondiciones.stream().map(c -> c.mostrarCadena()).collect(Collectors.toList()));
	}

	public String getNombre() {
		return nombre;
	}

	public List<Condiciones> getListaCondiciones() {
		return listaCondiciones;
	}

}
