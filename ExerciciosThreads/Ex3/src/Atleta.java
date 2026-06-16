public class Atleta extends Thread {

    private String nome;
    private int tempoCorrida;

    public Atleta(String nome, int tempoCorrida) {
        this.nome = nome;
        this.tempoCorrida = tempoCorrida;
    }

    @Override
    public void run() {
        System.out.println(nome + " iniciou a corrida.");

        try {
            Thread.sleep(tempoCorrida);
        } catch (InterruptedException e) {
            System.out.println("Erro na corrida de " + nome);
        }

        System.out.println(nome + " chegou!");
    }
}