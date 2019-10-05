import java.util.ArrayList;
import java.util.Scanner;

import javax.print.event.PrintServiceAttributeListener;

class Professor
{
    private String name;
    private int AM;
    private Course lesson;

    public Professor(String name, int AM){
        this.name = name;
        this.AM = AM;
    }

    public void setLesson(Course c){
        lesson = c ;
    }

    public String toString(){
        return name + " " + AM + " " + lesson;
    }
}

class Student{
    private String name;
    private int AM;
    private int units = 0;

    public Student(String name, int AM){
        this.name = name;
        this.AM = AM;
    }

    public int getAM(){
        return AM;
    }

    public void addUnits(int units){
        this.units += units;
    }

    public String toString(){
        return name + " AM: " + AM +" Units: " + units; 
    }
}
class StudentRecord{
    private Student student;
    private double grade;

    public StudentRecord(Student s){
        student = s;
    }

    public void SetGrade(double grade){
        this.grade= grade;
    }

    public Student getStudent(){
        return student;
    }

    public String toString(){
        return student + " : " + grade;
    }

    public boolean passed(){
        if (grade >= 5){
            return true;
        }
        return false;
    }
}

class Course
{
    private String name;
    private int code;
    private int units;
    private Professor prof;
    private ArrayList<StudentRecord> studentList = new ArrayList<StudentRecord>();

    public Course(String name, int code, int units){
        this.name =name;
        this.code = code;
        this.units = units;
    }

    public void setProfessor(Professor p){
        this.prof = p;
        p.setLesson(this);
    }

    public void enroll(Student s){
        studentList.add(new StudentRecord(s));
    }
    
    public void assignGrades(){
        System.out.println("Give grades for course: "  + toString());
        Scanner input = new Scanner(System.in);
        for (StudentRecord record: studentList){
            System.out.println("Give grade for student" + record.getStudent().getAM() + ": ");
            double grade =input.nextDouble();
            record.SetGrade(grade);
            if (record.passed()){
                record.getStudent().addUnits(units);
            }
            
        }
    }

    public String toString(){
        return name + " " + code + "(" + units + ")" ; 
    }

    public void printInfo(){
        System.out.println("Course: " + name + "code: " + code + "("+ units + ")");
        for (StudentRecord r: studentList){
            System.out.println(r);
        }
    }
}

class Department
{
    public static void main(String args[]){
        int numOfStudents = Integer.parseInt(args[0]);

        Professor profX = new Professor("profX", 2012);
        Professor profY = new Professor("profY", 2013);

        Course DiscreteMath = new Course("DiscreteMath", 212, 5);
        Course Calculus = new Course("Calculus", 101, 10);

        Student[] students = new Student[numOfStudents];
        Scanner input = new Scanner(System.in);

        for (int i=0; i< numOfStudents; i++){
            System.out.println("Give student name: ");
            String name = input.next();
            students[i] = new Student(name, i);
        }
        DiscreteMath.setProfessor(profX);
        DiscreteMath.enroll(students[0]); DiscreteMath.enroll(students[1]); DiscreteMath.enroll(students[3]);

        Calculus.setProfessor(profY);
        Calculus.enroll(students[2]); Calculus.enroll(students[1]); Calculus.enroll(students[3]);

        DiscreteMath.assignGrades(); Calculus.assignGrades();

        System.out.println(profX); System.out.println(profY);
        DiscreteMath.printInfo(); Calculus.printInfo();
    }
}
