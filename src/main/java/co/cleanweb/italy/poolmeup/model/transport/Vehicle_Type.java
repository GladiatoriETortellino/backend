package co.cleanweb.italy.poolmeup.model.transport;


/**
 * @author Simone De Cristofaro
 */
public enum Vehicle_Type {

	AUTO{
    	public String toString() {        
    		return "auto";
    	}
	},
	SCOOTER{
    	public String toString() {        
    		return "scooter";
    	}
	};

	public static Vehicle_Type fromString(String s) {
		if(s.equals(AUTO.toString())) return AUTO;
		else if(s.equals(SCOOTER.toString())) return SCOOTER;
		return null;
	}
	
}
