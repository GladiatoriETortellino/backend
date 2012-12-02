/**
 * 
 */
package co.cleanweb.italy.poolmeup.rest;

import java.util.ArrayList;
import java.util.Collection;
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
import co.cleanweb.italy.poolmeup.model.transport.RideRequest;
import co.cleanweb.italy.poolmeup.model.transport.RoutingRequest;
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
		return Response.status(Response.Status.OK).entity(FakeDB.offerDB).build();
	}
	/**
	 * 
	 * @return
	 */
	@GET
	@Path("/{offerId}")
	public Response getSpecificPath(@PathParam("offerId") Long offerId) {
		Offer dbOffer = FakeDB.offerDB.get(offerId);
		OfferResponse returnOffer = new OfferResponse();
		returnOffer.setIdDatabase(dbOffer.getKey());
		returnOffer.setPhoneNumber(dbOffer.getPhoneNumber());
		if(dbOffer.getPathRequest().size()==2) {
			returnOffer.setPathLink(null);
		} else {
			RoutingRequest routingRequest=new RoutingRequest(dbOffer.getVehicleType(), dbOffer.getRequestTime(), dbOffer.getPathRequest());
			String pathLink=routingRequest.toString();
			returnOffer.setPathLink(pathLink);
		}
		FakeDB.offerDB.remove(offerId);
		return Response.status(Response.Status.OK).entity(returnOffer).build();
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
		OfferResponse offerResponse = new OfferResponse(persistedOffer.getKey(),offerRequested);
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
	@Path("/{userPhoneNumber}/join")
	public Response joinOffer(@PathParam("userPhoneNumber") String userPhoneNumber, RideRequest rideRequested) {
		Collection<Offer> listAvailable = FakeDB.offerDB.values();
		Offer selectedOffer = null;
		for (Offer offer : listAvailable) {
			if(offer.getPhoneNumber().equals(userPhoneNumber)) {
				selectedOffer = offer;
				List<Step> listSteps = offer.getPathRequest();
				List<Step> listRequestedSteps = rideRequested.getODSteps();
				List<Step> newList = new ArrayList<Step>();
				newList.add(listSteps.get(0));
				newList.add(listRequestedSteps.get(0));
				newList.add(listRequestedSteps.get(1));
				newList.add(listSteps.get(listSteps.size()-1));
				
//				FakeDB.offerDB.remove(selectedOffer.getKey());
				offer.setPathRequest(newList);
			}
		}
		return Response.status(Response.Status.OK).entity("{\"response\":\"request pushed\"}").build();
	}



}
