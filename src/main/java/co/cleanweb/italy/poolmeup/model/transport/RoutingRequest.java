/**
 * Request.java
 */
package co.cleanweb.italy.poolmeup.model.transport;

import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import co.cleanweb.italy.poolmeup.model.Step;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author Simone De Cristofaro
 * @created 20/ott/2012
 */
public class RoutingRequest {
	
	private static final String routingServiceUrl="http://hackathon.opendata.sistemaits.com/dsps/"; 
	private static final SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private Vehicle_Type vehicle_Type;
	private Calendar tdat;
	private List<Step> stops_findPath;
	private String endpoint;
	private String parameters;
	private String response;//the response xml
	
	//Main informations
	private RouteStop[] routeStops;
	private Calendar inst[];
	private Double CO2[];
	
	
	//CONSTRUCTORS
	/**
	 * 
	 * @param rType
	 * @param mode
	 * @param process
	 */
	 public RoutingRequest(Vehicle_Type vehicle_Type,Date tdat,List<Step> steps) {
		super();
		this.vehicle_Type=vehicle_Type;
		if(tdat==null) {
			this.tdat=GregorianCalendar.getInstance();
		}else {
			this.tdat=Calendar.getInstance();
			this.tdat.setTime(tdat);
		}
		
		String date="" + this.tdat.get(Calendar.YEAR) + "-" + (this.tdat.get(Calendar.MONTH)+1) + "-" + this.tdat.get(Calendar.DAY_OF_MONTH) + "+" +
				  (this.tdat.get(Calendar.HOUR_OF_DAY)<10?0+""+this.tdat.get(Calendar.HOUR_OF_DAY):this.tdat.get(Calendar.HOUR_OF_DAY)) + "%3A" + 
				  (this.tdat.get(Calendar.MINUTE)<10?0+""+this.tdat.get(Calendar.MINUTE):this.tdat.get(Calendar.MINUTE)) + "%3A00";

		
		StringBuilder sb=new StringBuilder("treq=findPath&mode="+vehicle_Type.toString()+"&tdat="+date+"&lang=ENG&");
		stops_findPath=steps;
		Step[] stops=getStopsOfFindPathRequest();
		for(int i=0;i<stops.length;i++)
			sb.append("pxco"+(i+1)+"="+stops[i].getLatitude()+"&pyco"+(i+1)+"="+stops[i].getLongitude()+"&");
		sb.delete(sb.length()-1, sb.length());
			
		parameters= sb.toString();
		endpoint=routingServiceUrl;
		response=null;
	}
	
		
	//METHODS
	
	/**
	 * Add a <b>stop</b> to a <i>findPath</i> request
	 * @param s The <b>stop</b> to add to the <i>findPath</i> request
	 * @return <code>true</code> if the operation succeded
	 */
	public boolean addStopToFindPathRequest(Step s) {
		stops_findPath.add(s);
		return true;
	}
		
	public Step[] getStopsOfFindPathRequest() {
		Step[] toReturn= new Step[stops_findPath.size()];
		stops_findPath.toArray(toReturn);
		return toReturn;
	}
	
	public void clearStopOfFindPath() {
		stops_findPath.clear();
	}
	
	/**
	 * Set the specified stop at the specified index (starting from 0).
	 * If the operation has success return <code>true</code>, <code>false</code> otherwise
	 * @param stopIndex 
	 * @param s
	 */
	public boolean setStopOfFindPath(int stopIndex, Step s) {
		if(stopIndex<0 || stopIndex>=stops_findPath.size()) return false;
		stops_findPath.set(stopIndex, s);
		return true;
	}
	

	@Override
	public String toString() {
		return endpoint+parameters;
	}



	public Vehicle_Type getVehicle_Type() {
		return vehicle_Type;
	}



	public void setVehicle_Type(Vehicle_Type vehicle_Type) {
		this.vehicle_Type = vehicle_Type;
	};


	
	
	public Calendar getTdat() {
		return tdat;
	}


	public List<Step> getStops_findPath() {
		return stops_findPath;
	}


	public String getEndpoint() {
		return endpoint;
	}


	public String getParameters() {
		return parameters;
	}


	public String getResponse() {
		return response;
	}


	public RouteStop[] getRouteStops() {
		return routeStops;
	}


	public Calendar[] getInst() {
		return inst;
	}
	public Calendar getArrivalTime() {
		return inst[inst.length-1];
	}
	public Double getCO2Consuption() {
		return CO2[CO2.length-1];
	}

	public Double[] getCO2() {
		return CO2;
	}


	/**
	 * Send the get request to the server and return the response as a string
	 * @return
	 */
	public String sendRequest() {
		try {
			return HTTPRequest.sendGetRequestGetString(endpoint, parameters);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	/**
	 * Send the get request to the server and store the response
	 * @return False if the request return an errorm or is empty (withot path)
	 */
	public boolean incapsulateResponse() {
		response=sendRequest();
		//parse the xml response
		DocumentBuilder db;
		Document doc = null;
	    InputSource is = new InputSource();

		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		    is.setCharacterStream(new StringReader(response));
			doc = db.parse(is);

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		Element resp = (Element) doc.getElementsByTagName("response").item(0);
		
		
		if(resp.getAttribute("stat").equals("error")) {
//			errorMessage = ((Element) resp.getFirstChild()).getAttribute("errm");
//			errorType = ((Element) resp.getFirstChild()).getAttribute("errt");
//			responseStatus=" -  ERROR: " + errorMessage;
			return false;
		}else {
			
			//get a nodelist of elements
			routeStops=new RouteStop[stops_findPath.size()];
			Element origin=(Element) resp.getElementsByTagName("orig").item(0);
			Calendar tmp_cal=Calendar.getInstance();
			try {
				tmp_cal.setTime(sdf.parse( origin.getAttribute("inst").replace('T', ' ')));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			routeStops[0]=new RouteStop(Double.parseDouble( origin.getAttribute("xcoo")),
					Double.parseDouble( origin.getAttribute("ycoo")),tmp_cal);
			
			List<Calendar> list_inst=new ArrayList<Calendar>(100);
			List<Double> list_CO2=new ArrayList<Double>(100);
			NodeList nl_path = resp.getElementsByTagName("path");
			int nStop=0;
			if(nl_path != null && nl_path.getLength() > 0) {
				nStop++;
				for(int i = 0 ; i < nl_path.getLength();i++) {

					NodeList nl_link = nl_path.item(i).getChildNodes();
					for(int j = 0 ; j < nl_link.getLength();j++) {
						
						//get the employee element
						Element el = (Element)nl_link.item(j);
						if(el.getNodeName().equals("link")) {
							try {
								//System.out.println( sdf.format(tmp_cal.getTime()));
								tmp_cal=Calendar.getInstance();
								tmp_cal.setTime(sdf.parse( el.getAttribute("inst").replace('T', ' ')));
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								return false;
							}
							list_inst.add(tmp_cal);
							list_CO2.add(Double.parseDouble(el.getAttribute("CO2")));
						}else {
							try {
								tmp_cal=Calendar.getInstance();
								tmp_cal.setTime(sdf.parse( el.getAttribute("inst").replace('T', ' ')));
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							routeStops[nStop]=new RouteStop(Double.parseDouble( origin.getAttribute("xcoo")),
									Double.parseDouble( el.getAttribute("ycoo")),tmp_cal);
						}
						
					}

				}
				inst=new Calendar[list_inst.size()];
				list_inst.toArray(inst);
				CO2=new Double[list_CO2.size()];
				list_CO2.toArray(CO2);
				
			}
			else return false;
			
		}
		return false;

	}
	
}

