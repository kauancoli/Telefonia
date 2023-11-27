import java.util.GregorianCalendar;

class Assinante {
    private long cpf;
    private String nome;
    private int numero;
    protected Chamada[] chamadas;
    protected int numChamadas;

    public Assinante(long cpf, String nome, int numero) {
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
    }

    public long getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "CPF: " + cpf + ", Nome: " + nome + ", Número: " + numero;
    }
    
    public void exibirDetalhes() {
        System.out.println("CPF: " + cpf);
        System.out.println("Nome: " + nome);
        System.out.println("Número: " + numero);
        System.out.println("Chamadas efetuadas: ");
        for (Chamada chamada : chamadas) {
            System.out.println("Data: " + chamada.getData() + ", Duração: " + chamada.getDuracao() + " minutos");
        }
    }

	public void fazerChamada(GregorianCalendar data, int duracao) {
		
	}
    
    
}
