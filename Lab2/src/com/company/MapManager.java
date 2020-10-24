package com.company;

import java.util.*;
import java.io.File;

public class MapManager {
    public static Map<String, List<FootballClub>> PutDataToMap(List<FootballClub> footballClubList) {
        Map<String, List<FootballClub>> resultMap = new TreeMap<String, List<FootballClub>>();

        for (FootballClub club: footballClubList) {
            if (!resultMap.containsKey(club.getCity())) {
                resultMap.put(club.getCity(), new LinkedList<FootballClub>());
            }
            resultMap.get(club.getCity()).add(club);
        }

        return resultMap;
    }

    public static void PrintMap(Map<String, List<FootballClub>> map) {
        for (String key : map.keySet()) {
            System.out.println(key);
            for (FootballClub club : map.get(key)) {
                System.out.println("    " + club.getName() + ", " + club.getFoundationDate());
            }
        }
    }

    public static void PrintMap(Map<String, List<FootballClub>> map, int n) {
        if(n < 0){
            PrintMap(map);
        }

        for (String key : map.keySet()) {
            int counter = 0;
            System.out.println(key);
            for (FootballClub club : map.get(key)) {
                if ((++counter) > n) {
                    continue;
                }
                System.out.println("    " + club.getName() + ", " + club.getFoundationDate());
            }
        }
    }

    public static int SimilarClubCount(Map<String, List<FootballClub>> map){

        Set<String> citiesWithSimilarClub = new TreeSet<>();

        String[] keySet = new String[map.size()];
        map.keySet().toArray(keySet);

        for (int i = 0; i < keySet.length; ++i){
            for (int j = i; j < keySet.length; ++j){
                if(i == j){
                    continue;
                }
                List<FootballClub> clubs = CommonElements(map.get(keySet[i]), map.get(keySet[j]));

                if(!clubs.isEmpty()){
                    citiesWithSimilarClub.add(keySet[i]);
                    citiesWithSimilarClub.add(keySet[j]);
                }
            }
        }
        return citiesWithSimilarClub.size();
    }

    public static Map<String, List<FootballClub>> ReadFromFiles(MergeOptions mergeOption)
    {
        Map<String, List<FootballClub>> map1 = new TreeMap<String, List<FootballClub>>();
        Map<String, List<FootballClub>> map2 = new TreeMap<String, List<FootballClub>>();
        List<FootballClub> footballClubs1 = new LinkedList<FootballClub>(){};
        List<FootballClub> footballClubs2 = new LinkedList<FootballClub>(){};

        String fileName1 = "E:\\Term5\\CrossPlatformProgramming\\Lab2\\File1.txt";
        String fileName2 = "E:\\Term5\\CrossPlatformProgramming\\Lab2\\File2.txt";

        ReadFile(footballClubs1, fileName1);
        ReadFile(footballClubs2, fileName2);

        map1 = PutDataToMap(footballClubs1);
        map2 = PutDataToMap(footballClubs2);

        switch (mergeOption){
            case ALL:
                return MergeMaps(map1, map2);
            case COMMON:
                return MergeSimilarFromMaps(map1, map2);
        }
        return MergeMaps(map1, map2);
    }

    private static void ReadFile(List<FootballClub> footballClubs, String fileName) {
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            while(myReader.hasNextLine()){
                String name = myReader.next();
                String city = myReader.next();
                String year = myReader.next();

                footballClubs.add(new FootballClub(name, city, Integer.parseInt(year)));
            }
            myReader.close();
        }
        catch (Exception e){
            System.out.println("Something went wrong with " + fileName);
        }
    }

    public static Map<String, List<FootballClub>> MergeMaps(Map<String, List<FootballClub>> map1, Map<String, List<FootballClub>> map2){
        Map<String, List<FootballClub>> resultMap = new TreeMap<String, List<FootballClub>>(map1);

        for(String key : map2.keySet()){
            if(!resultMap.containsKey(key)){
                resultMap.put(key, map2.get(key));
            }
            else{
                for (FootballClub club : map2.get(key)){
                    if(!resultMap.get(key).contains(club)){
                        resultMap.get(key).add(club);
                    }
                }
            }
        }

        return resultMap;
    }

    public static Map<String, List<FootballClub>> MergeSimilarFromMaps(Map<String, List<FootballClub>> map1, Map<String, List<FootballClub>> map2){
        Map<String, List<FootballClub>> resultMap = new TreeMap<String, List<FootballClub>>();

        for(String key : map1.keySet()){
            if(map2.containsKey(key) && !CommonElements(map1.get(key), map2.get(key)).isEmpty()){
                resultMap.put(key, CommonElements(map1.get(key), map2.get(key)));
            }
        }

        return resultMap;
    }

    public static List<FootballClub> CommonElements(List<FootballClub> f1, List<FootballClub> f2){
        List<FootballClub> resultList = new LinkedList<>();

        for (FootballClub club : f1){
            if(f2.contains(club)){
                resultList.add(club);
            }
        }

        return resultList;
    }

}

enum MergeOptions{
    ALL,
    COMMON
}