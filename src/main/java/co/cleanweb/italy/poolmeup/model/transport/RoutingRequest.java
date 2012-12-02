/**
 * Request.java
 */
package co.cleanweb.italy.poolmeup.model.transport;

import java.net.HttpURLConnection;
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

import co.cleanweb.italy.poolmeup.model.Step;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author Simone De Cristofaro
 * @created 20/ott/2012
 */
public class RoutingRequest {
	
	private static final String routingServiceUrl="http://hackathon.opendata.sistemaits.com/dsps/?"; 
	private static final SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private Vehicle_Type vehicle_Type;
	private Calendar tdat;
	private List<Step> stops_findPath;

	
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
		
		 
		stops_findPath=steps;
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
				
		String date="" + tdat.get(Calendar.YEAR) + "-" + (tdat.get(Calendar.MONTH)+1) + "-" + tdat.get(Calendar.DAY_OF_MONTH) + "+" +
				  (tdat.get(Calendar.HOUR_OF_DAY)<10?0+""+tdat.get(Calendar.HOUR_OF_DAY):tdat.get(Calendar.HOUR_OF_DAY)) + "%3A" + 
				  (tdat.get(Calendar.MINUTE)<10?0+""+tdat.get(Calendar.MINUTE):tdat.get(Calendar.MINUTE)) + "%3A00";

		
		StringBuilder sb=new StringBuilder(routingServiceUrl+"treq=findPath&mode="+vehicle_Type.toString()+"&tdat="+date+"&lang=ENG&");
		Step[] stops=getStopsOfFindPathRequest();
		for(int i=0;i<stops.length;i++)
			sb.append("pxco"+(i+1)+"="+stops[i].getLatitude()+"&pyco"+(i+1)+"="+stops[i].getLongitude()+"&");
		sb.delete(sb.length()-1, sb.length());
			
		return sb.toString();
	}



	public Vehicle_Type getVehicle_Type() {
		return vehicle_Type;
	}



	public void setVehicle_Type(Vehicle_Type vehicle_Type) {
		this.vehicle_Type = vehicle_Type;
	};

	public String sendPathRequest(Vehicle_Type vehicle_Type,Date tdat,List<Step> steps){
		
		RoutingRequest rr = new RoutingRequest(vehicle_Type,tdat,steps);
		String httpReq = rr.toString();
		return null; //TODO: send http!
		
	}

	
}
