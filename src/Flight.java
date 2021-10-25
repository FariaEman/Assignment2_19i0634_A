
public class Flight {
	private int Ref_Code;
	private int Seats;
	private int Passengers;
	private String Origin;
	private String Destination;
	private String Dep_Date;
	private String Dep_Time;
	private String Des_Date;
	private String Des_Time;
	private String Type;
	private int Fare;
	
	Flight(){
		this.Ref_Code = 0;
		this.Seats = 0;
		this.Passengers = 0;
		this.Origin = null;
		this.Destination = null;
		this.Dep_Date = null;
		this.Dep_Time = null;
		this.Des_Date = null;
		this.Des_Time = null;
		this.Type = null;
		this.Fare = 0;
	}
	
	Flight(int Ref_Code , int Seats , int Passengers , String Origin , String Destination , String Dep_Date , String Dep_Time , String Des_Date , String Des_Time , String Type , int Fare){
		this.Ref_Code = Ref_Code;
		this.Seats = Seats;
		this.Passengers = Passengers;
		this.Origin = Origin;
		this.Destination = Destination;
		this.Dep_Date = Dep_Date;
		this.Dep_Time = Dep_Time;
		this.Des_Date = Des_Date;
		this.Des_Time = Des_Time;
		this.Type = Type;
		this.Fare = Fare;
	}
	
	//Setters
	
	public Flight(int code, String from, String dest, String deptim, String depdate, String arrtim, String arrdate,
			int f_i, String type2, int s_i) {
		// TODO Auto-generated constructor stub
	}

	public void setRef_Code(int Ref_Code) {
		this.Ref_Code = Ref_Code;
	}
	
	public void setSeats(int Seats) {
		this.Seats = Seats;
	}
	
	public void setPassengers(int Passengers) {
		this.Passengers = Passengers;
	}
	
	public void setOrigin(String Origin) {
		this.Origin = Origin;
	}
	
	public void setDestination(String Destination) {
		this.Destination = Destination;
	}
	
	public void setDep_Date(String Dep_Date) {
		this.Dep_Date = Dep_Date;
	}
	
	public void setDep_Time(String Dep_Time) {
		this.Dep_Time = Dep_Time;
	}
	
	public void setDes_Date(String Des_Date) {
		this.Des_Date = Des_Date;
	}
	
	public void setDes_Timee(String Des_Time) {
		this.Des_Time = Des_Time;
	}
	
	public void setType(String Type) {
		this.Type = Type;
	}
	
	public void setFare(int Fare) {
		this.Fare = Fare;
	}
	//Getters
	public int getRef_Code() {
		return this.Ref_Code;
	}
	
	public int getSeats() {
		return this.Seats;
	}
	
	public int getPassengers() {
		return this.Passengers;
	}
	
	public String getOrigin() {
		return this.Origin;
	}
	
	public String getDestination() {
		return this.Destination;
	}
	
	public String getDep_Date() {
		return this.Dep_Date;
	}
	
	public String getDep_Time() {
		return this.Dep_Time;
	}
	
	public String getDes_Date() {
		return this.Des_Date;
	}
	
	public String getDes_Time() {
		return this.Des_Time;
	}
	
	public String getType() {
		return this.Type;
	}
	
	public int getFare() {
		return this.Fare;
	}
}
