public class Contador extends Thread {

    public Contador(String nome) {
        super(nome);
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(getName() + ": " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Erro na thread: " + getName());
            }
        }
    }
}