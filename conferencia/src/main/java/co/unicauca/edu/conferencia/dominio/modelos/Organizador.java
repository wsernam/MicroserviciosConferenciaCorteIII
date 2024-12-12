package co.unicauca.edu.conferencia.dominio.modelos;


public class Organizador {

    private String palabrasClaves;

    public String getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(String palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }

    public Organizador(String palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }

    public Organizador() {
    }
    
}
