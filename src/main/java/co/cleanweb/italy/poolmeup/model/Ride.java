package co.cleanweb.italy.poolmeup.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

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
	protected List<User> friends = null;
	
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
			if (currentTrip != null){
				Double delay = currentTrip.getDelay(this.origin_destination); //if any, get delay (inf = out of delay)
				if (delay < inf){
					compatibleTrips.add(new TripForARide(currentFriend.getUserName(), currentFriend.getPhoneNumber(), currentTrip.getVehicleType())); //if compatible, add to the list
				}
			}
		}
		return compatibleTrips;
	}

}
