package users;

import java.util.HashMap;
import java.util.Hashtable;

public class User {
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
     * Hashtable of friends
     */
    private Hashtable<Integer, Friend> friends;
    /**
     * Constructor for user object.
     */
    public User(){

    }

    /**
     * Adds a friend to the hashtable. Key is the friend's id.
     * @param friend
     */
    public void addFriend(Friend friend){
        friends.put(friend.getID(), friend);
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

}
