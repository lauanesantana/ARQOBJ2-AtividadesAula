public class Main {

    public static void main(String[] args) {

        Sensor temperatura = new Sensor("Temperatura", 1000);
        Sensor umidade = new Sensor("Umidade", 1500);
        Sensor luminosidade = new Sensor("Luminosidade", 2000);

        temperatura.start();
        umidade.start();
        luminosidade.start();

        try {
            temperatura.join();
            umidade.join();
            luminosidade.join();
        } catch (InterruptedException e) {
            System.out.println("Erro ao aguardar os sensores.");
        }

        System.out.println("Todos os sensores finalizaram o monitoramento.");
    }
}