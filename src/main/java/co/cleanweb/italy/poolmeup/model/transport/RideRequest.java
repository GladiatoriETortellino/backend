package co.cleanweb.italy.poolmeup.model.transport;

import java.util.List;

import co.cleanweb.italy.poolmeup.model.User;

public class RideRequest {
	
	protected Long userID = null;
	protected String userName = null;
	protected Integer numberOfPerson = null; 
	protected List<StepRequest> origin_destination = null;
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
	public Long getNumberOfPerson() {
		return numberOfPerson;
	}
	public void setNumberOfPerson(Long numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}
	public List<StepRequest> getOrigin_destination() {
		return origin_destination;
	}
	public void setOrigin_destination(List<StepRequest> origin_destination) {
		this.origin_destination = origin_destination;
	}
	public List<User> getFriends() {
		return friends;
	}
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

}
