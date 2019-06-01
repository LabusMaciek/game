package com.lobuz.game.config;

import java.util.Objects;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StageManager {

    private final SpringFXMLLoader springFXMLLoader;
    private final Stage primaryStage;

    public StageManager(SpringFXMLLoader springFXMLLoader, Stage primaryStage) {
        this.springFXMLLoader = springFXMLLoader;
        this.primaryStage = primaryStage;
    }

    public void switchScene(final FxmlView view) {
        Parent viewRoot = loadViewNodeHierarchy(view.getFxmlFile());
        show(viewRoot, view.getTitle());
    }

    private Parent loadViewNodeHierarchy(String fxmlFilePath) {
        Parent rootNode = null;
        try {
            rootNode = springFXMLLoader.load(fxmlFilePath);
            Objects.requireNonNull(rootNode, "A Root FXML node must not be null");
        } catch (Exception e) {
            log.error("Error during load FXML view ", e);
        }
        return rootNode;
    }

    private void show(final Parent rootnode, String title) {
        Scene scene = prepareScene(rootnode);

        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
        primaryStage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });

        try {
            primaryStage.show();
        } catch (Exception e) {
            log.error("Unable to show scene for title");
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
