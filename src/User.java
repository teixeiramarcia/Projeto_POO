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
    private String name;
    private String email;
    private String password;
    private String address;
    private LocalDate birthDate;
    private String nif;

    /**
     * Construtor por omissão.
     */
    public User() {
        this.name = "N/A";
        this.email = "N/A";
        this.password = "N/A";
        this.address = "N/A";
        this.birthDate = null;
        this.nif = "N/A";
    }

    /**
     * Construtor parametrizado.
     *
     * @param name      nome do utilizador
     * @param email     email do utilizador (credencial de acesso ao espaço pessoal)
     * @param password  password do utilizador
     * @param address   morada do utilizador
     * @param birthDate data de nascimento do utilizador
     * @param nif       número de identificação fiscal do utilizador
     */
    public User(String name, String email, String password, String address, String birthDate, String nif) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.birthDate = LocalDate.parse(birthDate);
        this.nif = nif;
    }

    /**
     * Construtor cópia.
     */
    public User(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.address = user.getAddress();
        this.birthDate = user.getBirthDate();
        this.nif = user.getNif();
    }

    /**
     * Devolve o nome do utilizador.
     *
     * @return nome do utilizador
     */
    public String getName(){
        return name;
    }

    /**
     * Atribui um nome ao utilizador
     *
     * @param  name nome do utilizador
     */
    public void setName(String name){
        this.name = name;
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
     * Devolve o número de identificação fiscal do utilizador.
     *
     * @return número de identificação fiscal do utilizador
     */
    public String getNif() {
        return nif;
    }

    /**
     * Atribui um nif ao utilizador
     *
     * @param nif número de identificação fiscal do utilizador
     */
    public void setNif(String nif){
        this.nif = nif;
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
        return Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(address, user.address) &&
                Objects.equals(birthDate, user.birthDate) &&
                Objects.equals(nif, user.nif);
    }

    /**
     * Devolve o valor de hash baseado em (...)
     *
     * @return valor de hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, email, password, address, birthDate, nif);
    }

    /**
     * Método que devolve a representação em String do Utilizador.
     *
     * @return String que representa o utilizador
     */
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate.toString() +
                ", nif='" + nif + '\'' +
                '}';
    }

    /**
     * Método que faz uma cópia do Utilizador, invocando para tal o contrutor cópia.
     *
     * @return cópia do Utilizador
     */
    public User clone() {
        User newUser = new User();
        newUser.setName(this.name);
        newUser.setEmail(this.email);
        newUser.setPassword(this.password);
        newUser.setAddress(this.address);
        newUser.setBirthDate(this.birthDate);
        newUser.setNif(this.nif);
        return newUser;
    }

    /**
     * Método que devolve uma listagem dos alugueres efetuados entre duas datas.
     *
     * @param initialDate data a partir da qual se seleciona os alugueres.
     * @param finalDate   data até à qual se seleciona os alugueres.
     * @return devlove uma lista com os alugueres feitos entre as datas disponibilizadas.
     */
    public List<Rental> rentalsBetweenDates(LocalDateTime initialDate, LocalDateTime finalDate) {
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