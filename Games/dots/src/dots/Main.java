package dots;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    Stage stage;
    Rectangle a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
    Rectangle c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
    Rectangle e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10;
    Rectangle g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, h1, h2, h3, h4, h5, h6, h7, h8, h9, h10;
    Rectangle i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, j1, j2, j3, j4, j5, j6, j7, j8, j9, j10;

    @Override public void start(Stage primaryStage) {
		stage = primaryStage;

		a1 = new Rectangle(50, 50); a1.setFill(Color.WHITE);
		a2 = new Rectangle(50, 50); a2.setFill(Color.WHITE);
		a3 = new Rectangle(50, 50); a3.setFill(Color.WHITE);
		a4 = new Rectangle(50, 50); a4.setFill(Color.WHITE);
		a5 = new Rectangle(50, 50); a5.setFill(Color.WHITE);
		a6 = new Rectangle(50, 50); a6.setFill(Color.WHITE);
		a7 = new Rectangle(50, 50); a7.setFill(Color.WHITE);
		a8 = new Rectangle(50, 50); a8.setFill(Color.WHITE);
		a9 = new Rectangle(50, 50); a9.setFill(Color.WHITE);
		a10 = new Rectangle(50, 50); a10.setFill(Color.WHITE);

		b1 = new Rectangle(50, 50); b1.setFill(Color.WHITE);
		b2 = new Rectangle(50, 50); b2.setFill(Color.WHITE);
		b3 = new Rectangle(50, 50); b3.setFill(Color.WHITE);
		b4 = new Rectangle(50, 50); b4.setFill(Color.WHITE);
		b5 = new Rectangle(50, 50); b5.setFill(Color.WHITE);
		b6 = new Rectangle(50, 50); b6.setFill(Color.WHITE);
		b7 = new Rectangle(50, 50); b7.setFill(Color.WHITE);
		b8 = new Rectangle(50, 50); b8.setFill(Color.WHITE);
		b9 = new Rectangle(50, 50); b9.setFill(Color.WHITE);
		b10 = new Rectangle(50, 50); b10.setFill(Color.WHITE);
		
		c1 = new Rectangle(50, 50); c1.setFill(Color.WHITE);
		c2 = new Rectangle(50, 50); c2.setFill(Color.WHITE);
		c3 = new Rectangle(50, 50); c3.setFill(Color.WHITE);
		c4 = new Rectangle(50, 50); c4.setFill(Color.WHITE);
		c5 = new Rectangle(50, 50); c5.setFill(Color.WHITE);
		c6 = new Rectangle(50, 50); c6.setFill(Color.WHITE);
		c7 = new Rectangle(50, 50); c7.setFill(Color.WHITE);
		c8 = new Rectangle(50, 50); c8.setFill(Color.WHITE);
		c9 = new Rectangle(50, 50); c9.setFill(Color.WHITE);
		c10 = new Rectangle(50, 50); c10.setFill(Color.WHITE);

		d1 = new Rectangle(50, 50); d1.setFill(Color.WHITE);
		d2 = new Rectangle(50, 50); d2.setFill(Color.WHITE);
		d3 = new Rectangle(50, 50); d3.setFill(Color.WHITE);
		d4 = new Rectangle(50, 50); d4.setFill(Color.WHITE);
		d5 = new Rectangle(50, 50); d5.setFill(Color.WHITE);
		d6 = new Rectangle(50, 50); d6.setFill(Color.WHITE);
		d7 = new Rectangle(50, 50); d7.setFill(Color.WHITE);
		d8 = new Rectangle(50, 50); d8.setFill(Color.WHITE);
		d9 = new Rectangle(50, 50); d9.setFill(Color.WHITE);
		d10 = new Rectangle(50, 50); d10.setFill(Color.WHITE);

		e1 = new Rectangle(50, 50); e1.setFill(Color.WHITE);
		e2 = new Rectangle(50, 50); e2.setFill(Color.WHITE);
		e3 = new Rectangle(50, 50); e3.setFill(Color.WHITE);
		e4 = new Rectangle(50, 50); e4.setFill(Color.WHITE);
		e5 = new Rectangle(50, 50); e5.setFill(Color.WHITE);
		e6 = new Rectangle(50, 50); e6.setFill(Color.WHITE);
		e7 = new Rectangle(50, 50); e7.setFill(Color.WHITE);
		e8 = new Rectangle(50, 50); e8.setFill(Color.WHITE);
		e9 = new Rectangle(50, 50); e9.setFill(Color.WHITE);
		e10 = new Rectangle(50, 50); e10.setFill(Color.WHITE);

		f1 = new Rectangle(50, 50); f1.setFill(Color.WHITE);
		f2 = new Rectangle(50, 50); f2.setFill(Color.WHITE);
		f3 = new Rectangle(50, 50); f3.setFill(Color.WHITE);
		f4 = new Rectangle(50, 50); f4.setFill(Color.WHITE);
		f5 = new Rectangle(50, 50); f5.setFill(Color.WHITE);
		f6 = new Rectangle(50, 50); f6.setFill(Color.WHITE);
		f7 = new Rectangle(50, 50); f7.setFill(Color.WHITE);
		f8 = new Rectangle(50, 50); f8.setFill(Color.WHITE);
		f9 = new Rectangle(50, 50); f9.setFill(Color.WHITE);
		f10 = new Rectangle(50, 50); f10.setFill(Color.WHITE);

		g1 = new Rectangle(50, 50); g1.setFill(Color.WHITE);
		g2 = new Rectangle(50, 50); g2.setFill(Color.WHITE);
		g3 = new Rectangle(50, 50); g3.setFill(Color.WHITE);
		g4 = new Rectangle(50, 50); g4.setFill(Color.WHITE);
		g5 = new Rectangle(50, 50); g5.setFill(Color.WHITE);
		g6 = new Rectangle(50, 50); g6.setFill(Color.WHITE);
		g7 = new Rectangle(50, 50); g7.setFill(Color.WHITE);
		g8 = new Rectangle(50, 50); g8.setFill(Color.WHITE);
		g9 = new Rectangle(50, 50); g9.setFill(Color.WHITE);
		g10 = new Rectangle(50, 50); g10.setFill(Color.WHITE);

		h1 = new Rectangle(50, 50); h1.setFill(Color.WHITE);
		h2 = new Rectangle(50, 50); h2.setFill(Color.WHITE);
		h3 = new Rectangle(50, 50); h3.setFill(Color.WHITE);
		h4 = new Rectangle(50, 50); h4.setFill(Color.WHITE);
		h5 = new Rectangle(50, 50); h5.setFill(Color.WHITE);
		h6 = new Rectangle(50, 50); h6.setFill(Color.WHITE);
		h7 = new Rectangle(50, 50); h7.setFill(Color.WHITE);
		h8 = new Rectangle(50, 50); h8.setFill(Color.WHITE);
		h9 = new Rectangle(50, 50); h9.setFill(Color.WHITE);
		h10 = new Rectangle(50, 50); h10.setFill(Color.WHITE);

		i1 = new Rectangle(50, 50); i1.setFill(Color.WHITE);
		i2 = new Rectangle(50, 50); i2.setFill(Color.WHITE);
		i3 = new Rectangle(50, 50); i3.setFill(Color.WHITE);
		i4 = new Rectangle(50, 50); i4.setFill(Color.WHITE);
		i5 = new Rectangle(50, 50); i5.setFill(Color.WHITE);
		i6 = new Rectangle(50, 50); i6.setFill(Color.WHITE);
		i7 = new Rectangle(50, 50); i7.setFill(Color.WHITE);
		i8 = new Rectangle(50, 50); i8.setFill(Color.WHITE);
		i9 = new Rectangle(50, 50); i9.setFill(Color.WHITE);
		i10 = new Rectangle(50, 50); i10.setFill(Color.WHITE);

		j1 = new Rectangle(50, 50); j1.setFill(Color.WHITE);
		j2 = new Rectangle(50, 50); j2.setFill(Color.WHITE);
		j3 = new Rectangle(50, 50); j3.setFill(Color.WHITE);
		j4 = new Rectangle(50, 50); j4.setFill(Color.WHITE);
		j5 = new Rectangle(50, 50); j5.setFill(Color.WHITE);
		j6 = new Rectangle(50, 50); j6.setFill(Color.WHITE);
		j7 = new Rectangle(50, 50); j7.setFill(Color.WHITE);
		j8 = new Rectangle(50, 50); j8.setFill(Color.WHITE);
		j9 = new Rectangle(50, 50); j9.setFill(Color.WHITE);
		j10 = new Rectangle(50, 50); j10.setFill(Color.WHITE);
		
		Rectangle back = new Rectangle(550, 550); back.setFill(Color.DARKGRAY);

		HBox a = new HBox(1, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
		HBox b = new HBox(1, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10);
		HBox c = new HBox(1, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10);
		HBox d = new HBox(1, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10);
		HBox e = new HBox(1, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
		HBox f = new HBox(1, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10);
		HBox g = new HBox(1, g1, g2, g3, g4, g5, g6, g7, g8, g9, g10);
		HBox h = new HBox(1, h1, h2, h3, h4, h5, h6, h7, h8, h9, h10);
		HBox i = new HBox(1, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10);
		HBox j = new HBox(1, j1, j2, j3, j4, j5, j6, j7, j8, j9, j10);
		
		VBox vbox = new VBox(1, a, b, c, d, e, f, g, h, i, j);
		StackPane pane = new StackPane(back, vbox);
		BorderPane paneMain = new BorderPane(pane);

		Scene scene = new Scene(paneMain);
		primaryStage.setScene(scene);
		primaryStage.setMinHeight(556);
		primaryStage.setMinWidth(527);
		primaryStage.setTitle("Dots");
		primaryStage.show();
	}
}

