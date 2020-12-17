package vista;

import modelo.LectorDeTemperaturasDesdeCLI;

public class LeerDatosDesdeTerminal extends Opción{
    public LeerDatosDesdeTerminal(String etiqueta, String mensajeDeError) {
        super(etiqueta, mensajeDeError);
    }

    @Override
    public Double[][] ejecutar() throws Exception {
        return new LectorDeTemperaturasDesdeCLI().leerTemperaturas();
    }
}
