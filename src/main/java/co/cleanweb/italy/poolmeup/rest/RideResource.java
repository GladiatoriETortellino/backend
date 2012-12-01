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

/**
 * @author micheleorsi
 *
 */
@Path("/rides")
@Produces({ MediaType.APPLICATION_JSON+"; charset=utf-8" })
@Consumes({ MediaType.APPLICATION_JSON+"; charset=utf-8" })
public class RideResource {
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
	public Response createNewRide() {
		return Response.status(Response.Status.CREATED).entity("{\"response\":\"createNewRide method\"}").build();
	}
}
