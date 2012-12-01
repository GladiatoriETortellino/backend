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
//		PersistenceManager<Offer> manager = new PersistenceManagerObjectify<Offer>(Offer.class);
//		manager.save(Collections.singletonList(offerRequested));
//		return offerRequested.toString();
		return Response.status(Response.Status.CREATED).entity("{\"response\":\"createNewOffer method\"}").build();
	}
	/**
	 * 
	 * @param offerRequest
	 * @return
	 */
	@POST
	@Path("/{offerId}")
	public Response updateOffer(OfferRequest offerRequest) {
		return Response.status(Response.Status.OK).entity("{\"response\":\"updateOffer method\"}").build();
	}
	/**
	 * 
	 * @return
	 */
	@POST
	@Path("/{offerId}/join")
	public Response joinOffer() {
		return Response.status(Response.Status.OK).entity("{\"response\":\"joinOffer method\"}").build();
	}
}
