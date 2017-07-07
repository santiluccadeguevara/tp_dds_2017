package View.Metodologias;

import org.uqbar.commons.utils.Observable;

import Modelo.Empresa.BolsaDeEmpresas;
import Modelo.Metodologias.MetodologiasRepository;
import Modelo.Metodologias.Resultados.Ganador;
import Modelo.Metodologias.Resultados.Resultado;


@Observable
public class VMResultadoDual {
	
	public Resultado resultado;

	public VMResultadoDual(Resultado resultado) {
		super();
		setResultado(resultado);
		}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}




}