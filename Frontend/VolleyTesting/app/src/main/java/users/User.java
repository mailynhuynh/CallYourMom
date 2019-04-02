package users;

public class User {
    /**
     * Unique ID identifying user.
     */
    private static long staticUserId = 0;
    private long userId;
    /**
     * First name of user
     */
    private String name;
    /**
     * Last name of user
     */
    private String lastName;
    /**
     * Username of user
     */
    private String userName;
    /**
     * Password of user
     */
    private String password;
    /**
     * Email of user
     */
    private String email;
    /**
     * phone number of user
     */
    private String phoneNum;

    /**
     * Constructor for user object.
     */
    public User(){
        staticUserId++;
        userId = staticUserId;

    }

    /**
     *Setter methods
     */
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFirstName(String name){
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUser(String fname, String lname, String userName,
                        String password, String email, String phone){
        name = fname;
        lastName = lname;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNum = phone;
    }

    /**
     * Getter methods
     */
    public String getFirstName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public long getUserId() { return userId;}
}
