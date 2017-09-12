package Modelo.Indicadores;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.uqbar.commons.utils.Observable;

@Entity
@Table(name = "cuenta_indicadores")
public class Cuenta_Indicadores extends Expresiones{
	@Column(name = "cuenta_indi_id")
	String nombre;
	//No olvidarse de cambiar en la UI para que en el proceso de crear indicadores se use esta clase y no la de la del paquete empresas
	
	public Cuenta_Indicadores(String nombre){
		this.nombre = nombre;
	}
	
	public Cuenta_Indicadores(){};

	//Estan vacios ya que es solo para la creacion de los indicadores, al momento de evaluar se usa la clase cuenta de el paquete empresa que tiene los valores
	@Override
	public BigDecimal calcular(Query query) {
		return new BigDecimal(query.getEmpresa().buscarPeriodo(query.getPeriodo()).buscarCuenta(this.nombre).getValor());
	}

	@Override
	public void addOperando(Expresiones operando) {
		
	}

	@Override
	public String imprimirFormula() {
		return nombre;
	}

}
