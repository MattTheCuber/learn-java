package ballGame;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller extends Application {
	Model currentModel;
	
	public static void main(String[] args) {
        launch(args);
    }
	@Override public void start(Stage stage) {
		signin().show();
	}
	
	public void trophy(String yourName) {
		Trophy trophy = new Trophy();
		currentModel.getStage().close();
		trophy.trophyMethod(yourName);
	}
	public void info(String yourName) {
		info info = new info();
		currentModel.getStage().close();
		info.infoMethod(yourName);
	}
	public void ls(String yourName) {
		LevelSelect ls = new LevelSelect();
		currentModel.getStage().close();
		ls.level(yourName);
	}
	public void bg(String yourName) {
		BallGame ls = new BallGame();
		currentModel.getStage().close();
		ls.playGame(yourName);
	}
	public void login(String yourName) {
		Login l = new Login();
		currentModel.getStage().close();
		l.login();
	}
	public Stage signin() {
		SignIn l = new SignIn();
		return l.signIn();
	}
	public void key(KeyEvent e, Circle circle, double speed) {
		if ((e.getCode().equals(KeyCode.UP)||(e.getCode().equals(KeyCode.KP_UP)))) {
			move("u", circle, speed);
		} else if ((e.getCode().equals(KeyCode.LEFT)||(e.getCode().equals(KeyCode.KP_LEFT)))) {
			move("l", circle, speed);
		} else if ((e.getCode().equals(KeyCode.RIGHT)||(e.getCode().equals(KeyCode.KP_RIGHT)))) {
			move("r", circle, speed);
		} else if ((e.getCode().equals(KeyCode.DOWN)||(e.getCode().equals(KeyCode.KP_DOWN)))) {
			move("d", circle, speed);
		} else if (e.getCode().equals(KeyCode.PLUS)) {
			speed -= 100;
		} else if (e.getCode().equals(KeyCode.MINUS)) {
			speed += 100;
		}else if (e.getCode().equals(KeyCode.B)) {
			System.out.println("b");
		} else {
			System.out.println("UNKNOWN KEY");
		}
	}
	public void move(String dir, Circle circle, double speed) {
		TranslateTransition tt = new TranslateTransition(Duration.millis(speed), circle);
		RotateTransition rt = new RotateTransition();
		rt.setNode(circle);
		rt.setDuration(Duration.millis(speed));
		rt.setAxis(Rotate.Z_AXIS);
		rt.setByAngle(360);
		rt.setCycleCount(1);
		rt.setInterpolator(Interpolator.LINEAR);
		
		if (dir.equals("u")) {
			tt.setToY(0);
			tt.setInterpolator(Interpolator.LINEAR);
			tt.play();
		} else if (dir.equals("d")) {
			tt.setToY(596);
			tt.setInterpolator(Interpolator.LINEAR);
			tt.play();
		} else if (dir.equals("l")) {
			tt.setToX(0);
			tt.setInterpolator(Interpolator.LINEAR);
			tt.play();
		} else if (dir.equals("r")) {
			tt.setToX(1713);
			tt.setInterpolator(Interpolator.LINEAR);
			tt.play();
		} else if (dir.equals("st")) {
			tt.stop();
		}
		rt.play();
	}
	public void checkBoundries(Rectangle r, Circle c) {
		Bounds r1Boundary = r.getLayoutBounds();
		if (c.intersects(r1Boundary)) {
			System.out.println("You loose!!");
			collide();
		}
	}
	public void collide() {
		System.out.println("You loose!");
	}
	public void select(int i) {
		
	}
	public void setStuff(String nyn, String nyp, Stage ns) {
		Model model = new Model();
		model.setYourName(nyn);
		model.setYourPassword(nyp);
		model.setStage(ns);
		currentModel = model;
	}
	public void submit(String name, String password) {
		String allPasswords = currentModel.makePasswordsString(name);
		String allNames = currentModel.makeNamesString(name);
		
		if ((!name.equals(""))&&(!password.equals(""))) {
			if ((allNames.contains(name))&&
					(allPasswords.contains(password))) {
				currentModel.getStage().close();
				bg(name);
			} else {
	        	MessageBox.show("Incorect input", 
	        			"Erorr");
			}
		} else if  ((name.equals(""))&&(password.equals(""))) {
			MessageBox.show("Please enter a name and password", 
        			"Erorr");
		} else {
        	MessageBox.show("Sorry an error has occurred, please restart the program", 
        			"Erorr");
		}
	}
	public void onOK(String yn, String yp, Stage ps) {
		setStuff(yn, yp, ps);
		bg(yn);
		//submit(yn, yp);
	}
}
