package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;


public class Framework extends Application {
	
	// Size of scene
	Point2D size = new Point2D(1000, 800);
	
	/* Called automatically when application is setup */
	public void start(Stage stage) {
		Group root = new Group(); // Add to root's children to make objects visible
		Scene scene = new Scene(root, size.getX(), size.getY());
		
		stage.setScene(scene);
		stage.setTitle("My Game");
		scene.setFill(Color.BLACK);
		
		Label fpsLabel = new Label();
		fpsLabel.setTranslateX(2);
		fpsLabel.setTextFill(Color.WHITE);
		
		root.getChildren().add(fpsLabel);
		
		
		/*** INITIALIZE THINGS HERE ***/
		
		
		AnimationTimer loop = new AnimationTimer() {
			double old = -1;
			double elapsedTime = 0;

			public void handle(long nano) {
				if (old < 0) old = nano;
				double delta = (nano - old) / 1e9;
				
				old = nano;
				elapsedTime += delta;
				
				fpsLabel.setText(String.format("%.2f  %.2f", 1/delta, elapsedTime));
				
				/*** GAME LOOP GOES HERE ***/
				
			}
		};
		loop.start();
		
		stage.show();
	}
	
	
	/* Main method sets up application */
	public static void main(String[] args) {
		launch(args);
	}
}
