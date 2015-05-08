package ui;

import service.Service;

public class UI {

	private Service svc;

	public UI() {

		this.svc = new Service();

	}

	public void selectAllUsers() {
		System.out.print(svc.selectAllUsers());

	}

	public void space() {
		System.out.print("\n \n \n \n \n");
	}

	public void selectAllItems() {
		System.out.print(svc.selectAllItems());

	}

	public void insertUser(String name, String id) {
		svc.insertUser(name, id);

	}

	public void insertItem(String name, int id, String owner) {
		svc.insertItem(name, id, owner);

	}

	public void getPosesions(String userName) {
		System.out.print(svc.getPosesions(userName));

	}

}
