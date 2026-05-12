import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class AnotacoesSerializacao.java {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);

        	
        	//aqui estou criando meu leitor e meu "escrevedor", para que eles se referenciam a pasta nomes.txt
            FileWriter writer = new FileWriter("nomes.txt");
            BufferedReader br = new BufferedReader(
            	    new FileReader("nomes.txt")
            	);

            String nome;
            int contador = 0; 

            do {
                System.out.print("Digite um nome (0 para sair): ");
                nome = sc.nextLine();
                
                //se meu nome escrito for diferente de 0, registro e pulo linha
                if (!nome.equals("0")) {
                    writer.write(nome + "\n");
                }

            } while (!nome.equals("0"));
            
            //quando respeitar o codigo de parada e fechar, aparece essa mensagem 
            writer.close();
            System.out.println("Obrigadaaaa... o arquivo foi criado com sucesso!");
            
        	while ((nome = br.readLine()) != null) {
        	    contador++; 
        	}
        	
        	System.out.println ("A quantidade de linhas foi de " + contador); 
        	
        	br.close();
            
            sc.close();
        	
			/*ObjectOutputStream oos =
			    new ObjectOutputStream(
			        new FileOutputStream("pessoa.ser")
			    );
			
			Pessoa p = new Pessoa("José", 30, "256985");
			oos.writeObject(p);
			oos.close();

*/			ObjectInputStream ois =
			    new ObjectInputStream(
			        new FileInputStream("pessoa.ser")
			    );
			
			Pessoa p1 = (Pessoa) ois.readObject();
			System.out.println(p1);
			
			
			//aqui resulta nulo pq ele eh transient, ou seja, eu nao salvo ele por ser senha 
			System.out.println(p1.getSenha());
			
			System.out.println(p1.getIdade());
			
			ois.close();
			
       
    }
}
