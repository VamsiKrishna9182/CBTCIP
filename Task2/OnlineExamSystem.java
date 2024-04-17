package Task2;

import java.util.Scanner;

public class OnlineExamSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "Who wrote the play 'Romeo and Juliet'?",
            
        };

        String[][] options = {
            {"A) Paris", "B) London", "C) Berlin", "D) Madrid"},
            {"A) Venus", "B) Mars", "C) Jupiter", "D) Saturn"},
            {"A) Charles Dickens", "B) Jane Austen", "C) William Shakespeare", "D) Mark Twain"},
            
        };

        char[] answers = {'A', 'B', 'C', 'D'};

        int totalQuestions = questions.length;
        int score = 0;

        System.out.println("Welcome to the Online Exam System!");
        System.out.println("Please log in to start the exam.");

        // Simulating user login (you can replace this with actual authentication)
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Validate user credentials (dummy check for demonstration)
        if (username.equals("admin") && password.equals("secret")) {
            System.out.println("\nLogin successful! Let's begin the exam.");
            System.out.println("You have " + totalQuestions + " questions.");

            // Set exam duration (adjust as needed)
            int examDurationMinutes = 10;
            long endTime = System.currentTimeMillis() + examDurationMinutes * 60 * 1000;

            for (int i = 0; i < totalQuestions; i++) {
                System.out.println("\n" + questions[i]);
                for (String option : options[i]) {
                    System.out.println(option);
                }

                System.out.print("Your answer (A/B/C/D): ");
                char userAnswer = Character.toUpperCase(scanner.next().charAt(0));

                if (userAnswer == answers[i]) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect. The correct answer is: " + answers[i]);
                }

                // Check if time is up
                if (System.currentTimeMillis() >= endTime) {
                    System.out.println("\nTime's up! Submitting your answers.");
                    break;
                }
            }

            System.out.println("\nYour final score: " + score + " out of " + totalQuestions);
            System.out.print("Do you want to log out? (Y/N): ");
            char logoutChoice = Character.toUpperCase(scanner.next().charAt(0));
            if (logoutChoice == 'Y') {
                System.out.println("Logged out successfully. Have a great day!");
            } else {
                System.out.println("Thank you for using the Online Exam System.");
            }
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }

        scanner.close();
    }
}


