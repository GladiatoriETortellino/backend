/**
 * 
 */
package co.cleanweb.italy.poolmeup.persistence.datastore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import co.cleanweb.italy.poolmeup.model.Offer;
import co.cleanweb.italy.poolmeup.model.Trip;
import co.cleanweb.italy.poolmeup.model.User;
import co.cleanweb.italy.poolmeup.persistence.interfaces.ObjectPersistable;
import co.cleanweb.italy.poolmeup.persistence.interfaces.PersistenceManager;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.DAOBase;

/**
 * @author micheleorsi
 *
 */
public class PersistenceManagerObjectify<T extends ObjectPersistable> implements PersistenceManager<T> {
	
	private static final Logger log = Logger.getLogger(PersistenceManagerObjectify.class
			.getName());
	protected DAO localDao = null;
	
	protected final Class<T> typeParameterClass;
	
	public PersistenceManagerObjectify(Class<T> typeParameterClass) {
		this.typeParameterClass = typeParameterClass;
		localDao = new DAO();
	}
	
	@Override
	public Collection<T> read(Iterable<Long> keys) {
		return localDao.ofy().get(this.typeParameterClass,keys).values();
	}

	@Override
	public Collection<T> save(Iterable<T> objects) {		
		return localDao.ofy().put(objects).values();
	}

	@Override
	public void delete(Iterable<Long> keys) {
		Collection<Key> collectionKeys = new ArrayList<Key>();
		for (Long longKey : keys) {
			collectionKeys.add(KeyFactory.createKey(typeParameterClass.getSimpleName(), longKey));
		}
		localDao.ofy().delete(collectionKeys);
	}

	@Override
	public Collection<T> update(Iterable<T> objects) {
		return this.save(objects);
	}
}

class DAO extends DAOBase {
	static {
		ObjectifyService.register(User.class);
		ObjectifyService.register(Trip.class);
		ObjectifyService.register(Offer.class);
    }
}
