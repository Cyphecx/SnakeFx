import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class GameScene {
    static Scene gameView;

    static void startGame(Stage window){

        gameView = new Scene(b, window.getWidth(), window.getHeight());
        window.setScene(gameView);
    }

}
