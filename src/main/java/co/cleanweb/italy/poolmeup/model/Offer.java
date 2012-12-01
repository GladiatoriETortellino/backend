/**
 * 
 */
package co.cleanweb.italy.poolmeup.model;

import java.util.Date;

import co.cleanweb.italy.poolmeup.persistence.interfaces.ObjectPersistable;

/**
 * @author micheleorsi
 *
 */
public class Offer{
	protected String name = null;
	protected Long key = null;
	protected Date date = null;
	
	public Offer() {}
	
	public Offer(String name) {
		this.name = name;
	}

	
}
