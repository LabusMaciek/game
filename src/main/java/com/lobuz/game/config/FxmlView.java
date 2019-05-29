package com.lobuz.game.config;

public enum FxmlView {
    LOGIN {
        public String getTitle() {
            return "bangla";
        }

        public String getFxmlFile() {
            return "/view/start/start.fxml";
        }
    };

    public abstract String getTitle();

    public abstract String getFxmlFile();

}
