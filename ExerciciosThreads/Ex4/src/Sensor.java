public class Sensor extends Thread {

    private String nome;
    private int intervalo;

    public Sensor(String nome, int intervalo) {
        this.nome = nome;
        this.intervalo = intervalo;
    }

    @Override
    public void run() {

        System.out.println("Sensor " + nome + " iniciado.");

        for (int i = 1; i <= 5; i++) {
            /*System.out.println(nome + " - Leitura " + i);*/

            try {
                Thread.sleep(intervalo);
            } catch (InterruptedException e) {
                System.out.println("Erro no sensor " + nome);
            }
        }

        System.out.println("Sensor " + nome + " finalizou as leituras.");
    }
}