import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Recarga {
    private GregorianCalendar data;
    private float valor;

    public Recarga(GregorianCalendar data, float valor){
        this.data = data;
        this.valor = valor;
    }

    public GregorianCalendar getData(){
        return data;
    }

    public float getValor(){
        return valor;
    }

    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        String dataGerada = dateFormat.format(data.getTime());
        return "Data: " + dataGerada + "\nValor: " + valor;
    }

	public String getDataRecarga() {
		return null;
	}

	public String getValorRecarga() {
		return null;
	}
}
