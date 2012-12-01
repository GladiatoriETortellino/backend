package co.cleanweb.italy.poolmeup.model.transport;

import java.util.List;

import co.cleanweb.italy.poolmeup.model.User;

public class RideRequest {
	
	protected Long userID = null;
	protected String userName = null;
	protected Long numberOfPerson = null; 
	protected List<StepRequest> origin_destination = null;
	protected List<User> friends = null;

}
