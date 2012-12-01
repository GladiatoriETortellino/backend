/**
 * 
 */
package co.cleanweb.italy.poolmeup.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import co.cleanweb.italy.poolmeup.model.Ride;
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
		
		Iterable<User> subordinates = managerUser.localDao.ofy().query(User.class).filter("ride", ride);
		assertEquals(3, listFriends.size());
	}

}
