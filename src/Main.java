import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Main {
	static List<Flight> flight = new ArrayList<Flight>();
	static List<Booking> booking = new ArrayList<Booking>();
	static List<Integer> Seats = new ArrayList<Integer>();	
	
	public static int Input(String input) throws InputException {
        int N_input = -1;
        try {
            N_input = Integer.parseInt(input);
        } catch (Exception err) {
            throw new InputException("Input is not crorrect,Enter a positive number!");
        }
        return N_input;
    }
	
    public static boolean Check_Seat(Flight obj) throws SeatNotAvailableException {
       if(obj.getSeats()==0)
       {
    	   throw new SeatNotAvailableException("All Seats Reserved !No seats available");
       }
       else {
    	   return true;
       }
    }
    
    public static void main(String[] args) throws IOException, InterruptedException {

        Flight obj1 = new Flight(123 , 70 , 65, "Lahore" , "Islamabed" , "07/11/2021" , "07:00pm" , "08/11/2021" , "09:00am"  , "Business Class" , 6000);
        Flight obj2 = new Flight(456 , 65 , 65, "D.G.Khan" , "Islamabed" , "09/11/2021" , "02:00pm" , "07/11/2021" , "08:00pm" , "Economy Class" , 12000 );
        Flight obj3 = new Flight(789 , 50 , 45 , "Gujrawala" , "Multan" , "10/11/2021" , "07:00pm" , "10/11/2021" , "09:00am" , "First Class" , 5000);
        Flight obj4 = new Flight(623 , 55 , 55 , "Faislabad" , "Islamabed" , "08/11/2021" , "06:00pm" , "08/11/2021" , "09:00pm" , "Busicess Class" , 6000);
        Flight obj5 = new Flight(571 , 60 , 57 , "D.G.Khan" , "Lahore" , "11/11/2021" , "05:00pm" , "08/11/2021" , "11:00pm" , "Economy Class" , 6000);
        flight.add(obj1);
        flight.add(obj2);
        flight.add(obj3);
        flight.add(obj4);
        flight.add(obj5);
        
        Seats.add(0);
        Seats.add(0);
        Seats.add(0);

        //File Writing
        FileWriter F1 = new FileWriter("passengers.txt");
        FileWriter F2 = new FileWriter("flights.txt");
        FileWriter F3 = new FileWriter("bookings.txt");
        F2.write("REF_CODE  DEPARTURE  DEP_DATE DEPT. TIME  DESTINATION  ARR_DATE ARR. TIME  FARE  SEATS\n");
        for (int i = 0; i < flight.size(); i++) {
            Flight objj = flight.get(i);
            F2.write(
                    objj.getRef_Code() + "     " + objj.getOrigin() + "\t " + objj.getDep_Date() + "\t     " + objj.getDep_Time()
                            + "\t  " +objj.getDestination() + "   " +objj.getDes_Date()+"       " + objj.getDes_Time() + "       " +objj.getType() +"    " + objj.getFare() + "  " + objj.getSeats() + "\n");

        }
        F2.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("\nWelcome to the Flight Reservation system");
            System.out.println("1. USER");
            System.out.println("2. ADMIN");
            System.out.println("3. EXIT");
            System.out.print("Enter your Choice: ");
            String choice1 = in.readLine();
            int choice;
            try {
                choice = Input(choice1);
            } catch (InputException w) {
                System.out.println(w + "\nEnter a number");
                continue;
            }

            if (choice == 1) {
                System.out.println("\nHello User!");
                System.out.print("Enter your Name: ");
                String Name = in.readLine();
                System.out.println("\nHello " + Name + "!\nPlease enter further details");
                System.out.print("Enter your Age: ");
                String Age = in.readLine();
                System.out.print("Enter your Gender: ");
                String Gender = in.readLine();
                System.out.print("Enter your Passport Number: ");
                String Passport = in.readLine();
                System.out.print("Enter your Address: ");
                String Address = in.readLine();
                System.out.print("Enter your Contact Number: ");
                String Contact = in.readLine();

                Passenger pass = new Passenger(Name, Age, Gender, Address, Passport, Contact);
                F1.write(pass.getName() + " " + pass.getAge() + " " + pass.getGender() + " " + pass.getAddress()
                        + " " + pass.getPassport() + " " + pass.getContact() + " \n");
                while (true) {
                    System.out.println("\nWelcome to the Main Menu, " + Name + "!");
                    System.out.println("1. Search Flights");
                    System.out.println("2. Book Seats");
                    System.out.println("3. Cancel Seat");
                    System.out.println("4. Exit");
                    System.out.print("Enter Choice: ");
                    String choice2_str = in.readLine();
                    int choice2;
                    try {
                        choice2 = Input(choice2_str);
                    } catch (InputException e) {
                        System.out.println(e + "\nEnter a number");
                        continue;
                    }
                    if (choice2 == 1) {
                        System.out.print("From: ");
                        String src = in.readLine();
                        System.out.print("To: ");
                        String dest = in.readLine();
                        int find = 0;
                        for (int i = 0; i < flight.size(); i++) {
                            Flight objj1 = flight.get(i);
                            if (objj1.getOrigin().equals(src) && objj1.getDestination().equals(dest)) {
                                find++;
                                System.out.println("REF_CODE  DEPARTURE  DEP_DATE DEPT. TIME  DESTINATION  ARR_DATE ARR. TIME  FARE  SEATS\n");
                                System.out.println(objj1.getRef_Code() + "     " + objj1.getOrigin() + "\t " + 
                                         objj1.getDep_Date()+ "     " +objj1.getDep_Time() + "\t     " + objj1.getDestination() + "\t  " + objj1.getDes_Date()+ "     "+ objj1.getDes_Time()
                                    +"\t  " +objj1.getType() + "       " + objj1.getFare() + "  " + objj1.getSeats() + "\n");
                            }
                        }
                        if (find == 0) {
                            System.out.println("No flights found");
                        }
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Press Enter to continue...");
                        String t1 = in.readLine();

                    } else if (choice2 == 2) {
                        System.out.print("From: ");
                        String src = in.readLine();
                        System.out.print("To: ");
                        String dest = in.readLine();
                        System.out.print("Code: ");
                        String code = in.readLine();
                        int c_int = -1;
                        try {
                            c_int = Input(code);
                        } catch (InputException e) {
                            System.out.println(e + "\nEnter a number");
                            continue;
                        }
                        int found1 = 0;
                        for (int i = 0; i < flight.size(); i++) {
                            Flight temp = flight.get(i);
                            if (temp.getOrigin().equals(src) && temp.getDestination().equals(dest) && temp.getRef_Code() == c_int
                                    ) {
                            	try {
                            		Check_Seat(temp);
                            	}catch(SeatNotAvailableException er){
                            		System.out.println(er + "\nSeats not available!!");
                            		continue;
                            	}
                                found1++;
                                System.out
                                        .print("Found!\nYou have to pay $" + temp.getFare() + "\nEnter Card Number: ");
                                String card = in.readLine();
                                System.out.print("Enter Pin Number: ");
                                String pin = in.readLine();

                                booking.add(new Booking(pass ,temp , null, Seats.get(i)));
                                int x = Seats.get(i) + 1;
                                Seats.remove(i);
                                Seats.add(i, x);
                                flight.get(i).setSeats(temp.getSeats() - 1);
                                F3.write(booking.get(booking.size() - 1).getInfo());
                            }
                        }

                        if (found1 == 0) {
                            System.out.println("No flights found");
                        } else {
                            TimeUnit.SECONDS.sleep(1);
                            System.out.println("Flight Booked!");
                            F2 = new FileWriter("flights.txt");
                            F2.write("CODE  DEPARTURE  DEPT. TIME  DESTINATION  ARR. TIME  FARE  SEATS\n");
                            for (int i = 0; i < flight.size(); i++) {
                                Flight objj1 = flight.get(i);
                                F2.write(objj1.getRef_Code() + "     " + objj1.getOrigin() + "\t " + 
                                        objj1.getDep_Date()+ "     " +objj1.getDep_Time() + "\t     " + objj1.getDestination() + "\t  " + objj1.getDes_Date()+ "     "+ objj1.getDes_Time()
                                   +"\t  " +objj1.getType() + "       " + objj1.getFare() + "  " + objj1.getSeats() + "\n");
                            }
                        }
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Press Enter to continue...");
                        String t1 = in.readLine();

                    } else if (choice2 == 3) {
                        System.out.print("From: ");
                        String src = in.readLine();
                        System.out.print("To: ");
                        String dest = in.readLine();
                        System.out.print("Code: ");
                        String code = in.readLine();
                        int codeint = -1;
                        try {
                            codeint = Input(code);
                        } catch (InputException w) {
                            System.out.println(w + "\nEnter a number");
                            continue;
                        }
                        int found = 0;
                        for (int i = 0; i < booking.size(); i++) {
                            Booking temp = booking.get(i);
                            if (temp.getflight().getOrigin().equals(src) && temp.getflight().getDestination().equals(dest)
                                    && temp.getflight().getRef_Code() == codeint) {
                                found++;
                                System.out.print("Found!\nYou have will get $" + temp.getflight().getFare()
                                        + "\nEnter Card Number: ");
                                String card = in.readLine();
                                System.out.print("Enter Pin Number: ");
                                String pin = in.readLine();

                                for (int j = 0; j < flight.size(); j++) {
                                    Flight temp2 = flight.get(j);
                                    if (temp.getflight().getOrigin().equals(src)
                                            && temp.getflight().getDestination().equals(dest)
                                            && temp.getflight().getRef_Code() == codeint) {
                                        flight.get(i).setSeats(temp.getflight().getSeats() + 1);
                                        booking.remove(j);
                                        int x = Seats.get(j) - 1;
                                        Seats.remove(j);
                                        Seats.add(j, x);
                                    }
                                }
                            }
                        }

                        if (found == 0) {
                            System.out.println("No flights found");
                        } else {
                            TimeUnit.SECONDS.sleep(1);
                            System.out.println("Flight Cancelled!");
                            F2 = new FileWriter("flights.txt");
                            F2.write("CODE  DEPARTURE  DEPT. TIME  DESTINATION  ARR. TIME  FARE  SEATS\n");
                            for (int i = 0; i < flight.size(); i++) {
                                Flight objj1 = flight.get(i);
                                F2.write(objj1.getRef_Code() + "     " + objj1.getOrigin() + "\t " + 
                                        objj1.getDep_Date()+ "     " +objj1.getDep_Time() + "\t     " + objj1.getDestination() + "\t  " + objj1.getDes_Date()+ "     "+ objj1.getDes_Time()
                                   +"\t  " +objj1.getType() + "       " + objj1.getFare() + "  " + objj1.getSeats() + "\n");
                            }
                            F3 = new FileWriter("bookings.txt");
                            for (int i = 0; i < booking.size(); i++) {
                                Booking temp = booking.get(i);
                                F3.write(temp.getInfo());
                            }
                        }
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Press Enter to continue...");
                        String t1 = in.readLine();
                    } else if (choice2 == 4) {
                        break;
                    }
                }
            } else if (choice == 2) {
                System.out.println("\nHello Admin!");
                System.out.print("Enter your Name: ");
                String name = in.readLine();
                while (true) {
                    System.out.println("\nWelcome to the Main Menu, " + name + "!");
                    System.out.println("1. View Flights");
                    System.out.println("2. View Bookings");
                    System.out.println("3. Add Flight");
                    System.out.println("4. Remove Flight");
                    System.out.println("6. Exit");
                    System.out.print("Enter Choice: ");
                    String choice2_s = in.readLine();
                    int choice2;
                    try {
                        choice2 = Input(choice2_s);
                    } catch (InputException w) {
                        System.out.println(w + "\nEnter a number");
                        continue;
                    }
                    if (choice2 == 1) {
                        for (int i = 0; i < flight.size(); i++) {
                            Flight objj1 = flight.get(i);
                            System.out.println("CODE  DEPARTURE  DEPT. TIME  DESTINATION  ARR. TIME  FARE  SEATS");
                            System.out.println(objj1.getRef_Code() + "     " + objj1.getOrigin() + "\t " + 
                                    objj1.getDep_Date()+ "     " +objj1.getDep_Time() + "\t     " + objj1.getDestination() + "\t  " + objj1.getDes_Date()+ "     "+ objj1.getDes_Time()
                               +"\t  " +objj1.getType() + "       " + objj1.getFare() + "  " + objj1.getSeats() + "\n");
                        }

                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Press Enter to continue...");
                        String t1 = in.readLine();
                    } else if (choice2 == 2) {
                        for (int i = 0; i < booking.size(); i++) {
                            Booking temp = booking.get(i);
                            System.out.println(temp.getInfo());
                        }

                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Press Enter to continue...");
                        String t1 = in.readLine();
                    } 
                    
                    else if (choice2 == 3) 
                    {
                        System.out.print("From: ");
                        String from = in.readLine();
                        System.out.print("To: ");
                        String dest = in.readLine();
                        System.out.print("Departure time: ");
                        String deptim = in.readLine();
                        System.out.print("Departure Date: ");
                        String depdate = in.readLine();
                        System.out.print("Arrival time: ");
                        String arrtim = in.readLine();
                        System.out.print("Arrival time: ");
                        String arrdate = in.readLine();
                        int code = flight.get(flight.size() - 1).getRef_Code() + 1;
                        System.out.print("Seats: ");
                        String seat = in.readLine();
                        int s_i = Integer.parseInt(seat);
                        System.out.print("Fare: ");
                        String fare = in.readLine();
                        System.out.print("Type: ");
                        String type = in.readLine();
                        int f_i = Integer.parseInt(fare);
                        flight.add(new Flight(code, from , dest, deptim,depdate, arrtim, arrdate,f_i , type, s_i));
                        Seats.add(0);
                        Flight temp = flight.get(flight.size() - 1);
                        System.out.println("ADDED: " + temp.getRef_Code() + "     " + temp.getOrigin() + "\t "
                                + temp.getDep_Time() + "\t     " + temp.getDestination() + "\t  " + temp.getDes_Time()
                                + "       " + temp.getFare() + "  " + temp.getSeats() + "\n");
                        F2 = new FileWriter("flights.txt");
                        F2.write("CODE  DEPARTURE  DEPT. TIME  DESTINATION  ARR. TIME  FARE  SEATS\n");
                        for (int i = 0; i < flight.size(); i++) {
                            Flight objj1 = flight.get(i);
                            F2.write(objj1.getRef_Code() + "     " + objj1.getOrigin() + "\t " + 
                                    objj1.getDep_Date()+ "     " +objj1.getDep_Time() + "\t     " + objj1.getDestination() + "\t  " + objj1.getDes_Date()+ "     "+ objj1.getDes_Time()
                               +"\t  " +objj1.getType() + "       " + objj1.getFare() + "  " + objj1.getSeats() + "\n");
                        }
                        System.out.println("Flight Added!");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Press Enter to continue...");
                        String t1 = in.readLine();
                    } else if (choice2 == 4) {
                        System.out.print("code: ");
                        String code = in.readLine();
                        int code_i = Integer.parseInt(code);
                        for (int i = 0; i < flight.size(); i++) {
                            Flight temp = flight.get(i);
                            if (code_i == temp.getRef_Code()) {
                                System.out.println("REMOVED: " + temp.getRef_Code() + "     " + temp.getOrigin() + "\t "
                                        + temp.getDep_Time() + "\t     " + temp.getDestination() + "\t  " + temp.getDes_Time()
                                        + "       " + temp.getFare() +"   "+temp.getType()+ "  " + temp.getSeats() + "\n");
                                flight.remove(i);
                                Seats.remove(i);
                                break;
                            }
                        }

                        F2 = new FileWriter("flights.txt");
                        F2.write("CODE  DEPARTURE  DEPT. TIME  DESTINATION  ARR. TIME  FARE  SEATS\n");
                        for (int i = 0; i < flight.size(); i++) {
                            Flight objj1 = flight.get(i);
                           F2.write(objj1.getRef_Code() + "     " + objj1.getOrigin() + "\t " + 
                                   objj1.getDep_Date()+ "     " +objj1.getDep_Time() + "\t     " + objj1.getDestination() + "\t  " + objj1.getDes_Date()+ "     "+ objj1.getDes_Time()
                              +"\t  " +objj1.getType() + "       " + objj1.getFare() + "  " + objj1.getSeats() + "\n");
                        }
                        System.out.println("Flight Removed!");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Press Enter to continue...");
                        String t1 = in.readLine();

                    } else if (choice2 == 5) {
                        break;
                    }
                }
            } else if (choice == 3) {
                break;
            }
        }

        F2.close();
        F1.close();
        F3.close();
    }
}

