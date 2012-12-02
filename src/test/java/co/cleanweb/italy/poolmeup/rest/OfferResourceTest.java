/**
 * 
 */
package co.cleanweb.italy.poolmeup.rest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.cleanweb.italy.poolmeup.model.Offer;
import co.cleanweb.italy.poolmeup.model.Step;
import co.cleanweb.italy.poolmeup.model.transport.OfferRequest;
import co.cleanweb.italy.poolmeup.model.transport.OfferResponse;
import co.cleanweb.italy.poolmeup.model.transport.Vehicle_Type;
import co.cleanweb.italy.poolmeup.persistence.datastore.PersistenceManagerObjectify;
import co.cleanweb.italy.poolmeup.persistence.interfaces.PersistenceManager;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

/**
 * @author micheleorsi
 *
 */
public class OfferResourceTest {
	private LocalServiceTestHelper helper =
		    null;
	OfferRequest offerRequest = null;
	OfferResource offerResource = null;

	public OfferResourceTest() {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		offerResource = new OfferResource();
		helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
		helper.setUp();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		helper.tearDown();
	}

	/**
	 * Test method for {@link co.cleanweb.italy.poolmeup.rest.OfferResource#OfferResource()}.
	 */
	@Test
	public void testOfferResource() {
		
	}

	/**
	 * Test method for {@link co.cleanweb.italy.poolmeup.rest.OfferResource#getOffers()}.
	 */
	@Test
	public void testGetOffers() {
		
	}

	/**
	 * Test method for {@link co.cleanweb.italy.poolmeup.rest.OfferResource#getSpecificPath()}.
	 */
	@Test
	public void testGetSpecificPath() {
		
	}

	/**
	 * Test method for {@link co.cleanweb.italy.poolmeup.rest.OfferResource#createNewOffer(co.cleanweb.italy.poolmeup.model.transport.OfferRequest)}.
	 */
	@Test
	public void testCreateNewOffer() {
		List<Step> list = new ArrayList<Step>();
		offerRequest = new OfferRequest("333333333333", "Pippo", Vehicle_Type.AUTO, Integer.valueOf(1), new Date(), Boolean.valueOf(true), Integer.valueOf(30), list);
		Response response = offerResource.createNewOffer(offerRequest);
		
		PersistenceManagerObjectify<Offer> managerOffer = new PersistenceManagerObjectify<Offer>(Offer.class);
		List<Offer> listOffer = managerOffer.localDao.ofy().query(Offer.class).list();
		assertNotNull(listOffer);
		assertEquals(1, listOffer.size());
		Offer readOffer = listOffer.get(0);
		assertEquals(true,readOffer.getIsStartingTime().booleanValue());
		assertEquals(Integer.valueOf(30),readOffer.getMaxThreshold());
		assertEquals(Integer.valueOf(1),readOffer.getNumberPlaces());
		assertEquals("333333333333",readOffer.getPhoneNumber());
//		assertEquals("", actual)
//		OfferResponse responseClass = (OfferResponse) response.getEntity();
//		assertEquals("Pippo", responseClass.getUsername());
	}

	/**
	 * Test method for {@link co.cleanweb.italy.poolmeup.rest.OfferResource#updateOffer(co.cleanweb.italy.poolmeup.model.transport.OfferRequest)}.
	 */
	@Test
	public void testUpdateOffer() {
		
	}

	/**
	 * Test method for {@link co.cleanweb.italy.poolmeup.rest.OfferResource#joinOffer()}.
	 */
	@Test
	public void testJoinOffer() {
		
	}

}
