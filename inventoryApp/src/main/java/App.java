import ui.UI;

public class App {
	public static void main(String[] args) {
		UI console = new UI();
		/*
		 * console.insertUser("Ghita", "23141"); console.insertUser("Mara",
		 * "24121"); console.insertUser("Raul", "31141");
		 * console.insertUser("Paul", "62231");
		 */
		/*
		 * console.insertItem("pix", 1, "23141"); console.insertItem("mouse", 1,
		 * "23141"); console.insertItem("pix", 1, "62231");
		 * console.insertItem("veverita", 1, "31141");
		 */

		console.space();
		console.selectAllUsers();
		console.insertItem("mar", 5, "21341");
		console.space();
		console.selectAllItems();
		console.space();
		console.getPosesions("Ghita");
		// console.finalize();
	}
}
