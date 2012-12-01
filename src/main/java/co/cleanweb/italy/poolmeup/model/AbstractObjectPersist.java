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
public abstract class AbstractObjectPersist implements ObjectPersistable {

	private Long key = null;
	private Date creationDate = null;
	private Date updatedDate = null;
	
	public AbstractObjectPersist() {}
	
}
