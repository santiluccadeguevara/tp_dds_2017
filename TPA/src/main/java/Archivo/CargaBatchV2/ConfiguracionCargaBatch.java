package Archivo.CargaBatchV2;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import Archivo.CargaBatchV2.Cargadores.CargadorDeRepositorio;
import Archivo.CargaBatchV2.Contenedores.ContenedorDeStrings;
import Archivo.CargaBatchV2.FuentesDeStrings.Archivo;
import Archivo.CargaBatchV2.Scanners.CSV;

public class ConfiguracionCargaBatch {
	public static void iniciar() throws FileNotFoundException {
		FuenteDeStrings fuente = new Archivo("cuentas/cuentitasDeHector.csv");
		StringScanner scanner = new CSV(",");
		
		Contenedor contenedor = new ContenedorDeStrings(fuente, scanner);
		Cargador cargador = new CargadorDeRepositorio();
		
		CargaBatch tarea = new CargaBatch(contenedor, cargador);
		
		Cronometro cron = new Cronometro();

		cron.ejecutaPeriodicamente(tarea, TimeUnit.SECONDS.toMillis(15));
	}
}
