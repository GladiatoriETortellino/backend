/**
 * 
 */
package co.cleanweb.italy.poolmeup.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.googlecode.objectify.annotation.Subclass;
import co.cleanweb.italy.poolmeup.model.transport.StepRequest;
import co.cleanweb.italy.poolmeup.model.transport.Vehicle_Type;

/**
 * @author micheleorsi
 *
 */
@Subclass
public class Trip extends AbstractObjectPersist {
	
	protected String driverName;
	protected String driverPhoneNumber;
	protected Vehicle_Type vehicleType;
	protected Integer numberOfPlaces;
	protected List<StepRequest> stepList;
	
	public Trip(List<StepRequest> stepList) {
		this.stepList = stepList;
	}

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
		/*
		List<StepRequest> tripStepsList = this.getSteps();
		StepRequest[] tripSteps = new StepRequest[tripStepsList.size()];
		tripStepsList.toArray(tripSteps);
		
		for (int i = 0; i < tripSteps.length; i++){
			for (int j = i; j < tripSteps.length; j++){
				List<StepRequest> tentativeSteps = new ArrayList<StepRequest>();
				for (int k = 0; k < tripSteps.length; k++){
					
				}
				Trip tentativeTrip = new Trip();
			}
		}
		
		int freePlaces = this.numberOfPlaces;
		Iterator<StepRequest> it = tripSteps.iterator();
		while (it.hasNext()){
			StepRequest currentStep = it.next();
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
		
		*/
		
		return null; //TODO: insert delay calculation
	}
	
	public List<StepRequest> getSteps(){
		//TODO: query read steps from db
		return null;
	}

}
