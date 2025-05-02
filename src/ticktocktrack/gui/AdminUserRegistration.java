package ticktocktrack.gui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;

public class AdminUserRegistration {

    private static Pane createBasePanel() {
        Pane basePanel = new Pane();
        basePanel.setPrefSize(970, 560);
        basePanel.setStyle("-fx-background-color: WHITE; -fx-background-radius: 20;");
        basePanel.setLayoutX(40);
        basePanel.setLayoutY(45);

        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.rgb(0, 0, 0, 0.5));
        shadow.setRadius(15);
        shadow.setOffsetX(0);
        shadow.setOffsetY(0);
        shadow.setSpread(0.1);
        basePanel.setEffect(shadow);

        return basePanel;
    }

    private static Button createExitButton(Pane panel) {
        Button exitButton = new Button("X");
        exitButton.setLayoutX(920);
        exitButton.setLayoutY(20);
        exitButton.setStyle("-fx-background-color: red; " +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 14px; " +
                            "-fx-padding: 10px; " +
                            "-fx-background-radius: 12px;");
        exitButton.setCursor(Cursor.HAND);

        exitButton.setOnAction(e -> panel.setVisible(false));

        return exitButton;
    }

    private static Button createDoneButton(double x, double y) {
        Button doneButton = new Button("Done");
        doneButton.setPrefSize(150, 50);
        doneButton.setLayoutX(x);
        doneButton.setLayoutY(y);
        doneButton.setStyle("-fx-background-color: #02383E; " +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 16px; " +
                            "-fx-font-weight: bold; " +
                            "-fx-background-radius: 8px;");
        doneButton.setCursor(Cursor.HAND);

        return doneButton;
    }

    private static TextField createTextField(String prompt, double x, double y) {
        TextField textField = new TextField();
        textField.setPromptText(prompt);
        textField.setPrefSize(480, 60);
        textField.setLayoutX(x);
        textField.setLayoutY(y);
        textField.setStyle(
            "-fx-border-color: #02383E;" +
            "-fx-border-width: 2px;" +
            "-fx-background-radius: 12px;" +
            "-fx-border-radius: 12px;" +    // << Add this
            "-fx-background-color: white;"
        );
        return textField;
    }

    private static PasswordField createPasswordField(String prompt, double x, double y) {
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText(prompt);
        passwordField.setPrefSize(480, 60);
        passwordField.setLayoutX(x);
        passwordField.setLayoutY(y);
        passwordField.setStyle(
            "-fx-border-color: #02383E;" +
            "-fx-border-width: 2px;" +
            "-fx-background-radius: 12px;" +
            "-fx-border-radius: 12px;" +    // << Add this
            "-fx-background-color: white;"
        );
        return passwordField;
    }

    public static class FacultyRegistrationPanel {
        public static Pane createPanel() {
            Pane facultyRegistrationPanel = createBasePanel();

            Text title = new Text("Faculty Registration");
            title.setFont(Font.font("Poppins", FontWeight.BOLD, 36));
            title.setFill(Color.web("#02383E"));
            title.setLayoutX(313);
            title.setLayoutY(70);
            facultyRegistrationPanel.getChildren().add(title);

            Button exitButton = createExitButton(facultyRegistrationPanel);
            facultyRegistrationPanel.getChildren().add(exitButton);

            double startX = 225;
            double startY = 100;
            double gap = 80;

            TextField emailField = createTextField("Email Address", startX, startY);
            TextField usernameField = createTextField("Username", startX, startY + gap * 1);

         // Create the ComboBox for Role
            ComboBox<String> roleComboBox = new ComboBox<>();
            roleComboBox.getItems().addAll("Admin", "Teacher"); 
            roleComboBox.setLayoutX(startX);
            roleComboBox.setLayoutY(startY + gap * 2);
            roleComboBox.setPrefSize(480, 60);
            roleComboBox.setPromptText("Role"); 

            // Style for transparent background and dark teal dropdown
            String comboBoxBaseStyle = ""
                + "-fx-background-color: transparent;"    // transparent background
                + "-fx-text-fill: #02383E;"                 // dark teal text
                + "-fx-prompt-text-fill: #02383E;"           // dark teal prompt text
                + "-fx-border-color: #02383E;"               // dark teal border
                + "-fx-border-width: 2px;"
                + "-fx-background-radius: 12px;"             // curved base
                + "-fx-border-radius: 12px;";

            roleComboBox.setStyle(comboBoxBaseStyle);

            // Maintain style on selection
            roleComboBox.setOnAction(event -> {
                roleComboBox.setStyle(comboBoxBaseStyle);
            });
            PasswordField passwordField = createPasswordField("Password", startX, startY + gap * 3);
            PasswordField confirmPasswordField = createPasswordField("Confirm Password", startX, startY + gap * 4);

            Button doneButton = createDoneButton(800, 490);

            facultyRegistrationPanel.getChildren().addAll(
                    emailField,  usernameField, roleComboBox, passwordField, confirmPasswordField, doneButton
            );

            return facultyRegistrationPanel;
        }
    }


    public static class StudentRegistrationPanel {
        public static Pane createPanel() {
            Pane studentRegistrationPanel = createBasePanel();

            Text title = new Text("Student Registration");
            title.setFont(Font.font("Poppins", FontWeight.BOLD, 36));
            title.setFill(Color.web("#02383E"));
            title.setLayoutX(308);
            title.setLayoutY(70);
            studentRegistrationPanel.getChildren().add(title);

            Button exitButton = createExitButton(studentRegistrationPanel);
            studentRegistrationPanel.getChildren().add(exitButton);

            double startX = 225;
            double startY = 100;
            double gap = 70;

            TextField emailField = createTextField("Email Address", startX, startY);
            TextField usernameField = createTextField("Username", startX, startY + gap);
            TextField lastNameField = createTextField("Last Name", startX, startY + gap * 2);

            // For First Name and Middle Name on the same line
            double smallFieldWidth = 235;  // Half-width fields
            double smallGap = 10;           // Gap between first and middle name fields

            TextField firstNameField = createTextField("First Name", startX, startY + gap * 3);
            firstNameField.setPrefWidth(smallFieldWidth);

            TextField middleNameField = createTextField("Middle Name", startX + smallFieldWidth + smallGap, startY + gap * 3);
            middleNameField.setPrefWidth(smallFieldWidth);

            PasswordField passwordField = createPasswordField("Password", startX, startY + gap * 4);
            PasswordField confirmPasswordField = createPasswordField("Confirm Password", startX, startY + gap * 5);

            Button doneButton = createDoneButton(800, 490);

            studentRegistrationPanel.getChildren().addAll(
                    emailField, usernameField, lastNameField,
                    firstNameField, middleNameField,
                    passwordField, confirmPasswordField,
                    doneButton
            );

            return studentRegistrationPanel;
        }
    }

}