package ticktocktrack.gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class TeacherDashboardCenterPanel {

    public static Pane createPanel() {
        // Create the center panel
        Pane centerPanel = new Pane();
        centerPanel.setPrefSize(1300, 750);
        centerPanel.setLayoutX(0);
        centerPanel.setLayoutY(0);
        centerPanel.setStyle("-fx-background-color: white; -fx-border-color: #cccccc; -fx-border-width: 1px;");
        
        // Shadow image
        String shadowPath = TeacherDashboardCenterPanel.class.getResource("/resources/SHADOW.png").toExternalForm();
        ImageView shadowView = new ImageView(new Image(shadowPath));
        shadowView.setFitWidth(1300);
        shadowView.setFitHeight(250);
        shadowView.setLayoutX(0);
        shadowView.setLayoutY(-115);

        // Create the "Teacher Dashboard" Text
        Text dashboardTitle = new Text("Teacher Dashboard");
        dashboardTitle.setFont(Font.font("Poppins", FontWeight.BOLD, 36));
        dashboardTitle.setFill(Color.web("#02383E"));
        dashboardTitle.setLayoutX(50);
        dashboardTitle.setLayoutY(70);

        // Panel for Number of Classes (Default 0)
        Pane classPanel = createBoxPanel(50, 100, 300, 120, "Total Classes", 0); // Default 0 classes

        // Panel for Number of Students (Default 0)
        Pane studentsPanel = createBoxPanel(400, 100, 300, 120, "Number of Students", 0); // Default 0 students

        // Add panels to the center panel
        centerPanel.getChildren().addAll(dashboardTitle, classPanel, studentsPanel);

        return centerPanel;
    }

    // Helper method to create a styled box panel with a label and the relevant number (e.g., days or classes)
    private static Pane createBoxPanel(double x, double y, double width, double height, String labelText, int value) {
        Pane box = new Pane();
        box.setPrefSize(width, height);
        box.setLayoutX(x);
        box.setLayoutY(y);
        box.setStyle(
            "-fx-background-color: #f0f0f0;" +
            "-fx-background-radius: 20;" +
            "-fx-border-color: #cccccc;" +
            "-fx-border-radius: 20;" +
            "-fx-border-width: 1;"
        );

        // Title label
        Text label = new Text(labelText);
        label.setFont(Font.font("Poppins", FontWeight.BOLD, 16));
        label.setFill(Color.web("#02383E"));
        label.setLayoutX(20);
        label.setLayoutY(35);

        // Display the relevant value (e.g., days or number of classes)
        Text valueText = new Text(String.valueOf(value)); // Default value 0
        valueText.setFont(Font.font("Poppins", FontWeight.BOLD, 36)); // Large number font
        // Set color based on the type (Attendance panels = Blue, Classes and Students panel = Orange)
        if (labelText.contains("Class")) {
            valueText.setFill(Color.web("#FF9800")); // Orange for total classes
        } else if (labelText.contains("Student")) {
            valueText.setFill(Color.web("#FF9800")); // Orange for number of students
        } else {
            valueText.setFill(Color.web("#009688")); // Blue for other statistics
        }
        valueText.setLayoutX(20);
        valueText.setLayoutY(70); // Positioning the number below the label

        box.getChildren().addAll(label, valueText);

        return box;
    }
}
