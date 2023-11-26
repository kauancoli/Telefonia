import java.util.ArrayList;
import java.util.GregorianCalendar;

class PrePago extends Assinante {
    private ArrayList<Recarga> recargas;
    private Integer numRecargas;
    private Float creditos;

    public PrePago(long cpf, String nome, String numero) {
        super(cpf, nome, numero);
        this.recargas = new ArrayList<>();
        this.numRecargas = 0;
        this.creditos = 0.0f;
    }

    public void recarregar(GregorianCalendar data, float valor) {
        Recarga recarga = new Recarga(data, valor);
        recargas.add(recarga);
        creditos += valor;
        numRecargas++;
    }

    public void imprimirFatura(int mes) {

    }

}
