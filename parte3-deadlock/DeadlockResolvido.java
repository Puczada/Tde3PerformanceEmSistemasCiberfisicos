public class DeadlockResolvido {

    static final Object LOCK_A = new Object();
    static final Object LOCK_B = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> comer("T1"));
        Thread t2 = new Thread(() -> comer("T2"));

        t1.start();
        t2.start();
    }

    static void comer(String nome) {
        log(nome + " tentando LOCK_A");
        synchronized (LOCK_A) {
            log(nome + " pegou LOCK_A");

            dormir(100);

            log(nome + " tentando LOCK_B");
            synchronized (LOCK_B) {
                log(nome + " pegou LOCK_B");
                log(nome + " concluiu");
            }
        }
    }

    static void dormir(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static void log(String msg) {
        System.out.println(msg);
    }
}




