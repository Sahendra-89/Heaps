import java.io.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;
    public static class{

    
    
    
    class Student implements Serializable {
        private String name;
        private int rollNumber;
        private String grade;
    
        // Constructor
        public Student(String name, int rollNumber, String grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
        }
    
        // Getters and Setters
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public int getRollNumber() {
            return rollNumber;
        }
    
        public void setRollNumber(int rollNumber) {
            this.rollNumber = rollNumber;
        }
    
        public String getGrade() {
            return grade;
        }
    
        public void setGrade(String grade) {
            this.grade = grade;
        }
    
        @Override
        public String toString() {
            return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
        }
    }
    
    class StudentManagementSystem {
        private List<Student> students;
    
        public StudentManagementSystem() {
            students = new ArrayList<>();
        }
    
        public void addStudent(Student student) {
            students.add(student);
        }
    
        public void removeStudent(Student student) {
            students.remove(student);
        }
    
        public Student searchStudent(int rollNumber) {
            for (Student student : students) {
                if (student.getRollNumber() == rollNumber) {
                    return student;
                }
            }
            return null;
        }
    
        public List<Student> getAllStudents() {
            return students;
        }
    
        // Method to save student data to a file
        public void saveStudentsToFile(String fileName) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                oos.writeObject(students);
                System.out.println("Data saved to file successfully.");
            } catch (IOException e) {
                System.out.println("Error saving data to file: " + e.getMessage());
            }
        }
    
        // Method to load student data from a file
        public void loadStudentsFromFile(String fileName) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                students = (List<Student>) ois.readObject();
                System.out.println("Data loaded from file successfully.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading data from file: " + e.getMessage());
            }
        }
    }
    
    public class Task {
        public void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            StudentManagementSystem sms = new StudentManagementSystem();
    
            while (true) {
                System.out.println("1. Add a new student");
                System.out.println("2. Remove a student");
                System.out.println("3. Search for a student");
                System.out.println("4. Display all students");
                System.out.println("5. Save students to file");
                System.out.println("6. Load students from file");
                System.out.println("7. Exit");
    
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline left by nextInt()
    
                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter roll number: ");
                        int rollNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline left by nextInt()
                        System.out.print("Enter grade: ");
                        String grade = scanner.nextLine();
                        Student student = new Student(name, rollNumber, grade);
                        sms.addStudent(student);
                        System.out.println("Student added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter roll number of student to remove: ");
                        int rollToRemove = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline left by nextInt()
                        Student studentToRemove = sms.searchStudent(rollToRemove);
                        if (studentToRemove != null) {
                            sms.removeStudent(studentToRemove);
                            System.out.println("Student removed successfully.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter roll number of student to search: ");
                        int rollToSearch = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline left by nextInt()
                        Student searchedStudent = sms.searchStudent(rollToSearch);
                        if (searchedStudent != null) {
                            System.out.println("Student found: " + searchedStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 4:
                        List<Student> allStudents = sms.getAllStudents();
                        if (allStudents.isEmpty()) {
                            System.out.println("No students found.");
                        } else {
                            System.out.println("All students:");
                            for (Student s : allStudents) {
                                System.out.println(s);
                            }
                        }
                        break;
                    case 5:
                        System.out.print("Enter file name to save students: ");
                        String fileNameToSave = scanner.nextLine();
                        sms.saveStudentsToFile(fileNameToSave);
                        break;
                    case 6:
                        System.out.print("Enter file name to load students: ");
                        String fileNameToLoad = scanner.nextLine();
                        sms.loadStudentsFromFile(fileNameToLoad);
                        break;
                    case 7:
                        System.out.println("Exiting the application. Goodbye!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
    }
        
}
