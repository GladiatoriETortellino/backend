/**
 * 
 */
package co.cleanweb.italy.poolmeup.persistence.interfaces;

import java.util.Date;

/**
 * This represents basic operation on an object persisted
 * 
 * @author micheleorsi
 *
 */
public interface ObjectPersistable {
	/**
	 * Get the key useful to retrieve the object
	 *
	 * @return key
	 */
	public Long getKey();
	/**
	 * Get the creation date
	 *
	 * @return creationDate
	 */
	public Date getCreationDate();
	/**
	 * 
	 * @param updatedDate
	 */
	public void setCreationDate(Date creationDate);
	/**
	 * 
	 * @param updatedDate
	 */
	public void setUpdatedDate(Date updatedDate);
	/**
	 * Get the last updated date
	 *
	 * @return updatedDate
	 */
	public Date getUpdatedDate();
	/**
	 * Update the object 
	 *
	 */
	public void update(ObjectPersistable obj);
	/**
	 * Validate the object
	 * 
	 */
	public void validate();
}
