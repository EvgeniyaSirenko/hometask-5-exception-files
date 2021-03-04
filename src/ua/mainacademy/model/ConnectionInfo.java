package ua.mainacademy.model;

public class ConnectionInfo {
	private  Integer id;
	private  Long time;
	private  String connectionIp;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Long getTime() {
		return time;
	}
	
	public void setTime(Long time) {
		this.time = time;
	}
	
	public String getConnectionIp() {
		return connectionIp;
	}
	
	public void setConnectionIp(String connectionIp) {
		this.connectionIp = connectionIp;
	}
	
	public ConnectionInfo() {
	}
	
	public ConnectionInfo(Integer id, Long time, String connectionIp) {
		this.id = id;
		this.time = time;
		this.connectionIp = connectionIp;
	}
	
	@Override
	public String toString() {
		return id + " " + time + " " + connectionIp;
	}
}
