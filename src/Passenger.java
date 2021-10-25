
public class Passenger {
	private String Name;
	private String Gender;
	private String Age;
	private String Address;
	private String Contact;
	private String Passport;
	
	Passenger(){
		Name = null;
		Gender = null;
		Age = null;
		Address = null;
		Contact = null;
		Passport = null;
	}
	
	Passenger(String Name , String Gender , String Age , String Address , String Contact , String Passport){
		this.Name = Name;
		this.Gender = Gender;
		this.Age = Age;
		this.Address = Address;
		this.Contact = Contact;
		this.Passport = Passport;
	}
	
	//Setters
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public void setGender(String Gender) {
		this.Gender = Gender;
	}
	
	public void setAge(String Age) {
		this.Age = Age;
	}
	
	public void setAddress(String Address) {
		this.Address = Address;
	}
	
	public void setContact(String Contact) {
		this.Contact = Contact;
	}
	
	public void Passport(String Passport) {
		this.Passport = Passport;
	}
	
	//getters
	
	public String getName() {
		return this.Name;
	}
	
	public String getGender() {
		return this.Gender;
	}
	
	public String getAge() {
		return this.Age;
	}
	
	public String getAddress() {
		return this.Address;
	}
	
	public String getContact() {
		return this.Contact;
	}
	
	public String getPassport() {
		return this.Passport;
	}
	
}
