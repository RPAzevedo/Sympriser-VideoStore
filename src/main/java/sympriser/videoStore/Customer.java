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

        String result = "Rental Record for " + getName() + "\n";

        // show figures for all rentals
        for (Rental each : _rentals)
            result += "\t" + each.getVideo().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";

        // add footer lines
        result += "Amount owed is " + String.valueOf(this.getCharge()) + "\n";
        result += "You earned " + String.valueOf(this.getPoints()) + " frequent renter points";

        return result;
    }

    public double getCharge() {

        double charge = 0.00;

        // accumulate charge
        for (Rental each : _rentals)
            charge += each.getCharge();

        return charge;
    }
    
    public int getPoints() {
        
        int points = 0;

        // accumulate frequent renter points
        for (Rental each : _rentals)
            points += each.getPoints();
        
        return points;
    }
}