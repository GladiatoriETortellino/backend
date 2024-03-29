/**
 * 
 */
package co.cleanweb.italy.poolmeup.rest.config;


import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * <p>JacksonConfigurator class.</p>
 *
 * @author micheleorsi
 * @version $Id: $
 */
@Provider
public class JacksonConfigurator implements ContextResolver<ObjectMapper> {
	private static final Logger log = Logger
	.getLogger(JacksonConfigurator.class.getName());
    private static ObjectMapper mapper = null;
    public final static String dateFormat = "dd/MM/yyyy HH:mm";
    
    /**
     * <p>Constructor for JacksonConfigurator.</p>
     */
    public JacksonConfigurator() {
    	log.info("starting jackson context ..");
    	log.fine("initialize mapper");
    	mapper = new ObjectMapper();
    	SerializationConfig serConfig = mapper.getSerializationConfig();
        serConfig.setDateFormat(new SimpleDateFormat(dateFormat));
        serConfig.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        DeserializationConfig deserializationConfig = mapper.getDeserializationConfig();
        deserializationConfig.setDateFormat(new SimpleDateFormat(dateFormat));
//        mapper.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES,false);
        mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        mapper.configure(SerializationConfig.Feature.USE_ANNOTATIONS, false);
//        mapper.configure(DeserializationConfig.Feature.USE_ANNOTATIONS, false);
    }

    /** {@inheritDoc} */
    public ObjectMapper getContext(Class<?> arg0) {
    	
    	log.fine("class requested: "+arg0.getSimpleName());
        return mapper;
    }

}
