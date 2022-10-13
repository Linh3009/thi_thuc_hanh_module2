package manager;

import io.ReadAndWrite;
import model.Student;
import sort.SortDown;
import sort.SortUp;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerStudent {
    Scanner scanner = new Scanner(System.in);


    File file = new File("D:\\IntelliJ IDEA\\thi_thuc_hanh_module2\\exam_module2\\src\\io\\student.csv");
    ReadAndWrite readAndWrite = new ReadAndWrite();

    ArrayList<Student> students = readAndWrite.reader(file);

    public Student input() {
        System.out.println("INPUT STUDENT ID :");
        String studentCode = scanner.nextLine();
        System.out.println("INPUT NAME :");
        String name = scanner.nextLine();
        System.out.println("INPUT AGE :");
        int age;
        while (true){
            try {
                do {
                    age = Integer.parseInt(scanner.nextLine());
                    if (age < 0 || age > 100){
                        System.out.println("INPUT WRONG, INPUT AGAIN");
                    }
                }while (age < 0 || age > 100);

                break;
            }catch (NumberFormatException e){
                System.out.println("NUMBER PLEASE !");
            }
        }
        System.out.println("INPUT GENDER");
        String gender = scanner.nextLine();
        System.out.println("INPUT ADDRESS");
        String address = scanner.nextLine();
        System.out.println("INPUT Average Point :");
        double averagePoint;
        while (true){
            try {
                do {
                    averagePoint= Double.parseDouble(scanner.nextLine());
                    if (averagePoint < 0 || averagePoint > 10){
                        System.out.println("Average Point From 0 to 10");
                    }
                }while (averagePoint < 0 || averagePoint > 10);
                break;
            }catch (NumberFormatException e){
                System.out.println("Enter Number Please !");
            }
        }
        return new Student(studentCode, name, age, gender, address, averagePoint);
    }

    public void showStudent() {
        for (Student x : students) {
            System.out.println(x.toString());
        }
    }

    public void addStudent() {
        Student sinhVien = input();
        students.add(sinhVien);

        readAndWrite.write(file, students);
    }

    public void update() {
        int choice = 0;
        while (choice == 0) {
            System.out.println("ENTER STUDENT ID YOU WANT TO UPDATE");
            String maSinhVien = scanner.nextLine();
            if (maSinhVien.equals("")) {
                break;
            }
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getStudentCode().equals(maSinhVien)) {
                    students.set(i, input());
                    ++choice;
                }
            }
            if (choice == 0) {
                System.out.println("CAN'T FIND STUDENT ID !");
            }
        }
        readAndWrite.write(file, students);

    }

    public void deleteStudent() {
        int choice = 0;
        while (choice == 0) {
            System.out.println("INPUT ID STUDENT YOU WANT TO DELETE");
            String maSinhVien = scanner.nextLine();
            if (maSinhVien.equals("")) {
                break;
            }
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getStudentCode().equals(maSinhVien)) {
                    System.out.println("DO YOU WANT TO DELETE STUDENT ?(PRESS Y TO DELETE)");
                    String check = scanner.nextLine();
                    if (check.equals("y") || check.equals("Y")) {
                        students.remove(students.get(i));
                    }
                    ++choice;
                }
            }
            if (choice == 0) {
                System.out.println("CAN'T FIND STUDENT !");
            }
        }
        readAndWrite.write(file, students);

    }

    public void sort() {
        System.out.println("YOU WANT TO SORT UP OR DOWN ?");
        System.out.println("1. SORT DOWN Average Point");
        System.out.println("2. SORT UP Average Point");
        System.out.println("3. CANCEL SORT");
        int choice;
        while (true){
            try {
                do {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 1 || choice > 3){
                        System.out.println("CHOOSE 1 OR 2");
                    }
                }while (choice < 1 || choice > 3);
               break;
            }catch (NumberFormatException e){
                System.out.println("INPUT NUMBER");
            }
        }


        switch (choice) {
            case 1 -> students.sort(new SortDown());
            case 2 -> students.sort(new SortUp());

        }
    }

    public void fileReader(){
        students = ReadAndWrite.reader(file);
        System.out.println("FILE READER SUCCESS");
    }

    public void fileWriter(){
        ReadAndWrite.write(file,students);
        System.out.println("FILE WRITER SUCCESS");
    }
}
