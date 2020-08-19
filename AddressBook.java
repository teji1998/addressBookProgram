package com.addressbook;

import java.util.*;
public class AddressBook {
	static HashMap<String, PersonDetails> personMap = new HashMap<String, PersonDetails>();
	Scanner sc = new Scanner(System.in);
	int choice = 0;

	public void menu() {
		do {
			String firstName;
			String lastName = " ";
			String street = " ";
			String city = " ";
			String state;
			int zipCode;
			long phoneNum = 0;
			String fullName;
			System.out.println("---------MAIN MENU---------");
			System.out.println("OPTIONS\n1.Add a person\n2.Edit Details\n3.Delete a person\n4.Sort\n5.Print\n6.Search person");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
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
						if (personMap.containsKey(firstName))
						{
							System.out.println("Key already exists");
						} else {
							PersonDetails person = new PersonDetails(firstName, lastName, street, city, state, zipCode, phoneNum);
							personMap.put(person.getFirstName(), person);
						}
						System.out.println("Enter 1 to add more people, 0 to stop");
						choice = sc.nextInt();
						} while (choice != 0);
						break;
					case 2:
						System.out.println("Enter first name of the person");
						firstName = sc.next();
						edit(firstName);
						break;
					case 3:
						System.out.println("Enter first name of the person to be deleted");
						firstName = sc.next();
						delete(firstName);
						break;
					case 4:
						sort();
						break;
					case 5:
						print();
						break;
					case 6: System.out.println("Enter the name of the person to search");
						state=sc.next();
						search(state);
						break;
					default:
						System.out.println("Invalid output!");
				}
				System.out.println("Enter 0 to quit, 1 to go to main menu");
				choice = sc.nextInt();
			} while (choice != 0);
		}

		public void add(String nameKey, PersonDetails P) {
			personMap.put(nameKey, P);
		}

		public void edit(String name) {
			System.out.println("OPTIONS\n1.Edit last name\n2.Edit street\n3.Edit city\n4.Edit state\n5.Edit Zip code\n6.Edit phone number");
			do {
				System.out.println("Enter your choice");
				choice=sc.nextInt();
				PersonDetails p=personMap.get(name);
				switch(choice) {
					case 1: System.out.println("Enter new last name");
						String newName=sc.next();
						p.setLastName(newName);
						break;
					case 2: System.out.println("Enter new street name");
						String newStreet=sc.next();
						p.setStreet(newStreet);
						personMap.replace(name, p);
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
					default:
						System.out.println("Invalid Output");
				}
				System.out.println("Enter 1 to continue editing,0 to quit");
				choice=sc.nextInt();
			}while(choice!=0);
			search(name);
		}
		public void delete(String name) {
			personMap.remove(name);
			System.out.println(name + "'s details has been deleted from address book");
		}

		public void sort() {
			System.out.println("\nSORT OPTIONS\n1.By first name\n2.By zip\n3.By state\n4By city");
			choice = sc.nextInt();
			ArrayList<String> name = new ArrayList<>();
			ArrayList<Integer> zip = new ArrayList<>();
			ArrayList<String> stateName = new ArrayList<>();
			ArrayList<String> cityName = new ArrayList<>();
			switch (choice) {
				case 1:
					for (Map.Entry<String, PersonDetails> entry : personMap.entrySet()) {
						PersonDetails p = entry.getValue();
						name.add(p.getFirstName());
					}
					Collections.sort(name);
					System.out.println("The sorted first names are:" + personMap);
					break;
				case 2:
					for (Map.Entry<String, PersonDetails> entry : personMap.entrySet()) {
						PersonDetails p = entry.getValue();
						zip.add(p.getZipCode());
					}
					Collections.sort(zip);
					System.out.println("The sorted zip are:" + personMap);
					break;
				case 3:
					for (Map.Entry<String, PersonDetails> entry : personMap.entrySet()) {
						PersonDetails p = entry.getValue();
						stateName.add(p.getState());
					}
					Collections.sort(stateName);
					System.out.println("The sorted state names are:" + personMap);
					break;
				case 4:
					for (Map.Entry<String, PersonDetails> entry : personMap.entrySet()) {
						PersonDetails p = entry.getValue();
						cityName.add(p.getCity());
					}
					Collections.sort(cityName);
					System.out.println("The sorted city names are:" + personMap);
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
		public void search(String name) {
			PersonDetails p=personMap.get(name);
			System.out.println(name+"'s details are:\nCity: "+p.getCity()+"\nState: "+p.getState());
		}
	}
