package co.cleanweb.italy.poolmeup.model.transport;

public class StepRequest {
	private Long latitude = null;
	private Long longitude = null;
	
	public StepRequest() {}
	
	/**
	 * @param latitude
	 * @param longitude
	 */
	public StepRequest(Long latitude, Long longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public Long getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Long getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{\"returnMessage\":\"this is a good offer request\"}";
	}
}