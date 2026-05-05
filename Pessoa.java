
import java.io.Serializable;

public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
    private String nome;
    private int idade;
    private transient String senha; 

    public Pessoa(String nome, int idade, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.senha = senha; 
    }
        
       @Override 
        //ele nao permite
        public String toString() { 
        	return ("Nome: " + this.nome + " - "+ this.idade); 
        }
       
       public String getSenha() {
    	   return (this.senha); 
       }
       public int getIdade() {
    	   return (this.idade); 
       }
    
}
