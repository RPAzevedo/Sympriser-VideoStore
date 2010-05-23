package sympriser.videoStore;

import java.lang.StringBuilder;

import junit.framework.TestCase;
 
public class CustomerStatementTest extends TestCase {
    
    public void testTextStatement() {
        
        Customer c = new Customer("Barak Obama");
        
        c.addRental(new Rental(new Video("A Mulher Invis�vel",      Video.REGULAR),     5));
        c.addRental(new Rental(new Video("Bossa Nova",              Video.REGULAR),     9));
        c.addRental(new Rental(new Video("O Assalto ao Trem Pagador",       Video.CHILDRENS),   7));
        c.addRental(new Rental(new Video("Dona Flor e seus Dois Maridos",   Video.NEW_RELEASE), 2));
        
        String generatedStatement = c.textStatement();
        
        String expectedStatement = new StringBuilder()
            .append("Rental Record for Barak Obama\n")
            .append("\tA Mulher Invis�vel\t6.5\n")
            .append("\tBossa Nova\t12.5\n")
            .append("\tO Assalto ao Trem Pagador\t7.5\n")
            .append("\tDona Flor e seus Dois Maridos\t6.0\n")
            .append("Amount owed is 32.5\n")
            .append("You earned 5 frequent renter points")
            .toString();
        
        TestCase.assertEquals(expectedStatement, generatedStatement);
    }

 
    public void testHtmlStatement() {

        Customer c = new Customer("Barak Obama");

        c.addRental(new Rental(new Video("A Mulher Invis�vel",            Video.REGULAR), 5));
        c.addRental(new Rental(new Video("Bossa Nova",                    Video.REGULAR), 9));
        c.addRental(new Rental(new Video("O Assalto ao Trem Pagador",     Video.CHILDRENS), 7));
        c.addRental(new Rental(new Video("Dona Flor e seus Dois Maridos", Video.NEW_RELEASE), 2));

        String generatedStatement = c.htmlStatement();

        String expectedStatement = new StringBuilder()
                .append("<h1>Rental Record for <em>Barak Obama</em></h1><p>\n")
                .append("\tA Mulher Invis�vel\t6.5<br />\n")
                .append("\tBossa Nova\t12.5<br />\n")
                .append("\tO Assalto ao Trem Pagador\t7.5<br />\n")
                .append("\tDona Flor e seus Dois Maridos\t6.0<br />\n")
                .append("</p>")
                .append("<p>Amount owed is <em>32.5</em></p>\n")
                .append("<p>You earned <em>5</em> frequent renter points</p>\n")
                    .toString();

        TestCase.assertEquals(expectedStatement, generatedStatement);
    }
}
