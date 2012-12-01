/**
 * 
 */
package co.cleanweb.italy.poolmeup.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.cleanweb.italy.poolmeup.model.Offer;
import co.cleanweb.italy.poolmeup.model.transport.OfferRequest;
import co.cleanweb.italy.poolmeup.persistence.datastore.PersistenceManagerObjectify;
import co.cleanweb.italy.poolmeup.persistence.interfaces.PersistenceManager;

/**
 * @author micheleorsi
 *
 */
@Path("/offers")
@Produces({ MediaType.APPLICATION_JSON+"; charset=utf-8" })
public class OfferResource {

	@GET
	public String helloServer() {
		return "welcome test";
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON+"; charset=utf-8" })
	public String helloServer(OfferRequest offerRequested) {
//		PersistenceManager<Offer> manager = new PersistenceManagerObjectify<Offer>(Offer.class);
//		manager.save(Collections.singletonList(new offer(offerRequested)));
		return offerRequested.toString();
	}
}
