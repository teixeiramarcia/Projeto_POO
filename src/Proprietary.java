import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Subclasse de User que representa a informação adicional dos Proprietaries.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190417
 */

public class Proprietary extends User {
    private List<Car> cars;
    private int rating;
    private List<Rental> rented;

    /**
     * Construtor por omissão.
     */
    public Proprietary() {
        super();
        this.cars = new ArrayList<>();
        this.rating = -1;
        this.rented = new ArrayList<>();
    }

    /**
     * Construtor parametrizado.
     *
     * @param email     email do proprietário
     * @param password  password do proprietário
     * @param address   morada do proprietário
     * @param birthDate data de nascimento do proprietário
     * @param cars      listagem de carros que o proprietário possui
     * @param rating    avaliação do proprietário
     * @param rented    listagem de arrendamentos feitos até ao momento dos carros do proprietário
     */
    public Proprietary(String name, String email, String password, String address, String birthDate, String nif, List<Car> cars,
                       int rating, List<Rental> rented) {
        super(name, email, password, address, birthDate, nif);
        this.cars = cars;
        this.rating = rating;
        this.rented = rented;
    }

    /**
     * Construtor cópia.
     */
    public Proprietary(Proprietary proprietary) {
        super(proprietary);
        this.cars = proprietary.getCars();
        this.rating = proprietary.getRating();
        this.rented = proprietary.getRented();
    }

    /**
     * Devolve a listagem de carros que o proprietário possui.
     *
     * @return listagem de carros do proprietário
     */
    public List<Car> getCars() {
        return cars;
    }

    /**
     * Atribui ao proprietário uma listagem dos carros que possui.
     *
     * @param cars listagem de carros do proprietário
     */
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    /**
     * Devolve a avaliação atribuída ao proprietário.
     *
     * @return avaliação do proprietário
     */
    public int getRating() {
        return rating;
    }

    /**
     * Atribui ao proprietário uma avaliação.
     *
     * @param rating avaliação do proprietário
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Devolve uma listagem dos carros pertencentes ao proprietário que já foram arrendados.
     *
     * @return listagem de arrendamentos dos carros do proprietário feitos até ao momento
     */
    public List<Rental> getRented() {
        return rented;
    }

    /**
     * Atribui ao proprietário uma listagem de arrendamentos dos seus carros feitos até ao momento
     *
     * @param rented
     */
    public void setRented(List<Rental> rented) {
        this.rented = rented;
    }

    /**
     * Método que verifica se dois proprietários são iguais.
     *
     * @param o objeto a ser usado como termo de comparação
     * @return Booleano indicativo de se os dois objetos são iguais
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Proprietary that = (Proprietary) o;
        return rating == that.rating &&
                Objects.equals(cars, that.cars) &&
                Objects.equals(rented, that.rented);
    }

    /**
     * Devolve o valor de hash baseado em (...)
     *
     * @return valor de hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cars, rating, rented);
    }

    /**
     * Método que devolve a representação em String do Proprietário.
     *
     * @return String que representa o Proprietário
     */
    @Override
    public String toString() {
        return "Proprietary{" +
                super.toString() +
                ", cars=" + cars.toString() +
                ", rating=" + rating +
                ", rented=" + rented.toString() +
                '}';
    }

    /**
     * Método que faz uma cópia do proprietário, invocando para tal o construtor cópia.
     *
     * @return cópia do Proprietário
     */
    public Proprietary clone() {
        Proprietary newProprietary = (Proprietary) super.clone();
        newProprietary.setCars(this.cars);
        newProprietary.setRating(this.rating);
        newProprietary.setRented(this.rented);
        return newProprietary;
    }
}