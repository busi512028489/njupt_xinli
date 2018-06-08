package Model;

import java.sql.Date;
import java.sql.Timestamp;

public class Order1Model {
	String xh;
	String state;
	String reason;
	String require1;
	String emergency;
	String timelist;
	String extra;
	String arrange;
	Timestamp zcdate;
	Timestamp riqi;
	String week1;
	String time1;
	String room;
	Date insertdate;
	String tea;
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRequire1() {
		return require1;
	}
	public void setRequire1(String require1) {
		this.require1 = require1;
	}
	public String getEmergency() {
		return emergency;
	}
	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}
	public String getTimelist() {
		return timelist;
	}
	public void setTimelist(String timelist) {
		this.timelist = timelist;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public String getArrange() {
		return arrange;
	}
	public void setArrange(String arrange) {
		this.arrange = arrange;
	}
	public Timestamp getZcdate() {
		return zcdate;
	}
	public void setZcdate(Timestamp zcdate) {
		this.zcdate = zcdate;
	}
	public Timestamp getRiqi() {
		return riqi;
	}
	public void setRiqi(Timestamp riqi) {
		this.riqi = riqi;
	}
	public String getWeek1() {
		return week1;
	}
	public void setWeek1(String week1) {
		this.week1 = week1;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public Date getInsertdate() {
		return insertdate;
	}
	public void setInsertdate(Date insertdate) {
		this.insertdate = insertdate;
	}
	public String getTea() {
		return tea;
	}
	public void setTea(String tea) {
		this.tea = tea;
	}
	public Order1Model(){}
	public Order1Model(String xh,String state,String reason,String require1,
			String emergency,String timelist,String extra,String arrange,Timestamp zcdate,
			Timestamp riqi,String week1,String time1,String room,Date insertdate,String tea) {
		this.xh = xh;
		this.time1 = time1;
		this.state = state;
		this.reason = reason;
		this.require1 = require1;
		this.emergency = emergency;
		this.timelist = timelist;
		this.extra = extra;
		this.arrange = arrange;
		this.zcdate = zcdate;
		this.riqi = riqi;
		this.week1 = week1;
		this.room = room;
		this.insertdate = insertdate;
		this.tea = tea;
	}
	
	
	
}
