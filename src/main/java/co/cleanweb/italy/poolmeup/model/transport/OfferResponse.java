package co.cleanweb.italy.poolmeup.model.transport;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import co.cleanweb.italy.poolmeup.model.Offer;


/**
 * @author Simone De Cristofaro
 */
@XmlRootElement
public class OfferResponse {
	@XmlElement
	private static final String defaultVehicle=Vehicle_Type.AUTO.toString();
	//ATTRIBUTES
	@XmlElement
	private Long idDatabase;//tel number
	@XmlElement
	private String phoneNumber;
	@XmlElement
	private String pathLink;
	
	//TODO: MICHELE - Da non pubblicare
	private RoutingRequest routingRequest;

	//CONSTRUCORS
	public OfferResponse(){}

	
	public OfferResponse(Long idDatabase, OfferRequest request) {
		this.idDatabase=idDatabase;
		this.phoneNumber=request.getPhoneNumber();
		routingRequest=new RoutingRequest(request.getVehicleType(), request.getRequestTime(), request.getPathRequest());
		pathLink=routingRequest.toString();
	}

	//GETTERS
	public Long getId() {
		return idDatabase;
	}


	/**
	 * @return the idDatabase
	 */
	public Long getIdDatabase() {
		return idDatabase;
	}


	/**
	 * @param idDatabase the idDatabase to set
	 */
	public void setIdDatabase(Long idDatabase) {
		this.idDatabase = idDatabase;
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
	 * @return the pathLink
	 */
	public String getPathLink() {
		return pathLink;
	}


	/**
	 * @param pathLink the pathLink to set
	 */
	public void setPathLink(String pathLink) {
		this.pathLink = pathLink;
	}


	/**
	 * @return the routingRequest
	 */
	public RoutingRequest getRoutingRequest() {
		return routingRequest;
	}


	/**
	 * @param routingRequest the routingRequest to set
	 */
	public void setRoutingRequest(RoutingRequest routingRequest) {
		this.routingRequest = routingRequest;
	}

	

}
