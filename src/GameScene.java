import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GameScene {
    private static Scene gameView;
    private double CELL_INTERVEL = 20;
    ArrayList<Coordinate> snakeSegments;
    Direction movementDirection = Direction.RIGHT;

    GameScene(Stage window){
        snakeSegments = new ArrayList<Coordinate>();
        Group root = new Group();
        Canvas game = new Canvas(Main.WINDOW_WIDTH,Main.WINDOW_HEIGHT);
        GraphicsContext paint = game.getGraphicsContext2D();

        root.getChildren().add(game);
        gameView = new Scene(root, window.getWidth(), window.getHeight());
        gameView.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event.getCode());
                switch(event.getCode().toString()){
                    case "ESCAPE":
                        window.close();
                        break;
                }
            }
        });
        window.setScene(gameView);

        for (int i = 2; i < 13; i++) {
            snakeSegments.add(new Coordinate(i,i));
        }
        new AnimationTimer(){
            @Override
            public void handle(long now) {
                gameLogic();
                paintGame(paint);
            }
        }.start();

   }

    private void gameLogic(){

        switch(movementDirection) {
            case UP:

                break;

            case DOWN:

                break;

            case LEFT:

                break;

            case RIGHT:

                break;
        }


    }

    private void paintGame(GraphicsContext paint){
        paint.clearRect(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        paint.setFill(Color.BLUE);
        paint.setStroke(Color.BLACK);
        paint.setLineWidth(CELL_INTERVEL/3);

        for (Coordinate s: snakeSegments) {
            paint.fillRect((s.getX()*CELL_INTERVEL), (s.getY()*CELL_INTERVEL), CELL_INTERVEL, CELL_INTERVEL);
            paint.strokeRect((s.getX()*CELL_INTERVEL), (s.getY()*CELL_INTERVEL), CELL_INTERVEL, CELL_INTERVEL);

        }
    }

    Scene getGameView(){
        return gameView;
    }

    enum Direction{
        LEFT, RIGHT, UP, DOWN;
    }
}
