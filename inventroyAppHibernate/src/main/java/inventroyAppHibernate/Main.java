package inventroyAppHibernate;

import service.Service;

public class Main {

	public static void print(String s) {
		System.out.print(s);
	}

	public static void main(String[] args) {
		Service svc = new Service();

		for (int i = 0; i < 10; i++) {
			// svc.insertItem("mouse_" + i, Integer.toString(i % 5));
		}
		for (int i = 0; i < 5; i++) {
			// svc.insertUser("gigi_" + i, Integer.toString(i));
		}
		print(svc.selectAllItems());
		print(svc.selectAllUsers());
		print(svc.getPosesions("2"));
	}
}
