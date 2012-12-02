/**
 * 
 */
package co.cleanweb.italy.poolmeup.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import co.cleanweb.italy.poolmeup.model.AbstractObjectPersist;
import co.cleanweb.italy.poolmeup.model.Child;
import co.cleanweb.italy.poolmeup.model.Offer;
import co.cleanweb.italy.poolmeup.model.ParentClass;
import co.cleanweb.italy.poolmeup.model.Ride;
import co.cleanweb.italy.poolmeup.model.Step;
import co.cleanweb.italy.poolmeup.model.User;
import co.cleanweb.italy.poolmeup.model.transport.OfferRequest;
import co.cleanweb.italy.poolmeup.model.transport.Vehicle_Type;
import co.cleanweb.italy.poolmeup.persistence.datastore.PersistenceManagerObjectify;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.DAOBase;

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
		if(false) {
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
	}
	
	@Test
	public void testOfferAndStep() {
		//SIMONE
		PersistenceManagerObjectify<Offer> managerOffer = new PersistenceManagerObjectify<Offer>(Offer.class);
		PersistenceManagerObjectify<Step> managerStep = new PersistenceManagerObjectify<Step>(Step.class);
		
		List<Step> pathRequest=new ArrayList<Step>(2);
		Step origin=new Step(12.38228, 41.93889);
		Step destination=new Step(12.43446, 41.91284);
		pathRequest.add(origin);
		pathRequest.add(destination);
		OfferRequest offerRequest=new OfferRequest("3929428039", "bo", Vehicle_Type.AUTO, 
				3, new java.util.Date(), true, 3600, pathRequest);

		
		Offer offer = new Offer(offerRequest);
		ObjectifyFactory ofy=new ObjectifyFactory();
//		long key_offer= ofy.allocateId(Offer.class);
//		offer.setKey(key_offer);
		
		managerOffer.save(Collections.singleton(offer));

		List<Step> list_step=offer.getPathRequest();
		
		Iterator<Step> it_step=list_step.iterator();
		while(it_step.hasNext()) {
			Step tmp_step = it_step.next();
			Key<Offer> owner = new Key<Offer>(Offer.class, offer.getKey());
//			tmp_step.setOwner(owner);
		}
		managerStep.save(list_step);

		
		Step step_fake_1=new Step();
		Step step_fake_2=new Step();
		Step step_fake_3=new Step();
		List<Step> list_step_fake=new ArrayList<Step>(3);
		list_step_fake.add(step_fake_1);
		list_step_fake.add(step_fake_2);
		list_step_fake.add(step_fake_3);
		managerStep.save(list_step_fake);

		
		Iterable<Step> steps = managerStep.localDao.ofy().query(Step.class).ancestor(offer).list();
		int i=0;
		Iterator<Step> it = steps.iterator();
		
		while(it.hasNext()) {
			it.next();
			i++;
		}
//		assertEquals(offer.getPathRequest().size(), i);
		
		Iterable<Step> all_steps = managerStep.localDao.ofy().query(Step.class).list();
		i=0;
		it = all_steps.iterator();
		
		while(it.hasNext()) {
			it.next();
			i++;
		}
		assertEquals(offer.getPathRequest().size()+list_step_fake.size(), i);

	}

	public void testModel() {
//		ObjectifyService.register(ParentClass.class);
//		ObjectifyService.register(Child.class);
//		ObjectifyService.register(AbstractObjectPersist.class);
//		Objectify ofy = ObjectifyService.begin();
		
		PersistenceManagerObjectify<ParentClass> managerParent = new PersistenceManagerObjectify<ParentClass>(ParentClass.class);
		PersistenceManagerObjectify<Child> managerChild = new PersistenceManagerObjectify<Child>(Child.class);
		
		ParentClass parent = new ParentClass("testName");
		Child child1 = new Child(parent, "color1");
		Child child2 = new Child(parent, "color2");
		Child child3 = new Child(parent, "color3");		
		
		managerParent.save(Collections.singleton(parent));
		managerChild.save(Collections.singleton(child1));
		managerChild.save(Collections.singleton(child2));
		managerChild.save(Collections.singleton(child3));
		assertNotNull(parent.getKey());
		assertNotNull(child1.getKey());
		assertNotNull(child2.getKey());
		assertNotNull(child3.getKey());
		
		Collection<ParentClass> parentReturn = managerParent.read(Collections.singleton(parent.getKey()));
		ParentClass parentTest = parentReturn.iterator().next();
		assertNull(parent.getListChild());
		
		List<Child> list = managerChild.localDao.ofy().query(Child.class).ancestor(parent).list();
		assertEquals(3, list.size());
		
		parentTest.setListChild(list);
		assertNotNull(parent.getListChild());
		assertEquals(3,parent.getListChild().size());
//		Key<ParentClass> owner = new Key<ParentClass>(ParentClass.class, "somePersonId");
//		Car someCar = ofy.get(new Key<Car>(owner, Car.class, someCarId));
	}
}
