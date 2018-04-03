package alarmloadsearchVo;

public class AlarmVo {
	private String startDeparture;
	private String endDeparture;
	private String promiseDay;
	private String promiseTime;
	private String startTime;
	private String way;
	private int no;
	public String getStartDeparture() {
		return startDeparture;
	}
	public void setStartDeparture(String startDeparture) {
		this.startDeparture = startDeparture;
	}
	public String getEndDeparture() {
		return endDeparture;
	}
	public void setEndDeparture(String endDeparture) {
		this.endDeparture = endDeparture;
	}
	public String getPromiseDay() {
		return promiseDay;
	}
	public void setPromiseDay(String promiseDay) {
		this.promiseDay = promiseDay;
	}
	public String getPromiseTime() {
		return promiseTime;
	}
	public void setPromiseTime(String promiseTime) {
		this.promiseTime = promiseTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "AlarmVo [startDeparture=" + startDeparture + ", endDeparture=" + endDeparture + ", promiseDay="
				+ promiseDay + ", promiseTime=" + promiseTime + ", startTime=" + startTime + ", way=" + way + ", no="
				+ no + "]";
	}
	
	
}
