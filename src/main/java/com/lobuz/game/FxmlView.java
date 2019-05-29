package com.lobuz.game;

public enum FxmlView {
    LOGIN {

        public String getTitle() {
            return "bangla";
        }

        public String getFxmlFile() {
            return "/start.fxml";
        }
    };

    public abstract String getTitle();

    public abstract String getFxmlFile();

}
