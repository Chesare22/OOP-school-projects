package test;

import modelo.Distribuidora;
import vista.DistribuidoraCLI;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DistribuidoraCLITest {

    public static void main(String[] args) throws IOException {
        Distribuidora distribuidora = new Distribuidora("Distribuidora Patito");
        DistribuidoraCLI cli = new DistribuidoraCLI(distribuidora);

        String reporte = cli.correr();
        guardarEnArchivo("reporte.txt", reporte);
        System.out.println("Se guardó el reporte en \"reporte.txt\"");
    }

    private static void guardarEnArchivo(String nombreDeArchivo, String contenido) throws IOException {
        File archivo = new File(nombreDeArchivo);
        if(!archivo.exists()){
            archivo.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(archivo);
        fileWriter.write(contenido);
        fileWriter.close();
    }
}
