package PackFATPrep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

class VITFeedback implements Comparable<VITFeedback> {
    String course_Name, faculty_Name;
    int feedback_Rating;

    void getMethod(Scanner scanner) {
        course_Name = scanner.nextLine();
        faculty_Name = scanner.nextLine();
        feedback_Rating = scanner.nextInt();
    }

    public int compareTo(VITFeedback e) {
        return this.feedback_Rating < e.feedback_Rating ? 1 : this.feedback_Rating > e.feedback_Rating ? -1 : 0;
    }
}

public class College {

    static double AverageRating(ArrayList<VITFeedback> students) {
        Iterator<VITFeedback> iterator = students.iterator();
        double total = 0;
        int count = 0;
        while (iterator.hasNext()) {
            total += iterator.next().feedback_Rating;
            count++;
        }
        return total / count;
    }

    static void View_All_Feedbacks(ArrayList<VITFeedback> students) {
        Iterator<VITFeedback> iterator = students.iterator();
        System.out.println("Course Name\t\tFaculty Name\t\tFeedback");
        while (iterator.hasNext()) {
            VITFeedback temp = iterator.next();
            System.out.println(temp.course_Name + "\t\t" + temp.faculty_Name + "\t\t" + temp.feedback_Rating);
        }
    }

    static void Get_Highest_Feedback(ArrayList<VITFeedback> students) {
        Collections.sort(students);
        Iterator<VITFeedback> iterator = students.iterator();
        VITFeedback highest = iterator.next();
        System.out.println("Course Name\t\tFaculty Name\t\tFeedback");
        System.out.println(highest.course_Name + "\t\t" + highest.faculty_Name + "\t\t" + highest.feedback_Rating);
        while (iterator.hasNext()) {
            VITFeedback temp = iterator.next();
            if (temp.feedback_Rating != highest.feedback_Rating) {
                break;
            }
            System.out.println(temp.course_Name + "\t\t" + temp.faculty_Name + "\t\t" + temp.feedback_Rating);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<VITFeedback> students = new ArrayList<VITFeedback>();
        System.out.print("Number of students: ");
        final int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            VITFeedback temp = new VITFeedback();
            temp.getMethod(scanner);
            students.add(temp);
        }

        System.out.print("Enter Choice: ");
        switch (scanner.nextInt()) {
            case 1:
                AverageRating(students);
                break;
            case 2:
                View_All_Feedbacks(students);
                break;
            case 3:
                Get_Highest_Feedback(students);
                break;

            default:
                break;
        }
        scanner.close();
    } 
    system.out.println(" The program ends here");
}
