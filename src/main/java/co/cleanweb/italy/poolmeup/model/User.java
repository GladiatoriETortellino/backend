/**
 * 
 */
package co.cleanweb.italy.poolmeup.model;

/**
 * @author micheleorsi
 *
 */
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
		//TODO: insert query to the db
		return tripOfUser;
		
	}
}
