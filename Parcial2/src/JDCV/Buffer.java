package JDCV;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

class Buffer {

    private Queue<Recurso> buffer;
    private int capacidad;

    // Semáforos para controlar el acceso  
    private Semaphore mutex; // Semáforo binario para acceso exclusivo al buffer  
    private Semaphore espacios; // Semáforo contador para espacios disponibles  
    private Semaphore items; // Semáforo contador para elementos disponibles  

    public Buffer(int capacidad) {
        this.buffer = new LinkedList<>();
        this.capacidad = capacidad;

        // Inicializando semáforos  
        this.mutex = new Semaphore(1); // 1 para asegurar acceso exclusivo  
        this.espacios = new Semaphore(capacidad); // Inicialmente hay capacidad máxima  
        this.items = new Semaphore(0); // No hay elementos al inicio  
    }

    public void producir(Recurso rec) throws InterruptedException {
        espacios.acquire(); // Espera si no hay espacios disponibles  
        mutex.acquire(); // Adquiere el mutex para acceder al buffer  

        buffer.add(rec); // Agrega el recurso al buffer  
        System.out.println("    ▲ Recurso [" + rec.getId() + "] producido ▼");

        mutex.release(); // Libera el mutex  
        items.release(); // Indica que hay un nuevo recurso disponible  
    }

    public Recurso consumir() throws InterruptedException {
        items.acquire(); // Espera si no hay elementos disponibles  
        mutex.acquire(); // Adquiere el mutex para acceder al buffer  

        Recurso res = buffer.poll(); // Extrae el recurso del buffer  
        System.out.println("Recurso [" + res.getId() + "] -►☺ consumido por " + Thread.currentThread().getName());

        mutex.release(); // Libera el mutex  
        espacios.release(); // Indica que hay espacio disponible en el buffer  
        return res;
    }
}
