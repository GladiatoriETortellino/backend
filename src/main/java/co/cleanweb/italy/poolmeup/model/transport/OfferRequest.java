/**
 * 
 */
package co.cleanweb.italy.poolmeup.model.transport;

import java.util.Date;
import java.util.List;

/**
 * @author micheleorsi
 *
 */
public class OfferRequest {
	
	private String phoneNumber = null;
	private String userName = null;
	
	private String vehicleType = null;
	private int numberPlaces = 0;
	private Date requestTime = null;
	private boolean isStartingTime;
	private int maxThreshold;
	
	private List<StepRequest> pathRequest = null;
	
	public OfferRequest() {}

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
	public String getVehicleType() {
		return vehicleType;
	}

	/**
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * @return the numberPlaces
	 */
	public int getNumberPlaces() {
		return numberPlaces;
	}

	/**
	 * @param numberPlaces the numberPlaces to set
	 */
	public void setNumberPlaces(int numberPlaces) {
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
	public boolean isStartingTime() {
		return isStartingTime;
	}

	/**
	 * @param isStartingTime the isStartingTime to set
	 */
	public void setStartingTime(boolean isStartingTime) {
		this.isStartingTime = isStartingTime;
	}

	/**
	 * @return the maxThreshold
	 */
	public int getMaxThreshold() {
		return maxThreshold;
	}

	/**
	 * @param maxThreshold the maxThreshold to set
	 */
	public void setMaxThreshold(int maxThreshold) {
		this.maxThreshold = maxThreshold;
	}

	/**
	 * @return the pathRequest
	 */
	public List<StepRequest> getPathRequest() {
		return pathRequest;
	}

	/**
	 * @param pathRequest the pathRequest to set
	 */
	public void setPathRequest(List<StepRequest> pathRequest) {
		this.pathRequest = pathRequest;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{\"returnMessage\":\"this is a good offer request\"}";
	}
}
