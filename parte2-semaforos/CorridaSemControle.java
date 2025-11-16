public class CorridaSemControle {

    static int contador = 0;

    public static void main(String[] args) {
        int T = 8;
        int M = 250_000;

        Thread[] threads = new Thread[T];

        Runnable tarefa = () -> {
            for (int i = 0; i < M; i++) {
                contador++;
            }
        };

        for (int i = 0; i < T; i++) {
            threads[i] = new Thread(tarefa);
            threads[i].start();
        }

        for (int i = 0; i < T; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Esperado: " + (T * M));
        System.out.println("Obtido:   " + contador);
    }
}
