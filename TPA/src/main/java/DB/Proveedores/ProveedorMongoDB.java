package DB.Proveedores;

import DB.MongoDBManager;
import DB.Repositorios.Repositorio;
import DB.TiposDeRepositorios.RepoDocumental;
import DB.TiposDeRepositorios.TipoDeRepositorio;
import Modelo.Indicadores.Precalculado;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import com.mongodb.client.MongoCursor;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class ProveedorMongoDB<T extends TipoDeRepositorio> extends MongoDBManager implements Proveedor<T> {

    private RepoDocumental repoMongo;

    public ProveedorMongoDB(RepoDocumental repoMongo) {
        this.repoMongo = repoMongo;
    }

    @Override
    public T ejecutarQuery(Object query) {
        Document json = ejecutarQueryMongo(repoMongo.getTabla(), (Bson) query);
        T objeto = (T) repoMongo.jsonToObjeto(json);
        return objeto;
    }

    @Override
    public List<T> EjecutarQueryReturnList(Object query){
        List<Document> list = ejecutarQueryMongoReturnList(repoMongo.getTabla(), (Bson) query);
        List<T> lista = new ArrayList<T>();
        for(Document json : list){
            lista.add((T) repoMongo.jsonToObjeto(json));
        }
        return lista;
    }


    @Override
    public void eliminarConQuery(Object query) {
        eliminarPorQuery(repoMongo.getTabla(), (Bson) query);
    }

    @Override
    public List<T> darLista(String unTipo) {
        List<T> lista = new ArrayList<>();
        List<Document> list = getElementsColecction(unTipo);
        for(Document json : list){
            lista.add((T)repoMongo.jsonToObjeto(json));
        }
        return lista;
    }

    @Override
    public void agregar(T unObjeto) {
        Document doc = repoMongo.crearDocument(unObjeto);
        addObjectMongo(repoMongo.getTabla(), doc);
    }

    @Override
    public void agregarLista(List<T> listaObjetos) {
        List<Document> documents = new ArrayList<Document>();
        for(T obj : listaObjetos){
            documents.add(repoMongo.crearDocument(obj));
        }
        addListMongo(repoMongo.getTabla(),documents);
    }

    @Deprecated
    @Override
    public void eliminar(T unObjeto) {
    }

    @Deprecated
    @Override
    public List<String> darListaNombres(String unTipo) {
        return null;
    }

    @Deprecated
    @Override
    public T darObjeto(String unNombre, String unTipo) {
        return null;
    }

    @Deprecated
    @Override
    public void modificar(T unObjeto) {}
}