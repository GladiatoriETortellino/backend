/**
 * 
 */
package co.cleanweb.italy.poolmeup.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import co.cleanweb.italy.poolmeup.model.transport.OfferRequest;
import co.cleanweb.italy.poolmeup.model.transport.OfferResponse;
import co.cleanweb.italy.poolmeup.model.transport.StepRequest;
import co.cleanweb.italy.poolmeup.model.transport.Vehicle_Type;
import co.cleanweb.italy.poolmeup.persistence.interfaces.ObjectPersistable;

/**
 * @author micheleorsi
 *
 */
public class Offer extends AbstractObjectPersist {
	
	private Integer numberPlaces = 0;
	
	//CONSTRUCTORS
	public Offer() {}
	
	public Offer(OfferRequest offerRequest) {
		this.numberPlaces=offerRequest.getNumberPlaces();
	}
	
	//METHODS
	public OfferRequest getRequest() {
		return null;
	}

	/**
	 * @return the numberPlaces
	 */
	public Integer getNumberPlaces() {
		return numberPlaces;
	}
	
	

	
	
}
