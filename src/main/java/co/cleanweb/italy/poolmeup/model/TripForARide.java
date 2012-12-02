
package co.cleanweb.italy.poolmeup.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import co.cleanweb.italy.poolmeup.model.transport.Vehicle_Type;

@XmlRootElement
public class TripForARide {
	@XmlElement
	protected String offererName;
	@XmlElement
	protected String offererPhoneNumber;
	@XmlElement
	protected Vehicle_Type vehicleType;
	@XmlElement
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

	/**
	 * @return the offererName
	 */
	public String getOffererName() {
		return offererName;
	}

	/**
	 * @param offererName the offererName to set
	 */
	public void setOffererName(String offererName) {
		this.offererName = offererName;
	}

	/**
	 * @return the offererPhoneNumber
	 */
	public String getOffererPhoneNumber() {
		return offererPhoneNumber;
	}

	/**
	 * @param offererPhoneNumber the offererPhoneNumber to set
	 */
	public void setOffererPhoneNumber(String offererPhoneNumber) {
		this.offererPhoneNumber = offererPhoneNumber;
	}

	/**
	 * @return the vehicleType
	 */
	public Vehicle_Type getVehicleType() {
		return vehicleType;
	}

	/**
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(Vehicle_Type vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * @return the sufferedDelay
	 */
	public Double getSufferedDelay() {
		return sufferedDelay;
	}

	/**
	 * @param sufferedDelay the sufferedDelay to set
	 */
	public void setSufferedDelay(Double sufferedDelay) {
		this.sufferedDelay = sufferedDelay;
	}
	
	
}
