package co.cleanweb.italy.poolmeup.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Transient;

import com.googlecode.objectify.annotation.Subclass;

import co.cleanweb.italy.poolmeup.model.transport.RideRequest;
import co.cleanweb.italy.poolmeup.model.transport.StepRequest;

@Subclass
public class Ride extends AbstractObjectPersist {
	
	private static final Double inf = (double) 99999;
	protected Long userID = null;
	protected String userName = null;
	protected Calendar requestTime = null;  
	protected Integer numberOfPerson = null; 
	protected StepRequest origin_destination = null;
	@Transient protected List<User> friends = null;
	
	public Ride(RideRequest rr){
		
		this.userID = rr.getUserID();
		this.userName = rr.getUserName();
		this.requestTime = rr.getRequestTime();
		this.numberOfPerson = rr.getNumberOfPerson(); 
		this.origin_destination = rr.getOrigin_destination();
		this.friends = rr.getFriends();
		
	}
	
	public Ride() {}

	public List<TripForARide> getCompatibleTrips(){
		
		List<TripForARide> compatibleTrips = new ArrayList<TripForARide>();
		Iterator<User> it = this.friends.iterator();
		while (it.hasNext()){ 
			User currentFriend = it.next(); //for each pollable friend
			Trip currentTrip = currentFriend.getTrip(); //get his trip
			if (currentTrip != null){ //TODO: and vehicleType is compatible with asker's preferences
				Double delay = currentTrip.getDelay(this); //if any, get delay (inf = out of delay)
				if (delay < inf){
					compatibleTrips.add(new TripForARide(currentFriend.getUserName(), currentFriend.getPhoneNumber(), currentTrip.getVehicleType())); //if compatible, add to the list
				}
			}
		}
		return compatibleTrips;
	}

	/**
	 * @return the userID
	 */
	public Long getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Long userID) {
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
	 * @return the requestTime
	 */
	public Calendar getRequestTime() {
		return requestTime;
	}

	/**
	 * @param requestTime the requestTime to set
	 */
	public void setRequestTime(Calendar requestTime) {
		this.requestTime = requestTime;
	}

	
	/**
	 * @return the friends
	 */
	public List<User> getFriends() {
		return friends;
	}

	/**
	 * @param friends the friends to set
	 */
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
	public Integer getNumberOfPerson() {
		return numberOfPerson;
	}

	public void setNumberOfPerson(Integer numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}

	public StepRequest getOrigin_destination() {
		return origin_destination;
	}

	public void setOrigin_destination(StepRequest origin_destination) {
		this.origin_destination = origin_destination;
	}

}
