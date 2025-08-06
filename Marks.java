import java.util.Scanner;

public class Marks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = input.nextInt(); // number of students
        String[][] studentGrades = new String[n][3];
        int[][] studentMarks = new int[n][3];

        while (true) {
            System.out.println("\n---------- MENU ----------");
            System.out.println("1 - Add Student Marks");
            System.out.println("2 - Update Student Mark");
            System.out.println("3 - Average for a Subject");
            System.out.println("4 - Average for a Student");
            System.out.println("5 - Total Mark of a Student");
            System.out.println("6 - Exit");
            System.out.print("Enter command number: ");
			
            int cmd = input.nextInt();

            int studentID, subjectID, totalSubject, totalStudent;

            switch (cmd) {
                case 1:
                    System.out.println("\nAdding student marks");
                    for (int i = 0; i < n; i++) {
                        System.out.printf("\nEnter marks of student %d\n", i + 1);

                        int mathMarks;
                        do {
                            System.out.print("Maths: ");
                            mathMarks = input.nextInt();
                        } while (mathMarks < 0 || mathMarks > 100);
                        studentMarks[i][0] = mathMarks;

                        int chemMarks;
                        do {
                            System.out.print("Chemistry: ");
                            chemMarks = input.nextInt();
                        } while (chemMarks < 0 || chemMarks > 100);
                        studentMarks[i][1] = chemMarks;

                        int physMarks;
                        do {
                            System.out.print("Physics: ");
                            physMarks = input.nextInt();
                        } while (physMarks < 0 || physMarks > 100);
                        studentMarks[i][2] = physMarks;
                    }
                    break;

                case 2:
                    System.out.println("\nUpdating student marks");

                    do {
                        System.out.print("Enter student ID (1-" + n + "): ");
                        studentID = input.nextInt();
                        if (studentID <= 0 || studentID > n) {
                            System.out.println("Invalid Student ID! Please retry");
                        }
                    } while (studentID <= 0 || studentID > n);

                    do {
                        System.out.print("Enter subject ID (0-Maths, 1-Chemistry, 2-Physics): ");
                        subjectID = input.nextInt();
                        if (subjectID < 0 || subjectID > 2) {
                            System.out.println("Invalid Subject ID! Please retry");
                        }
                    } while (subjectID < 0 || subjectID > 2);

                    System.out.print("Enter marks: ");
                    studentMarks[studentID - 1][subjectID] = input.nextInt();
                    break;

                case 3:
                    System.out.println("\nAverage mark of a subject:");
                    totalSubject = 0;
                    float avgSub;

                    do {
                        System.out.print("Enter subject ID (0-Maths, 1-Chemistry, 2-Physics): ");
                        subjectID = input.nextInt();
                        if (subjectID < 0 || subjectID > 2) {
                            System.out.println("Invalid Subject ID! Please retry");
                        }
                    } while (subjectID < 0 || subjectID > 2);

                    for (int i = 0; i < n; i++) {
                        totalSubject += studentMarks[i][subjectID];
                    }
                    avgSub = (float) totalSubject / n;

                    if (subjectID == 0) {
                        System.out.printf("\nAverage marks for Maths: %.2f\n", avgSub);
                    } else if (subjectID == 1) {
                        System.out.printf("\nAverage marks for Chemistry: %.2f\n", avgSub);
                    } else {
                        System.out.printf("\nAverage marks for Physics: %.2f\n", avgSub);
                    }
                    break;

                case 4:
                    System.out.println("\nAverage mark of a student:");
                    totalStudent = 0;
                    float avgStu;

                    do {
                        System.out.print("Enter student ID (1-" + n + "): ");
                        studentID = input.nextInt();
                        if (studentID <= 0 || studentID > n) {
                            System.out.println("Invalid Student ID! Please retry.");
                        }
                    } while (studentID <= 0 || studentID > n);

                    for (int j = 0; j < 3; j++) {
                        totalStudent += studentMarks[studentID - 1][j];
                    }
                    avgStu = (float) totalStudent / 3;
                    System.out.printf("\nAverage mark of Student %d: %.2f\n", studentID, avgStu);
                    break;

                case 5:
                    System.out.println("\nTotal marks of a student:");
                    totalStudent = 0;

                    do {
                        System.out.print("Enter student ID (1-" + n + "): ");
                        studentID = input.nextInt();
                        if (studentID <= 0 || studentID > n) {
                            System.out.println("Invalid Student ID! Please retry");
                        }
                    } while (studentID <= 0 || studentID > n);

                    for (int j = 0; j < 3; j++) {
                        totalStudent += studentMarks[studentID - 1][j];
                    }

                    System.out.println("\nTotal marks of Student " + studentID + ": " + totalStudent);
                    break;


                case 6:
                    System.out.println("\nExiting...\n\n");
                    return;

                default:
                    System.out.println("Invalid Command!");
            }
        }
    }
}
