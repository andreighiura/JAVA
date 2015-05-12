package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;

	public Item() {
	}

	public Item(int id, String name, User user) {
		this.id = id;
		this.name = name;
		this.user = user;

	}

	public Item(String name, User user) {
		this.name = name;
		this.user = user;

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
	public User getUser() {
		return user;
	}

	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUser(User user) {
		this.user = user;
	};

	public String toString() {
		return this.name + " id_" + this.id + "  owner: "
				+ this.user.toString() + "\n";
	}
}
