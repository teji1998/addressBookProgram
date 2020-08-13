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
			do {
				System.out.println("---------MAIN MENU---------");
				System.out.println("OPTIONS\n1.Add a person\n2.Edit Details\n3.Delete a person");
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
						personMap.put(person.getFirstName(), person);
						System.out.println("Contact Added as : ");
						System.out.println(personMap);
						break;
					}while(ch!=0);break;
					case 2: System.out.println("Enter first name of the person");
						firstName=sc.next();
						edit(firstName);
						break;
				}
				System.out.println("Enter 0 to quit, 1 to go to main menu");
				ch=sc.nextInt();
			}while(ch!=0);
		}
		public void add(String nameKey,PersonDetails P) {
			personMap.put(nameKey, P);
		}
		public void edit(String name) {
			System.out.println("OPTIONS\n1.Edit last name\n2.Edit street\n3.Edit city\n4.Edit state\n5.Edit Zip code\n6.Edit phone number");
			do {
				System.out.println("Enter your choice");
				ch=sc.nextInt();
				PersonDetails p=personMap.get(name);
				switch(ch) {
					case 1: System.out.println("Enter new last name");
						String newName=sc.next();
						p.setLastName(newName);
						break;
					case 2: System.out.println("Enter new street name");
						String newStreet=sc.next();
						p.setStreet(newStreet);
						break;
					case 3: System.out.println("Enter new city name");
						String newCity=sc.next();
						p.setCity(newCity);
						break;
					case 4: System.out.println("Enter new state name");
						String newState=sc.next();
						p.setState(newState);
						break;
					case 5: System.out.println("Enter new zip code");
						int newZip=sc.nextInt();
						p.setZipCode(newZip);
						break;
					case 6: System.out.println("Enter new phone number");
						long newPhone=sc.nextLong();
						p.setPhoneNum(newPhone);
						break;
				}
				System.out.println("Enter 1 to continue editing,0 to quit");
				ch=sc.nextInt();
			}while(ch!=0);

		}
}
