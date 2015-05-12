package inventroyAppHibernate;

import service.Service;

public class Main {

	public static void main(String[] args) {
		Service svc = new Service();
		// svc.insertTestData();

		print(svc.selectAllItems());
		// print(svc.selectAllUsers());
		print(svc.getPosesions(" user 9 "));
	}

	public static void print(String s) {
		System.out.print(s);
	}

}
