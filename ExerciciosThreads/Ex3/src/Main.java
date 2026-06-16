public class Main {

    public static void main(String[] args) {

        Atleta atleta1 = new Atleta("João", 2000);
        Atleta atleta2 = new Atleta("Maria", 1500);
        Atleta atleta3 = new Atleta("Pedro", 2500);

        atleta1.start();
        atleta2.start();
        atleta3.start();

        try {
            atleta1.join();
            atleta2.join();
            atleta3.join();
        } catch (InterruptedException e) {
            System.out.println("Erro ao aguardar atletas.");
        }

        System.out.println("Todos os atletas terminaram a corrida!");
    }
}