

public class Flight_Type {
	private String Type;
	private int Fare;
	
	Flight_Type(){
		this.Type  = null;
		this.Fare = 0;
	}
	
	
	Flight_Type(String Type,int Fare){
		this.Type = Type;
		this.Fare = Fare;
	}
	
	//Setters
	public void setType(String Type) {
		this.Type = Type;
	}
	
	public void setFare(int Fare) {
		this.Fare = Fare;
	}
	
	//Getters
	
	public String getType() {
		return this.Type;
	}
	
	public int getFare() {
		return this.Fare;
	}
}




