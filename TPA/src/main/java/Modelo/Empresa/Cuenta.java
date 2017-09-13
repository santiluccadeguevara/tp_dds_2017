package Modelo.Empresa;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import org.uqbar.commons.utils.Observable;
import Excepciones.Empresas.CuentaConValorNegativoException;
import Excepciones.Empresas.CuentaSinNombreException;
import Modelo.Indicadores.Expresion;
import Modelo.Indicadores.Expresiones;
import Modelo.Indicadores.Query;
import javax.persistence.Table;

@Entity
@Observable
@Table(name = "cuenta")
public class Cuenta extends Expresiones implements Expresion, Deserializa {	
	@Column(name = "cuenta_nombre")
	String nombre;
	@Column(name = "cuenta_valor")
	Integer valor;
	
	@SuppressWarnings("unused")
	private Cuenta(){};

	public Cuenta(String nombre, Integer nuevoValor) {
		this.setNombre(nombre);
		this.setValor(nuevoValor);
	}

	public Cuenta(String nuevoNombre) {
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == "") throw new CuentaSinNombreException();
		this.nombre = nombre;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		if(valor < 0) throw new CuentaConValorNegativoException();
		this.valor = valor;
	}

	public BigDecimal calcular(Query query) {
		return new BigDecimal(query.getEmpresa().buscarPeriodo(query.getPeriodo()).buscarCuenta(this.nombre).getValor());
	}
	
	public void addOperando(Expresiones operando){
		
	}
	
	public String imprimirFormula() {
		return nombre;
	}

}
