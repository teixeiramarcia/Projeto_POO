import java.awt.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Atores do sistema que interagem com a aplicação.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190325
 */

public class User {
    private String email;
    private String password;
    private String address;
    private LocalDate birthDate;
    private Point location;

    public User() {
        this.email = "N/A";
        this.password = "N/A";
        this.address = "N/A";
        this.birthDate = null;
        this.location = new Point(-1, -1);
    }

    public User(String email, String password, String address, String birthDate, Point location) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.birthDate = LocalDate.parse(birthDate);
        this.location = location;
    }

    public User(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.address = user.getAddress();
        this.birthDate = user.getBirthDate();
        this.location = user.getLocation();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(email, password, address, birthDate, location);
    }

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

    public User clone() {
        User newUser = new User();
        newUser.setEmail(this.email);
        newUser.setPassword(this.password);
        newUser.setAddress(this.address);
        newUser.setBirthDate(this.birthDate);
        newUser.setLocation(this.location);
        return newUser;
    }
}