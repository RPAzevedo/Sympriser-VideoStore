package sympriser.videoStore;

import org.apache.commons.lang.Validate;

public class RentalConditions {

    private final int    _initialTerm;
    private final double _initialPrice;
    private final double _extraPricePerDay;
    private final int    _INITIAL_POINTS = 1;
    private final int    _extraPoints;

    public RentalConditions(int initialTerm, double initialPrice, double extraPricePerDay, int extraPoints) {

        Validate.isTrue(initialTerm >= 0, "Initial Term must be non negative");
        Validate.isTrue(initialPrice >= 0.00, "Initial Price must be non negative");
        Validate.isTrue(extraPricePerDay >= 0, "Extra Price per Day must be non negative");

        _initialTerm      = initialTerm;
        _initialPrice     = initialPrice;
        _extraPricePerDay = extraPricePerDay;
        _extraPoints      = extraPoints;
    }

    public double getCharge(int rentalPeriod) {
        
        if (rentalPeriod < 0)
            throw new IllegalArgumentException("Rental period must not be negative");

        double charge = _initialPrice;
        if (rentalPeriod > _initialTerm) charge += (rentalPeriod - _initialTerm) * _extraPricePerDay;

        return (charge);
    }

    public int getPoints(int rentalPeriod) {

        if (rentalPeriod < 0)
            throw new IllegalArgumentException("Rental period must not be negative");

        int points = _INITIAL_POINTS;
        if (rentalPeriod > _initialTerm) points += _extraPoints;

        return (points);
    }
}
