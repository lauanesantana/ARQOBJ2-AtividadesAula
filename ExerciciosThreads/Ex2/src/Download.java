public class Download extends Thread {

    private String arquivo;
    private int tempoDownload;

    public Download(String arquivo, int tempoDownload) {
        this.arquivo = arquivo;
        this.tempoDownload = tempoDownload;
    }


    public void run() {
        System.out.println("Iniciando download do arquivo: " + arquivo);

        try {
            Thread.sleep(tempoDownload);
        } catch (InterruptedException e) {
            System.out.println("Erro no download de " + arquivo);
        }

        System.out.println("Download concluído: " + arquivo);
    }
}