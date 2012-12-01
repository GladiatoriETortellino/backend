/**
 * 
 */
package co.cleanweb.italy.poolmeup.persistence.interfaces;

import java.util.Collection;

/**
 * The manager for persisting objects
 * 
 * @author micheleorsi
 *
 */
public interface PersistenceManager<T extends ObjectPersistable> {
	/**
	 * Read a list of keys and return a list of objects
	 * 
	 * @param keys
	 * @return
	 */
	public Collection<T> read(Iterable<Long> keys);
	/**
	 * Save a list of objects 
	 *
	 * @param objects
	 * @return
	 */
	public Collection<T> save(Iterable<T> objects);
	/**
	 * Update a list of objects 
	 *
	 * @param objects
	 * @return
	 */
	public Collection<T> update(Iterable<T> objects);
	/**
	 * Delete a list of keys
	 * 
	 * @param keys
	 */
	public void delete(Iterable<Long> keys);
}
