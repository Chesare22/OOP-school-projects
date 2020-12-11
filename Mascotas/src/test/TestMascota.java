package test;

import modelo.Gato;
import modelo.Mascota;
import modelo.Perro;
import modelo.Vaca;

public class TestMascota {
    public static void main(String[] args) {
        Mascota mascota;
        
        mascota = new Perro();
        System.out.println(mascota.habla());
        System.out.println(((Perro) mascota).trae());

        mascota = new Gato();
        System.out.println(mascota.habla());

        mascota = new Vaca();
        System.out.println(mascota.habla());
    }
}

