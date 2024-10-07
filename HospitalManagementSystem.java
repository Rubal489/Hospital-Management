import java.sql.*;
import java.util.Scanner;

public class HospitalManagementSystem {
    
    public static void main(String[] args) {
        try {
            // Step 1: Register the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Step 2: Establish the Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db", "root", "password");
            
            // Scanner for user input
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Choose Operation: 1. Add Patient 2. View Patients");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline
            
            if (choice == 1) {
                // Step 3: Add a Patient
                System.out.println("Enter Patient Name: ");
                String name = sc.nextLine();
                System.out.println("Enter Patient Age: ");
                int age = sc.nextInt();
                sc.nextLine();  // consume newline
                
                String query = "INSERT INTO patients (name, age) VALUES (?, ?)";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                
                int rows = pstmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("Patient added successfully!");
                }
            } else if (choice == 2) {
                // Step 4: View Patients
                String query = "SELECT * FROM patients";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Age: " + rs.getInt("age"));
                }
            }
            
            // Step 5: Close the connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
