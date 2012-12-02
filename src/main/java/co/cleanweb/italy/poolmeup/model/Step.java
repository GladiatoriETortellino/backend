package co.cleanweb.italy.poolmeup.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Step extends AbstractObjectPersist{
	@XmlElement 
	private Double lat;
	@XmlElement 
	private Double lng;
	@XmlElement 
	private String name;
	@XmlElement
	private boolean isFromPickToDrop = true;
	
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
	 * @return the lat
	 */
	public Double getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}

	/**
	 * @return the lng
	 */
	public Double getLng() {
		return lng;
	}

	/**
	 * @param lng the lng to set
	 */
	public void setLng(Double lng) {
		this.lng = lng;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the isFromPickToDrop
	 */
	public boolean isFromPickToDrop() {
		return isFromPickToDrop;
	}

	/**
	 * @param isFromPickToDrop the isFromPickToDrop to set
	 */
	public void setFromPickToDrop(boolean isFromPickToDrop) {
		this.isFromPickToDrop = isFromPickToDrop;
	}

	


}