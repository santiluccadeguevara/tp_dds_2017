package Modelo.Indicadores;

import java.math.BigDecimal;

public abstract class Expresion {

	public abstract BigDecimal calcular(Query query);

}