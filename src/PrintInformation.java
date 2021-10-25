
public class PrintInformation {
	private Booking booking;
	
	PrintInformation(){
		this.booking = null; 
	}
	
	PrintInformation(Booking booking){
		this.booking = booking;
	}
	
	public String getPrint_Info() {
		return booking.getInfo();
	}
}
