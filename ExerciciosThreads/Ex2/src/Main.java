public class Main {

    public static void main(String[] args) {

        Download download1 = new Download("Filme.mp4", 3000);
        Download download2 = new Download("Musica.mp3", 2000);
        Download download3 = new Download("Foro.jpg", 1000);

        download1.start();
        download2.start();
        download3.start();

    }
}