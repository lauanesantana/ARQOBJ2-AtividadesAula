public class Main {
    public static void main(String[] args) {

        Contador contador1 = new Contador("Thread 1");
        Contador contador2 = new Contador("Thread 2");

        contador1.start();
        contador2.start();

    }
}