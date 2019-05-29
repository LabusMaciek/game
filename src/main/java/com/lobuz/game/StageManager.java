package com.lobuz.game;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class StageManager {


    private final SpringFXMLLoader springFXMLLoader;
    private final Stage primaryStage;


    public StageManager(SpringFXMLLoader springFXMLLoader, Stage primaryStage) {
        this.springFXMLLoader = springFXMLLoader;
        this.primaryStage = primaryStage;
    }


    public void switchScene(final FxmlView view) {
        System.out.println(view.getFxmlFile());
        Parent viewRoot = loadViewNodeHierarchy(view.getFxmlFile());
        show(viewRoot, view.getTitle());
    }


    private Parent loadViewNodeHierarchy(String fxmlFilePath) {
        Parent rootNode = null;
        try {
            rootNode = springFXMLLoader.load(fxmlFilePath);
            Objects.requireNonNull(rootNode, "A Root FXML node must not be null");
        } catch (Exception exception) {
            System.out.println("Unable to load FXML view");
        }
        return rootNode;
    }


    private void show(final Parent rootnode, String title) {
        Scene scene = prepareScene(rootnode);

        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
//        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
//        primaryStage.getIcons().add(new Image(Controller.class.getResourceAsStream("/icon/icon.png")));

        primaryStage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });

        try {
            primaryStage.show();
        } catch (Exception exception) {
            System.out.println("Unable to show scene for title");
        }
    }

    private Scene prepareScene(Parent rootNode) {
        Scene scene = primaryStage.getScene();

        if (scene == null) {
            scene = new Scene(rootNode);
        }
        scene.setRoot(rootNode);
        return scene;
    }
}
