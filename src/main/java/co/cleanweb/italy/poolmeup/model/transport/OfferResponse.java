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

	private static final String routingServiceUrl="http://hackathon.opendata.sistemaits.com/dsps/?"; 
	private static final String defaultVehicle=Vehicle_Type.AUTO.toString();
	private static final SimpleDateFormat sdf= new SimpleDateFormat("yyyymmdd HH:mm:ss");
	
	//ATTRIBUTES
	private String idDatabase;//tel number
	private String phoneNumber;
	private String pathLink;
	
	//CONSTRUCORS
	public OfferResponse(){}
	
	public OfferResponse(String id, String phoneNumber, String pathLink) {
		super();
		this.idDatabase = id;
		this.phoneNumber = phoneNumber;
		this.pathLink = pathLink;
	}

	
	public OfferResponse(Offer persistedOffer,OfferRequest request) {
//		request=persistedOffer.getRequest();
		RoutingRequest routingRequest=new RoutingRequest(request.getVehicleType(), request.getRequestTime(), request.getPathRequest());
		pathLink=routingServiceUrl+routingRequest.toString();
	}

	//METHODS
		
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
}
