package chap02_MVC;

public class Main {

	public static void main(String[] args) {
		CafeModel model = new CafeModel();
		CafeView view = new CafeView(model);
		CafeController controller = new CafeController(model, view);
		
		controller.run();
	}
}
