import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{

    Stage window;
    Scene bScene;

    public static void main(String[] args) {
       launch(args);
    }

    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        Button changeScenes = new Button();
        changeScenes.setText("Lets change scenes");
        changeScenes.setOnAction(e -> {
            AlertBox.display("Hi", "Meow");
            if(AlertBox.choice){
                System.out.println("hel");
            }
            else{
                System.out.println("na");
            }
        });
        bScene = new Scene(changeScenes, 400, 400);

        window.setScene(bScene);
        window.show();
    }

}
