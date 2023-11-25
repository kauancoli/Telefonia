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

    public void fazerChamada(GregorianCalendar data, int duracao) {
        Chamada chamada = new Chamada(data, duracao);
        chamadas.add(chamada);
        numChamadas++;
    }

    public void exibirDetalhes() {
        System.out.println("CPF: " + cpf);
        System.out.println("Nome: " + nome);
        System.out.println("Número: " + numero);
        System.out.println("Chamadas: ");
        for (Chamada chamada : chamadas) {
            System.out.println("Data: " + chamada.getData() + ", Duração: " + chamada.getDuracao() + " minutos");
        }
    }
}
