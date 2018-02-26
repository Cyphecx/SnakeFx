import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GameScene {
    private static Scene gameView;
    private double CELL_INTERVEL = 20;
    ArrayList<Coordinate> snakeSegments;

    GameScene(Stage window){
        snakeSegments = new ArrayList<Coordinate>();
        Group root = new Group();
        Canvas game = new Canvas(Main.WINDOW_WIDTH,Main.WINDOW_HEIGHT);
        GraphicsContext paint = game.getGraphicsContext2D();

        root.getChildren().add(game);
        gameView = new Scene(root, window.getWidth(), window.getHeight());
        window.setScene(gameView);

        snakeSegments.add(new Coordinate(4,4));
        new AnimationTimer(){
            int i = 0;
            @Override
            public void handle(long now) {
                gameLogic();
                paintGame(paint);
            }
        }.start();

   }

    private void gameLogic(){



    }

    private void paintGame(GraphicsContext paint){
        paint.clearRect(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        paint.setFill(Color.BLACK);
        for (Coordinate s: snakeSegments) {
            paint.fillRect((s.getX()*CELL_INTERVEL), (s.getY()*CELL_INTERVEL), CELL_INTERVEL, CELL_INTERVEL);
        }
    }

    Scene getGameView(){
        return gameView;
    }


}
