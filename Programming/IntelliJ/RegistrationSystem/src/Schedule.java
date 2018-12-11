public class Schedule {

    private String studentID;
    private String course1;
    private String course2;
    private String course3;
    private String course4;
    private String course5;
    private String term;

    ///////////////////////////////////////////////////////////////////////////////////////

    public String getStudentID(){
        return studentID;
    }
    public void setStudentID(String studentID){
        this.studentID = studentID;
    }

    public String getCourse1(){
        return this.course1;
    }
    public void setCourse1(String course){
        this.course1 = course;
    }

    public String getCourse2(){
        return this.course2;
    }
    public void setCourse2(String course){
        this.course2 = course;
    }

    public String getCourse3(){
        return this.course3;
    }
    public void setCourse3(String course){
        this.course3 = course;
    }

    public String getCourse4(){
        return this.course4;
    }
    public void setCourse4(String course){
        this.course4 = course;
    }

    public String getCourse5(){
        return this.course5;
    }
    public void setCourse5(String course){
        this.course5 = course;
    }

    public String getTerm(){
        return term;
    }
    public void setTerm(String term){
        this.term = term;
    }


}
