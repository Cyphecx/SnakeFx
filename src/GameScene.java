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
import java.util.Arrays;

class GameScene {
    private static Scene gameView;
    private double CELL_INTERVEL = 40;
    ArrayList<Coordinate> snakeSegments;
    Coordinate pellet;
    Direction movementDirection = Direction.RIGHT;
    private double speedFactor = 1;
    GameScene(Stage window){
        snakeSegments = new ArrayList<Coordinate>(Arrays.asList(new Coordinate(1,1), new Coordinate(1,2), new Coordinate(1,2)));
        for (int i = 0; i < 100; i++) {
            snakeSegments.add(new Coordinate(1,1));
        }
        Group root = new Group();
        Canvas game = new Canvas(Main.WINDOW_WIDTH,Main.WINDOW_HEIGHT);
        GraphicsContext paint = game.getGraphicsContext2D();
        spawnPellet();
        root.getChildren().add(game);
        gameView = new Scene(root, window.getWidth(), window.getHeight());
        gameView.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event.getCode());
                switch(event.getCode().toString()) {
                    case "ESCAPE":
                        window.close();
                        break;
                    case "LEFT":
                        if(movementDirection != Direction.RIGHT) {
                            movementDirection = Direction.LEFT;
                        }
                        break;
                    case "RIGHT":
                        if(movementDirection != Direction.LEFT) {
                            movementDirection = Direction.RIGHT;
                        }
                        break;
                    case "UP":
                        if(movementDirection != Direction.DOWN) {
                            movementDirection = Direction.UP;
                        }
                        break;
                    case "DOWN":
                        if(movementDirection != Direction.UP) {
                            movementDirection = Direction.DOWN;
                        }
                        break;
                }
            }
        });
        window.setScene(gameView);
        new AnimationTimer(){
            long lastTimeRan = 0;
            @Override
            public void handle(long now) {

                if(now-lastTimeRan >= speedFactor*50000000) {
                    gameLogic();
                    paintGame(paint);
                    lastTimeRan = now;
                }
            }
        }.start();

   }

    private void gameLogic(){
        Coordinate head = snakeSegments.get(0);
        for (int i = snakeSegments.size()-1; i > 0; i--) {
            snakeSegments.get(i).setX(snakeSegments.get(i-1).getX());
            snakeSegments.get(i).setY(snakeSegments.get(i-1).getY());
        }
        switch(movementDirection) {
            case UP:
                head.setY(head.getY()-1);
                break;
            case DOWN:
                head.setY(head.getY()+1);
                break;

            case LEFT:
                head.setX(head.getX()-1);
                break;

            case RIGHT:
                head.setX(head.getX()+1);
                break;
        }

    }

    private void paintGame(GraphicsContext paint){
        paint.clearRect(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        paint.setFill(Color.CHARTREUSE);
        paint.fillRect(pellet.getX()*CELL_INTERVEL, pellet.getY()*CELL_INTERVEL, CELL_INTERVEL, CELL_INTERVEL);
        paint.setFill(Color.BLACK);
        paint.fillRect(0,Main.WINDOW_HEIGHT-80,Main.WINDOW_WIDTH,80);
        paint.setFill(Color.BLUE);
        paint.setStroke(Color.BLACK);
        paint.setLineWidth(CELL_INTERVEL/8);

        for (Coordinate s: snakeSegments) {
            paint.fillRect((s.getX()*CELL_INTERVEL), (s.getY()*CELL_INTERVEL), CELL_INTERVEL, CELL_INTERVEL);
        }
    }

    void spawnPellet(){
        int x = (int)(Math.random()*(Main.WINDOW_WIDTH/CELL_INTERVEL));
        int y = (int)(Math.random()*((Main.WINDOW_HEIGHT-80)/CELL_INTERVEL));
        pellet = new Coordinate(x,y);
    }
    Scene getGameView(){
        return gameView;
    }

    enum Direction{
        LEFT, RIGHT, UP, DOWN;
    }
}
