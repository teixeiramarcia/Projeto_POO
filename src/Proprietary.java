import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Subclasse de User que representa a informação adicional dos Proprietaries.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 *
 * @version 20190325
 */
public class Proprietary extends User {
    private List<Carro> carros;
    private int classificacao;
    private List<Rental> rented;

    public Proprietary (){
        super();
        this.carros = new ArrayList<>();
        this.classificacao = 0;
        this.rented = new ArrayList<>();
    }

    public Proprietary (String email, String password, String address, String birthDate, List<Carro> carros, int classificacao, List<Rental> rented){
        super(email, password, address, birthDate);
        this.carros = carros;
        this.classificacao = classificacao;
        this.rented = rented;
    }

    public Proprietary (Proprietary proprietary){
        super(proprietary);
        this.carros = proprietary.getCarros();
        this.classificacao = proprietary.getClassificacao();
        this.rented = proprietary.getRented();
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public List<Rental> getRented() {
        return rented;
    }

    public void setRented(List<Rental> rented) {
        this.rented = rented;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Proprietary that = (Proprietary) o;
        return classificacao == that.classificacao &&
                Objects.equals(carros, that.carros) &&
                Objects.equals(rented, that.rented);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carros, classificacao, rented);
    }

    @Override
    public String toString() {
        return "Proprietary{" +
                super.toString() +
                "carros=" + carros.toString() +
                ", classificacao=" + classificacao +
                ", rented=" + rented.toString() +
                '}';
    }

    public Proprietary clone() {
        Proprietary newProprietary = (Proprietary) super.clone();
        newProprietary.setCarros(this.carros);
        newProprietary.setClassificacao(this.classificacao);
        newProprietary.setRented(this.rented);
        return newProprietary;
    }
}
