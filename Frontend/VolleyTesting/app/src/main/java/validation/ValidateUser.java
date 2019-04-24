package validation;

public class ValidateUser {
    /** Method to determine if a string is ALL numeric
     *
     * @param str -- String to be passed in
     * @return -- True if all numeric, false otherwise
     */
    public static boolean allNumbers(String str)
    {
        if(str.length()==0) { return false; }
        for(int i = 0; i < str.length(); i++)
        {
            if(!Character.isDigit(str.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Validates phone number is in correct form. EITHER xxxxxxxxxx OR xxx-xxx-xxxx
     *
     * @param phoneNum - String phone number
     * @return - true if valid phone format, false otherwise.
     */
    public static boolean validPhone(String phoneNum)
    {
        if(phoneNum.length() == 10) { return allNumbers(phoneNum); }
        else if(phoneNum.length() == 12)
        {
            String[] phoneArray = phoneNum.split("-");
            if(phoneArray.length != 3) { return false; }
            else {
                return allNumbers(phoneArray[0] + phoneArray[1] + phoneArray[2]);
            }
        }
        return false;
    }

    /**
     * Validates the user's email follows a 'xxx____@xxx___.xxx format.
     *
     * @param email
     * @return True if email is valid, false otherwise
     */
    public static boolean validateUserEmail(String email)
    {
        String[] emailArray = email.split("@");
        if(emailArray.length == 2){
            String[] emailDot;
            emailDot = emailArray[1].split("\\.");
            if(emailDot.length == 2)
            {
                if(emailDot[1].length() == 3) { return true; }

            }
        }
        return false;
    }
}
