/**
 * 
 */
package co.cleanweb.italy.poolmeup.model;


import java.util.List;

import javax.persistence.Id;

import com.googlecode.objectify.annotation.Subclass;

/**
 * @author micheleorsi
 *
 */
@Subclass
public class ParentClass extends AbstractObjectPersist {

	String name;
	List<Child> listChild = null;
    
    public ParentClass(String name) {
    	super();
    	this.name = name;
    }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the listChild
	 */
	public List<Child> getListChild() {
		return listChild;
	}

	/**
	 * @param listChild the listChild to set
	 */
	public void setListChild(List<Child> listChild) {
		this.listChild = listChild;
	}

}
