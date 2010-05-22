package sympriser.videoStore;

public class Rental {
    
    private Video _video;
    private int   _daysRented;

    public Rental(Video movie, int daysRented) {
        _video      = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Video getVideo() {
        return _video;
    }
}