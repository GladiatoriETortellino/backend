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

	public static final String defaultVehicle=Vehicle_Type.AUTO.toString();
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

	
	public OfferResponse(Offer persistedOffer) {
		OfferRequest request=persistedOffer.getRequest();
		
		StringBuilder sb=new StringBuilder("http://hackathon.opendata.sistemaits.com/dsps/?treq=findPath&tdes=0&");
		List<StepRequest> pathRequest=request.getPathRequest();
		Iterator<StepRequest> it=pathRequest.iterator();
		StepRequest step=null;
		int counter=0;
		while(it.hasNext()){
			counter++;
			step=it.next();
			sb.append("pxcoo").append(counter).append("=").append(step.getLongitude());
			sb.append("&");
			sb.append("pycoo").append(counter).append("=").append(step.getLongitude());
			sb.append("&");
		}
		sb.append("mode=").append(defaultVehicle).append("&");
		sb.append("tdes=").append(request.isStartingTime()?"0":"1");
		sb.append("tdat=").append(sdf.format(request.getRequestTime()));
		sb.append("&");


		
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
