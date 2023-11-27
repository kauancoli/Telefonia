import java.util.ArrayList;
import java.util.GregorianCalendar;

class PrePago extends Assinante {
    private static final float CustoPorMinuto = 1.04f;
    private ArrayList<Recarga> recargas;
    private float creditos;

    public PrePago(long cpf, String nome, String numero) {
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
