package co.cleanweb.italy.poolmeup.model.transport;

public class StepRequest {
	private Double latitude = null;
	private Double longitude = null;
	private boolean isFromPickToDrop = true;
	
	public StepRequest() {}
	
	/**
	 * @param latitude
	 * @param longitude
	 */
	public StepRequest(Double latitude, Double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{\"returnMessage\":\"this is a good offer request\"}";
	}

	public boolean isFromPickToDrop() {
		return isFromPickToDrop;
	}

	public void setFromPickToDrop(boolean isFromPickToDrop) {
		this.isFromPickToDrop = isFromPickToDrop;
	}
	
	public Double getDelay(StepRequest step){
		return null; //TODO: get Step Delay
	}
}