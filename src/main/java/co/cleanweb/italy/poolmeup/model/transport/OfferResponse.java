package co.cleanweb.italy.poolmeup.model.transport;

public class OfferResponse {

	//ATTRIBUTES
	private int id;//tel number
	private String username;
	private String pathLink;
	
	//CONSTRUCORS
	public OfferResponse(){}

	public OfferResponse(int id, String username, String pathLink) {
		super();
		this.id = id;
		this.username = username;
		this.pathLink = pathLink;
	}


	//METHODS
		
	//GETTERS
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPathLink() {
		return pathLink;
	}

	
}
