package entities;

public class Item {
	String name;
	int id;
	String userID;

	public Item(String name, int id, String userID) {

		this.name = name;
		this.id = id;
		this.userID = userID;
	}

	public String toString() {
		return "" + this.name + " id: " + this.id + " owner " + this.userID
				+ "\n";
	}
}
