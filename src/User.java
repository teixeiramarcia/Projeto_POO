import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Atores do sistema que interagem com a aplicação.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190417
 */

public class User {
    private String email;
    private String password;
    private String address;
    private LocalDate birthDate;
    private Point location;

    /**
     * Construtor por omissão.
     */
    public User() {
        this.email = "N/A";
        this.password = "N/A";
        this.address = "N/A";
        this.birthDate = null;
        this.location = new Point(-1, -1);
    }

    /**
     * Construtor parametrizado.
     *
     * @param email     email do utilizador (credencial de acesso ao espaço pessoal)
     * @param password  password do utilizador
     * @param address   morada do utilizador
     * @param birthDate data de nascimento do utilizador
     * @param location  localização atual do utilizador
     */
    public User(String email, String password, String address, String birthDate, Point location) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.birthDate = LocalDate.parse(birthDate);
        this.location = location;
    }

    /**
     * Construtor cópia.
     */
    public User(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.address = user.getAddress();
        this.birthDate = user.getBirthDate();
        this.location = user.getLocation();
    }

    /**
     * Devolve o email do utilizador.
     *
     * @return email do utilizador (credencial de acesso ao espaço pessoal)
     */
    public String getEmail() {
        return email;
    }

    /**
     * Atribui um email ao utilizador
     *
     * @param email email do utilizador (credencial de acesso ao espaço pessoal)
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devolve a password do utilizador.
     *
     * @return password do utilizador
     */
    public String getPassword() {
        return password;
    }

    /**
     * Atribui uma password ao utilizador.
     *
     * @param password password do utilizador
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Devolve a morada do utilizador.
     *
     * @return morada do utilizador
     */
    public String getAddress() {
        return address;
    }

    /**
     * Atribui uma morada ao utilizador.
     *
     * @param address morada do utilizador
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Devolve a data de nascimento do utilizador.
     *
     * @return data de nascimento do utilizador
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Atribui uma data de nascimento ao utilizador
     *
     * @param birthDate data de nascimento do utilizador
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Devolve a localização atual do utilizador.
     *
     * @return localização atual do utilizador
     */
    public Point getLocation() {
        return location;
    }

    /**
     * Atribui ao utilizador uma posição atual.
     *
     * @param location posição atual do utilizador
     */
    public void setLocation(Point location) {
        this.location = location;
    }

    /**
     * Método que verifica se dois utilizadores são iguais.
     *
     * @param o Objeto a ser usado como termo de comparação
     * @return Booleano que indica se dois objetos são iguais
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(address, user.address) &&
                Objects.equals(birthDate, user.birthDate) &&
                Objects.equals(location, user.location);
    }

    /**
     * Devolve o valor de hash baseado em (...)
     *
     * @return valor de hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(email, password, address, birthDate, location);
    }

    /**
     * Método que devolve a representação em String do Utilizador.
     *
     * @return String que representa o utilizador
     */
    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", location=" + location +
                '}';
    }

    /**
     * Método que faz uma cópia do Utilizador, invocando para tal o contrutor cópia.
     *
     * @return cópia do Utilizador
     */
    public User clone() {
        User newUser = new User();
        newUser.setEmail(this.email);
        newUser.setPassword(this.password);
        newUser.setAddress(this.address);
        newUser.setBirthDate(this.birthDate);
        newUser.setLocation(this.location);
        return newUser;
    }

    /**
     * Método que devolve uma listagem dos alugueres efetuados entre duas datas.
     *
     * @param initialDate data a partir da qual se seleciona os alugueres.
     * @param finalDate   data até à qual se seleciona os alugueres.
     * @return devlove uma lista com os alugueres feitos entre as datas disponibilizadas.
     */
    public java.util.List<Rental> rentalsBetweenDates(LocalDateTime initialDate, LocalDateTime finalDate) {
        List<Rental> rentals;
        if (this.getClass().equals(Client.class)) {
            rentals = ((Client) this).getRentals();
        } else {
            rentals = ((Proprietary) this).getRented();
        }
        List<Rental> rentedBetweenList = new ArrayList<>();
        for (Rental rental : rentals) {
            LocalDateTime rentalDate = rental.getRentalDate();
            if ((rentalDate.isAfter(initialDate) && rentalDate.isBefore(finalDate)) || rentalDate.isEqual(initialDate)
                    || rentalDate.isEqual(finalDate)) {
                rentedBetweenList.add(rental);
            }
        }
        return rentedBetweenList;
    }
}