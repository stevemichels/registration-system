import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static boolean runProgram = true;

    public static void main(String[] args) {

        // declare ArrayLists for saving all CSV data
        ArrayList<Student> studentList = new ArrayList();
        ArrayList<Parent> parentList = new ArrayList();
        ArrayList<Adviser> adviserList = new ArrayList();
        ArrayList<Course> courseList = new ArrayList();
        ArrayList<Schedule> scheduleList = new ArrayList();


        // fill ArrayLists by reading CSV's
        CSV.readStudentCSV(studentList);
        CSV.readParentCSV(parentList);
        CSV.readAdviserCSV(adviserList);
        CSV.readCoursesCSV(courseList);
        CSV.readScheduleCSV(scheduleList);


        // Main menu loop
        int action;
        while(runProgram){
            action = startMenu();
            switch(action){
                case 0: runProgram = false;
                        System.exit(0);
                break;
                case 1: studentLogin(studentList, scheduleList, courseList);
                break;
                case 2: parentLogin(parentList, studentList, scheduleList);
                break;
                case 3: adviserLogin(adviserList, studentList, scheduleList, courseList);
                break;
                case 4: createStudent(studentList);
                break;
                case 5: createParent(parentList);
                break;
                case 6: createAdviser(adviserList);
                break;
            }

        }

    }

    public static int startMenu(){
        int response;
        Scanner scan = new Scanner(System.in);

        System.out.println("What would you like to do? (Enter Number)");
        System.out.println("1) Student Login");
        System.out.println("2) Parent Login");
        System.out.println("3) Adviser Login");
        System.out.println("4) Create Student Account");
        System.out.println("5) Create Parent Account");
        System.out.println("6) Create Adviser Account");
        System.out.println("0) Exit Program");
        System.out.print(">>>>>> ");
        response = scan.nextInt();

        if(response < 0 || response > 6){
            System.out.println("ERROR in Start Menu Response");
            response = -1;
        }

        return response;
    }


    ///// Student Methods

    public static void createStudent(ArrayList<Student> studentList){
        Scanner scan = new Scanner(System.in);

        Student student = new Student();
        String studentID;
        String password;
        String firstName;
        String lastName;

        System.out.print("Enter Student ID: ");
        studentID = scan.nextLine();
        student.setStudentID(studentID);

        System.out.print("Enter Student Password: ");
        password = scan.nextLine();
        student.setPassword(password);

        System.out.print("Enter First Name: ");
        firstName = scan.nextLine();
        student.setFirstName(firstName);

        System.out.print("Enter Last Name: ");
        lastName = scan.nextLine();
        student.setLastName(lastName);

        CSV.appendStudentCSV(student);
        CSV.readStudentCSV(studentList);
    }

    public static void studentLogin(ArrayList<Student> studentList, ArrayList<Schedule> scheduleList,
                                    ArrayList<Course> courseList){
        Scanner scan = new Scanner(System.in);
        String userID = "";
        String password = "";

        System.out.print("Enter User ID: ");
        userID = scan.nextLine();
        System.out.print("Enter User Password: ");
        password = scan.nextLine();

        /////////////////////////////////////////////////////
        boolean userFound = false;
        int action;

        while(!userFound) {
            for (int i = 0; i < studentList.size(); i++) {
                Student student = new Student();
                student = studentList.get(i);

                if (userID.equals(student.getStudentID()) && password.equals(student.getPassword())) {
                    System.out.println("* * Successful Login * * ");
                    System.out.println("Welcome " + student.getFirstName() + " " + student.getLastName());
                    action = studentMenu();
                    userFound = true;

                    switch(action){
                        case 0: runProgram = false;
                        System.exit(0);
                        break;
                        case 1: createSchedule(student, scheduleList, courseList);
                        break;
                        case 2: viewSchedule(scheduleList, student);
                        break;
                        case 3: deleteSchedule(student, scheduleList);
                        break;
                    }
                }
                else
                {
                    System.out.println("User not found");
                }
            }
        }
    }

    public static int studentMenu(){
        int response;
        Scanner scan = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("1) Create Schedule");
        System.out.println("2) View Schedule");
        System.out.println("3) Delete Schedule");
        System.out.print(">>>>>>");
        response = scan.nextInt();

        if(response < 0 || response > 3){
            System.out.println("ERROR in Student Menu Response");
            response = -1;
        }

        return response;
    }

    public static void createSchedule(Student user, ArrayList<Schedule> scheduleList, ArrayList<Course> courseList){
        Scanner scan = new Scanner(System.in);

        System.out.println("* Creating a schedule for " + user.getFirstName() + " " + user.getLastName());
        System.out.println();
        System.out.println("Available courses: ");
        displayCourseList(courseList);

        // creating the schedule
        Schedule schedule = new Schedule();
        schedule.setStudentID(user.getStudentID());

        System.out.print("Enter Term: ");
        schedule.setTerm(scan.nextLine());
        System.out.print("Enter Course ID for Course 1: ");
        schedule.setCourse1(scan.nextLine());
        System.out.print("Enter Course ID for Course 2: ");
        schedule.setCourse2(scan.nextLine());
        System.out.print("Enter Course ID for Course 3: ");
        schedule.setCourse3(scan.nextLine());
        System.out.print("Enter Course ID for Course 4: ");
        schedule.setCourse4(scan.nextLine());
        System.out.print("Enter Course ID for Course 5: ");
        schedule.setCourse5(scan.nextLine());


        // display schedule (check)
        System.out.println("Student: " + user.getFirstName() + " " + user.getLastName());
        System.out.println("Term: " + schedule.getTerm());
        System.out.println("Course 1: " + schedule.getCourse1());
        System.out.println("Course 2: " + schedule.getCourse2());
        System.out.println("Course 3: " + schedule.getCourse3());
        System.out.println("Course 4: " + schedule.getCourse4());
        System.out.println("Course 5: " + schedule.getCourse5());

        CSV.appendScheduleCSV(schedule);
        CSV.readScheduleCSV(scheduleList);
    }

    public static void viewSchedule(ArrayList<Schedule> scheduleList, Student user){
        Schedule schedule = new Schedule();
        for(int i = 0; i < scheduleList.size(); i++){
            schedule = scheduleList.get(i);
            if(user.getStudentID().equals(schedule.getStudentID())){
                System.out.println("Showing Schedule(s) for " + user.getFirstName() + " " + user.getLastName());
                System.out.println("Term: " + schedule.getTerm());
                System.out.println("Course 1: " + schedule.getCourse1());
                System.out.println("Course 2: " + schedule.getCourse2());
                System.out.println("Course 3: " + schedule.getCourse3());
                System.out.println("Course 4: " + schedule.getCourse4());
                System.out.println("Course 5: " + schedule.getCourse5());
            }
        }
    }

    public static void deleteSchedule(Student user, ArrayList<Schedule> scheduleList){
        // not yet.
    }

    public static void checkStudentList(ArrayList<Student> studentList){
        Student student;

        for(int i = 0; i < studentList.size(); i++){
            student = studentList.get(i);
            System.out.println("Student ID: " + student.getStudentID());
            System.out.println("Student Password: " + student.getPassword());
            System.out.println("Student Name: " + student.getFirstName() + " " + student.getLastName());
            System.out.println();
        }
    }

    ///// Parent Methods

    public static void createParent(ArrayList<Parent> parentList){
        Scanner scan = new Scanner(System.in);

        Parent parent = new Parent();
        String parentID;
        String parentPassword;
        String studentID;

        System.out.print("Enter Parent ID: ");
        parentID = scan.nextLine();
        parent.setParentID(parentID);

        System.out.print("Enter Parent Password: ");
        parentPassword = scan.nextLine();
        parent.setParentPassword(parentPassword);

        System.out.print("Enter Associated Student ID: ");
        studentID = scan.nextLine();
        parent.setStudentID(studentID);

        CSV.appendParentCSV(parent);
        CSV.readParentCSV(parentList);
    }

    public static void parentLogin(ArrayList<Parent> parentList, ArrayList<Student> studentList,
                                   ArrayList<Schedule> scheduleList) {
        Scanner scan = new Scanner(System.in);
        String userID = "";
        String password = "";

        System.out.print("Enter Parent ID: ");
        userID = scan.nextLine();
        System.out.print("Enter Password: ");
        password = scan.nextLine();

        //////////////////////////////////////////////////////
        boolean userFound = false;
        int action;

        while (!userFound) {
            for (int i = 0; i < parentList.size(); i++) {
                Parent parent = new Parent();
                parent = parentList.get(i);
                String associatedStudent = "";

                if (userID.equals(parent.getParentID()) && password.equals(parent.getParentPassword())) {
                    System.out.println("* * Successful Login * * ");
                    associatedStudent = parent.getStudentID();

                    for (int j = 0; j < studentList.size(); i++) {
                        Student student = new Student();
                        student = studentList.get(i);
                        if (associatedStudent.equals(student.getStudentID())) {
                            System.out.println("Welcome, Parent of " + student.getFirstName() + " " + student.getLastName());
                            action = parentMenu();
                            userFound = true;

                            switch(action){
                                case 0: runProgram = false;
                                System.exit(0);
                                break;
                                case 1: viewSchedule(scheduleList, parent);
                            }
                        } else {
                            System.out.println("Welcome Parent!");
                        }
                    }
                }
            }
        }
    }

    public static int parentMenu(){
        int response;
        Scanner scan = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("1) View Schedule");
        System.out.print(">>>>>>");
        response = scan.nextInt();

        if(response < 0 || response > 1){
            System.out.println("ERROR in Parent Menu");
        }

        return response;
    }

    public static void viewSchedule(ArrayList<Schedule> scheduleList, Parent user){
        Schedule schedule = new Schedule();
        for(int i = 0; i < scheduleList.size(); i++){
            schedule = scheduleList.get(i);
            if(user.getStudentID().equals(schedule.getStudentID())){
                System.out.println("Term: " + schedule.getTerm());
                System.out.println("Course 1: " + schedule.getCourse1());
                System.out.println("Course 2: " + schedule.getCourse2());
                System.out.println("Course 3: " + schedule.getCourse3());
                System.out.println("Course 4: " + schedule.getCourse4());
                System.out.println("Course 5: " + schedule.getCourse5());
            }
        }
    }

    public static void checkParentList(ArrayList<Parent> parentList){
        Parent parent;

        for(int i = 0; i < parentList.size(); i++){
            parent = parentList.get(i);
            System.out.println("Parent ID: " + parent.getParentID());
            System.out.println("Parent Password: " + parent.getParentPassword());
            System.out.println("Associated Student: " + parent.getStudentID());
        }
    }

    ///// Adviser Methods

    public static void createAdviser(ArrayList<Adviser> adviserList){
        Scanner scan = new Scanner(System.in);

        Adviser adviser = new Adviser();
        String adviserID;
        String adviserPassword;

        System.out.print("Enter Adviser ID: ");
        adviserID = scan.nextLine();
        adviser.setAdvisorID(adviserID);

        System.out.print("Enter Adviser Password: ");
        adviserPassword = scan.nextLine();
        adviser.setAdvisorPassword(adviserPassword);

        CSV.appendAdviserCSV(adviser);
        CSV.readAdviserCSV(adviserList);
    }

    public static void adviserLogin(ArrayList<Adviser> adviserList, ArrayList<Student> studentList,
                                    ArrayList<Schedule> scheduleList, ArrayList<Course> courseList){
        Scanner scan = new Scanner(System.in);

        String userID = "";
        String password = "";

        System.out.print("Enter Adviser ID: ");
        userID = scan.nextLine();
        System.out.print("Enter Password: ");
        password = scan.nextLine();

        //////////////////////////////////////////////////////
        boolean userFound = false;
        int action;

        while(!userFound){
            for(int i = 0; i < adviserList.size(); i++){
                Adviser adviser = new Adviser();
                adviser = adviserList.get(i);

                if(userID.equals(adviser.getAdvisorID()) && password.equals(adviser.getAdvisorPassword())){
                    System.out.println("* * Successful Login * * ");
                    System.out.println("Welcome, Adviser.");
                    action = adviserMenu();
                    userFound = true;

                    switch(action){
                        case 0: runProgram = false;
                        System.exit(0);
                        break;
                        case 1: createStudentSchedule(studentList, scheduleList, courseList);
                        break;
                        case 2: editStudentSchedule();
                        break;
                        case 3: deleteStudentSchedule();
                        break;
                        case 4: createCourse(courseList);
                        break;
                    }
                }
                else
                {
                    System.out.println("User not found.");
                }
            }
        }
    }

    public static int adviserMenu(){
        int response;
        Scanner scan = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("1) Create Student Schedule");
        System.out.println("2) Edit Student Schedule");
        System.out.println("3) Delete Student Schedule");
        System.out.println("4) Create Course");
        System.out.print(">>>>>");
        response = scan.nextInt();

        if(response < 0 || response > 3){
            System.out.print("ERROR in Adviser Menu Response");
            response = -1;
        }

        return response;
    }

    public static void checkAdviserList(ArrayList<Adviser> adviserList){
        Adviser adviser;

        for(int i = 0; i < adviserList.size(); i++){
            adviser = adviserList.get(i);
            System.out.println("Adviser ID: " + adviser.getAdvisorID());
            System.out.println("Adviser Password: " + adviser.getAdvisorPassword());
        }

    }

    public static void createStudentSchedule(ArrayList<Student> studentList,
                                             ArrayList<Schedule> scheduleList, ArrayList<Course> courseList){
        Scanner scan = new Scanner(System.in);
        String studentID;

        System.out.print("Enter Student ID: ");
        studentID = scan.nextLine();

        for(int i = 0; i < studentList.size(); i++){
            Student student = new Student();
            student = studentList.get(i);
            if(studentID.equals(student.getStudentID())){

                System.out.println("* Creating a schedule for " + student.getFirstName() + " " + student.getLastName());
                System.out.println();
                System.out.println("Available courses: ");
                displayCourseList(courseList);

                // creating the schedule
                Schedule schedule = new Schedule();
                schedule.setStudentID(student.getStudentID());

                System.out.print("Enter Term: ");
                schedule.setTerm(scan.nextLine());
                System.out.print("Enter Course ID for Course 1: ");
                schedule.setCourse1(scan.nextLine());
                System.out.print("Enter Course ID for Course 2: ");
                schedule.setCourse2(scan.nextLine());
                System.out.print("Enter Course ID for Course 3: ");
                schedule.setCourse3(scan.nextLine());
                System.out.print("Enter Course ID for Course 4: ");
                schedule.setCourse4(scan.nextLine());
                System.out.print("Enter Course ID for Course 5: ");
                schedule.setCourse5(scan.nextLine());

                // display schedule (check)
                System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
                System.out.println("Term: " + schedule.getTerm());
                System.out.println("Course 1: " + schedule.getCourse1());
                System.out.println("Course 2: " + schedule.getCourse2());
                System.out.println("Course 3: " + schedule.getCourse3());
                System.out.println("Course 4: " + schedule.getCourse4());
                System.out.println("Course 5: " + schedule.getCourse5());
            }
        }


    }

    public static void editStudentSchedule(){
        // not yet.
    }

    public static void deleteStudentSchedule(){
        // not yet.
    }

    public static void createCourse(ArrayList<Course> courseList){
        Scanner scan = new Scanner(System.in);

        Course course = new Course();
        String courseID;
        String courseName;
        String courseDescription;

        System.out.print("Enter Course ID: ");
        courseID = scan.nextLine();
        course.setCourseID(courseID);

        System.out.print("Enter Course Name: ");
        courseName = scan.nextLine();
        course.setCourseName(courseName);

        System.out.print("Enter Course Description: ");
        courseDescription = scan.nextLine();
        course.setCourseDescription(courseDescription);

        CSV.appendCourseCSV(course);
        CSV.readCoursesCSV(courseList);
    }

    public static void displayCourseList(ArrayList<Course> courseList){
        Course course;

        System.out.println("Available Courses: ");
        for(int i = 0; i < courseList.size(); i++){
            course = courseList.get(i);
            System.out.println("Course ID: " + course.getCourseID());
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Course Description: " + course.getCourseDescription());
            System.out.println();
        }
        System.out.println();
        System.out.println("* END OF COURSE LIST * ");
    }


}
