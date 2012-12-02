/**
 * 
 */
package co.cleanweb.italy.poolmeup.model;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Parent;

import co.cleanweb.italy.poolmeup.persistence.interfaces.ObjectPersistable;

/**
 * @author micheleorsi
 *
 */
@Entity
public abstract class AbstractObjectPersist implements ObjectPersistable {

	@Id private Long key = null;
	private Date creationDate = null;
	private Date updatedDate = null;
	

	public AbstractObjectPersist() {}

	/**
	 * @return the key
	 */
	public Long getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(Long key) {
		this.key = key;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
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
	 * 
	 */
	@PrePersist 
	void updateDate() { 
		if(this.creationDate==null) {
			this.creationDate = new Date();
			this.updatedDate = this.creationDate;
		} else {
			this.updatedDate = new Date();	
		}
	}
	
}
