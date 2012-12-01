/**
 * 
 */
package co.cleanweb.italy.poolmeup.rest.config;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import co.cleanweb.italy.poolmeup.model.User;

/**
 * <p>JAXBContextResolver class.</p>
 *
 * @author micheleorsi
 * @version $Id: $
 */
public class JAXBContextResolver {
	private static final Logger log = Logger
			.getLogger(JAXBContextResolver.class.getName());

	private static JAXBContext context = null;
	private final Class<?>[] classTypes = new Class[] { User.class };

	/**
	 * <p>Constructor for JAXBContextResolver.</p>
	 */
	public JAXBContextResolver() {
		log.info("JAXB context constructor..");
	}

	/**
	 * <p>Getter for the field <code>context</code>.</p>
	 *
	 * @param objectType a {@link java.lang.Class} object.
	 * @return a {@link javax.xml.bind.JAXBContext} object.
	 */
	public JAXBContext getContext(Class<?> objectType) {
		log.fine("class requested: "+objectType.getName());
		if(context==null) {
			log.fine("JAXB context starting");
			Map<String, Object> properties = new HashMap<String, Object>();			
			try {
				context = JAXBContext.newInstance(classTypes, properties);
			} catch (JAXBException e) {
				log.severe("error in starting JAXBContext");
			}
			log.fine("JAXB context started");
		}
		return context;
	}
}
