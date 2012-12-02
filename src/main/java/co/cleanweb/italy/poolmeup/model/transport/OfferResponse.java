package co.cleanweb.italy.poolmeup.model.transport;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Date;

import co.cleanweb.italy.poolmeup.model.Offer;


/**
 * @author Simone De Cristofaro
 */

public class OfferResponse {

	private static final String defaultVehicle=Vehicle_Type.AUTO.toString();
	private static final SimpleDateFormat sdf= new SimpleDateFormat("yyyymmdd HH:mm:ss");
	
	//ATTRIBUTES
	private String idDatabase;//tel number
	private String phoneNumber;
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
