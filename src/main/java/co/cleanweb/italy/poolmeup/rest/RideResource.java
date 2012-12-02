/**
 * 
 */
package co.cleanweb.italy.poolmeup.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.cleanweb.italy.poolmeup.model.Offer;
import co.cleanweb.italy.poolmeup.model.Ride;
import co.cleanweb.italy.poolmeup.model.transport.RideRequest;
import co.cleanweb.italy.poolmeup.model.transport.RideResponse;
import co.cleanweb.italy.poolmeup.persistence.datastore.FakeDB;
import co.cleanweb.italy.poolmeup.persistence.interfaces.PersistenceManager;

/**
 * @author micheleorsi
 *
 */
@Path("/rides")
@Produces({ MediaType.APPLICATION_JSON+"; charset=utf-8" })
@Consumes({ MediaType.APPLICATION_JSON+"; charset=utf-8" })
public class RideResource {
	PersistenceManager<Ride> managerRide = null;
	
	public RideResource() {
//		managerRide = new PersistenceManagerObjectify<Ride>(Ride.class);
	}
	/**
	 * 
	 * @return
	 */
	@GET
	public Response getRides() {
		return Response.status(Response.Status.OK).entity("{\"response\":\"getRides method\"}").build();
	}
	/**
	 * 
	 * @return
	 */
	@POST
	public Response createNewRide(RideRequest rideRequested) {
		Ride persistedRide = new Ride(rideRequested);
		
		
		Collection<Offer> listOffers = FakeDB.offerDB.values();
		List<Offer> pheasibleOffer = new ArrayList<Offer>();
		for (Offer offer : listOffers) {
//			if(offer.getPhoneNumber().eq
		}
		
		
//		persistedRide.setKey(Long.valueOf(FakeDB.countRide));
//		FakeDB.rideDB.put(Long.valueOf(FakeDB.countRide), persistedRide);
//		FakeDB.countRide++;
		
		RideResponse rideResponse = new RideResponse(persistedRide, rideRequested);
		rideResponse.setUserID("12345");
		return Response.status(Response.Status.CREATED).entity(rideResponse).build();
	}
}
