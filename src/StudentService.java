import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    // Add Student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student Added Successfully!");
    }

    // Display Students
    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }

        System.out.println("\nAll Students:");

        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Search Student
    public void searchStudent(int id) {

        for (Student s : students) {

            if (s.getId() == id) {
                System.out.println("Student Found:");
                System.out.println(s);
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // Update Student
    public void updateStudent(int id, String name, int age, String course) {

        for (Student s : students) {

            if (s.getId() == id) {

                s.setName(name);
                s.setAge(age);
                s.setCourse(course);

                System.out.println("Student Updated Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // Delete Student
    public void deleteStudent(int id) {

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId() == id) {

                students.remove(i);

                System.out.println("Student Deleted Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // Getter
    public ArrayList<Student> getStudents() {
        return students;
    }
}