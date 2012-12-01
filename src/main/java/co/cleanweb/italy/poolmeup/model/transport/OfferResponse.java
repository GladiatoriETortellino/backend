package co.cleanweb.italy.poolmeup.model.transport;

/**
 * @author Simone De Cristofaro
 */
public class OfferResponse {

	//ATTRIBUTES
	private String id;//tel number
	private String username;
	private String pathLink;
	
	//CONSTRUCORS
	public OfferResponse(){}

	public OfferResponse(String id, String username, String pathLink) {
		super();
		this.id = id;
		this.username = username;
		this.pathLink = pathLink;
	}


	//METHODS
		
	//GETTERS
	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPathLink() {
		return pathLink;
	}

	
}
