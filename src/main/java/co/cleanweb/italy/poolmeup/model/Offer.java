/**
 * 
 */
package co.cleanweb.italy.poolmeup.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Id;

import com.googlecode.objectify.annotation.Subclass;

import co.cleanweb.italy.poolmeup.model.transport.OfferRequest;
import co.cleanweb.italy.poolmeup.model.transport.OfferResponse;
import co.cleanweb.italy.poolmeup.model.transport.StepRequest;
import co.cleanweb.italy.poolmeup.model.transport.Vehicle_Type;
import co.cleanweb.italy.poolmeup.persistence.interfaces.ObjectPersistable;

/**
 * @author micheleorsi
 *
 */
@Subclass
public class Offer extends AbstractObjectPersist {
		
	private Integer numberPlaces = null;
	
	//CONSTRUCTORS
	public Offer() {}
	
	public Offer(OfferRequest offerRequest) {
		this.numberPlaces=offerRequest.getNumberPlaces();
	}

	//METHODS
	/**
	 * @return the numberPlaces
	 */
	public Integer getNumberPlaces() {
		return numberPlaces;
	}
	/**
	 * @param numberPlaces the numberPlaces to set
	 */
	public void setNumberPlaces(Integer numberPlaces) {
		this.numberPlaces = numberPlaces;
	}
	
}
