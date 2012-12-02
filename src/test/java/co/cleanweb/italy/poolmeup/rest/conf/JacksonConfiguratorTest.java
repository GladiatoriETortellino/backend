/**
 * 
 */
package co.cleanweb.italy.poolmeup.rest.conf;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.cleanweb.italy.poolmeup.rest.config.JacksonConfigurator;

/**
 * @author micheleorsi
 *
 */
public class JacksonConfiguratorTest {

	public JacksonConfiguratorTest() {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link co.cleanweb.italy.poolmeup.rest.config.JacksonConfigurator#JacksonConfigurator()}.
	 * @throws ParseException 
	 */
	@Test
	public void testJacksonConfigurator() {
		SimpleDateFormat simpleFormat = new SimpleDateFormat(JacksonConfigurator.dateFormat);
		String testString = "23/10/1991 23:23";
		Date dateTest = null;
		try {
			dateTest = simpleFormat.parse(testString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		assertEquals("Wed Oct 23 23:23:00 CET 1991", dateTest.toString());
	}

	/**
	 * Test method for {@link co.cleanweb.italy.poolmeup.rest.config.JacksonConfigurator#getContext(java.lang.Class)}.
	 */
	@Test
	public void testGetContext() {
		
	}

}
