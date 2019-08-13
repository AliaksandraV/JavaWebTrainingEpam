package by.training.composite;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class HamletInternational {
    public static void main(String[] args) {
        System.out.println("1 — английский \n2 — белорусский \n3 — русский ");

        char i = 0;
        try {
            i = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String country = "US";
        String language = "en";
        switch (i) {
            case '1':
                country = "US";
                language = "en";
                break;
            case '2':
                country = "BY";
                language = "be";
                break;
            case '3':
                country = "RU";
                language = "ru";
                break;
        }
        Locale current = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle("property.text", current);
        String s1 = rb.getString("str1");
        System.out.println(s1);
        String s2 = rb.getString("str2");
        System.out.println(s2);

//        ResourceBundle rb = ResourceBundle.getBundle("property.text", current);
//        String s1 = rb.getString("str1");
//        System.out.println("s1 = " + s1);
//        try {
        String coorectStr = null;
        try {
            coorectStr = new String(s1.getBytes("ISO-8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("coorectStr = " + coorectStr);
    }
}
