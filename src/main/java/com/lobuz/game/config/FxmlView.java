package com.lobuz.game.config;

public enum FxmlView {
    START {
        public String getTitle() {
            return "quiz by lobuz";
        }

        public String getFxmlFile() {
            return "/view/start.fxml";
        }
    },
    GAME {
        public String getTitle() {
            return "quiz by lobuz";
        }

        public String getFxmlFile() {
            return "/view/game.fxml";
        }

    },
    FINISH {
        public String getTitle() {
            return "quiz by lobuz";
        }

        public String getFxmlFile() {
            return "/view/finish.fxml";
        }

    };

    public abstract String getTitle();

    public abstract String getFxmlFile();

}
