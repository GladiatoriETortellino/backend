/**
 * 
 */
package co.cleanweb.italy.poolmeup.model;

/**
 * @author micheleorsi
 *
 */
public class User {
	
	private String phoneNumber = null;
	private String userName = null;
	

	public User(String phoneNumber, String userName) {
		this.phoneNumber = phoneNumber;
		this.userName = userName;
	}
	
	public User() {
		
	}
}
