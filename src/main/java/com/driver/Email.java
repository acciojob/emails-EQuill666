package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword) {
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        //Start Here

        if (oldPassword.equals(password)) {
            if (!checkValid(newPassword)) {
                System.out.println("Invalid Password!!");
            } else {
                this.password = newPassword;
                System.out.println("Password Changed!!");
            }
        }
        else{
            System.out.println("Does not Match Current Password!!");
        }
    }
    public boolean checkValid(String pass){
        if(pass.length() < 8){
            return false;
        }
        //flags
        Boolean caps = false;
        Boolean small = false;
        Boolean num = false;
        Boolean spChar = false;

        for(int i = 0; i<pass.length(); i++){
            char ch = pass.charAt(i);
            if((ch >= 'A') && (ch <= 'Z')){
                caps = true;
            }
            else if((ch >= 'a') && (ch <= 'z')){
                small = true;
            }
            else if((ch >= '0') && (ch <= '9')){
                num = true;
            }
            else if(!((ch >= 'A') && (ch <= 'Z')) && !((ch >= 'a') && (ch <= 'z')) && !((ch >= '0') && (ch <= '9'))){
                spChar = true;
            }
        }
        return caps && small && num && spChar;
    }
}

