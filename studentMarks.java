import java.util.ArrayList;
import java.util.Scanner;

public class studentMarks {

    private static int maxGrades(ArrayList<Integer> Grades) {
        int high = 0;
        for (int i = 0; i < Grades.size(); i++) {
            high = Grades.get(0);
            if (Grades.get(i) > high) {
                high = Grades.get(i);
            }
        }
        return high;
    }

    private static int lowGrades(ArrayList<Integer> Grades) {
        int low = 0;
        for (int i = 0; i < Grades.size(); i++) {
            low = Grades.get(0);
            if (Grades.get(i) < low) {
                low = Grades.get(i);
            }
        }
        return low;
    }

    public static void main(String args[]) {
        ArrayList<Integer> Grades = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Enter the no of students :");
        int n = sc.nextInt();
        System.out.println("Enter the grades ( Enter -1 to exit) : ");

        while (n-- > 0) {
            int grade = sc.nextInt();
            if (grade == -1) {
                break;
            } else {
                Grades.add(grade);
            }
        }
        if (Grades.isEmpty()) {
            System.out.println("No grades are entered!");
        }
        for (int i = 0; i < Grades.size(); i++) {
            total += Grades.get(i);
        }
        double Average = total / Grades.size();
        System.out.println("The total grades of students is: " + total);
        System.out.println("The average of the grades of all the students is:" + Average);
        System.out.println("The highest of all the student is:" + maxGrades(Grades));
        System.out.println("The highest of all the students grades is:" + lowGrades(Grades));

        sc.close();
    }
}
