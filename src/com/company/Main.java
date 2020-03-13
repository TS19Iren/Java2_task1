package com.company;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
 * - Найти список слов, из которых состоит текст (дубликаты не считать);
 * - Посчитать сколько раз встречается каждое слово (использовать HashMap);
 * */
public class Main {
    private static String[] wordsArray = {"weather", "wind", "umbrella", "wet", "wind", "coat", "sleepy", "people", "tea", "cold", "city", "rain", "storm",
            "snow", "cold", "cup", "tea", "coffee", "cup", "street", "city", "weather", "homecoming", "rainy","cup"};


    public static void main(String[] args) {
        System.out.println(getUniqueWords(wordsArray));
        System.out.println(getNumberOfWordsRepeat(wordsArray));
    }
      //найти список слов, из которых состоит текст (без дубликатов)
    public static List<String> getUniqueWords(String[] a) {
        List<String> uniqueWords = new ArrayList<>();
        for (String word : a) {
            if (!uniqueWords.contains(word)) {
                uniqueWords.add(word);
            }
        }
        return uniqueWords;
    }
//посчитать сколько раз встречается каждое слово (использовать HashMap)
    public  static Map <String, Integer > getNumberOfWordsRepeat (String[] b) {
        Map <String,Integer> numberCount = new HashMap<>(b.length);
        for (String word : b) {
            if(!numberCount.containsKey(word)){
                numberCount.put(word,1);
            }else {
                numberCount.put(word,numberCount.get(word)+1);
            }
        }
        return numberCount;
    }

}