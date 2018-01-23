import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    static boolean choice;

    public static void display(String title, String message){
        Stage window = new Stage();

        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(300);

        Label text = new Label(message);

        Button yes = new Button("Yes");
        yes.setOnAction(e -> {
            choice = true;
            window.close();
        });
        Button no = new Button("No");
        no.setOnAction(e -> {
            choice = false;
            window.close();
        });

        VBox lay = new VBox(10);
        lay.getChildren().addAll(text,yes, no);
        lay.setAlignment(Pos.CENTER);

        Scene scene = new Scene(lay, 300,200);

        window.setScene(scene);
        window.setAlwaysOnTop(true);
        window.showAndWait();
    }
}
