import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameScene {
    private static Scene gameView;

    static void startGame(Stage window){
        Group root = new Group();
        gameView = new Scene(root, window.getWidth(), window.getHeight());
        window.setScene(gameView);
    }



    Scene getGameView(){
        return gameView;
    }

}
