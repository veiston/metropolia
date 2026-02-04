import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task3 {
    public static void main(String[] args) throws Exception {

        /* Serialisointi */
        Student student = new Student(1, "Veikka Liukonen", 22);
        Course course = new Course("Jarkon kurssi", "Java", "J. Vuori");
        Enrollment enrollment = new Enrollment(student, course, "14.1.2026");

        Path file = Path.of("enrollments.ser");
        Files.write(file, toBytes(enrollment));

        Enrollment loaded = (Enrollment) fromBytes(Files.readAllBytes(file));
        System.out.println(loaded);
    }

    private static byte[] toBytes(Serializable obj) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(obj);
        out.close();
        return bos.toByteArray();
    }

    private static Object fromBytes(byte[] data) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data));
        Object obj = in.readObject();
        in.close();
        return obj;
    }

    static class Student implements Serializable {
        private int id;
        private String name;
        private int age;

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Oppilas{id=" + id + ", nimi='" + name + "', ikä=" + age + "}";
        }
    }

    static class Course implements Serializable {
        private String courseCode;
        private String courseName;
        private String instructor;

        public Course(String courseCode, String courseName, String instructor) {
            this.courseCode = courseCode;
            this.courseName = courseName;
            this.instructor = instructor;
        }

        public String getCourseCode() {
            return courseCode;
        }

        public void setCourseCode(String courseCode) {
            this.courseCode = courseCode;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getInstructor() {
            return instructor;
        }

        public void setInstructor(String instructor) {
            this.instructor = instructor;
        }

        @Override
        public String toString() {
            return "Kurssi{Kurssin koodi='" + courseCode + "', Kurssi='" + courseName + "', Opettaja='" + instructor + "'}";
        }
    }

    static class Enrollment implements Serializable {
        private Student student;
        private Course course;
        private String enrollmentDate;

        public Enrollment(Student student, Course course, String enrollmentDate) {
            this.student = student;
            this.course = course;
            this.enrollmentDate = enrollmentDate;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public Course getCourse() {
            return course;
        }

        public void setCourse(Course course) {
            this.course = course;
        }

        public String getEnrollmentDate() {
            return enrollmentDate;
        }

        public void setEnrollmentDate(String enrollmentDate) {
            this.enrollmentDate = enrollmentDate;
        }

        @Override
        public String toString() {
            return "Ilmoittautuminen{" + student + ", " + course + ", Ilmoittautumispäivä='" + enrollmentDate + "'}";
        }
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        Task3.main(args);
    }
}
