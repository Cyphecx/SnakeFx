import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Main extends Application{

    Stage window;
    Scene TitleScreen;
    static int WINDOW_HEIGHT = 1010;
    static int WINDOW_WIDTH = 1920;

    public static void main(String[] args) {
       launch(args);
    }

    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        TextFlow titleText = new TextFlow();
        titleText.setTextAlignment(TextAlignment.CENTER);
        Text part1 = new Text("Snake!");
        part1.setFont(Font.font(100));
        Text part2 = new Text(" Now with FX!");
        part2.setFont(Font.font(100));
        titleText.getChildren().addAll(part1, part2);
        titleText.setId("titleText");

        Button startGame = new Button();
        startGame.setText("Start a new Game!");
        startGame.setOnAction(e -> new GameScene(window));
        //In case I want to add a settings menu
        Button openSettings = new Button("Settings");
        openSettings.setOnAction(e -> System.out.println("Opened Settings"));

        Button closeGame = new Button("Exit to Desktop");
        closeGame.setOnAction(e -> quitGame());

        ChoiceBox<String> difficultySelector = new ChoiceBox<String>();
        difficultySelector.getItems().addAll("Easy", "Normal","Hard");
        difficultySelector.getSelectionModel().selectFirst();

        VBox test = new VBox(10);
        test.getChildren().addAll(/*titleStylized*/titleText, startGame, difficultySelector, /*openSettings,*/ closeGame);
        test.setAlignment(Pos.BASELINE_CENTER);


        TitleScreen = new Scene(test,WINDOW_WIDTH,WINDOW_HEIGHT);
        TitleScreen.getStylesheets().add("style.css");
        window.setScene(TitleScreen);
        window.setTitle("Snake");
        window.setOnCloseRequest(e -> {
            e.consume();
            quitGame();
        });
        window.show();
        window.setMaximized(true);
    }

    Scene getTitleScene(){
        return TitleScreen;
    }
    void quitGame(){
        window.close();
    }
}
