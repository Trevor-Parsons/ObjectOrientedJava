package proj6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Battleship extends Application {

	@Override
	public void start(Stage window) throws Exception {
		// Variables for potential gameplay
		int numHits = 0;
		int numMisses = 0; 
		int numSunk = 0;
		
		// gridPane gameBoard that will hold an array of buttons for gameplay
		GridPane gameBoard = new GridPane();
		
		
		// Adding game play variables to GridPane display
		gameBoard.add(new Label("    Hits"), 0, 0);
		gameBoard.add(new Label("      " + Integer.toString(numHits)), 0, 1);
		gameBoard.add(new Label("  Misses  "), 0, 4);
		gameBoard.add(new Label("      " + Integer.toString(numMisses)), 0, 5);
		gameBoard.add(new Label("   Sunk"), 0, 8);
		gameBoard.add(new Label("      " + Integer.toString(numSunk)), 0, 9);
		
		// Creating a 10x10 array of buttons that resize with the window
		Button[][] buttons = new Button[10][10];
		
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				buttons[i][j] = new Button();
				buttons[i][j].setText("0");
				buttons[i][j].setMaxHeight(Double.MAX_VALUE);
				buttons[i][j].setMaxWidth(Double.MAX_VALUE);
				GridPane.setHgrow(buttons[i][j], Priority.ALWAYS);
				GridPane.setVgrow(buttons[i][j], Priority.ALWAYS);
			}
		}
		
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				gameBoard.add(buttons[i][j], i + 1, j);
			}
		}
	
		// Initialization of BorderPane that will hold the gameBoard GridPane
		BorderPane border = new BorderPane();
		
		// Formatting of the BorderPane
		String gameText = "Try to sink my battleship!";
		border.setCenter(gameBoard);
		Label topText = new Label(gameText);
		border.setTop(topText);
		BorderPane.setAlignment(topText, Pos.CENTER);
		BorderPane.setMargin(topText, new Insets(10));
		
		window.setScene(new Scene(border));
		window.setTitle("Battleship");
		window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}