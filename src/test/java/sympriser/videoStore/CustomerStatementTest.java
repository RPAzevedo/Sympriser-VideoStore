package sympriser.videoStore;

import java.lang.StringBuilder;

import org.junit.* ;
import static org.junit.Assert.* ;
 
public class CustomerStatementTest {
    
    private Customer _customer;

    @Before
    public void createCustomerWithSeveralRentals() {
        
        _customer = new Customer("Barak Obama");
        
        _customer.addRental(new Rental(new Video("A Mulher Invisível",            Video.REGULAR), 5));
        _customer.addRental(new Rental(new Video("Bossa Nova",                    Video.REGULAR), 9));
        _customer.addRental(new Rental(new Video("O Assalto ao Trem Pagador",     Video.CHILDRENS), 7));
        _customer.addRental(new Rental(new Video("Dona Flor e seus Dois Maridos", Video.NEW_RELEASE), 2));
    }
    
    @Test
    public void testTextStatement() {
        
        String generatedStatement = _customer.textStatement();
        
        String expectedStatement = new StringBuilder()
            .append("Rental Record for Barak Obama\n")
            .append("\tA Mulher Invisível\t6.5\n")
            .append("\tBossa Nova\t12.5\n")
            .append("\tO Assalto ao Trem Pagador\t7.5\n")
            .append("\tDona Flor e seus Dois Maridos\t6.0\n")
            .append("Amount owed is 32.5\n")
            .append("You earned 5 frequent renter points")
            .toString();
        
        assertEquals(expectedStatement, generatedStatement);
    }

 
    @Test
    public void testHtmlStatement() {

        String generatedStatement = _customer.htmlStatement();

        String expectedStatement = new StringBuilder()
                .append("<h1>Rental Record for <em>Barak Obama</em></h1><p>\n")
                .append("\tA Mulher Invisível\t6.5<br />\n")
                .append("\tBossa Nova\t12.5<br />\n")
                .append("\tO Assalto ao Trem Pagador\t7.5<br />\n")
                .append("\tDona Flor e seus Dois Maridos\t6.0<br />\n")
                .append("</p>")
                .append("<p>Amount owed is <em>32.5</em></p>\n")
                .append("<p>You earned <em>5</em> frequent renter points</p>\n")
                    .toString();

        assertEquals(expectedStatement, generatedStatement);
    }
}
