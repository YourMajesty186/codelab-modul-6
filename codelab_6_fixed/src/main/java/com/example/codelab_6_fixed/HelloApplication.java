package com.example.codelab_6_fixed;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Form Login");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Text pageTitle = new Text("Halaman Login");
        pageTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gridPane.add(pageTitle, 0, 0, 2, 1);

        Label userNameLabel = new Label("User Name:");
        gridPane.add(userNameLabel, 0, 1);

        TextField userTextField = new TextField();
        gridPane.add(userTextField, 1, 1);

        Label passwordLabel = new Label("Password:");
        gridPane.add(passwordLabel, 0, 2);

        PasswordField passwordField = new PasswordField();
        gridPane.add(passwordField, 1, 2);

        Button btn = new Button("Sign In");
        gridPane.add(btn, 2, 4);

        final Text actiontarget = new Text();
        gridPane.add(actiontarget, 1, 6);

        btn.setOnAction(e -> {
            String userName = userTextField.getText();
            String password = passwordField.getText();

            if (validateCredentials(userName, password)) {
                showWelcomeStage(primaryStage);
            } else {
                actiontarget.setText("Passowrd / Username salah");
            }
        });

        Scene scene = new Scene(gridPane, 350, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean validateCredentials(String userName, String password) {
        return "Erlangga".equals(userName) && "123".equals(password);
    }

    private void showWelcomeStage(Stage primaryStage) {
        Stage welcomeStage = new Stage();
        welcomeStage.setTitle("Form 2");

        GridPane welcomeGrid = new GridPane();
        welcomeGrid.setAlignment(Pos.CENTER);
        welcomeGrid.setHgap(10);
        welcomeGrid.setVgap(10);
        welcomeGrid.setPadding(new Insets(25, 25, 25, 25));

        Label welcomeLabel = new Label("Halo Erlangga!");
        welcomeGrid.add(welcomeLabel, 0, 0);

        Button backButton = new Button("Kembali");
        backButton.setOnAction(e -> {
            welcomeStage.close();
            primaryStage.show();
        });
        welcomeGrid.add(backButton, 0, 1);

        Scene welcomeScene = new Scene(welcomeGrid, 300, 200);
        welcomeStage.setScene(welcomeScene);
        welcomeStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
