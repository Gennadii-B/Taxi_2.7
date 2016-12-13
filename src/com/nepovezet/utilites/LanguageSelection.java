package com.nepovezet.utilites;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.nepovezet.tools.SOPrint.println;

/**
 * Created by gendy on 13.12.16.
 */
public class LanguageSelection {

    boolean isOk = true;
    Matcher matcher;
    Dialog dialog = Dialog.getInstance();

    public void quLocale () throws Exception{
        println("1. Русский\n2. English");
        String answerLocale = "";
        Pattern pattern = Pattern.compile("[12]");

        while(isOk){
            answerLocale = dialog.reader.readLine();
            Matcher matcher = pattern.matcher(answerLocale);
            if(matcher.matches()) isOk = false;
            else System.out.println("incorrect input");
        }


        if(answerLocale.equals("1"))dialog.texts.setNeedLocale(dialog.texts.getRuLocale());
        else if(answerLocale.equals("2"))dialog.texts.setNeedLocale(dialog.texts.getEnLocale());
        dialog.texts = new Texts();
        isOk = true;

    }
}
