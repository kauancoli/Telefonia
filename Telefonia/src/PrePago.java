import java.util.ArrayList;
import java.util.GregorianCalendar;

class PrePago extends Assinante {
    private ArrayList<Recarga> recargas;
    private int numRecargas;
    private float creditos;

    public PrePago(long cpf, String nome, String numero) {
        super(cpf, nome, numero);
        this.recargas = new ArrayList<>();
        this.numRecargas = 0;
        this.creditos = 0.0f;
    }

    public void recarregar(GregorianCalendar data, float valor) {

    }

    public void imprimirFatura(int mes) {

    }

}
