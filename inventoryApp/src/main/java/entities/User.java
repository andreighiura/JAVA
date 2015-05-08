package entities;

public class User {
	String userName;
	String userID;

	public User(String name, String id) {
		this.userName = name;
		this.userID = id;
	}

	public String toString() {
		return this.userName + "   id:  " + this.userID + "\n";
	}
}
