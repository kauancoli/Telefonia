import java.util.ArrayList;
import java.util.GregorianCalendar;

class Assinante {
    private long cpf;
    private String nome;
    private String numero;
    private ArrayList<Chamada> chamadas;
    private int numChamadas;

    public Assinante(long cpf, String nome, String numero) {
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        this.chamadas = new ArrayList<>();
        this.numChamadas = 0;
    }

    public long getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "CPF: " + cpf + ", Nome: " + nome + ", Número: " + numero;
    }

    public void fazerChamada(GregorianCalendar data, int duracao) {

    }
}
