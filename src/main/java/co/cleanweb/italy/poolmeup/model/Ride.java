package co.cleanweb.italy.poolmeup.model;

import java.util.List;

import com.googlecode.objectify.annotation.Subclass;

import co.cleanweb.italy.poolmeup.model.transport.RideRequest;
import co.cleanweb.italy.poolmeup.model.transport.StepRequest;

@Subclass
public class Ride extends AbstractObjectPersist {
	
	protected Long userID = null;
	protected String userName = null;
	protected Long numberOfPerson = null; 
	protected List<StepRequest> origin_destination = null;
	protected List<User> friends = null;
	
	public Ride(RideRequest rr){
		
		//copia degli attributi da RideRequest a Ride
		
	}
	
	public Ride() {}

}
