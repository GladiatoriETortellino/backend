package co.cleanweb.italy.poolmeup.model;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Parent;
import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class Step extends AbstractObjectPersist{
	private Double latitude = null;
	private Double longitude = null;
	private boolean isFromPickToDrop = true;
	
	@Parent 
	Key<Offer> offer;
	
	public Step() {}
	
	/**
	 * @param latitude
	 * @param longitude
	 */
	public Step(Double latitude, Double longitude) {
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
	
	public Double getDelay(Step step){
		return null; //TODO: get Step Delay
	}
}