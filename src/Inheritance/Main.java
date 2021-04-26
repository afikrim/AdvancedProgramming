package Inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Manusia manusia = new MahasiswaFILKOM("Aziz", true, "102831983", false, "1098310239109", 4);

        System.out.println(manusia.getPendapatan());

    }

}
