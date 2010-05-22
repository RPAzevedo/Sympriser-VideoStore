package sympriser.videoStore;

public class Rental {

    private Video _video;
    private int   _daysRented;

    public Rental(Video movie, int daysRented) {

        _video = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {

        return _daysRented;
    }

    public Video getVideo() {

        return _video;
    }

    public double getCharge() {

        double charge;

        switch (this.getVideo().getPriceCode()) {
        case Video.REGULAR:
            charge = 2;
            if (this.getDaysRented() > 2) 
                charge += (this.getDaysRented() - 2) * 1.5;
            break;
        case Video.NEW_RELEASE:
            charge = this.getDaysRented() * 3;
            break;
        case Video.CHILDRENS:
            charge = 1.5;
            if (this.getDaysRented() > 3) 
                charge += (this.getDaysRented() - 3) * 1.5;
            break;
        default:
            charge = 0.00;
        }

        return charge;
    }
    
    public int getPoints() {
        
        int points = 1;
        
        // add bonus for a two day new release rental
        if ((this.getVideo().getPriceCode() == Video.NEW_RELEASE) && (this.getDaysRented() > 1))
            points++;

        return points;
    }
}
