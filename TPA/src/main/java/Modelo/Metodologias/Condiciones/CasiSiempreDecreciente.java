package Modelo.Metodologias.Condiciones;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import Modelo.Indicadores.Indicador;
import Modelo.Metodologias.Try;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CASI_SIEMPRE_DECRECIENTE")
public class CasiSiempreDecreciente extends Comportamiento {

	@Id
	@GeneratedValue
	private long id_casi_siempre_decreciente;

	public CasiSiempreDecreciente(Indicador indicador, int anios) {
		super(indicador, anios);
	}

	public CasiSiempreDecreciente() {
	}

	@Override
	protected boolean satisface(List<Boolean> comportamiento) {
		
		return comportamiento.stream().filter(bool->bool).collect(Collectors.toList()).size() <= 1;
	}

	@Override
	protected boolean comparacion(Try<BigDecimal> try1, Try<BigDecimal> try2) {

		return this.esMayor(try1, try2);
	}

	@Override
	public String mostrarCadena() {
		return "El indicador " + indicador.getNombre() + " es casi siempre decreciente en " + String.valueOf(anios) + " a�os";
	}
	
}
