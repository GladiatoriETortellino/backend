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
	
	public RideResponse(Ride ride, RideRequest rideRequest) {
		this.userName = rideRequest.getUserName();
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the offers
	 */
	public List<TripForARide> getOffers() {
		return offers;
	}

	/**
	 * @param offers the offers to set
	 */
	public void setOffers(List<TripForARide> offers) {
		this.offers = offers;
	}
}

