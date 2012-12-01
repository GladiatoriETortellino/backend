/**
 * 
 */
package co.cleanweb.italy.poolmeup.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import co.cleanweb.italy.poolmeup.model.Offer;
import co.cleanweb.italy.poolmeup.model.Ride;
import co.cleanweb.italy.poolmeup.model.Step;
import co.cleanweb.italy.poolmeup.model.User;
import co.cleanweb.italy.poolmeup.persistence.datastore.PersistenceManagerObjectify;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

/**
 * @author micheleorsi
 *
 */
public class PersistenceTestRelation {
	
	private LocalServiceTestHelper helper =
		    null;
	
	
	public PersistenceTestRelation() {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
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

	@Test
	public void testRideUser() {
		
		PersistenceManagerObjectify<Ride> managerRide = new PersistenceManagerObjectify<Ride>(Ride.class);
		PersistenceManagerObjectify<User> managerUser = new PersistenceManagerObjectify<User>(User.class);
		
		Ride ride = new Ride();
		User newUser1 = new User("123456","userName");
		User newUser2 = new User("123456","userName");
		User newUser3 = new User("123456","userName");
		
		ArrayList<User> listFriends = new ArrayList<User>();
		listFriends.add(newUser1);
		listFriends.add(newUser2);
		listFriends.add(newUser3);
		ride.setFriends(listFriends);
		managerUser.save(listFriends);
		managerRide.save(Collections.singleton(ride));
		assertNotNull(ride.getKey());
		for (User user : listFriends) {
			assertNotNull(user);
		}
		
		Iterable<User> subordinates = managerUser.localDao.ofy().query(User.class).filter("ride =", ride);
		int i=1;
		Iterator<User> it = subordinates.iterator();
		while(it.hasNext()) {
			it.next();
			i++;
		}
		assertEquals(3, i);
	}
	
	@Test
	public void testOfferAndStep() {
		
		PersistenceManagerObjectify<Offer> managerOffer = new PersistenceManagerObjectify<Offer>(Offer.class);
		PersistenceManagerObjectify<Step> managerStep = new PersistenceManagerObjectify<Step>(Step.class);
		
		Offer offer = new Offer();
		Step step1 = new Step();
		Step step2 = new Step();
		Step step3 = new Step();
		List<Step> listFromOfferRequest = new ArrayList<Step>();
		listFromOfferRequest.add(step1);
		listFromOfferRequest.add(step2);
		listFromOfferRequest.add(step3);
		
		// ideal start from POST request: Offer and List<Step>
		managerOffer.save(Collections.singleton(offer));
		// offer.getPathRequest(); -> listFromOfferRequest
		managerStep.save(listFromOfferRequest);
		
		assertNotNull(offer.getKey());
		assertNotNull(managerOffer.read(Collections.singleton(offer.getKey())));
		
		assertNotNull(managerStep.read(Collections.singleton(listFromOfferRequest.get(0).getKey())));
		assertNotNull(managerStep.read(Collections.singleton(listFromOfferRequest.get(1).getKey())));
		assertNotNull(managerStep.read(Collections.singleton(listFromOfferRequest.get(2).getKey())));
		
		// until here is ok
		
		Iterable<Step> steps = managerStep.localDao.ofy().query(Step.class).ancestor(offer).list();
		int i=0;
		Iterator<Step> it = steps.iterator();
		
		while(it.hasNext()) {
			it.next();
			i++;
		}
		assertEquals(3, i);
	}

}
