import java.util.ArrayList;
import java.util.GregorianCalendar;

class Recarga {
    private GregorianCalendar data;
    private float valor;

    public Recarga(GregorianCalendar data, float valor) {
        this.data = data;
        this.valor = valor;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public float getValor() {
        return valor;
    }
}

class PrePago extends Assinante {
    private static final int CustoPorMinuto = 0;
    private ArrayList<Recarga> recargas;
    private float creditos;

    public PrePago(long cpf, String nome, int numero) {
        super(cpf, nome, numero);
        this.recargas = new ArrayList<>();
        this.creditos = 0.0f;
    }

    public void recarregar(GregorianCalendar data, float valor) {
        Recarga recarga = new Recarga(data, valor);
        recargas.add(recarga);
        creditos += valor;
    }

    public void imprimirFatura(int mes) {
        float totalFatura = creditos;

        for (Recarga recarga : recargas) {
            if (recarga.getData().get(GregorianCalendar.MONTH) == mes) {
                totalFatura -= recarga.getValor();
            }
        }

        for (Chamada chamada : getChamadas()) {
            if (chamada.getData().get(GregorianCalendar.MONTH) == mes) {
                totalFatura -= chamada.getDuracao() * CustoPorMinuto;  
            }
        }

        System.out.println("Fatura para o mês " + mes + ": R$" + totalFatura);
    }

    private Chamada[] getChamadas() {
        return null;
    }
}
