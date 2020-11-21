package study.Collectons;

import study.Strings.MySet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyDictionaryOfWords {
    List<Map<String, Double>> frequencyWords;
    String text;

    public FrequencyDictionaryOfWords(String text) {
        this.frequencyWords = new ArrayList<>();
        this.text=text;
    }

    public List<Map<String, Double>> getFrequencyWords() {

        String[] words = this.text.toLowerCase().split("\\s*(\\s|,|!|\\.)\\s*");
        MySet set = new MySet();
        for (String word : words) {
            set.add(word);
        }

        for (int i = 0; i < set.size(); i++) {
            int count = 0;

            for (int word = 0; word < words.length; word++) {
                if (set.getSet(i).toString().equals(word)){

                }
            }
            for (String word : words) {
                if (set.getSet(i).equals(word)) {
                    count++;
                }
            }
            frequencyWords.add(new HashMap<>(set.getSet(i),count/words.length*100));
        }

        return frequencyWords;
    }

    @Override
    public String toString() {
        return "FrequencyDictionaryOfWords{" +
                "frequencyWords=" + frequencyWords +
                '}';
    }
}
