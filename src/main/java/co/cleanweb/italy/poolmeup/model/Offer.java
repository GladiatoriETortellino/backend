/**
 * 
 */
package co.cleanweb.italy.poolmeup.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Id;

import com.googlecode.objectify.annotation.Subclass;

import co.cleanweb.italy.poolmeup.model.transport.OfferRequest;
import co.cleanweb.italy.poolmeup.model.transport.OfferResponse;
import co.cleanweb.italy.poolmeup.model.transport.StepRequest;
import co.cleanweb.italy.poolmeup.model.transport.Vehicle_Type;
import co.cleanweb.italy.poolmeup.persistence.interfaces.ObjectPersistable;

/**
 * @author micheleorsi
 *
 */
@Subclass
public class Offer extends AbstractObjectPersist {
	
	//ATTRIBUTES
	private String phoneNumber = null;
	private String userName = null;
	
	private Vehicle_Type vehicleType = null;
	private Integer numberPlaces = 0;
	private Date requestTime = null;
	private Boolean isStartingTime;
	private Integer maxThreshold;
	
	private List<StepRequest> pathRequest = null;


	//CONSTRUCTORS
	public Offer() {}
	
	public Offer(String phoneNumber, String userName, Vehicle_Type vehicleType,
			Integer numberPlaces, Date requestTime, Boolean isStartingTime,
			Integer maxThreshold, List<StepRequest> pathRequest) {
		super();
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.vehicleType = vehicleType;
		this.numberPlaces = numberPlaces;
		this.requestTime = requestTime;
		this.isStartingTime = isStartingTime;
		this.maxThreshold = maxThreshold*60;
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
	/**
	 * @param numberPlaces the numberPlaces to set
	 */
	public void setNumberPlaces(Integer numberPlaces) {
		this.numberPlaces = numberPlaces;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Vehicle_Type getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(Vehicle_Type vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public Boolean getIsStartingTime() {
		return isStartingTime;
	}

	public void setIsStartingTime(Boolean isStartingTime) {
		this.isStartingTime = isStartingTime;
	}

	public Integer getMaxThreshold() {
		return maxThreshold;
	}

	public void setMaxThreshold(Integer maxThreshold) {
		this.maxThreshold = maxThreshold;
	}

	public List<StepRequest> getPathRequest() {
		return pathRequest;
	}

	public void setPathRequest(List<StepRequest> pathRequest) {
		this.pathRequest = pathRequest;
	}

	
	@Override
	public String toString() {
		return "Offer [phoneNumber=" + phoneNumber + ", userName=" + userName
				+ ", vehicleType=" + vehicleType + ", numberPlaces="
				+ numberPlaces + ", requestTime=" + requestTime
				+ ", isStartingTime=" + isStartingTime + ", maxThreshold="
				+ maxThreshold + ", pathRequest=" + pathRequest + "]";
	}
	
	
	
}
