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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import co.cleanweb.italy.poolmeup.model.Offer;
import co.cleanweb.italy.poolmeup.model.transport.OfferRequest;
import co.cleanweb.italy.poolmeup.model.transport.OfferResponse;
import co.cleanweb.italy.poolmeup.persistence.datastore.PersistenceManagerObjectify;
import co.cleanweb.italy.poolmeup.persistence.interfaces.PersistenceManager;

/**
 * @author micheleorsi
 *
 */
@Path("/offers")
@Produces({ MediaType.APPLICATION_JSON+"; charset=utf-8" })
@Consumes({ MediaType.APPLICATION_JSON+"; charset=utf-8" })
public class OfferResource {
	/**
	 * 
	 * @return
	 */
	@GET
	public Response getOffers() {
		return Response.status(Response.Status.OK).entity("{\"response\":\"getOffers method\"}").build();
	}
	/**
	 * create a new offer
	 * 
	 * @param offerRequested
	 * @return
	 */
	@POST
	public Response createNewOffer(OfferRequest offerRequested) {
		Offer persistedOffer = new Offer(offerRequested);
		// persistiamo persistedOffer ..
		OfferResponse offerResponse = new OfferResponse(persistedOffer);
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
		Offer persistedOffer = new Offer(offerRequested);
		// aggiorniamo persistedOffer ..
		OfferResponse offerResponse = new OfferResponse(persistedOffer);
		return Response.status(Response.Status.OK).entity(offerResponse).build();
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
