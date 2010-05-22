package sympriser.videoStore;

import java.util.List;
import java.util.ArrayList;

public class Customer {

    private String       _name;
    private List<Rental> _rentals = new ArrayList<Rental>();

    public Customer(String name) {

        _name = name;
    }

    public void addRental(Rental arg) {

        _rentals.add(arg);
    }

    public String getName() {

        return _name;
    }

    public String statement() {

        double totalCharge = 0.00;
        int    renterPoints = 0;
        
        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : _rentals)
        {
            double thisCharge = each.getCharge();
            
            // add frequent renter points
            renterPoints++;

            // add bonus for a two day new release rental
            if ((each.getVideo().getPriceCode() == Video.NEW_RELEASE) && (each.getDaysRented() > 1))
                renterPoints++;

            // show figures for this rental
            result += "\t" + each.getVideo().getTitle() + "\t" + String.valueOf(thisCharge) + "\n";
            totalCharge += thisCharge;
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalCharge) + "\n";
        result += "You earned " + String.valueOf(renterPoints) + " frequent renter points";

        return result;
    }
}