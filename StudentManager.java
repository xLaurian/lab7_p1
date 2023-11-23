/*
 * You may modify this file to run more tests (runSomeTests)
 */
public class StudentManager {


    private IDatabase<Student> database;

    public StudentManager(IDatabase<Student> database) {
        this.database = database;
    }

    public void insertStudent(Student student) {
        this.database.connect();
        this.database.insert(student);
        this.database.disconnect();
    }

    public void updateStudent(Student student, Student newStudent) {
        this.database.connect();
        this.database.update(student, newStudent);
        this.database.disconnect();
    }

    public void deleteStudent(Student student) {
        this.database.connect();
        this.database.delete(student);
        this.database.disconnect();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object student : database.getAll())
        {
            sb.append((Student) student + "\t");
        }
        return "StudentManager contains " +
                "students: " + sb.toString();
    }

    public void runSomeTests() {
        Student studentVasile = new Student("Vasile");
        Student studentGigel = new Student("Gigel");
        Student studentFlorina = new Student("Florina");

        this.insertStudent(studentVasile);
        System.out.println(this + "\n");
        this.deleteStudent(studentGigel);
        System.out.println(this + "\n");
        this.updateStudent(studentVasile, studentFlorina);
        System.out.println(this + "\n");
        this.insertStudent(studentVasile);
        System.out.println(this + "\n");
        this.deleteStudent(studentFlorina);
        System.out.println(this + "\n");
        this.insertStudent(studentGigel);
        System.out.println(this + "\n");

    }

}
