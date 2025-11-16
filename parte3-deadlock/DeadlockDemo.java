public class DeadlockDemo {

    static final Object LOCK_A = new Object();
    static final Object LOCK_B = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            log("T1 tentando LOCK_A");
            synchronized (LOCK_A) {
                log("T1 pegou LOCK_A");
                dormir(100);

                log("T1 tentando LOCK_B");
                synchronized (LOCK_B) {
                    log("T1 pegou LOCK_B");
                    log("T1 concluiu");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            log("T2 tentando LOCK_B");
            synchronized (LOCK_B) {
                log("T2 pegou LOCK_B");
                dormir(100);

                log("T2 tentando LOCK_A");
                synchronized (LOCK_A) {
                    log("T2 pegou LOCK_A");
                    log("T2 concluiu");
                }
            }
        });

        t1.start();
        t2.start();
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
