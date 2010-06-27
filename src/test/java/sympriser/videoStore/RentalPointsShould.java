package sympriser.videoStore;

import org.junit.* ;

import static org.junit.Assert.* ;

public class RentalPointsShould {
    
    @Test(expected=IllegalArgumentException.class)
    public void beUndefinedForANegativeRentalTerm() {
        
        RentalConditions conditions    = new RentalConditions(2, 10.0, 1.5, 3);

        conditions.getPoints(-1);
    }

    @Test
    public void beOneForARentalPeriodWithinTheInitialTerm() {
        
        RentalConditions conditions    = new RentalConditions(2, 10.0, 1.5, 3);

        assertEquals(1, conditions.getPoints(0));
        assertEquals(1, conditions.getPoints(1));
        assertEquals(1, conditions.getPoints(2));
    }

    @Test
    public void sumTheExtraPointsForAnyRentalPeriodLongerThanTheInitialTerm() {
        
        RentalConditions conditions    = new RentalConditions(2, 10.0, 1.5, 3);

        assertEquals(4, conditions.getPoints(3));
        assertEquals(4, conditions.getPoints(4));
        assertEquals(4, conditions.getPoints(1000));
    }

}
