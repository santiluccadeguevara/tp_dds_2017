package View.Metodologias.Comparacion;


import java.util.List;
import org.uqbar.commons.utils.Observable;

import Modelo.Metodologias.Resultados.ResultadoAdapterView;



@Observable
public class VMResultadoMultiple {
	
	
	public List<ResultadoAdapterView> listaResultadosAdapter;
	
	
	

	public VMResultadoMultiple(List<ResultadoAdapterView> listaResultados) {
		super();
		this.listaResultadosAdapter = listaResultados;
		
		}

	

	public List<ResultadoAdapterView> getListaResultadosAdapter() {
		return listaResultadosAdapter;
	}

	public void setListaResultadosAdapter(List<ResultadoAdapterView> listaResultadosAdapter) {
		this.listaResultadosAdapter = listaResultadosAdapter;
	}



}
