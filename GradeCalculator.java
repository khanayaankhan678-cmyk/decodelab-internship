import java.util.Scanner;

public class GradeCalculator {

    private static int readInt(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value < min || value > max) {
                    System.out.printf("  Invalid: value must be between %d and %d. Try again.%n", min, max);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("  Invalid: please enter a whole number.");
            }
        }
    }

    private static char assignGrade(double percentage) {
        if (percentage >= 90) {
            return 'A';
        } else if (percentage >= 80) {
            return 'B';
        } else if (percentage >= 70) {
            return 'C';
        } else if (percentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== STUDENT GRADE CALCULATOR ===");
        System.out.print("Enter student name: ");
        String name = sc.nextLine().trim();

        int numSubjects = readInt(sc, "Enter number of subjects (1-20): ", 1, 20);

        int totalMarks = 0;
        int[] marks = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            marks[i] = readInt(sc, "Enter marks for subject " + (i + 1) + " (0-100): ", 0, 100);
            totalMarks += marks[i];
        }

        double percentage = (double) totalMarks / numSubjects;
        char grade = assignGrade(percentage);
        String result = (grade == 'F') ? "FAIL" : "PASS";

        System.out.println();
        System.out.println("========== REPORT CARD ==========");
        System.out.printf("Student      : %s%n", name.isEmpty() ? "N/A" : name);
        System.out.println("---------------------------------");
        for (int i = 0; i < numSubjects; i++) {
            System.out.printf("Subject %-3d  : %d / 100%n", i + 1, marks[i]);
        }
        System.out.println("---------------------------------");
        System.out.printf("Total Marks  : %d / %d%n", totalMarks, numSubjects * 100);
        System.out.printf("Average      : %.2f%%%n", percentage);
        System.out.printf("Grade        : %c%n", grade);
        System.out.printf("Result       : %s%n", result);
        System.out.println("=================================");

        sc.close();
    }
}