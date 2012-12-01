package co.cleanweb.italy.poolmeup.model.transport;

import co.cleanweb.italy.poolmeup.model.Offer;


/**
 * @author Simone De Cristofaro
 */

public class OfferResponse {

	//ATTRIBUTES
	private String idDatabase;//tel number
	private String phoneNumber;
	private String pathLink;
	
	//CONSTRUCORS
	public OfferResponse(){}
	
	public OfferResponse(Offer persistedOffer) {}

	public OfferResponse(String id, String phoneNumber, String pathLink) {
		super();
		this.idDatabase = id;
		this.phoneNumber = phoneNumber;
		this.pathLink = pathLink;
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
