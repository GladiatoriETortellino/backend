/**
 * 
 */
package co.cleanweb.italy.poolmeup.persistence.datastore;

import java.util.HashMap;
import java.util.Map;

import co.cleanweb.italy.poolmeup.model.Offer;
import co.cleanweb.italy.poolmeup.model.Ride;

/**
 * @author micheleorsi
 *
 */
public class FakeDB {

	public static Map<Long, Offer> offerDB = new HashMap<Long, Offer>();
	public static int countOffer = 0;
	
	public static Map<Long, Ride> rideDB = new HashMap<Long, Ride>();
	public static int countRide = 0;
	
}
