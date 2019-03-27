import java.awt.Point;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Write a description of class Rental here.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 *
 * @version 20190326
 */
public class Rental {
    private Car rentedCar;
    private Client client;
    private Point initialPosCar;
    private Point finalPos;
    private String rentalStatus;
    private LocalDateTime rentalDate;
    private LocalDateTime useStartDate;
    private LocalDateTime useFinishDate;
    private int rating;
}
