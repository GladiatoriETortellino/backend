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
	
	public static final String defaultVehicle=Vehicle_Type.AUTO.toString();
	private static final SimpleDateFormat sdf= new SimpleDateFormat("yyyymmdd HH:mm:ss");

	//ATTRIBUTES
	private OfferRequest request;
	private OfferResponse response;
//	protected String name = null;
//	protected Long key = null;
//	protected Date date = null;
	
	//CONSTRUCTORS
	public Offer() {}
	
	public Offer(OfferRequest offerRequest) {
		this.request=offerRequest;
		StringBuilder sb=new StringBuilder("http://hackathon.opendata.sistemaits.com/dsps/?treq=findPath&tdes=0&");
		List<StepRequest> pathRequest=this.request.getPathRequest();
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
		sb.append("tdat=").append( request.getRequestTime());

	}

	//METHODS
	
	
	
}
