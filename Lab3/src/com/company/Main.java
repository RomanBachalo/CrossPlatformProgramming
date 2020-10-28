package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("============ Task 1 ============\n");
        String text1 = readFromFile("file1.txt");

        Scanner textScanner = new Scanner(text1);
        List<String> sentences = new LinkedList<>();
        textScanner.useDelimiter("\\. |\\? |! |\\n");

        while(textScanner.hasNext()){
            sentences.add(textScanner.next());
        }

        for (String s : sentences) {
            if (s.length() <= 180) {
                System.out.println(s);

            }
            else{
                System.out.println("<Too long sentence deleted>");
            }
        }

        System.out.println("\n\nPossible file paths:\n");

        for(String s : sentences){
            if (findPathInString(s) != null){
                System.out.println(findPathInString(s));
            }
        }


        /* -------------------------------------------------------- */

        System.out.println("============ Task 2 ============\n");
        Task2 task2 = new Task2();
        String text2 = task2.readFromFile("file2.txt");
        List<String> questionSentenceList = task2.findQuestionSentences(text2);

        System.out.print("Enter word length\n> ");

        Scanner myInput = new Scanner(System.in);
        int wordLength = myInput.nextInt();

        for (String s : questionSentenceList){
            System.out.println(s);

            List<String> words = task2.findWordsWithLength(s, wordLength);

            if (words.size() > 0) {
                for (String w : words){
                    System.out.println("    " + w);
                }
            }
            else{
                System.out.println("<There are no such words>");
            }
        }

    }



    //Find possible paths to file in string
    public static String findPathInString(String input){
        int index = -1;

        String[] pathPattern = new String[]{":\\", "\\", ":/", "/"};
        for (String pattern : pathPattern){
            if(input.contains(pattern)){
                index = input.indexOf(pattern);
            }
        }

        if(index == -1){
            return null;
        }

        int begin = -1;
        int end = -1;
        if(input.substring(0 , index).contains(" ")){
            begin = input.substring(0 , index).lastIndexOf(" ") + 1;
        }
        else{
            begin = 0;
        }

        if(input.substring(begin , input.length()).contains(" ")){
            end = input.substring(begin , input.length()).indexOf(" ") + begin;
        }
        else{
            end = input.length();
        }

        return input.substring(begin, end);
    }



    //Read entire text from file
    public static String readFromFile(String filename) throws FileNotFoundException{
        File file = new File(filename);

        Scanner fileScanner = new Scanner(file);
        String text = new String();
        fileScanner.useDelimiter("\\Z");
        text = fileScanner.next();

        return text;
    }
}
