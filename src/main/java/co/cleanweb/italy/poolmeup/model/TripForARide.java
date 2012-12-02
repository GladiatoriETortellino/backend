
package co.cleanweb.italy.poolmeup.model;

import co.cleanweb.italy.poolmeup.model.transport.Vehicle_Type;

public class TripForARide {

	protected String offererName;
	protected String offererPhoneNumber;
	protected Vehicle_Type vehicleType;
	protected Double sufferedDelay;
	//protected Double waitingTime;

	public TripForARide(String userName, String phoneNumber, Vehicle_Type vehicleType, Double sufferedDelay) {
		this.offererName = userName;
		this.offererPhoneNumber = phoneNumber;
		this.vehicleType = vehicleType;
		this.sufferedDelay = sufferedDelay;
	}
	
	public TripForARide(Trip trip) {
		
		this.offererName = trip.getDriverName();
		this.offererPhoneNumber = trip.getDriverPhoneNumber();
		this.vehicleType = trip.getVehicleType();
		
	}
	
	public TripForARide() {}
	
	public double compareTo(TripForARide otherTrip){
		return this.sufferedDelay - otherTrip.sufferedDelay;
	}
	
}
