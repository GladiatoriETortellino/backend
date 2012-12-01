package co.cleanweb.italy.poolmeup.model.transport;

import java.util.Calendar;
import java.util.List;

import co.cleanweb.italy.poolmeup.model.Ride;
import co.cleanweb.italy.poolmeup.model.TripForARide;
import co.cleanweb.italy.poolmeup.model.User;

public class RideRequest {
	
	protected Long userID = null;
	protected String userName = null;
	protected Calendar requestTime = null;  
	protected Integer numberOfPerson = null; 
	protected StepRequest origin_destination = null;
	protected List<User> friends = null;
	
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Calendar getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Calendar requestTime) {
		this.requestTime = requestTime;
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
	public List<User> getFriends() {
		return friends;
	}
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
	public List<TripForARide> getFeasibleLifts(){
		Ride r = new Ride(this);
		return r.getCompatibleTrips();
	}

}
