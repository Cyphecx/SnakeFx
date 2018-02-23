import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameScene {
    private static Scene gameView;

    GameScene(Stage window){
        Group root = new Group();
        Canvas game = new Canvas();
        StackPane layout = new StackPane();
        layout.getChildren().add(game);
        root.getChildren().add(layout);
        GraphicsContext paint = game.getGraphicsContext2D();
        gameView = new Scene(root, window.getWidth(), window.getHeight());
        window.setScene(gameView);
        paintGame(paint);
    }



    Scene getGameView(){
        return gameView;
    }

    private void paintGame(GraphicsContext paint){
        paint.setFill(Color.BLACK);
        paint.fillRect(100,100,100,100);
    }
}
