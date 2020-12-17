package vista;

import modelo.LectorDeTemperaturasDesdeArchivo;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerDatosDesdeArchivo extends Opción{

    public LeerDatosDesdeArchivo(String etiqueta, String mensajeDeError) {
        super(etiqueta, mensajeDeError);
    }

    @Override
    public Double[][] ejecutar() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresar nombre de archivo: ");
        String nombreDeArchivo = scanner.nextLine();
        return new LectorDeTemperaturasDesdeArchivo(nombreDeArchivo).leerTemperaturas();
    }
}
