/**
 * 
 */
package co.cleanweb.italy.poolmeup.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author micheleorsi
 *
 */
@Path("/paths")
@Produces({ MediaType.APPLICATION_JSON+"; charset=utf-8" })
@Consumes({ MediaType.APPLICATION_JSON+"; charset=utf-8" })
public class PathResource {
	/**
	 * 
	 * @return
	 */
	@GET
	@Path("/{offerId}")
	public Response getSpecificPath() {
		return Response.status(Response.Status.OK).entity("{\"response\":\"getOffers method\"}").build();
	}
}
