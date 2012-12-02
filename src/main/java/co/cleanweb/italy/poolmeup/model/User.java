/**
 * 
 */
package co.cleanweb.italy.poolmeup.model;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Parent;
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
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Trip getTrip(){
		
		Trip tripOfUser = null;
		//TODO: query read from db
		return tripOfUser;
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User) {
			User passedUser = (User) obj;
			return passedUser.getPhoneNumber().equals(this.phoneNumber);
		}
		else return false;
	}
}
