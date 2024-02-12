package calculator;

import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View {
	Button a, b, c, d, e, f, g, h, i, zero, plus, minus, divide, multiply, point, equals, pM, cl;
	Button xToy, x2Root, x3Root, bS, xTo2, xTo3, pi;
	Stage stage;
	Text txt;
	ViewsInterface vi;

	public View() {
		stage = new Stage();

		String str = "";
		txt = new Text(str);
		txt.setFont(new Font(30));

		Rectangle rect = new Rectangle(277, 50);
		rect.setFill(Color.LIGHTGRAY);

		createButton(cl, "AC", 54, false);
		createButton(xToy, "^", 54, false);
		createButton(xTo2, "x²", 49, false);
		createButton(xTo3, "x³", 49, false);
		createButton(x2Root, "√", 49, false);
		createButton(x3Root, "³√", 49, false);
		createButton(pM, "±", 54, false);
		createButton(bS, "←", 54, false);
		createButton(equals, "=", 42, false);
		createButton(point, ".", 54, false);
		createButton(a, "1", 54, true);
		createButton(b, "2", 54, true);
		createButton(c, "3", 54, true);
		createButton(d, "4", 54, true);
		createButton(e, "5", 54, true);
		createButton(f, "6", 54, true);
		createButton(g, "7", 54, true);
		createButton(h, "8", 54, true);
		createButton(i, "9", 54, true);
		createButton(pi, "π", 49, true);
		createButton(zero, "0", 54, true);
		createButton(plus, "+", 42, false);
		createButton(minus, "-", 42, false);
		createButton(divide, "÷", 42, false);
		createButton(multiply, "×", 42, false);

		StackPane totalPane = new StackPane(rect, txt);
		TilePane panelStart = new TilePane(/*5, 5, pi, cl, xToy, bS, xTo2, g, h, i, xTo3, d, e, f, x2Root, a, b, c,
				x3Root, pM, zero, point*/);
		panelStart.setPrefColumns(4);
		VBox right = new VBox(/*5, divide, multiply, minus, plus, equals*/);
		HBox panelMiddle = new HBox(5, panelStart, right);
		VBox panel = new VBox(5, totalPane, panelMiddle);
		panel.setPadding(new Insets(5, 5, 5, 5));

		BorderPane paneMain = new BorderPane(panel);
		Scene scene = new Scene(paneMain);
		stage.setScene(scene);
		stage.setWidth(296);
		stage.setHeight(341);
		stage.setResizable(false);
		stage.setTitle("Calculator");
		stage.show();
	}

	private void createButton(Button bName, String string, int width, boolean bold) {
		bName = new Button(string);
		bName.setPrefWidth(width);
		bName.setFont(new Font(20));
		if (bold == true) {
			bName.setStyle("-fx-font-weight:bold;");
		}
		bName.setOnAction(e -> actionPerformed(e));
	}

	public void actionPerformed(Event e) {
		Object source = (Object) e.getSource();
		if (vi != null) {
			if (source == plus) {
				vi.sign("p");
			} else if (source == minus) {
				vi.sign("mi");
			} else if (source == divide) {
				vi.sign("d");
			} else if (source == multiply) {
				vi.sign("mu");
			} else if (source == equals) {
				vi.equals();
			} else if (source == pM) {
				vi.pm();
			} else if (source == x2Root) {
				vi.sqrRoot();
			} else if (source == x3Root) {
				vi.cubRoot();
			} else if (source == bS) {
				vi.bS();
			} else if (source == xTo2) {
				vi.pow2();
			} else if (source == xTo3) {
				vi.pow3();
			} else if (source == cl) {
				vi.clear();
			} else if (source == a) {
				vi.add(1.0);
			} else if (source == b) {
				vi.add(2.0);
			} else if (source == c) {
				vi.add(3.0);
			} else if (source == d) {
				vi.add(4.0);
			} else if (source == e) {
				vi.add(5.0);
			} else if (source == f) {
				vi.add(6.0);
			} else if (source == g) {
				vi.add(7.0);
			} else if (source == h) {
				vi.add(8.0);
			} else if (source == i) {
				vi.add(9.0);
			} else if (source == zero) {
				vi.add(0.0);
			} else if (source == point) {
				vi.addPo(".");
			} else if (source == pi) {
				vi.changePi(3.1415926535897932384626433832795028841971693993751058209749445923078164062862, 3.1415);
			} else if (source == xToy) {
				vi.powX();
			}
		}
	}

	public void setInterface(ViewsInterface c2) {
		vi = c2;
	}

	public void setText(String string) {
		txt.setText(string);
	}
}
