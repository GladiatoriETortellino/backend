/**
 * 
 */
package co.cleanweb.italy.poolmeup.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author micheleorsi
 *
 */
@Path("/offers")
public class OfferResource {

	@GET
	public String helloServer() {
		return "welcome test";
	}
}
