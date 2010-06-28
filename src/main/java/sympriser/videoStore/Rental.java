package sympriser.videoStore;

import org.joda.time.Days;
import org.joda.time.LocalDate;

public class Rental {

    private final Video             _video;
    private final LocalDate         _initialDate;
    private final RentalConditions  _conditions;

    public Rental(Video video, RentalConditions conditions, LocalDate initialDate) {

        _video       = video;
        _conditions  = conditions;
        _initialDate = initialDate;
    }

    public Rental(Video video, RentalConditions conditions, int daysRented) {

        LocalDate today = new LocalDate();
        
        _video       = video;
        _conditions  = conditions;
        _initialDate = today.minusDays(daysRented);
    }

    public int getDaysRented() {

        LocalDate today = new LocalDate();
        
        return Days.daysBetween(_initialDate, today).getDays();
    }

    public Video getVideo() {

        return _video;
    }

    public double getCharge() {

        return _conditions.getCharge(getDaysRented());
    }

    public int getPoints() {

        return _conditions.getPoints(getDaysRented());
    }
}
