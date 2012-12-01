package co.cleanweb.italy.poolmeup.model;

import java.util.Iterator;
import java.util.List;

import co.cleanweb.italy.poolmeup.model.transport.RideRequest;
import co.cleanweb.italy.poolmeup.model.transport.StepRequest;

public class Ride{
	
	protected Long userID = null;
	protected String userName = null;
	protected Long numberOfPerson = null; 
	protected List<StepRequest> origin_destination = null;
	protected List<User> friends = null;
	
	public Ride(RideRequest rr){
		
		this.userID = rr.getUserID();
		this.userName = rr.getUserName();
		this.numberOfPerson = rr.getNumberOfPerson(); 
		this.origin_destination = rr.getOrigin_destination();
		this.friends = rr.getFriends();
		
	}
	
	public List<User> getCompatibleTrips(){
		
		Iterator<User> it = this.friends.iterator();
		while (it.hasNext()){
			User currentFriend = it.next();
			
		}
		
		return null;
		
	}

}
