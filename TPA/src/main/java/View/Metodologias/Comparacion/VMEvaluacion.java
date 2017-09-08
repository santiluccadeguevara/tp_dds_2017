package View.Metodologias.Comparacion;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import Modelo.Empresa.BolsaDeEmpresas;
import Modelo.Empresa.Empresa;
import Modelo.Metodologias.Metodologia;
import Modelo.Metodologias.MetodologiasRepository;

@Observable
public class VMEvaluacion {
	

	public List<String> listaDeEmpresas;
	public List<String> listaDeMetodologias;
	public List<String> listaDeEmpresasSinEmpresaElegida;
	public String nombreEmpresaElegida;
	public Empresa empresaElegida;
	public String nombreEmpresaB;
	public Empresa empresaB;
	public String nombreMetodologiaElegida;
	public Metodologia metodologiaElegida;
	
	public VMEvaluacion (){
		
		super();
		listaDeEmpresas = BolsaDeEmpresas.getInstancia().getNombresDeEmpresas();
		listaDeMetodologias = MetodologiasRepository.getInstancia().nombresDeMetodologias();
		
	}
		
	public void buscarEmpresa() {
		setEmpresaElegida(BolsaDeEmpresas.getInstancia().buscarEmpresa(getNombreEmpresaElegida()));
	}
	
	public void buscarMetodologia(){
		
		setMetodologiaElegida(MetodologiasRepository.getInstancia().obtenerMetodologia(nombreMetodologiaElegida));
	}

	public String getNombreEmpresaB() {
		
	return nombreEmpresaB;
	
	}

	public void setNombreEmpresaB(String nombreEmpresaB) {
		
	this.nombreEmpresaB = nombreEmpresaB;
	
	}

	public Empresa getEmpresaB() {
		
	return empresaB;
	
	}

	public void setEmpresaB(Empresa empresaB) {
		
	this.empresaB = empresaB;
	
	}

	public List<String> getListaDeEmpresas() {
		return listaDeEmpresas;
	}

	public void setListaDeEmpresas(List<String> listaDeEmpresas) {
		this.listaDeEmpresas = listaDeEmpresas;
	}

	public List<String> getListaDeMetodologias() {
		return listaDeMetodologias;
	}

	public void setListaDeMetodologias(List<String> listaDeMetodologias) {
		this.listaDeMetodologias = listaDeMetodologias;
	}

	public String getNombreEmpresaElegida() {
		return nombreEmpresaElegida;
	}

	public void setNombreEmpresaElegida(String nombreEmpresaElegida) {
		this.nombreEmpresaElegida = nombreEmpresaElegida;
	}

	public Empresa getEmpresaElegida() {
		return empresaElegida;
	}

	public void setEmpresaElegida(Empresa empresaElegida) {
		this.empresaElegida = empresaElegida;
	}

	public String getNombreMetodologiaElegida() {
		return nombreMetodologiaElegida;
	}

	public void setNombreMetodologiaElegida(String nombreMetodologiaElegida) {
		this.nombreMetodologiaElegida = nombreMetodologiaElegida;
	}

	public Metodologia getMetodologiaElegida() {
		return metodologiaElegida;
	}

	public void setMetodologiaElegida(Metodologia metodologiaElegida) {
		this.metodologiaElegida = metodologiaElegida;
	}
	
	
	public void buscarEmpresaB() {
		setEmpresaB(BolsaDeEmpresas.getInstancia().buscarEmpresa(getNombreEmpresaB()));
	}
	
	public void generarListaSinPrimerEmpresaElegida() {
		
		setListaDeEmpresasSinEmpresaElegida(listaDeEmpresas.stream().filter(x -> !x.equals(nombreEmpresaElegida)).collect(Collectors.toList()));
		
	}

	public void setListaDeEmpresasSinEmpresaElegida(List<String> listaDeEmpresasSinEmpresaElegida) {
	this.listaDeEmpresasSinEmpresaElegida = listaDeEmpresasSinEmpresaElegida;
	
	}
	
	public List<String> getListaDeEmpresasSinEmpresaElegida() {
		return listaDeEmpresasSinEmpresaElegida;
	}
	
}