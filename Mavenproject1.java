
package managementsystem.mavenproject1;

import java.util.ArrayList;
import java.util.Scanner;

// Class to store schedule details
class Schedule {
    private String courseName;
    private String classTime;
    private String examDate;

    public Schedule(String courseName, String classTime, String examDate) {
        this.courseName = courseName;
        this.classTime = classTime;
        this.examDate = examDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getClassTime() {
        return classTime;
    }

    public String getExamDate() {
        return examDate;
    }

    @Override
    public String toString() {
        return "Course: " + courseName +
               "\nClass Time: " + classTime +
               "\nExam Date: " + examDate;
    }
}

  
public class Mavenproject1 {

     private static ArrayList<Schedule> schedules = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Routine and Exam Scheduler ---");
            System.out.println("1. Add Schedule");
            System.out.println("2. View Class Routine");
            System.out.println("3. View Exam Schedule");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addSchedule(scanner);
                case 2 -> viewClassRoutine();
                case 3 -> viewExamSchedule();
                case 4 -> System.out.println("Exiting application...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }

    private static void addSchedule(Scanner scanner) {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter class time (e.g., Mon 10:00 AM): ");
        String classTime = scanner.nextLine();
        System.out.print("Enter exam date (e.g., 2024-12-15): ");
        String examDate = scanner.nextLine();

        schedules.add(new Schedule(courseName, classTime, examDate));
        System.out.println("Schedule added successfully!");
    }

    private static void viewClassRoutine() {
        System.out.println("\n--- Class Routine ---");
        if (schedules.isEmpty()) {
            System.out.println("No schedules available.");
        } else {
            for (Schedule schedule : schedules) {
                System.out.println(schedule.getCourseName() + " -> Class Time: " + schedule.getClassTime());
            }
        }
    }

    private static void viewExamSchedule() {
        System.out.println("\n--- Exam Schedule ---");
        if (schedules.isEmpty()) {
            System.out.println("No schedules available.");
        } else {
            for (Schedule schedule : schedules) {
                System.out.println(schedule.getCourseName() + " -> Exam Date: " + schedule.getExamDate());
            }
        }
    }
}
