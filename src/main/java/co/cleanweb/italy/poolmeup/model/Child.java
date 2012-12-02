/**
 * 
 */
package co.cleanweb.italy.poolmeup.model;


import com.googlecode.objectify.*;
import com.googlecode.objectify.annotation.*;


/**
 * @author micheleorsi
 *
 */
public class Child extends AbstractObjectPersist {

    @Parent 
    Key<ParentClass> owner;
    String color = null;
    
    public Child(ParentClass owner, String color) {
    	this.color = color;
    }

	/**
	 * @return the owner
	 */
	public Key<ParentClass> getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Key<ParentClass> owner) {
		this.owner = owner;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

}
