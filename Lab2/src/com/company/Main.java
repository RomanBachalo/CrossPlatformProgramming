package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String,List<FootballClub>> footballClubsMap = new HashMap<String, List<FootballClub>>();

        boolean exit = false;

        while (!exit) {
            System.out.print("1.Print map    ");
            System.out.print("2.Add club   ");
            System.out.print("3.Remove club   ");
            System.out.print("4.Read from files   \n\n> ");

            Scanner myInput = new Scanner(System.in);
            int option = (int) myInput.nextInt();

            switch (option) {
                case 1:
                    System.out.print("How much clubs to print? \n> ");
                    int n = (int) myInput.nextInt();
                    MapManager.PrintMap(footballClubsMap, n);
                    System.out.println("Count of cities with same clubs is " + MapManager.SimilarClubCount(footballClubsMap));
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Enter name \n> ");
                    String newName = myInput.next();
                    System.out.print("Enter city \n> ");
                    String newCity = myInput.next();
                    System.out.print("Enter foundation date \n> ");
                    int newYear = (int) myInput.nextInt();

                    FootballClub newClub = new FootballClub(newName, newCity, newYear);

                    if(!footballClubsMap.containsKey(newCity))
                    {
                        footballClubsMap.put(newCity, new LinkedList<FootballClub>());
                    }
                    footballClubsMap.get(newCity).add(newClub);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Enter name \n> ");
                    String _name = myInput.next();
                    System.out.print("Enter city \n> ");
                    String _city = myInput.next();
                    System.out.print("Enter foundation date \n> ");
                    int _year = (int) myInput.nextInt();

                    FootballClub clubToDelete = new FootballClub(_name, _city, _year);

                    if(footballClubsMap.containsKey(_city) && footballClubsMap.get(_city).contains(clubToDelete))
                    {
                        footballClubsMap.get(_city).remove(clubToDelete);
                    }
                    else{
                        System.out.println("There is no such club");
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Choose merge options \n 1 - All clubs   2 - Common clubs only \n> ");
                    int mergeOption = (int) myInput.nextInt();

                    if (mergeOption == 1)
                    footballClubsMap = MapManager.ReadFromFiles(MergeOptions.ALL);

                    else{
                        footballClubsMap = MapManager.ReadFromFiles(MergeOptions.COMMON);
                    }
                    System.out.println();
                    break;

                default:
                    exit = true;
                    break;
            }
        }
    }
}
