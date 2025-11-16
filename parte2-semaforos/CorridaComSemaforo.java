import java.util.concurrent.Semaphore;

public class CorridaComSemaforo {

    private static int contador = 0;
    private static final Semaphore semaforo = new Semaphore(1);

    public static void main(String[] args) {

        Runnable tarefa = () -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    semaforo.acquire();   // trava o recurso
                    contador++;           // seção crítica protegida
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaforo.release();   // libera o recurso
                }
            }
        };

        Thread t1 = new Thread(tarefa);
        Thread t2 = new Thread(tarefa);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor final do contador: " + contador);
    }
}
