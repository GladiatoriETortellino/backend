package co.cleanweb.italy.poolmeup.model;

import javax.jdo.annotations.Element;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Parent;
import com.googlecode.objectify.annotation.Subclass;

@Subclass
@XmlRootElement
public class Step extends AbstractObjectPersist{
	@XmlElement 
	private Double lat = null;
	@XmlElement 
	private Double lng = null;
	@XmlElement 
	private String name="";
	private boolean isFromPickToDrop = true;
	
	@Parent
	private Key<Offer> offer;
	
	public Step() {}
	
	/**
	 * @param latitude
	 * @param longitude
	 */
	public Step(Double latitude, Double longitude) {
		super();
		this.lat = latitude;
		this.lng = longitude;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return lat;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.lat = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return lng;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.lng = longitude;
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

	/**
	 * @return the offer
	 */
	public Key<Offer> getOffer() {
		return offer;
	}

	/**
	 * @param offer the offer to set
	 */
	public void setOffer(Key<Offer> offer) {
		this.offer = offer;
	}


//	public Key<Offer> getOwner() {
//		return owner;
//	}
//
//	public void setOwner(Key<Offer> owner) {
//		this.owner = owner;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if(obj==null || !obj.getClass().equals(getClass())) return false;
//		Step step=(Step) obj;
//		return latitude==step.getLatitude() && longitude==step.getLongitude() && isFromPickToDrop==step.isFromPickToDrop()
//				&& owner.equals(step.getOwner());
//		
//	};


}