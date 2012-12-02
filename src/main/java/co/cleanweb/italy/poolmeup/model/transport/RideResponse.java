/**
 * 
 */
package co.cleanweb.italy.poolmeup.model.transport;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import co.cleanweb.italy.poolmeup.model.Ride;
import co.cleanweb.italy.poolmeup.model.Trip;
import co.cleanweb.italy.poolmeup.model.TripForARide;

/**
 * @author micheleorsi
 *
 */
@XmlRootElement
public class RideResponse {
	@XmlElement
	protected String userID;
	@XmlElement
	protected String userName;
	@XmlElement
	protected List<TripForARide> offers;
	
	public RideResponse() {}
	
	public RideResponse(Ride ride) {}
}

