import java.io.*;
import java.util.ArrayList;

public class CSV {

    static String studentCSV = "studentCSV.txt";
    static String parentCSV = "parentCSV.txt";
    static String advisorCSV = "advisorCSV.txt";
    static String courseCSV = "courseCSV.txt";
    static String scheduleCSV = "scheduleCSV.txt";

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void readStudentCSV(ArrayList<Student> studentList){
        String currentLine = "";
        String[] values = new String[4];
        String delimiter = ",";

        try{
            BufferedReader reader = new BufferedReader(new FileReader(studentCSV));
            while((currentLine = reader.readLine()) != null){
                Student student = new Student();
                values = currentLine.split(delimiter);
                student.setStudentID(values[0]);
                student.setPassword(values[1]);
                student.setFirstName(values[2]);
                student.setLastName(values[3]);

                studentList.add(student);
            }
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File Not Found Exception - CSV.java - readStudentCSV");

        }
        catch(IOException e){
            System.out.println("IO Exception - CSV.java - readStudentCSV");
        }
    }

    public static void writeStudentCSV(ArrayList<Student> list){
        String record = "";
        String delimiter = ",";

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(studentCSV, true));
            for(int i = 0; i < list.size(); i++){
                Student student = new Student();
                student = list.get(i);

                record = student.getStudentID() + delimiter +
                                student.getPassword() + delimiter +
                                student.getFirstName() + delimiter +
                                student.getLastName();

                writer.write(record, 0, record.length());
                writer.newLine();
                writer.close();
            }

        }
        catch(IOException e){
            System.out.println("IO Exception - CSV.java = writeStudentCSV");
        }
    }

    public static void appendStudentCSV(Student student){
        String record = "";
        String delimiter = ",";

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(studentCSV, true));
            record = student.getStudentID() + delimiter +
                    student.getPassword() + delimiter +
                    student.getFirstName() + delimiter +
                    student.getLastName();

            writer.write(record, 0, record.length());
            writer.newLine();
            writer.close();
        }
        catch(IOException e){
            System.out.println("IO Exception - CSV.java = appendStudentCSV");
        }
    }



    public static void readParentCSV(ArrayList<Parent> parentList){
        String currentLine = "";
        String[] values = new String[3];
        String delimiter = ",";

        try{
            BufferedReader reader = new BufferedReader(new FileReader(parentCSV));
            while((currentLine = reader.readLine()) != null){
                    Parent parent = new Parent();
                    values = currentLine.split(delimiter);
                    parent.setParentID(values[0]);
                    parent.setParentPassword(values[1]);
                    parent.setStudentID(values[2]);

                    parentList.add(parent);

            }
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File Not Found Exception - CSV.java - readParentCSV");

        }
        catch(IOException e){
            System.out.println("IO Exception - CSV.java - readParentCSV");
        }
    }

    public static void writeParentCSV(ArrayList<Parent> list){
        String record = "";
        String delimiter = ",";

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(parentCSV, true));
            for(int i = 0; i < list.size(); i++){
                Parent parent = new Parent();
                parent = list.get(i);


                record = parent.getParentID() + delimiter +
                        parent.getParentPassword() + delimiter +
                        parent.getStudentID();

                writer.write(record, 0, record.length());
                writer.newLine();
                writer.close();
            }

        }
        catch(IOException e){
            System.out.println("IO Exception - CSV.java = writeStudentCSV");
        }
    }

    public static void appendParentCSV(Parent parent){
        String record = "";
        String delimiter = ",";

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(parentCSV, true));
            record = parent.getParentID() + delimiter +
                    parent.getParentPassword() + delimiter +
                    parent.getStudentID();

            writer.write(record, 0, record.length());
            writer.newLine();
            writer.close();
        }
        catch(IOException e){
            System.out.println("IO Exception - CSV.java = appendParentCSV");
        }
    }



    public static void readAdviserCSV(ArrayList<Adviser> adviserList){
        String currentLine = "";
        String[] values = new String[2];
        String delimiter = ",";

        try{
            BufferedReader reader = new BufferedReader(new FileReader(advisorCSV));
            while((currentLine = reader.readLine()) != null){
                Adviser adviser = new Adviser();
                values = currentLine.split(delimiter);
                adviser.setAdvisorID(values[0]);
                adviser.setAdvisorPassword(values[1]);

                adviserList.add(adviser);
            }
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File Not Found Exception - CSV.java - readAdvisorCSV");

        }
        catch(IOException e){
            System.out.println("IO Exception - CSV.java - readAdvisorCSV");
        }
    }

    public static void writeAdviserCSV(ArrayList<Adviser> list){
        String record = "";
        String delimiter = ",";

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(studentCSV, true));
            for(int i = 0; i < list.size(); i++){
                Adviser adviser = new Adviser();
                 adviser = list.get(i);

                record = adviser.getAdvisorID() + delimiter +
                        adviser.getAdvisorPassword();

                writer.write(record, 0, record.length());
                writer.newLine();
                writer.close();
            }

        }
        catch(IOException e){
            System.out.println("IO Exception - CSV.java = writeAdviserCSV");
        }
    }

    public static void appendAdviserCSV(Adviser adviser){
        String record = "";
        String delimiter = ",";

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(advisorCSV, true));
            record = adviser.getAdvisorID() + delimiter +
                    adviser.getAdvisorPassword();

            writer.write(record, 0, record.length());
            writer.newLine();
            writer.close();
        }
        catch(IOException e){
            System.out.println("IO Exception - CSV.java = appendAdviserCSV");
        }
    }


    public static void readCoursesCSV(ArrayList<Course> courseList){
        String currentLine = "";
        String[] values = new String[3];
        String delimiter = ",";

        try{
            BufferedReader reader = new BufferedReader(new FileReader(courseCSV));
            while((currentLine = reader.readLine()) != null){
                Course course = new Course();
                values = currentLine.split(delimiter);
                course.setCourseID(values[0]);
                course.setCourseName(values[1]);
                course.setCourseDescription(values[2]);

                courseList.add(course);
            }
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File Not Found Exception - CSV.java - readStudentCSV");

        }
        catch(IOException e){
            System.out.println("IO Exception - CSV.java - readStudentCSV");
        }
    }

    public static void writeCoursesCSV(ArrayList<Course> list){
        String record = "";
        String delimiter = ",";

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(courseCSV, true));
            for(int i = 0; i < list.size(); i++){
                Course course = new Course();

                record = course.getCourseID() + delimiter +
                        course.getCourseName() + delimiter +
                        course.getCourseDescription();

                writer.write(record, 0, record.length());
                writer.newLine();
                writer.close();
            }

        }
        catch(IOException e){
            System.out.println("IO Exception - CSV.java = writeStudentCSV");
        }
    }

    public static void appendCourseCSV(Course course){
        String record = "";
        String delimiter = ",";

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(courseCSV, true));
            record = course.getCourseID() + delimiter +
                    course.getCourseName() + delimiter +
                    course.getCourseDescription();

            writer.write(record, 0, record.length());
            writer.newLine();
            writer.close();
        }
        catch(IOException e){
            System.out.println("IO Exception - CSV.java = appendCourseCSV");
        }
    }



    public static void readScheduleCSV(ArrayList<Schedule> scheduleList){
        String currentLine = "";
        String[] values = new String[7];
        String delimiter = ",";

        try{
            BufferedReader reader = new BufferedReader(new FileReader(scheduleCSV));
            while((currentLine = reader.readLine()) != null){
                Schedule schedule = new Schedule();
                values = currentLine.split(delimiter);
                schedule.setStudentID(values[0]);
                schedule.setCourse1(values[1]);
                schedule.setCourse2(values[2]);
                schedule.setCourse3(values[3]);
                schedule.setCourse4(values[4]);
                schedule.setCourse5(values[5]);
                schedule.setTerm(values[6]);

                scheduleList.add(schedule);
            }
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File Not Found Exception - CSV.java - readStudentCSV");

        }
        catch(IOException e){
            System.out.println("IO Exception - CSV.java - readStudentCSV");
        }
    }

    public static void writeScheduleCSV(ArrayList<Schedule> list){
        String record = "";
        String delimiter = ",";

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(studentCSV, true));
            for(int i = 0; i < list.size(); i++){
                Schedule schedule = new Schedule();

                record = schedule.getStudentID() + delimiter +
                        schedule.getCourse1() + delimiter +
                        schedule.getCourse2() + delimiter +
                        schedule.getCourse3() + delimiter +
                        schedule.getCourse4() + delimiter +
                        schedule.getCourse5() + delimiter +
                        schedule.getTerm();

                writer.write(record, 0, record.length());
                writer.newLine();
                writer.close();
            }

        }
        catch(IOException e){
            System.out.println("IO Exception - CSV.java = writeStudentCSV");
        }
    }

    public static void appendScheduleCSV(Schedule schedule){
        String record = "";
        String delimiter = ",";

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(scheduleCSV, true));
            record = schedule.getStudentID() + delimiter + schedule.getCourse1() +
                    schedule.getCourse2() + delimiter + schedule.getCourse3() +
                    schedule.getCourse4() + delimiter + schedule.getCourse5() +
                    schedule.getTerm();

            writer.write(record, 0, record.length());
            writer.newLine();
            writer.close();
        }
        catch(IOException e){
            System.out.println("IO Exception - CSV.java = appendCourseCSV");
        }
    }

}
