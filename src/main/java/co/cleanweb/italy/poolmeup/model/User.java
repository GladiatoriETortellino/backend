/**
 * 
 */
package co.cleanweb.italy.poolmeup.model;

import com.googlecode.objectify.annotation.Subclass;

/**
 * @author micheleorsi
 *
 */
@Subclass
public class User extends AbstractObjectPersist {
	
	private String phoneNumber = null;
	private String userName = null;
	
	public User(String phoneNumber, String userName) {
		this.phoneNumber = phoneNumber;
		this.userName = userName;
	}
	
	public User() {
		
	}
}
