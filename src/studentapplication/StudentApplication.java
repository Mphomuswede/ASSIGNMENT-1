/*
/Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentapplication;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author RC_Student_lab
 */
public class StudentApplication {

    
    public static class Student {
        private String id;
        private String name;
        private int age;
        private String email;
        private String course;

        public Student(String id, String name, int age, String email, String course) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.email = email;
            this.course = course;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Email: " + email + ", Course: " + course;
        }
    }

    
    public static class StudentManager {
        private ArrayList<Student> studentList;
        private Scanner input;

        public StudentManager() {
            studentList = new ArrayList<>();
            input = new Scanner(System.in);
        }

        public void showMenu() {
            while (true) {
                System.out.println("1. Capture New Student");
                System.out.println("2. Search Student");
                System.out.println("3. Delete a Student");
                System.out.println("4. Print Student Report");
                System.out.println("5. Exit Application");
                System.out.print("Choose an option: ");
                
                int option = input.nextInt();
                input.nextLine(); // Consume newline

                switch (option) {
                    case 1:
                        captureNewStudent();
                        break;
                    case 2:
                        searchStudent();
                        break;
                    case 3:
                        deleteStudent();
                        break;
                    case 4:
                        printStudentReport();
                        break;
                    case 5:
                        exitApplication();
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        }

        private void captureNewStudent() {
            System.out.print("Enter Student ID: ");
            String id = input.nextLine();
            
            System.out.print("Enter Name: ");
            String name = input.nextLine();
            
            int age;
            while (true) {
                System.out.print("Enter Age (16 or older): ");
                try {
                    age = Integer.parseInt(input.nextLine());
                    if (age >= 16) break;
                    else System.out.println("Age must be 16 or older.");
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }

            System.out.print("Enter Email: ");
            String email = input.nextLine();
            
            System.out.print("Enter Course: ");
            String course = input.nextLine();
            
            Student student = new Student(id, name, age, email, course);
            studentList.add(student);
            System.out.println("Student added successfully.");
        }

        private void searchStudent() {
            System.out.print("Enter Student ID to find: ");
            String id = input.nextLine();
            
            for (Student student : studentList) {
                if (student.getId().equals(id)) {
                    System.out.println(student);
                    return;
                }
            }
            System.out.println("Student not found.");
        }

        private void deleteStudent() {
            System.out.print("Enter Student ID to remove: ");
            String id = input.nextLine();
            
            for (Student student : studentList) {
                if (student.getId().equals(id)) {
                    System.out.print("Are you sure? (yes/no): ");
                    String confirm = input.nextLine();
                    
                    if (confirm.equalsIgnoreCase("yes")) {
                        studentList.remove(student);
                        System.out.println("Student removed.");
                    } else {
                        System.out.println("Removal canceled.");
                    }
                    return;
                }
            }
            System.out.println("Student not found.");
        }

        private void printStudentReport() {
            if (studentList.isEmpty()) {
                System.out.println("No students available.");
            } else {
                for (Student student : studentList) {
                    System.out.println(student);
                }
            }
        }

        private void exitApplication() {
            System.out.println("Application closed.");
        }
    }

    // Main method
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.showMenu();
    }
}
