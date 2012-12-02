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
	private String idDatabase;//tel number
	@XmlElement
	private String phoneNumber;
	@XmlElement
	private String pathLink;
	
	//TODO: MICHELE - Da non pubblicare
	private RoutingRequest routingRequest;

	//CONSTRUCORS
	public OfferResponse(){}

	
	public OfferResponse(OfferRequest request) {
		routingRequest=new RoutingRequest(request.getVehicleType(), request.getRequestTime(), request.getPathRequest());
		pathLink=routingRequest.toString();
	}

	//GETTERS
	public String getId() {
		return idDatabase;
	}

	public String getUsername() {
		return phoneNumber;
	}

	public String getPathLink() {
		return pathLink;
	}
	
	public RoutingRequest getRoutingRequest() {
		return routingRequest;
	}


	public void setRoutingRequest(RoutingRequest routingRequest) {
		this.routingRequest = routingRequest;
	}

}
