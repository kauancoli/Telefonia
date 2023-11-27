import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

class Chamada {
    private GregorianCalendar data;
    private int duracao;

    public Chamada(GregorianCalendar data, int duracao) {
        this.data = data;
        this.duracao = duracao;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Data: " + dateFormat.format(data.getTime()) + ", Duração: " + duracao + " minutos";
    }
}
