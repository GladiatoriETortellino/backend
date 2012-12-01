/**
 * 
 */
package co.cleanweb.italy.poolmeup.model.transport;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.cleanweb.italy.poolmeup.model.Step;

/**
 * @author micheleorsi
 *
 */
public class OfferRequest {
	
	private String phoneNumber = null;
	private String userName = null;
	
	private Vehicle_Type vehicleType = null;
	private Integer numberPlaces = 0;
	private Date requestTime = null;
	private Boolean isStartingTime;
	private Integer maxThreshold;
	
	private List<Step> pathRequest = null;
	
	public OfferRequest() {}
	/**
	 * @param phoneNumber
	 * @param userName
	 * @param vehicleType
	 * @param numberPlaces
	 * @param requestTime
	 * @param isStartingTime
	 * @param maxThreshold
	 * @param pathRequest
	 */
	public OfferRequest(String phoneNumber, String userName,
			Vehicle_Type vehicleType, Integer numberPlaces, Date requestTime,
			Boolean isStartingTime, Integer maxThreshold,
			List<Step> pathRequest) {
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

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

	/**
	 * @return the requestTime
	 */
	public Date getRequestTime() {
		return requestTime;
	}

	/**
	 * @param requestTime the requestTime to set
	 */
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	/**
	 * @return the isStartingTime
	 */
	public Boolean isStartingTime() {
		return isStartingTime;
	}

	/**
	 * @param isStartingTime the isStartingTime to set
	 */
	public void setStartingTime(Boolean isStartingTime) {
		this.isStartingTime = isStartingTime;
	}

	/**
	 * @return the maxThreshold
	 */
	public Integer getMaxThreshold() {
		return maxThreshold;
	}

	/**
	 * @param maxThreshold the maxThreshold to set
	 */
	public void setMaxThreshold(Integer maxThreshold) {
		this.maxThreshold = maxThreshold;
	}

	/**
	 * @return the pathRequest
	 */
	public List<Step> getPathRequest() {
		return pathRequest;
	}

	/**
	 * @param pathRequest the pathRequest to set
	 */
	public void setPathRequest(List<Step> pathRequest) {
		this.pathRequest = pathRequest;
	}
}
