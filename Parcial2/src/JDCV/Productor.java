package JDCV;

class Productor implements Runnable {

    private Buffer buffer;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 11; i++) {
                Recurso nuevo = new Recurso(i);
                buffer.producir(nuevo);
                Thread.sleep(4000); // Espera antes de producir el siguiente recurso  
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
