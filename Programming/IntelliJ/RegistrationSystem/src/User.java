public class User {

    private String userID;
    private int clearenceLevel;

    //////////////////////////////////////////////////////////////////////

    public String getUserID(){
        return userID;
    }
    public void setUserID(String userID){
        this.userID = userID;
    }

    public int getClearenceLevel(){
        return clearenceLevel;
    }
    public void setClearenceLevel(int clearenceLevel){
        this.clearenceLevel = clearenceLevel;
    }
}
