/**
 * 
 */
package co.cleanweb.italy.poolmeup.model;

import co.cleanweb.italy.poolmeup.model.transport.StepRequest;
import co.cleanweb.italy.poolmeup.model.transport.Vehicle_Type;

/**
 * @author micheleorsi
 *
 */
public class Trip  extends AbstractObjectPersist {
	
	protected String driverName;
	protected String driverPhoneNumber;
	protected Vehicle_Type vehicleType;
	protected Integer numberOfPlaces;
	
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverPhoneNumber() {
		return driverPhoneNumber;
	}

	public void setDriverPhoneNumber(String driverPhoneNumber) {
		this.driverPhoneNumber = driverPhoneNumber;
	}

	public Vehicle_Type getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(Vehicle_Type vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Integer getNumberOfPlaces() {
		return numberOfPlaces;
	}

	public void setNumberOfPlaces(Integer numberOfPlaces) {
		this.numberOfPlaces = numberOfPlaces;
	}

	public Double getDelay(StepRequest ODStep){
		return null; //TODO: insert delay calculation
	}

}
