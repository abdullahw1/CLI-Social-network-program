/*
    Profile.java
*/

import java.util.Iterator;

public class Profile {
	private String name;
	private String status;
	private HashedDictionary<String, Profile> friends;

	public Profile() {
		this.name = "Admin";
		this.status = "Online";
		this.friends = new HashedDictionary<>();
	}

	public Profile(String name) {
		this.name = name;
		this.status = "Online";
		this.friends = new HashedDictionary<>();
	}

	public String getStatus() {
		return status;
	}

	public void setOnlineStatus() {
		this.status = "Online";
	}

	public void setOfflineStatus() {
		this.status = "Offline";
	}

	public void setBusyStatus() {
		this.status = "Busy";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashedDictionary<String, Profile> getFriends() {
		return friends;
	}

	public void addFriend(Profile friendToAdd) {
		Profile friend = friends.getValue(friendToAdd.name);

		if (friend == null) {
			friends.add(friendToAdd.name, friendToAdd);
			System.out.println(friendToAdd.name + " is added to your friend list.\n");
		} else
			System.out.println(friendToAdd.name + " is already added to your friend list.\n");
	}

	//overrides the toString method to display the info of a profile + friends
	@Override
	public String toString() {
		String out = "Profile Name: " + getName() + ", Status: " + getStatus();
		if (friends.isEmpty())
			return out;
		else {
			out += "\nFriends:\n ";
			Iterator<String> iterator = friends.getKeyIterator();
			while (iterator.hasNext()) {
				Profile friend = friends.getValue((String) iterator.next());
				if(!name.equals(friend.name)) {
				out += "Profile Name: " + friend.getName() + ", Status: " + friend.getStatus()+ "\n";
				}
			}
		}
		return out;
	}
}
