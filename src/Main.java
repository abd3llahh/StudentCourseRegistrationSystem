import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        core.RegistrationSystem system = new core.RegistrationSystem();

        while (true) {
            System.out.println("\n======================================");
            System.out.println("     STUDENT COURSE REGISTRATION");
            System.out.println("======================================");
            System.out.println("1. Add Course");
            System.out.println("2. Add Student");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Drop Student from Course");
            System.out.println("5. List All Courses");
            System.out.println("6. List All Students");
            System.out.println("7. Search Courses");
            System.out.println("8. Search Students");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": // Add Course
                    System.out.print("Course ID: ");
                    String cId = scanner.nextLine().trim();
                    System.out.print("Course Name: ");
                    String cName = scanner.nextLine().trim();
                    System.out.print("Capacity (-1 for unlimited): ");
                    int cap = parseIntOrDefault(scanner.nextLine().trim(), -1);
                    system.addCourse(cId, cName, cap);
                    break;

                case "2": // Add Student
                    System.out.print("Student ID: ");
                    String sId = scanner.nextLine().trim();
                    System.out.print("Student Name: ");
                    String sName = scanner.nextLine().trim();
                    system.addStudent(sId, sName);
                    break;

                case "3": // Enroll
                    System.out.print("Student ID: ");
                    String enrollSid = scanner.nextLine().trim();
                    System.out.print("Course ID: ");
                    String enrollCid = scanner.nextLine().trim();
                    system.enrollStudent(enrollSid, enrollCid);
                    break;

                case "4": // Drop
                    System.out.print("Student ID: ");
                    String dropSid = scanner.nextLine().trim();
                    System.out.print("Course ID: ");
                    String dropCid = scanner.nextLine().trim();
                    system.dropStudent(dropSid, dropCid);
                    break;

                case "5": // List Courses
                    system.listCourses();
                    break;

                case "6": // List Students
                    system.listStudents();
                    break;

                case "7": // Search Courses
                    System.out.print("Enter course id or name query: ");
                    String cquery = scanner.nextLine().trim();
                    system.searchCourse(cquery);
                    break;

                case "8": // Search Students
                    System.out.print("Enter student id or name query: ");
                    String squery = scanner.nextLine().trim();
                    system.searchStudent(squery);
                    break;

                case "0":
                    System.out.println("Saving (if implemented) and exiting. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Enter a number from the menu.");
            }
        }
    }

    private static int parseIntOrDefault(String s, int def) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return def;
        }
    }
}
