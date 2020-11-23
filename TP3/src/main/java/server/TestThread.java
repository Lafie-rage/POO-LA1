package server;

public class TestThread extends Thread{
    @Override
    public void run() {
        while (true) {
            try {
                if(!Thread.currentThread().isInterrupted()) {
                    System.out.println("Serveur en vie");
                }
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Fin de vie du thread");
                break;
            }
        }
    }
}
