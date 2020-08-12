package com.addressbook;
import java.util.*;
	public class AddressBook {
		static HashMap<String,PersonDetails> personMap=new HashMap<String,PersonDetails>();
		Scanner sc=new Scanner(System.in);
		String firstName;
		String lastName=" ";
		String street=" ";
		String city=" ";
		String state;
		int zipCode;
		long phoneNum=0;
		int ch=0;
		public void menu() {
			AddressBook address=new AddressBook();
			do {
				System.out.println("---------MAIN MENU---------");
				System.out.println("OPTIONS\n1.Add a person");
				System.out.println("Enter your choice");
				ch=sc.nextInt();
				switch(ch) {
					case 1: do {
						System.out.println("Enter first name");
						firstName=sc.next();
						System.out.println("Enter last name");
						lastName=sc.next();
						System.out.println("Enter street");
						street=sc.next();
						System.out.println("Enter city");
						city=sc.next();
						System.out.println("Enter state");
						state=sc.next();
						System.out.println("Enter zipcode");
						zipCode=sc.nextInt();
						System.out.println("Enter phone number");
						phoneNum=sc.nextLong();
						PersonDetails person=new PersonDetails(firstName,lastName,street,city,state,zipCode,phoneNum);
						address.add(person.getFirstName(),person);
						break;

					}while(ch!=0);break;
				}
				System.out.println("Enter 0 to quit, 1 to go to main menu");
				ch=sc.nextInt();
			}while(ch!=0);
		}
		public void add(String nameKey,PersonDetails P) {
			personMap.put(nameKey, P);
		}
}
