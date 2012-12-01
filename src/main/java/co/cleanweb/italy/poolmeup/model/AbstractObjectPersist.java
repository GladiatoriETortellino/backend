/**
 * 
 */
package co.cleanweb.italy.poolmeup.model;

import java.util.Date;

import javax.persistence.Id;

import co.cleanweb.italy.poolmeup.persistence.interfaces.ObjectPersistable;

/**
 * @author micheleorsi
 *
 */
public abstract class AbstractObjectPersist implements ObjectPersistable {

	@Id 
	private Long key = null;
	private Date creationDate = null;
	private Date updatedDate = null;
	
	public AbstractObjectPersist() {}

	/* (non-Javadoc)
	 * @see co.cleanweb.italy.poolmeup.persistence.interfaces.ObjectPersistable#getKey()
	 */
	@Override
	public Long getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see co.cleanweb.italy.poolmeup.persistence.interfaces.ObjectPersistable#getCreationDate()
	 */
	@Override
	public Date getCreationDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see co.cleanweb.italy.poolmeup.persistence.interfaces.ObjectPersistable#setCreationDate(java.util.Date)
	 */
	@Override
	public void setCreationDate(Date creationDate) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see co.cleanweb.italy.poolmeup.persistence.interfaces.ObjectPersistable#setUpdatedDate(java.util.Date)
	 */
	@Override
	public void setUpdatedDate(Date updatedDate) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see co.cleanweb.italy.poolmeup.persistence.interfaces.ObjectPersistable#getUpdatedDate()
	 */
	@Override
	public Date getUpdatedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see co.cleanweb.italy.poolmeup.persistence.interfaces.ObjectPersistable#update(co.cleanweb.italy.poolmeup.persistence.interfaces.ObjectPersistable)
	 */
	@Override
	public void update(ObjectPersistable obj) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see co.cleanweb.italy.poolmeup.persistence.interfaces.ObjectPersistable#validate()
	 */
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(Long key) {
		this.key = key;
	}
	
}
