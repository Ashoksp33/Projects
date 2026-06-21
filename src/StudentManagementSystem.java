import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class StudentManagementSystem {

    public static void main(String[] args) {

        StudentService service = new StudentService();
        ArrayList<Student> students = service.getStudents();

        // Load students from file
        loadStudents(students);

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Student Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Course: ");
                    String course = sc.nextLine();

                    Student student = new Student(id, name, age, course);

                    service.addStudent(student);

                    break;

                case 2:

                    service.displayStudents();

                    break;

                case 3:

                    System.out.print("Enter Student ID to Search: ");
                    int searchId = sc.nextInt();

                    service.searchStudent(searchId);

                    break;

                case 4:

                    System.out.print("Enter Student ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    service.updateStudent(updateId, newName, newAge, newCourse);

                    break;

                case 5:

                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = sc.nextInt();

                    service.deleteStudent(deleteId);

                    break;

                case 6:

                    saveStudents(students);

                    System.out.println("Students Saved Successfully!");
                    System.out.println("Thank You!");

                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    // Save students to file
    public static void saveStudents(ArrayList<Student> students) {

        try {

            FileWriter writer = new FileWriter("students.txt");

            for (Student s : students) {

                writer.write(
                        s.getId() + "," +
                                s.getName() + "," +
                                s.getAge() + "," +
                                s.getCourse() + "\n"
                );
            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error Saving File!");
        }
    }

    // Load students from file
    public static void loadStudents(ArrayList<Student> students) {

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader("students.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];

                students.add(new Student(id, name, age, course));
            }

            reader.close();

            System.out.println("Students Loaded Successfully!");

        } catch (IOException e) {

            System.out.println("No Previous Data Found.");
        }
    }
}