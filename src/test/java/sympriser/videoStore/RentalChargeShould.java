package sympriser.videoStore;

import org.junit.* ;
import static org.junit.Assert.* ;

public class RentalChargeShould {
    
    private static final double epsilon = 0.01;

    @Test(expected=IllegalArgumentException.class)
    public void beUndefinedForANegativeRentalPeriod() {
        
        RentalConditions conditions    = new RentalConditions(2, 10.0, 1.5, 3);

        conditions.getCharge(-1);
    }

    @Test
    public void beTheInitialPriceForARentalPeriodWithinInitialTerm() {
        
        RentalConditions conditions    = new RentalConditions(2, 10.0, 1.5, 3);

        assertEquals(10.0, conditions.getCharge(0), epsilon);
        assertEquals(10.0, conditions.getCharge(1), epsilon);
        assertEquals(10.0, conditions.getCharge(2), epsilon);
    }


    @Test
    public void sumTheExtraPricePerDayAterInitialTerm() {
        
        RentalConditions conditions    = new RentalConditions(2, 10.0, 1.5, 3);

        assertEquals(11.5, conditions.getCharge(3), epsilon);
        assertEquals(13.0, conditions.getCharge(4), epsilon);
    }
    
}
