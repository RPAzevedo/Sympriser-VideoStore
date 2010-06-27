package sympriser.videoStore;

public class Rental {

    private final Video      _video;
    private final int        _daysRented;
    private final RentalConditions _conditions;

    public Rental(Video movie, RentalConditions conditions, int daysRented) {

        _video = movie;
        _conditions = conditions;
        _daysRented = daysRented;
    }

    public int getDaysRented() {

        return _daysRented;
    }

    public Video getVideo() {

        return _video;
    }

    public double getCharge() {

        return _conditions.getCharge(_daysRented);
    }

    public int getPoints() {

        return _conditions.getPoints(_daysRented);
    }
}
