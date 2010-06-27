package sympriser.videoStore;

import java.util.List;
import java.util.ArrayList;

public class Customer {

    private final String       _name;
    private final List<Rental> _rentals = new ArrayList<Rental>();

    public Customer(String name) {

        _name = name;
    }

    public void addRental(Rental arg) {

        _rentals.add(arg);
    }

    public String getName() {

        return _name;
    }

    public String textStatement() {

        String result = "Rental Record for " + this.getName() + "\n";

        // show figures for all rentals
        for (Rental each : _rentals) {

            result += "\t" + each.getVideo().getTitle() +
                      "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(this.getCharge()) + "\n";
        result += "You earned " + String.valueOf(this.getPoints()) +
                  " frequent renter points";

        return result;
    }

    public String htmlStatement() {

        String result = "<h1>Rental Record for <em>" + this.getName() + "</em></h1><p>\n";

        // show figures for all rentals
        for (Rental each : _rentals) {

            result += "\t" + each.getVideo().getTitle() +
                      "\t" + String.valueOf(each.getCharge()) + "<br />\n";
        }
        result += "</p>";

        // add footer lines
        result += "<p>Amount owed is <em>" + String.valueOf(this.getCharge()) + "</em></p>\n";
        result += "<p>You earned <em>" + String.valueOf(this.getPoints()) +
                  "</em> frequent renter points</p>\n";

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