/**
 * 
 */
package co.cleanweb.italy.poolmeup.persistence;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

import co.cleanweb.italy.poolmeup.model.Offer;
import co.cleanweb.italy.poolmeup.model.transport.OfferRequest;
import co.cleanweb.italy.poolmeup.persistence.datastore.PersistenceManagerObjectify;
import co.cleanweb.italy.poolmeup.persistence.interfaces.PersistenceManager;

/**
 * @author micheleorsi
 *
 */
public class PersistenceManagerTest {

	public PersistenceManagerTest() {
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
	 * Test method for {@link co.cleanweb.italy.poolmeup.persistence.interfaces.PersistenceManager#read(java.lang.Iterable)}.
	 */
	@Test
	public void testRead() {
		
	}

	/**
	 * Test method for {@link co.cleanweb.italy.poolmeup.persistence.interfaces.PersistenceManager#save(java.lang.Iterable)}.
	 */
	@Test
	public void testSave() {
		Offer testOffer = new Offer(new OfferRequest("13243124","username",null,Integer.valueOf(4),null,null,null,null));
		
		Objectify ofy = ObjectifyService.begin();
		
//		PersistenceManager<Offer> managerOffer = new PersistenceManagerObjectify<Offer>(Offer.class);
//		managerOffer.save(Collections.singleton(testOffer));
		
//		Offer readOffer = managerOffer.read(Collections.singleton(testOffer.getKey())).iterator().next();
//		assertEquals(4, readOffer.getNumberPlaces().intValue());
	}

	/**
	 * Test method for {@link co.cleanweb.italy.poolmeup.persistence.interfaces.PersistenceManager#update(java.lang.Iterable)}.
	 */
	@Test
	public void testUpdate() {
		
	}

	/**
	 * Test method for {@link co.cleanweb.italy.poolmeup.persistence.interfaces.PersistenceManager#delete(java.lang.Iterable)}.
	 */
	@Test
	public void testDelete() {
		
	}

}
