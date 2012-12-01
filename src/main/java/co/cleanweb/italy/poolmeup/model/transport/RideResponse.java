/**
 * 
 */
package co.cleanweb.italy.poolmeup.model.transport;

import java.util.List;

import co.cleanweb.italy.poolmeup.model.Ride;
import co.cleanweb.italy.poolmeup.model.Trip;
import co.cleanweb.italy.poolmeup.model.TripForARide;

/**
 * @author micheleorsi
 *
 */
public class RideResponse {
	
	protected String userID;
	protected String userName;
	protected List<TripForARide> offers;

	public RideResponse() {}
	
	public RideResponse(Ride ride) {}
}

