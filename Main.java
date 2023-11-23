/**
 * UPB, ACS, POO CB 2022-2023
 * @author Gabriel Gutu-Robu
 *
 */
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        IDatabase mysql = null; // ... add your code here
        StudentManager studentManager2 = new StudentManager(new IDatabase<Student>() {
            // ArrayList pentru stocarea studenților adăugați
            private ArrayList<Student> students = new ArrayList<>();

            @Override
            public void connect() {
                System.out.println("Connected to the database");
            }

            @Override
            public void disconnect() {
                System.out.println("Disconnected from the database");
            }

            @Override
            public void insert(Student student) {
                students.add(student);
                System.out.println("Inserted student: " + student);
            }

            @Override
            public void update(Student oldStudent, Student newStudent) {
                if (students.contains(oldStudent)) {
                    students.remove(oldStudent);
                    students.add(newStudent);
                    System.out.println("Updated student: " + oldStudent + " with " + newStudent);
                } else {
                    System.out.println("Student not found for update: " + oldStudent);
                }
            }

            @Override
            public void delete(Student student) {
                if (students.contains(student)) {
                    students.remove(student);
                    System.out.println("Deleted student: " + student);
                } else {
                    System.out.println("Student not found for deletion: " + student);
                }
            }

            @Override
            public ArrayList<Student> getAll() {
                return new ArrayList<>(students);
            }
        });

        StudentManager studentManager = new StudentManager(mysql);
        studentManager.runSomeTests();
    }
}
