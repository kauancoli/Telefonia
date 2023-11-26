import java.util.GregorianCalendar;

class PosPago extends Assinante {
    private static final int CustoPorMinuto = 0;
    private float assinatura;

    public PosPago(long cpf, String nome, int numero, float assinatura) {
        super(cpf, nome, numero);
        this.assinatura = assinatura;
    }
    
    public float getAssinatura() {
        return assinatura;
    }
    
    public void setAssinatura(float assinatura) {
        this.assinatura = assinatura;
    }
    
    public void fazerChamada(GregorianCalendar data, int duracao) {
        if (numChamadas < chamadas.length) {
            chamadas[numChamadas] = new Chamada(data, duracao);
            numChamadas++;
        } else {
            System.out.println("Não há espaço para mais chamadas.");
        }
    }
    
    public void imprimirFatura(int mes) {
        float totalFatura = assinatura;

        for (Chamada chamada : chamadas) {
            if (chamada.getData().get(GregorianCalendar.MONTH) == mes) {
                totalFatura += chamada.getDuracao() * CustoPorMinuto;
            }
        }

        System.out.println("Fatura para o mês " + mes + ": R$" + totalFatura);
    }
}