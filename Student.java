/**
 * UPB, ACS, POO CB 2022-2023
 * @author Gabriel Gutu-Robu
 *
 * DO NOT MODIFY THIS FILE
 */

public class Student {

    String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object object) {
        if ( !(object instanceof Student) ) return false;
        return this.name.equals( ((Student) object).name );
    }
}
