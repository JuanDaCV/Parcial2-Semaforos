package JDCV;

class Persona implements Runnable {

    private Buffer buffer;

    public Persona(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.consumir();
                Thread.sleep(2000); // Espera antes de consumir el siguiente recurso  
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
