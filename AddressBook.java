package com.addressbook;
import java.util.*;
	public class AddressBook {
		static HashMap<String, PersonDetails> personMap = new HashMap<String, PersonDetails>();
		Scanner sc = new Scanner(System.in);
		String firstName;
		String lastName = " ";
		String street = " ";
		String city = " ";
		String state;
		int zipCode;
		long phoneNum = 0;
		String fullName;
		int ch = 0;

		public void menu() {
			do {
				System.out.println("---------MAIN MENU---------");
				System.out.println("OPTIONS\n1.Add a person\n2.Edit Details\n3.Delete a person\n4.Sort\n5.Print");
				System.out.println("Enter your choice");
				ch = sc.nextInt();
				switch (ch) {
					case 1:
						do {
							System.out.println("Enter first name");
							firstName = sc.next();
							System.out.println("Enter last name");
							lastName = sc.next();
							System.out.println("Enter street");
							street = sc.next();
							System.out.println("Enter city");
							city = sc.next();
							System.out.println("Enter state");
							state = sc.next();
							System.out.println("Enter zipcode");
							zipCode = sc.nextInt();
							System.out.println("Enter phone number");
							phoneNum = sc.nextLong();
							if (personMap.containsKey(firstName)) {
								System.out.println("Key already exists");
							} else {
								PersonDetails person = new PersonDetails(firstName, lastName, street, city, state, zipCode, phoneNum);
								personMap.put(person.getFirstName(), person);
							}
							System.out.println("Enter 1 to add more people, 0 to stop");
							ch = sc.nextInt();
						} while (ch != 0);
						break;
					case 2:
						System.out.println("Enter first name of the person");
						firstName = sc.next();
						edit(firstName);
						break;
					case 3:
						System.out.println("Enter first name of the person to be deleted");
						firstName = sc.next();
						del(firstName);
						break;
					case 4:
						sort();
						break;
					case 5:
						print();
						break;

					default:
						System.out.println("Invalid output!");
				}
				System.out.println("Enter 0 to quit, 1 to go to main menu");
				ch = sc.nextInt();
			} while (ch != 0);
		}

		public void add(String nameKey, PersonDetails P) {
			personMap.put(nameKey, P);
		}

		public void edit(String name) {
			System.out.println("OPTIONS\n1.Edit street\n2.Edit city\n3.Edit state\n4.Edit Zip code\n5.Edit phone number");
			do {
				System.out.println("Enter your choice");
				ch = sc.nextInt();
				PersonDetails p = personMap.get(name);
				switch (ch) {
					case 1:
						System.out.println("Enter new street name");
						String newStreet = sc.next();
						p.setStreet(newStreet);
						break;
					case 2:
						System.out.println("Enter new city name");
						String newCity = sc.next();
						p.setCity(newCity);
						break;
					case 3:
						System.out.println("Enter new state name");
						String newState = sc.next();
						p.setState(newState);
						break;
					case 4:
						System.out.println("Enter new zip code");
						int newZip = sc.nextInt();
						p.setZipCode(newZip);
						break;
					case 5:
						System.out.println("Enter new phone number");
						long newPhone = sc.nextLong();
						p.setPhoneNum(newPhone);
						break;
					default:
						System.out.println("Invalid output!");
				}
				System.out.println("Enter 1 to continue editing,0 to quit");
				ch = sc.nextInt();
			} while (ch != 0);
		}

		public void del(String name) {
			personMap.remove(name);
			System.out.println(name + "'s details has been deleted from address book");
		}

		public void sort() {
			System.out.println("\nSORT OPTIONS\n1.By first name");
			ch = sc.nextInt();
			ArrayList<String> name = new ArrayList<String>();
			switch (ch) {
				case 1:
					for (Map.Entry<String, PersonDetails> entry : personMap.entrySet()) {
						PersonDetails p = entry.getValue();
						name.add(p.getFirstName());
					}
					Collections.sort(name);
					System.out.println("The sorted last names are:" + name);
					break;
			}
		}

		public void print() {
			for(Map.Entry<String, PersonDetails> entry:personMap.entrySet()){
				String key=entry.getKey();
				PersonDetails p=entry.getValue();
				System.out.println(key+"'s Details:");
				System.out.println("\nLast Name: "+p.getLastName()+"\nAddress: "+p.getStreet()+","+p.getCity()+","+p.getState()+","+p.getZipCode()+"\nPhone Num: "+p.getPhoneNum()+"\n");
				System.out.println("------------------------------------------------------------------");
			}
		}
	}
