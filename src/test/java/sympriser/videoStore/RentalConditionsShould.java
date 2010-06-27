package sympriser.videoStore;

import org.junit.* ;

public class RentalConditionsShould {
    
    @Test(expected=IllegalArgumentException.class)
    public void beUndefinedForANegativeInitialTerm() {
        
        new RentalConditions(-2, 10.0, 1.5, 3);
    }

    @Test(expected=IllegalArgumentException.class)
    public void beUndefinedForANegativeInitialPrice() {
        
        new RentalConditions(2, -10.0, 1.5, 3);
    }

    @Test(expected=IllegalArgumentException.class)
    public void beUndefinedForANegativeExtraPricePerDay() {
        
        new RentalConditions(2, 10.0, -1.5, 3);
    }
}
