import java.util.Scanner;

public class Student {

    private String studentID;
    private String password;
    private String firstName;
    private String lastName;

////////////////////////////////////////////////////////////////////////////////

    public String getStudentID(){
        return studentID;
    }
    public void setStudentID(String studentID){
        this.studentID = studentID;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /////////////////////////////////////////////////////////////////


}
