package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Item {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	private String userID;

	public Item() {
	}

	public Item(int id, String name, String userID) {
		this.id = id;
		this.name = name;
		this.userID = userID;

	}

	public Item(String name, String userID) {
		this.name = name;
		this.userID = userID;

	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	};

	public String toString() {
		return this.name + " id_" + this.id + "  owner: " + this.userID + "\n";
	}
}
