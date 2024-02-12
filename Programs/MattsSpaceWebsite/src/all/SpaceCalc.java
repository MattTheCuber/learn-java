package all;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class SpaceCalc extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Button convert;
    Stage stage;
    Double totalDouble = 0.0;
    Label totalLbl, eql, howMLbl, lbl1, lbl2;
    TextField howMF;
    ChoiceBox<String> from, to;

    @Override public void start(Stage primaryStage) {
		stage = primaryStage;
		
		eql = new Label("=");
		totalLbl = new Label();
		howMLbl = new Label("How much? ");
		lbl1 = new Label("From: ");
		lbl2 = new Label("To: ");

		from = new ChoiceBox<String>();
		from.getItems().addAll("Astronomical unit", "Light Year", "Light Minute", "Mile",
				"Kilometer", "Foot");
		from.setValue("Astronomical unit");
		to = new ChoiceBox<String>();
		to.getItems().addAll("Astronomical unit", "Light Year", "Light Minute", "Mile",
				"Kilometer", "Foot");
		to.setValue("Mile");
		
		howMF = new TextField();
		
		convert = new Button("Convert");
		convert.setOnAction(e -> convert());

		HBox top = new HBox(5, lbl1, from, lbl2, to);
		HBox middle = new HBox(5, howMLbl, howMF);
		HBox bottom = new HBox(5, convert, eql, totalLbl);
		top.setPadding(new Insets(5, 5, 5, 5));
		middle.setPadding(new Insets(5, 5, 5, 5));
		bottom.setPadding(new Insets(5, 5, 5, 5));
		VBox pane = new VBox(10, top, middle, bottom);
		BorderPane paneMain = new BorderPane(pane);

		Scene scene = new Scene(paneMain);
		scene.getStylesheets().add(getClass().getResource("calc.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setWidth(450);
		primaryStage.setTitle("Hows my website");
		primaryStage.show();
	}
	public void convert() {
		String whatFrom = from.getValue();
		String whatTo = to.getValue();
		double amount = Double.parseDouble(howMF.getText());

		if ((whatFrom.equals("Astronomical unit")) && (whatTo.equals("Mile"))) {
			totalDouble = amount * 92955807.267;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Astronomical unit")) && (whatTo.equals("Kilometer"))) {
			totalDouble = amount * 149597870.69;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Kilometer")) && (whatTo.equals("Astronomical unit"))) {
			totalDouble = amount * 0.0000000066845871227;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Mile")) && (whatTo.equals("Astronomical unit"))) {
			totalDouble = amount * 0.000000010757800178;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Mile")) && (whatTo.equals("Kilometer"))) {
			totalDouble = amount *  1.609344;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Kilometer")) && (whatTo.equals("Mile"))) {
			totalDouble = amount *  0.62137119224;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Astronomical unit")) && (whatTo.equals("Foot"))) {
			totalDouble = amount * 490806662370.0;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Foot")) && (whatTo.equals("Astronomical unit"))) {
			totalDouble = amount * 0.000000000002037462155;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Foot")) && (whatTo.equals("Mile"))) {
			totalDouble = amount * 0.00016457883369;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Mile")) && (whatTo.equals("Foot"))) {
			totalDouble = amount * 6076.1154856;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Foot")) && (whatTo.equals("Kilometer"))) {
			totalDouble = amount * 0.0003048;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Kilometer")) && (whatTo.equals("Foot"))) {
			totalDouble = amount * 3280.839895;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Astronomical unit")) && (whatTo.equals("Light Year"))) {
			totalDouble = amount * 0.000015823337893;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Light Year")) && (whatTo.equals("Astronomical unit"))) {
			totalDouble = amount * 63197.79093;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Light Year")) && (whatTo.equals("Foot"))) {
			totalDouble = amount * 31017896836000000.0;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Foot")) && (whatTo.equals("Light Year"))) {
			totalDouble = amount * 0.000000000000000032239452123;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Light Year")) && (whatTo.equals("Mile"))) {
			totalDouble = amount * 5104889284800.0;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Mile")) && (whatTo.equals("Light Year"))) {
			totalDouble = amount * 0.00000000000019589063429;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Light Year")) && (whatTo.equals("Kilometer"))) {
			totalDouble = amount * 9454254955500.0;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Kilometer")) && (whatTo.equals("Light Year"))) {
			totalDouble = amount * 0.00000000000010577248072;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Light Minute")) && (whatTo.equals("Mile"))) {
			totalDouble = amount * 9712498.6393;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Mile")) && (whatTo.equals("Light Minute"))) {
			totalDouble = amount * 0.00000010296011738;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Light Minute")) && (whatTo.equals("Kilometer"))) {
			totalDouble = amount * 17987547.48;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Kilometer")) && (whatTo.equals("Light Minute"))) {
			totalDouble = amount * 0.000000055594015866;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Light Minute")) && (whatTo.equals("Light Year"))) {
			totalDouble = amount * 0.000001902587519;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Light Year")) && (whatTo.equals("Light Minute"))) {
			totalDouble = amount * 525600.0;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Light Minute")) && (whatTo.equals("Foot"))) {
			totalDouble = amount * 59014263386.0;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Foot")) && (whatTo.equals("Light Minute"))) {
			totalDouble = amount * 0.000000000016945056036;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Light Minute")) && (whatTo.equals("Astronomical unit"))) {
			totalDouble = amount * 0.12023932825;
			totalLbl.setText(totalDouble.toString());
		} else if ((whatFrom.equals("Astronomical unit")) && (whatTo.equals("Light Minute"))) {
			totalDouble = amount * 8.3167463967;
			totalLbl.setText(totalDouble.toString());
		} else {
			totalLbl.setText("Wrong input");
		}
	}
}
