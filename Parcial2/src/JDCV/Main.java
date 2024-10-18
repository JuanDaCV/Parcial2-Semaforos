package JDCV;

public class Main {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(10); // Cambia el tamaño del buffer  

        // Crear productores  
        Thread productor1 = new Thread(new Productor(buffer), "Productor Paco");
        Thread productor2 = new Thread(new Productor(buffer), "Productor Fabian");

        // Crear consumidores  
        Thread consumidor1 = new Thread(new Persona(buffer), "Juan");
        Thread consumidor2 = new Thread(new Persona(buffer), "Anna");
        Thread consumidor3 = new Thread(new Persona(buffer), "Sofi");
        Thread consumidor4 = new Thread(new Persona(buffer), "Jose");
        Thread consumidor5 = new Thread(new Persona(buffer), "Gabi");

        // Iniciar hilos  
        productor1.start();
        productor2.start();
        consumidor1.start();
        consumidor2.start();
        consumidor3.start();
        consumidor4.start();
        consumidor5.start();
    }
}
