import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private String course;
    private double marks;

    public Student(int id, String name, int age, String course, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}

public class StudentManagementSystem {

    // ArrayList stores all student records
    static ArrayList<Student> students = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    // Find student by ID
    static Student findStudent(int id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    // Add student
    static void addStudent() {

        System.out.println("\n===== Add Student =====");

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findStudent(id) != null) {
            System.out.println("Student ID already exists.");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        if (name.trim().isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        if (age < 5 || age > 100) {
            System.out.println("Please enter a valid age.");
            return;
        }

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        if (course.trim().isEmpty()) {
            System.out.println("Course cannot be empty.");
            return;
        }

        System.out.print("Enter Marks (0-100): ");
        double marks = sc.nextDouble();

        if (marks < 0 || marks > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }

        Student student =
                new Student(id, name, age, course, marks);

        students.add(student);

        System.out.println("Student added successfully.");
    }

    // View all students
    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("\nNo student records available.");
            return;
        }

        System.out.println("\n================ STUDENT RECORDS ================");

        System.out.printf(
                "%-8s %-20s %-8s %-15s %-10s%n",
                "ID", "Name", "Age", "Course", "Marks"
        );

        System.out.println(
                "-------------------------------------------------"
        );

        for (Student student : students) {

            System.out.printf(
                    "%-8d %-20s %-8d %-15s %-10.2f%n",
                    student.getId(),
                    student.getName(),
                    student.getAge(),
                    student.getCourse(),
                    student.getMarks()
            );
        }

        System.out.println(
                "================================================="
        );
    }

    // Update student
    static void updateStudent() {

        System.out.print("\nEnter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        if (name.trim().isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        System.out.print("Enter New Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        if (age < 5 || age > 100) {
            System.out.println("Invalid age.");
            return;
        }

        System.out.print("Enter New Course: ");
        String course = sc.nextLine();

        if (course.trim().isEmpty()) {
            System.out.println("Course cannot be empty.");
            return;
        }

        System.out.print("Enter New Marks (0-100): ");
        double marks = sc.nextDouble();

        if (marks < 0 || marks > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }

        student.setName(name);
        student.setAge(age);
        student.setCourse(course);
        student.setMarks(marks);

        System.out.println("Student updated successfully.");
    }

    // Delete student
    static void deleteStudent() {

        System.out.print("\nEnter Student ID to delete: ");
        int id = sc.nextInt();

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(student);

        System.out.println("Student deleted successfully.");
    }

    // Main menu
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("==================================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println(
                            "Thank you for using Student Management System!"
                    );
                    sc.close();
                    return;

                default:
                    System.out.println(
                            "Invalid choice. Please enter 1-5."
                    );
            }
        }
    }
}