package sympriser.videoStore;

import java.util.List;
import java.util.ArrayList;

public class Customer {
    
    private String _name;
    private List<Rental> _rentals = new ArrayList<Rental>();

    public Customer (String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {

        double      totalAmount  = 0;
        int         renterPoints = 0;
        String      result       = "Rental Record for " + getName() + "\n";

        for (Rental each : _rentals) {

            double thisAmount = 0;

            // determine amounts for each rental
            switch (each.getVideo().getPriceCode()) {
                case Video.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Video.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Video.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }

            // add frequent renter points
            renterPoints++;

            // add bonus for a two day new release rental
            if ((each.getVideo().getPriceCode() == Video.NEW_RELEASE) &&
                (each.getDaysRented() > 1)) {
                    renterPoints++;
            }

            // show figures for this rental
            result += "\t" + each.getVideo().getTitle() +
                      "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(renterPoints) +
                  " frequent renter points";

        return result;
    }
}