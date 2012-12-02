/**
 * 
 */
package co.cleanweb.italy.poolmeup.rest;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyFactory;

import co.cleanweb.italy.poolmeup.model.Offer;
import co.cleanweb.italy.poolmeup.model.Step;
import co.cleanweb.italy.poolmeup.model.transport.OfferRequest;
import co.cleanweb.italy.poolmeup.model.transport.OfferResponse;
import co.cleanweb.italy.poolmeup.persistence.datastore.FakeDB;
import co.cleanweb.italy.poolmeup.persistence.interfaces.PersistenceManager;

/**
 * @author micheleorsi
 *
 */
@Path("/offers")
@Produces({ MediaType.APPLICATION_JSON+"; charset=utf-8" })
@Consumes({ MediaType.APPLICATION_JSON+"; charset=utf-8" })
public class OfferResource {
	PersistenceManager<Offer> managerOffer = null;
	PersistenceManager<Step> managerStep = null;
	private static final Logger log = Logger.getLogger(OfferResource.class
			.getName());

	public OfferResource() {
//		managerOffer = new PersistenceManagerObjectify<Offer>(Offer.class);
//		managerStep=new PersistenceManagerObjectify<Step>(Step.class);
	}
	/**
	 * 
	 * @return
	 */
	@GET
	public Response getOffers() {
		return Response.status(Response.Status.OK).entity("{\"response\":\"getOffers method\"}").build();
	}
	/**
	 * 
	 * @return
	 */
	@GET
	@Path("/{offerId}")
	public Response getSpecificPath(@PathParam("offerId") Long offerId) {
		return Response.status(Response.Status.OK).entity(FakeDB.offerDB.get(offerId)).build();
	}
	@POST
	@Path("/steps")
	public Response testStep(Step step) {
		log.info(step.getLat()+" "+step.getLng()+" "+step.getName());
		return Response.status(Response.Status.CREATED).entity("{\"response\":\"testStep method\"}").build();
	}
	/**
	 * create a new offer
	 * 
	 * @param offerRequested
	 * @return
	 */
	@POST
	public Response createNewOffer(OfferRequest offerRequested) {
		// persist the offer on DB
		Offer persistedOffer = new Offer(offerRequested);
		
		for (Step localStep : offerRequested.getPathRequest() ) {
			log.info(localStep.getLat()+" "+localStep.getLng());
			
		}
		// ottengo la lista di path richiesti dall'utente
		List<Step> list_step=offerRequested.getPathRequest();
//		for (Step step : list_step) {
//			step.setOffer(persistedOffer);
//		}
		// persisto l'offerta
		
		persistedOffer.setKey(Long.valueOf(FakeDB.countOffer));
		FakeDB.offerDB.put(Long.valueOf(FakeDB.countOffer), persistedOffer);
		FakeDB.countOffer++;
		
//		//Create the response
		OfferResponse offerResponse = new OfferResponse(persistedOffer.getKey().toString(),offerRequested);
		return Response.status(Response.Status.CREATED).entity(offerResponse).build(); 
	}
	/**
	 * 
	 * @param offerRequest
	 * @return
	 */
	@POST
	@Path("/{offerId}")
	public Response updateOffer(OfferRequest offerRequested) {
//		Offer persistedOffer = new Offer(offerRequested);
		
//		managerOffer.update(Collections.singleton(persistedOffer));
//		OfferResponse offerResponse = new OfferResponse(offerRequested);
		return Response.status(Response.Status.OK).entity(null).build();
	}
	/**
	 * 
	 * @return
	 */
	@POST
	@Path("/{offerId}/join")
	public Response joinOffer() {
		// cristallizzo richiesta
		// faccio push notification al guidatore
		return Response.status(Response.Status.OK).entity("{\"response\":\"request pushed\"}").build();
	}



}
