import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GameScene {
    private static Scene gameView;
    private int CELL_INTERVEL = 20;
    ArrayList<Rectangle> snakeSegments;

    GameScene(Stage window){
        snakeSegments = new ArrayList<Rectangle>();
        Group root = new Group();
        Canvas game = new Canvas(Main.WINDOW_WIDTH,Main.WINDOW_HEIGHT);
        GraphicsContext paint = game.getGraphicsContext2D();

        root.getChildren().add(game);
        gameView = new Scene(root, window.getWidth(), window.getHeight());
        window.setScene(gameView);

        snakeSegments.add(new Rectangle());
        boolean isGameRunning = true;
        while(isGameRunning){
            paintGame(paint);
        }
    }

    private void gameLogic(){

    }


    Scene getGameView(){
        return gameView;
    }

    private void paintGame(GraphicsContext paint){
        paint.setFill(Color.BLACK);
        paint.fillRect(100,100,100,100);

    }
}
