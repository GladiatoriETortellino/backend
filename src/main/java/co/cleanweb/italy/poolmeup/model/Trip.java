/**
 * 
 */
package co.cleanweb.italy.poolmeup.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.googlecode.objectify.annotation.Subclass;

import co.cleanweb.italy.poolmeup.model.transport.RoutingRequest;
import co.cleanweb.italy.poolmeup.model.transport.Vehicle_Type;

/**
 * @author micheleorsi
 *
 */
@Subclass
public class Trip extends AbstractObjectPersist {
	
	private static final Double inf = 99999.0;
	
	protected String driverName;
	protected String driverPhoneNumber;
	protected Double maxDelay;
	protected Vehicle_Type vehicleType;
	protected Integer numberOfPlaces;
	protected List<Step> stepList;
	protected Calendar calculatedArrivalTime;
	
	public Trip(List<Step> stepList) {
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
		
		//costruisco il nuovo percorso
		List<Step> newSteps = new ArrayList<Step>();
		newSteps.add(this.stepList.get(0));
		newSteps.add(ride.getODSteps().get(0));
		newSteps.add(ride.getODSteps().get(1));
		newSteps.add(this.stepList.get(1));
		//costruisco la route request
		RoutingRequest rr = new RoutingRequest(this.vehicleType, new Date(), newSteps);
		rr.toString();
		
		//TODO: la mando
		
		Calendar newArrivalTime = null; //TODO: prendo il tempo di arrivo
		long sec1 = newArrivalTime.getTimeInMillis() / 1000;
		long sec2 = this.calculatedArrivalTime.getTimeInMillis() / 1000;
		if (sec1 - sec2 > this.maxDelay){
			return inf;
		}
		else{
			return (double) (sec1 - sec2);
		}
				
	}
	
	public List<Step> getSteps(){
		//TODO: query read steps from db
		return null;
	}

}
