
public class Booking {
	private Passenger passenger;
	private Flight flight;
	int Seat_Number;
	
	Booking(){
		passenger = null;
		flight = null;
		Seat_Number = 0;
	}
	
	Booking(Passenger passenger , Flight flight , Flight_Type flight_type , int SeatNumber){
		this.passenger = passenger;
		this.flight = flight;
		this.Seat_Number = Seat_Number;
	}
	
	//Setters
	public void setpassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
	public void setflight(Flight flight) {
		this.flight = flight;
	}
	
	public void setSeat_Number(int Seat_Number) {
		this.Seat_Number = Seat_Number;
	}
	
	//getters
	public Passenger getpassenger() {
		return this.passenger;
	}
	
	public Flight getflight() {
		return this.flight;
	}
	
	public int getSeat_Number() {
		return this.Seat_Number;
	}
	
	public String getInfo() {
		return passenger.getName() + "  " + passenger.getGender()+"  " + passenger.getContact() + "  " + passenger.getPassport()+"\n\n"+
	    this.getSeat_Number() + "  " + flight.getOrigin() + "  " + flight.getDep_Time() + "  " + flight.getDes_Date() + "\n\n" +
		flight.getDestination() + "  " + flight.getDes_Time() + "  " + flight.getDes_Date() + "  " + flight.getType() + "\n\n" +
	    flight.getFare();
	}
}
