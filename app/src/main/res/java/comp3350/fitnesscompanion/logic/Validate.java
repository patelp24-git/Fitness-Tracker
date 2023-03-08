package comp3350.fitnesscompanion.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    private String inputEmail, inputPassword;

    public Validate(){
        this.inputEmail = "";
        this.inputPassword = "";
    }

    public boolean checkName(final String input){
        if(input != null && input.length() >= 3 && input.length() <= 15){
            final String validate = "[A-Z][a-z]*";
            Pattern val = Pattern.compile(validate,Pattern.CASE_INSENSITIVE);
            Matcher match = val.matcher(input);
            return match.find();
        }
        return false;
    }

    public boolean checkEmail(final String input){
        if(input.length() != 0 && input != null){
            final String validate = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
            Pattern val = Pattern.compile(validate,Pattern.CASE_INSENSITIVE);
            Matcher match = val.matcher(input);
            return match.find();
        }
        return false;
    }

    public boolean checkPassword(final String input){
        if (input.length() != 0 && input != null){
            final String validate = "^(?=.*\\d)(?=\\S+$)(?=.*[@#$%&+=])(?=.*[a-z])(?=.*[A-Z]).{8,10}$";
            Pattern val = Pattern.compile(validate,Pattern.CASE_INSENSITIVE);
            Matcher match = val.matcher(input);
            return match.find();
        }
        return false;
    }



    public boolean verifyNumber(final String Number){
        try{
            int num =  Integer.parseInt(Number);
            if(!(num <= 0) && num < Integer.MAX_VALUE ){
                return true;
            }
        }catch(Exception e) {
            return false;
        }
        return false;
    }

}
