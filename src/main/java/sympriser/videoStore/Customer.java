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

        int renterPoints = 0;

        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : _rentals)
        {
            // show figures for this rental
            result += "\t" + each.getVideo().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";

            // accumulate frequent renter points
            renterPoints += each.getPoints();
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(this.getCharge()) + "\n";
        result += "You earned " + String.valueOf(renterPoints) + " frequent renter points";

        return result;
    }

    public double getCharge() {

        double charge = 0.00;

        for (Rental each : _rentals)
        {
            // accumulate charge
            charge += each.getCharge();
        }
        return charge;
    }
}