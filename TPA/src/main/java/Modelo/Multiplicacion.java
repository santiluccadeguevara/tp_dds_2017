package Modelo;

import java.math.BigDecimal;
import java.util.List;

public class Multiplicacion implements Operacion{
	
	String operando1, operando2;
	
	public Multiplicacion(String operando1, String operando2) {
		this.operando1 = operando1;
		this.operando2 = operando2;
	}
	
	public BigDecimal aplicar(List <Cuenta> cuentas){
	    BigDecimal valorA,valorB;
	    valorA = Determinador.determinar(operando1,cuentas);
	    valorB = Determinador.determinar(operando2,cuentas);
	    return valorA.multiply(valorB);
	}
}