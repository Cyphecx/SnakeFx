import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    Stage window;
    Scene TitleScreen;
    static int WINDOW_HEIGHT = 500;
    static int WINDOW_WIDTH = 800;

    public static void main(String[] args) {
       launch(args);
    }

    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        Label titleStylized = new Label("Snake now with FX");

        Button startGame = new Button();
        startGame.setText("Start a new Game!");
        startGame.setOnAction(e -> GameScene.startGame(window));

        Button openSettings = new Button("Settings");
        openSettings.setOnAction(e -> System.out.println("Opened Settings"));

        Button closeGame = new Button("Exit to Desktop");
        closeGame.setOnAction(e -> quitGame());

        ChoiceBox<String> difficultySelector = new ChoiceBox<String>();
        difficultySelector.getItems().addAll("Easy", "Normal","Hard");

        VBox test = new VBox(10);
        test.getChildren().addAll(titleStylized, startGame, difficultySelector, openSettings, closeGame);
        test.setAlignment(Pos.BASELINE_CENTER);


        TitleScreen = new Scene(test, WINDOW_HEIGHT, WINDOW_WIDTH);

        window.setScene(TitleScreen);
        window.setOnCloseRequest(e -> {
            e.consume();
            quitGame();
        });
        window.show();
    }

    Scene getTitleScene(){
        return TitleScreen;
    }
    void quitGame(){
        window.close();
    }
}
