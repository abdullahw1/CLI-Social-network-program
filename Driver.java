/*
   Driver.java
*/

import java.util.Scanner;

public class Driver {

	//asks user to do the following actions in our social network app
//		1. Create profile
//		2. Search for a profile
//		3. Add friend
//		4. Remove friends
//		5. Update a profile
//		6. Delete a profile
//		0. Log out
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FriendList friendList = new FriendList();
		int choice;

		do {
			displayMenu();
			choice = Integer.parseInt(sc.nextLine().trim());
			switch (choice) {
			case 1: {
				System.out.println("\nCREATE PROFILE:");   
				System.out.println("----------------------");
				friendList.createProfile();
				break;
			}

			case 2: {
				System.out.println("\nSEARCH PROFILE:");
				System.out.println("----------------------");
				friendList.searchProfile();
				break;
			}

			case 3: {
				System.out.println("\nADD FRIENDS:"); 
				System.out.println("----------------------");
				friendList.addFriends();
				break;
			}

			case 4: {
				System.out.println("\nREMOVE FRIENDS:");
				friendList.removeFriends();
				break;
			}

			case 5: {
				System.out.println("UPDATE PROFILE:");
				System.out.println("----------------------"); 
				friendList.updateProfile();
				break;
			}

			case 6: {
				System.out.println("\nDELETE PROFILE:");
				System.out.println("----------------------");
				friendList.deleteProfile();
				break;
			}

			case 0: {
				System.out.println("\nThanks for using out Social Networking Application!");
				System.exit(0);
			}
			default:
				System.out.println("\nInvalid selection!\n");
			}
		} while (choice != 0);
	}

	private static void displayMenu() {
		System.out.println("Welcome to our social network! ");
		System.out.println("Choose from the options by entering corresponding number: ");
		System.out.println("1. Create Profile");
		System.out.println("2. Search for profile:");  
		System.out.println("3. Add Friends");
		System.out.println("4. Remove friend");
		System.out.println("5. Update profile");
		System.out.println("6. Delete profile");
		System.out.println("0. Log out");
		System.out.println("Enter your selection -->"); 
	}
}
