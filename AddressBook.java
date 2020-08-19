package com.addressbook;

import java.util.*;
public class AddressBook {
	static HashMap<String, PersonDetails> personMap = new HashMap<>();
	Scanner input = new Scanner(System.in);
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
			System.out.println("---------MAIN MENU---------");
			System.out.println("OPTIONS\n1.Add a person\n2.Edit Details of a person\n3.Delete a person\n4.Sort the persons\n5.Display the all the persons details\n6.Search a person");
			System.out.println("Enter your choice");
			choice = input.nextInt();
			switch (choice) {
				case 1:
					do {
						System.out.println("Enter first name");
						firstName = input.next();
						System.out.println("Enter last name");
						lastName = input.next();
						System.out.println("Enter street");
						street = input.next();
						System.out.println("Enter city");
						city = input.next();
						System.out.println("Enter state");
						state = input.next();
						System.out.println("Enter zipcode");
						zipCode = input.nextInt();
						System.out.println("Enter phone number");
						phoneNum = input.nextLong();
						if (personMap.containsKey(firstName)) {
							System.out.println("Key already exists");
						} else {
							PersonDetails person = new PersonDetails(firstName, lastName, street, city, state, zipCode, phoneNum);
							personMap.put(person.getFirstName(), person);
						}
						System.out.println("Enter 1 to add more people, 0 to stop");
						choice = input.nextInt();
					} while (choice != 0);
					break;
				case 2:
					System.out.println("Enter first name of the person");
					firstName = input.next();
					edit(firstName);
					break;
				case 3:
					System.out.println("Enter first name of the person to be deleted");
					firstName = input.next();
					delete(firstName);
					break;
				case 4:
					sort();
					break;
				case 5:
					display();
					break;
				case 6:
					System.out.println("Enter the name of the person to search");
					firstName = input.next();
					search(firstName);
					break;
				default:
					System.out.println("Invalid output!");
			}
			System.out.println("Enter 0 to quit, 1 to go to main menu");
			choice = input.nextInt();
		} while (choice != 0);
	}

	//To edit the details of a person in addressbook
	public void edit(String name) {
		System.out.println("OPTIONS\n1.Edit last name\n2.Edit street\n3.Edit city\n4.Edit state\n5.Edit Zip code\n6.Edit phone number");
		do {
			System.out.println("Enter your choice");
			choice = input.nextInt();
			PersonDetails person = personMap.get(name);
			switch(choice) {
				case 1:
					System.out.println("Enter new last name");
					String newName = input.next();
					person.setLastName(newName);
					break;
				case 2:
					System.out.println("Enter new street name");
					String newStreet = input.next();
					person.setStreet(newStreet);
					personMap.replace(name, person);
					break;
				case 3:
					System.out.println("Enter new city name");
					String newCity = input.next();
					person.setCity(newCity);
					break;
				case 4:
					System.out.println("Enter new state name");
					String newState = input.next();
					person.setState(newState);
					break;
				case 5:
					System.out.println("Enter new zip code");
					int newZip = input.nextInt();
					person.setZipCode(newZip);
					break;
				case 6:
					System.out.println("Enter new phone number");
					long newPhone = input.nextLong();
					person.setPhoneNum(newPhone);
					break;
				default:
					System.out.println("Invalid Output!");
			}
			System.out.println("Enter 1 to continue editing,0 to quit");
			choice = input.nextInt();
		}while(choice != 0);
		search(name);
	}

	//To delete a person from the addressbook
	public void delete(String name) {
		personMap.remove(name);
		System.out.println(name + "'s details has been deleted from address book");
	}

	//To sort the details of the person in addressbook
	public void sort() {
		System.out.println("\nSORT OPTIONS\n1.By first name\n2.By zip\n3.By state\n4.By city");
		choice = input.nextInt();
		ArrayList<String> name = new ArrayList<>();
		ArrayList<Integer> zip = new ArrayList<>();
		ArrayList<String> stateName = new ArrayList<>();
		ArrayList<String> cityName = new ArrayList<>();
		switch (choice) {
			case 1:
				for (Map.Entry<String, PersonDetails> entry : personMap.entrySet()) {
					PersonDetails contact = entry.getValue();
					name.add(contact.getFirstName());
				}
				Collections.sort(name);
				System.out.println("The sorted first names are:" + personMap);
				break;
			case 2:
				for (Map.Entry<String, PersonDetails> entry : personMap.entrySet()) {
					PersonDetails contact = entry.getValue();
					zip.add(contact.getZipCode());
				}
				Collections.sort(zip);
				System.out.println("The sorted zip are:" + personMap);
				break;
			case 3:
				for (Map.Entry<String, PersonDetails> entry : personMap.entrySet()) {
					PersonDetails contact = entry.getValue();
					stateName.add(contact.getState());
				}
				Collections.sort(stateName);
				System.out.println("The sorted state names are:" + personMap);
				break;
			case 4:
				for (Map.Entry<String, PersonDetails> entry : personMap.entrySet()) {
					PersonDetails contact = entry.getValue();
					cityName.add(contact.getCity());
				}
				Collections.sort(cityName);
				System.out.println("The sorted city names are:" + personMap);
				break;
			default:
				System.out.println("Invalid Output!");
		}
	}

	//To display all the contacts in addressbook
	public void display() {
		for(Map.Entry<String, PersonDetails> entry:personMap.entrySet()){
			String key = entry.getKey();
			PersonDetails contact = entry.getValue();
			System.out.println(key+"'s Details:");
			System.out.println("\nLast Name: "+contact.getLastName()+"\nAddress: "+contact.getStreet()+","+contact.getCity()+","+contact.getState()+","+contact.getZipCode()+"\nPhone Num: "+contact.getPhoneNum()+"\n");
			System.out.println("------------------------------------------------------------------");
		}
	}

	//To search a contact in addressbook
	public void search(String name) {
		PersonDetails contact = personMap.get(name);
		System.out.println(name+"'s details are:\nCity: "+contact.getCity()+"\nState: "+contact.getState());
	}
}
