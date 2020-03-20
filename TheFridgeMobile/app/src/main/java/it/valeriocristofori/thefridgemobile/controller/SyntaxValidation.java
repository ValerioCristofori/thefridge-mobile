package it.valeriocristofori.thefridgemobile.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyntaxValidation {

    public boolean validSyntaxUsername( String username ) {
        if (username == null){
            return false;
        }
        return !( username.length() < 4 || username.length() > 30 );
    }

    public boolean validSyntaxPassword( String password ) {
        if (password == null){
            return false;
        }
        return !( password.length() < 6 || password.length() > 30 );
    }

    public boolean validSyntaxEmail( String mail ) {
        if (mail == null){
            return false;
        }

        Pattern p = Pattern.compile(".+@.+\\.[a-z]+", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(mail);
        boolean matchFound = m.matches();

        //Condizioni più restrittive rispetto alle precedenti
        String  expressionPlus="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pPlus = Pattern.compile(expressionPlus, Pattern.CASE_INSENSITIVE);
        Matcher mPlus = pPlus.matcher(mail);
        boolean matchFoundPlus = mPlus.matches();

        return matchFound && matchFoundPlus;
    }


}
