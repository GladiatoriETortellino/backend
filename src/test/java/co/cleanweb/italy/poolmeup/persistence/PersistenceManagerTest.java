/**
 * 
 */
package co.cleanweb.italy.poolmeup.persistence;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

import co.cleanweb.italy.poolmeup.model.Offer;
import co.cleanweb.italy.poolmeup.model.Ride;
import co.cleanweb.italy.poolmeup.model.Trip;
import co.cleanweb.italy.poolmeup.model.User;
import co.cleanweb.italy.poolmeup.model.transport.OfferRequest;
import co.cleanweb.italy.poolmeup.persistence.datastore.PersistenceManagerObjectify;
import co.cleanweb.italy.poolmeup.persistence.interfaces.PersistenceManager;

/**
 * @author micheleorsi
 *
 */
public class PersistenceManagerTest {
	
	private LocalServiceTestHelper helper =
		    null;
	Offer testOffer = null;
	PersistenceManagerObjectify<Offer> manager = null;
	
	public PersistenceManagerTest() {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testOffer = new Offer();
		helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
		helper.setUp();
		manager = new PersistenceManagerObjectify<Offer>(Offer.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		helper.tearDown();
	}

	/**
	 * Test method for {@link co.cleanweb.italy.poolmeup.persistence.interfaces.PersistenceManager#read(java.lang.Iterable)}.
	 */
	@Test
	public void testRead() {
		manager.save(Collections.singleton(testOffer));
		assertNotNull(manager.read(Collections.singleton(testOffer.getKey())));
	}

	/**
	 * Test method for {@link co.cleanweb.italy.poolmeup.persistence.interfaces.PersistenceManager#save(java.lang.Iterable)}.
	 */
	@Test
	public void testSave() {
		manager.save(Collections.singleton(testOffer));
		
		assertNotNull(testOffer.getKey());
		assertNotNull(testOffer.getCreationDate());
		assertNotNull(testOffer.getUpdatedDate());
		
		Date firstDate = testOffer.getUpdatedDate();
		manager.save(Collections.singleton(testOffer));
		assertFalse(firstDate.equals(testOffer.getUpdatedDate()));
		
		Offer readOffer = manager.read(Collections.singleton(testOffer.getKey())).iterator().next();
		assertNotNull(readOffer);
	}

	/**
	 * Test method for {@link co.cleanweb.italy.poolmeup.persistence.interfaces.PersistenceManager#update(java.lang.Iterable)}.
	 */
	@Test
	public void testUpdate() {
		manager.save(Collections.singleton(testOffer));
		
		assertNotNull(testOffer.getKey());
		assertNotNull(testOffer.getCreationDate());
		assertNotNull(testOffer.getUpdatedDate());
		assertEquals(testOffer.getCreationDate(), testOffer.getUpdatedDate());
		assertEquals(0,testOffer.getNumberPlaces().intValue());
		
		Date firstDate = testOffer.getUpdatedDate();
		testOffer.setNumberPlaces(Integer.valueOf(2));
		manager.save(Collections.singleton(testOffer));
		assertFalse(firstDate.equals(testOffer.getUpdatedDate()));
		assertEquals(Integer.valueOf(2),testOffer.getNumberPlaces());
	}

	/**
	 * Test method for {@link co.cleanweb.italy.poolmeup.persistence.interfaces.PersistenceManager#delete(java.lang.Iterable)}.
	 */
	@Test
	public void testDelete() {
		manager.save(Collections.singleton(testOffer));
		manager.delete(Collections.singleton(testOffer.getKey()));
	}

}
