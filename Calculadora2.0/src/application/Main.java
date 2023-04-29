package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


//Decimais X
//Multiplas operações X (funciona uma a uma tho VER SE CONSIGO ALTERAR) (gostei do efeito, vou deixar)
//button para apagar tudo X
//button para apagar ultimo digito X
//enumerados X
//adicionei negativos

public class Main extends Application {

    private double xoffset;
    private double yoffset;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../view/CalculatorWindow.fxml"));

        root.setOnMousePressed(event -> {
            xoffset = event.getSceneX();
            yoffset = event.getSceneY();

        });

        root.setOnMouseDragged(e -> {
            primaryStage.setX(e.getScreenX() - xoffset);
            primaryStage.setY(e.getScreenY() - yoffset);
        });

        primaryStage.getIcons().addAll(
                new Image("/img/11.png"),
                new Image("/img/11_32.png"),
                new Image("/img/11_64.png"),
                new Image("/img/11_16.png")
        );
        primaryStage.setScene(new Scene(root,273,481) );
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("CALCULATOR");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



