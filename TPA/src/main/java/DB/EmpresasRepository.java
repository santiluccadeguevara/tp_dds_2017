package DB;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import Modelo.Empresa.Empresa;

public class EmpresasRepository extends DBManager {
	
	private static EmpresasRepository bolsa = null;
	
	public List<Empresa> getEmpresas() {
		return (List<Empresa>) createQuery("from Empresa").getResultList();
	}

	public void insertarListaDeEmpresas(List<Empresa> empresas) {
	  	beginTransaction();
    	for (Empresa e : empresas){
    		persist(e);
    	}
    	commit();
	}

	public Empresa buscarEmpresa(String nombre) {
		return (Empresa) createQuery("from Empresa e where e.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();
	}
	
	public List<String> getNombresDeEmpresas() {
		return (List<String>) createQuery("select e.nombre from Empresa e").getResultList();	
	}
	
    public static EmpresasRepository getInstancia() {
		
		if(bolsa == null){
			bolsa = new EmpresasRepository();
		}
		
		return bolsa;
	}
}
