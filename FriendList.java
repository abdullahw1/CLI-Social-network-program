/*
   FriendList.java
*/


import java.util.Iterator;
import java.util.Scanner;

public class FriendList {
	private AList<Profile> profiles;

	public FriendList() {
		this.profiles = new AList<Profile>();
	}

	// get the index of the profile in the list of profiles
	public int getIndexOfProfile(String name) {
		int index = -1;
		for (int i = 1; i <= profiles.getLength(); i++) {
			if (profiles.getEntry(i).getName().equalsIgnoreCase(name)) {
				index = i;
				break;
			}
		}
		return index;
	}

	// adds a friend to the profile represented by it is name ProfileName
	private void addFriends(String ProfileName) {
		if (profiles.isEmpty()) {
			System.out.println("No profiles exist!\n");
			return;
		}
		int index = getIndexOfProfile(ProfileName);
		if (index == -1) {
			System.out.println("There's no such profile named " + ProfileName + "!\n");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the friend: ");
		String FriendName = sc.nextLine().trim();
		int indexF = getIndexOfProfile(FriendName);
		if (indexF == -1) {
			System.out.println("There's no such profile named " + FriendName + "!\n");
			return;
		}
		// cannot add a friend having the same name as friend because it is considered
		// the same profile
		if (FriendName.endsWith(ProfileName)) {
			System.out.println("cannot add yourself as friend\n");
			return;
		}
		Profile sender = profiles.getEntry(index);
		Profile reciever = profiles.getEntry(indexF);
		sender.addFriend(reciever);
	}

	// add friends by asking the user to enter first the name of profile to which we
	// will add the friend then we ask the user the enter the name of the friend to
	// add
	public void addFriends() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter profile name: ");
		String ProfileName = sc.nextLine().trim();
		addFriends(ProfileName);
	}

	// creates the profile of the user by entering the name the status and asking if
	// we want to add friends to the new profile
	// we can add friends if the friend has already a created profile
	public void createProfile() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter profile name: ");
		String ProfileName = sc.nextLine().trim();

		int index = getIndexOfProfile(ProfileName);

		if (index == -1) {
			// profile not present, can add it
			Profile profile = new Profile(ProfileName);
			System.out.print("Enter profile status:\n" + "1. Online\n" + "2. Offline\n" + "3. Busy\n" + "Enter >> ");
			int stChoice = Integer.parseInt(sc.nextLine().trim());
			while (stChoice != 1 && stChoice != 2 && stChoice != 3) {
				System.out.println("Invalid status choice!\n");
				System.out
						.print("Enter profile status:\n" + "1. Online\n" + "2. Offline\n" + "3. Busy\n" + "Enter >> ");
				stChoice = Integer.parseInt(sc.nextLine().trim());
			}
			if (stChoice == 1) {
				profile.setOnlineStatus();
			} else if (stChoice == 2) {
				profile.setOfflineStatus();
			} else if (stChoice == 3) {
				profile.setBusyStatus();
			} else {
				profile.setOfflineStatus();
			}
			System.out.println("Profile status set to " + profile.getStatus() + ".");

			profiles.add(profile);

			char yesNo;
			do {
				System.out.print("Add friend? [y/n]: ");
				yesNo = sc.nextLine().trim().charAt(0);
				if (yesNo == 'N' || yesNo == 'n')
					break;
				else {
					addFriends(profile.getName());
				}
			} while (yesNo != 'N' || yesNo != 'n');

			System.out.println("Profile has been created for " + ProfileName + ".\n");
		}
	}

	// search a profile by the name and the prints all its info including the
	// friends
	public void searchProfile() {
		if (profiles.isEmpty()) {
			System.out.println("No profiles yet!\n");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter profile name to search: ");
		String ProfileName = sc.nextLine().trim();
		int index = getIndexOfProfile(ProfileName);
		if (index == -1)
			System.out.println("Sorry, there's no such profile named " + ProfileName + "!\n");
		else
			System.out.println("Match found:\n" + profiles.getEntry(index) + "\n");
	}

	// updates the profile info
	public void updateProfile() {
		if (profiles.isEmpty()) {
			System.out.println("No profiles yet!\n");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter profile name to search: ");
		String ProfileName = sc.nextLine().trim();
		int index = getIndexOfProfile(ProfileName);
		if (index == -1)
			System.out.println("Sorry, there's no such profile named " + ProfileName + "!\n");
		else {
// update the profile
			System.out.print("Enter new name for the profile: ");
			String newProfileName = sc.nextLine().trim();
			profiles.getEntry(index).setName(newProfileName);
			System.out.print("Enter profile status:\n" + "1. Online\n" + "2. Offline\n" + "3. Busy\n" + "Enter >> ");
			int stChoice = Integer.parseInt(sc.nextLine().trim());
			while (stChoice != 1 && stChoice != 2 && stChoice != 3) {
				System.out.println("Invalid status choice!\n");
				System.out
						.print("Enter profile status:\n" + "1. Online\n" + "2. Offline\n" + "3. Busy\n" + "Enter >> ");
				stChoice = Integer.parseInt(sc.nextLine().trim());
			}
			if (stChoice == 1)
				profiles.getEntry(index).setOnlineStatus();
			else if (stChoice == 2)
				profiles.getEntry(index).setOfflineStatus();
			else if (stChoice == 3)
				profiles.getEntry(index).setBusyStatus();
			else
				profiles.getEntry(index).setOfflineStatus();

			char yesNo;
			do {
				System.out.print("Add friend? [y/n]: ");
				yesNo = sc.nextLine().trim().charAt(0);
				if (yesNo == 'N' || yesNo == 'n')
					break;
				else {
					System.out.print("Name of the friend: ");
					String FriendName = sc.nextLine().trim();
					profiles.getEntry(index).addFriend(new Profile(FriendName));
					System.out.println();
				}
			} while (yesNo != 'N' || yesNo != 'n');
			System.out.println("Profile updated successfully.\n");
		}
	}

	// deletes a profile from the list of profiles
	public void deleteProfile() {
		if (profiles.isEmpty()) {
			System.out.println("No profiles yet!\n");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter profile name to search: ");
		String ProfileName = sc.nextLine().trim();
		int index = getIndexOfProfile(ProfileName);
		if (index == -1)
			System.out.println("Sorry, " + ProfileName + " does not exist!\n");
		else {
			profiles.remove(index);
			System.out.println("Profile " + ProfileName + " is deleted successfully.\n");
		}
	}

	// remove a friend from the list of friends of a profile
	// it asks user to enter first the name of the profile for which we will delete
	// a friend then asks to enter the name of the friend to delete
	public void removeFriends() {
		if (profiles.isEmpty()) {
			System.out.println("No profiles!\n");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter profile name to search: ");
		String ProfileName = sc.nextLine().trim();
		int index = getIndexOfProfile(ProfileName);
		if (index == -1)
			System.out.println("Sorry, there's no such profile named " + ProfileName + "!\n");
		else {
			HashedDictionary<String, Profile> friends = profiles.getEntry(index).getFriends();
			System.out.println("There are " + friends.getSize() + " friends.");
			Iterator<String> iterator = friends.getKeyIterator();
			while (iterator.hasNext()) {
				System.out.println(friends.getValue((String) iterator.next()));
			}
			System.out.print("Enter name of the friend to remove: ");
			String FriendName = sc.nextLine().trim();
			Profile removedFriend = friends.remove(FriendName);

			if (removedFriend == null)
				System.out.println("Sorry, there's no friend named " + FriendName + ".\n");
			else
				System.out.println(removedFriend.getName() + " friend removed.\n");
		}
	}
}
