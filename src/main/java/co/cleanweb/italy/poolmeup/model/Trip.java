/**
 * 
 */
package co.cleanweb.italy.poolmeup.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.googlecode.objectify.annotation.Subclass;
import co.cleanweb.italy.poolmeup.model.transport.Step;
import co.cleanweb.italy.poolmeup.model.transport.Vehicle_Type;

/**
 * @author micheleorsi
 *
 */
@Subclass
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

	public Double getDelay(Ride ride){
		List<Step> tripSteps = this.getSteps();
		int freePlaces = this.numberOfPlaces;
		Iterator<Step> it = tripSteps.iterator();
		while (it.hasNext()){
			Step currentStep = it.next();
			if (currentStep.isFromPickToDrop()){
				freePlaces--;
				}
			else{
				freePlaces++;
			} 
			if (freePlaces >= ride.numberOfPerson){
				currentStep.getDelay(ride.origin_destination);
			}
		}		
		return null; //TODO: insert delay calculation
	}
	
	public List<Step> getSteps(){
		//TODO: query read steps from db
		return null;
	}

	public Trip() {}
}
