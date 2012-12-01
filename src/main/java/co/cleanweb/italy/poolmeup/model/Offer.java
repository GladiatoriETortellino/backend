/**
 * 
 */
package co.cleanweb.italy.poolmeup.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import co.cleanweb.italy.poolmeup.model.transport.OfferRequest;
import co.cleanweb.italy.poolmeup.model.transport.OfferResponse;
import co.cleanweb.italy.poolmeup.model.transport.StepRequest;
import co.cleanweb.italy.poolmeup.model.transport.Vehicle_Type;
import co.cleanweb.italy.poolmeup.persistence.interfaces.ObjectPersistable;

/**
 * @author micheleorsi
 *
 */
public class Offer extends AbstractObjectPersist {
	
	//ATTRIBUTES
	private String phoneNumber = null;
	private String userName = null;
	
	private Vehicle_Type vehicleType = null;
	private Integer numberPlaces = 0;
	private Calendar requestTime = null;
	private Boolean isStartingTime;
	private Integer maxThreshold;
	
	private List<StepRequest> pathRequest = null;


	//CONSTRUCTORS
	public Offer(String phoneNumber, String userName, Vehicle_Type vehicleType,
			Integer numberPlaces, Calendar requestTime, Boolean isStartingTime,
			Integer maxThreshold, List<StepRequest> pathRequest) {
		super();
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.vehicleType = vehicleType;
		this.numberPlaces = numberPlaces;
		this.requestTime = requestTime;
		this.isStartingTime = isStartingTime;
		this.maxThreshold = maxThreshold;
		this.pathRequest = pathRequest;
	}
	
	public Offer(OfferRequest offerRequest) {
		this.phoneNumber = offerRequest.getPhoneNumber();
		this.userName = offerRequest.getUserName();
		this.vehicleType = offerRequest.getVehicleType();
		this.numberPlaces = offerRequest.getNumberPlaces();
		this.requestTime = offerRequest.getRequestTime();
		this.isStartingTime = offerRequest.isStartingTime();
		this.maxThreshold = offerRequest.getMaxThreshold();
		this.pathRequest = offerRequest.getPathRequest();
	}
	
	
	//METHODS
	/**
	 * @return the numberPlaces
	 */
	public Integer getNumberPlaces() {
		return numberPlaces;
	}
	
	
}
