package co.cleanweb.italy.poolmeup.model.transport;

import java.util.Calendar;

import co.cleanweb.italy.poolmeup.model.Step;

public class RouteStop extends Step{
	
	private Calendar inst;

	public RouteStop(Double lat,Double lon,Calendar inst) {
		super(lat,lon);
		this.inst = inst;
	}

	public Calendar getInst() {
		return inst;
	}

	public void setInst(Calendar inst) {
		this.inst = inst;
	}
	
	
	
}

