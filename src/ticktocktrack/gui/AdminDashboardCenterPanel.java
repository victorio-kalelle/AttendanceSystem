package ticktocktrack.gui;

import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class AdminDashboardCenterPanel {

    public static Pane createPanel() {
        // Create the center panel
        Pane centerPanel = new Pane();
        
        centerPanel.setPrefSize(1300, 750);
        centerPanel.setLayoutX(0);
        centerPanel.setLayoutY(0);
        centerPanel.setStyle("-fx-background-color: white; -fx-border-color: #cccccc; -fx-border-width: 1px;");

        // Shadow image
        String shadowPath = AdminDashboardCenterPanel.class.getResource("/resources/SHADOW.png").toExternalForm();
        ImageView shadowView = new ImageView(new Image(shadowPath));
        shadowView.setFitWidth(1300);
        shadowView.setFitHeight(250);
        shadowView.setLayoutX(0);
        shadowView.setLayoutY(-115);

        // Create the "Dashboard" Text
        Text dashboardTitle = new Text("Admin Dashboard");
        dashboardTitle.setFont(Font.font("Poppins", FontWeight.BOLD, 36));
        dashboardTitle.setFill(Color.web("#02383E"));
        dashboardTitle.setLayoutX(50);
        dashboardTitle.setLayoutY(70);

        // Create 3 panels (box holders)
        double startX = 50;
        double gap = 50;
        double width = 267;
        double height = 120;

        Pane panel1 = createBoxPanel(startX, 100, width, height, "Total Admins User", "/resources/admin_icon.png");
        Pane panel2 = createBoxPanel(startX + width + gap, 100, width, height, "Total Teachers User", "/resources/teacher_icon.png");
        Pane panel3 = createBoxPanel(startX + 2 * (width + gap), 100, width, height, "Total Students User", "/resources/student_icon.png");

        centerPanel.getChildren().addAll(shadowView, dashboardTitle, panel1, panel2, panel3);

        return centerPanel;
    }

    // Helper method to create a styled box panel with a label, number holder, and icon
    private static Pane createBoxPanel(double x, double y, double width, double height, String labelText, String iconResourcePath) {
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

        // Number holder
        Text number = new Text("0"); // Default 0, you will update later from database
        number.setFont(Font.font("Poppins", FontWeight.BOLD, 32));
        number.setFill(Color.web("#009688"));
        number.setLayoutX(20);
        number.setLayoutY(90);

        // Load the icon from resources
        String fullIconPath = AdminDashboardCenterPanel.class.getResource(iconResourcePath).toExternalForm();
        ImageView icon = new ImageView(new Image(fullIconPath));
        icon.setFitWidth(40);
        icon.setFitHeight(40);
        icon.setLayoutX(width - 55); // Right side
        icon.setLayoutY(30); // Align vertically

        box.getChildren().addAll(label, number, icon);

        return box;
    }
}
