package manager;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    ManagerStudent ManagerStudent = new ManagerStudent();
    public void menu(){
        boolean check = true;
        while (check){
            System.out.println("╔=================================================╗");
            System.out.println("║       ▂ ▃ ▅ ▆ █ STUDENT MANAGER█ ▆ ▅ ▃ ▂        ║");
            System.out.println("╠=================================================╣");
            System.out.println();
            System.out.println( "PLEASE CHOOSE NUMBER!\n" +
                    "1. SHOW STUDENTS\n" +
                    "2. ADD STUDENT \n" +
                    "3. UPDATE\n" +
                    "4. DELETE\n" +
                    "5. SORT\n" +
                    "6. FILE READER\n" +
                    "7. FILE WRITER\n" +
                    "8. EXIT \n" +
                    "ENTER YOUR CHOICE: ");

            int choice = 0;
            while (true){
                try {
                    do {
                        choice = Integer.parseInt(scanner.nextLine());
                        if (choice < 1 || choice > 8){
                            System.out.println("INPUT FROM 1->8");
                        }
                    }while (choice < 1 || choice > 8);

                    break;
                }catch (NumberFormatException e){
                    System.out.println("INPUT NUMBER !");
                }
            }


            switch (choice) {
                case 1 -> ManagerStudent.showStudent();
                case 2 -> ManagerStudent.addStudent();
                case 3 -> ManagerStudent.update();
                case 4 -> ManagerStudent.deleteStudent();
                case 5 -> ManagerStudent.sort();
                case 6 -> ManagerStudent.fileReader();
                case 7 -> ManagerStudent.fileWriter();
                case 8 -> check = false;
            }
        }
        System.out.println("THANKS YOU !");
    }
}
