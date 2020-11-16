package proyectomeia;

import proyectomeia.Clases.Singleton;

public class ProyectoMEIA {

    public static void main(String[] args) {
        Singleton datos = new Singleton();
        Inicio start = new Inicio(datos);
        start.setVisible(true);
    }
}