package Archivo.CargaBatchV2.Excepciones;

public class CantidadCamposIncorrectosException extends RuntimeException implements ScannerException {
	private int cantidadActualCampos;
	
	public CantidadCamposIncorrectosException(int unaCantidadDeCampos) {
		cantidadActualCampos = unaCantidadDeCampos;
	}
	
	public int camposDeMasOMenos() {
		return Math.abs(4 - cantidadActualCampos);
	}
}
