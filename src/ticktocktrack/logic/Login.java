package ticktocktrack.logic;

public class Login {

    public Login() {
        // No need for database connection or hashing
    }

    // Simple authenticate method without hashing
    public boolean authenticate(String username, String password) {
        // Admin credentials
        String adminUsername = "admin";
        String adminPassword = "admin123";
        
     // Teacher credentials
        String teacherUsername = "teacher";
        String teacherPassword = "teacher123";

        // Student credentials
        String studentUsername = "student";
        String studentPassword = "student123";

        
        // Check if it's admin login
        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            return true;
        }
        
        // Check if it's teacher login
        if (username.equals(teacherUsername) && password.equals(teacherPassword)) {
            return true;
        }
        // Check if it's student login
        if (username.equals(studentUsername) && password.equals(studentPassword)) {
            return true;
        }

       

        // Otherwise, authentication failed
        return false;
    }
}
