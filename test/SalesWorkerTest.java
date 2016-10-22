import static org.junit.Assert.*;

/**
 * @author Isaac Allen
 *
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;



public class SalesWorkerTest {
	
	private SalesWorker sales1, invalidSales;

	@Before
	public void setUp() throws Exception {
		sales1 = new SalesWorker("Scratch", "Cat", 10, 10);
		invalidSales = new SalesWorker("George", "Bush", -1, -1);
	}

	@Test
	public void testConstructor() {

		assertEquals("Scratch", sales1.getFirstName());
		assertEquals("Cat", sales1.getSecondName());
		assertEquals(10, sales1.getHourlyRate(), 0.01);

		assertEquals(0, invalidSales.getHourlyRate(), 0.01);

	}
	
	@Test	
	public void testCaclulateSalary(){
		assertEquals(375, sales1.calculateSalary(37.5), 0.01 );
	
		assertEquals(300, sales1.calculateSalary(30), 0.01 );
		assertEquals(305.67, sales1.calculateSalary(30.5678), 0.01 );
	}
	
	@Test
	public void testGetSetSalesBonusPercentage() {
        sales1.setSalesBonusPercentage(-1);
		assertEquals(0, sales1.getSalesBonusPercentage(), 0.01);
        sales1.setSalesBonusPercentage(0);
        assertEquals(0, sales1.getSalesBonusPercentage(), 0.01);
        sales1.setSalesBonusPercentage(12);
        assertEquals(12, sales1.getSalesBonusPercentage(), 0.01);
        
        //Test to see if it will reset to zero if too high
        invalidSales.setSalesBonusPercentage(40);
        assertEquals(0, invalidSales.getSalesBonusPercentage(), 0.01);
	}
	
	@Test	
	public void testSettersGetters(){	
		assertEquals("Scratch", sales1.getFirstName());
		sales1.setFirstName("Donald Duck");
		assertEquals("Donald Duck", sales1.getFirstName());
		
		assertEquals("Cat", sales1.getSecondName());
		sales1.setSecondName("Mickey Mouse");
		assertEquals("Mickey Mouse", sales1.getSecondName());

		sales1.setHourlyRate(40);
		assertEquals(40, sales1.getHourlyRate(), 0.01);
		
		//ensure no change when invalid data used
		sales1.setHourlyRate(-40);
		assertEquals(40, sales1.getHourlyRate(), 0.01);
		
		sales1.setSalesBonusPercentage(10);
		assertEquals(10, sales1.getSalesBonusPercentage(), 0.01);

	}
	
}
