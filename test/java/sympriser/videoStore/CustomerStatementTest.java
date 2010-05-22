package sympriser.videoStore;

import java.lang.StringBuilder;

import junit.framework.TestCase;

public class CustomerStatementTest extends TestCase {
	
	public void testStatement() {
		
	    Customer c = new Customer("Barak Obama");
		
	    c.addRental(new Rental(new Video("A Mulher Invisível",		Video.REGULAR),		5));
	    c.addRental(new Rental(new Video("Bossa Nova",				Video.REGULAR),		9));
	    c.addRental(new Rental(new Video("O Assalto ao Trem Pagador",		Video.CHILDRENS),	7));
	    c.addRental(new Rental(new Video("Dona Flor e seus Dois Maridos",	Video.NEW_RELEASE), 2));
		
		String generatedStatement = c.statement();
		
		String expectedStatement = new StringBuilder()
			.append("Rental Record for Barak Obama\n")
			.append("\tA Mulher Invisível\t6.5\n")
			.append("\tBossa Nova\t12.5\n")
			.append("\tO Assalto ao Trem Pagador\t7.5\n")
			.append("\tDona Flor e seus Dois Maridos\t6.0\n")
			.append("Amount owed is 32.5\n")
			.append("You earned 5 frequent renter points")
			.toString();
		
		TestCase.assertEquals(expectedStatement, generatedStatement);
	}
}

