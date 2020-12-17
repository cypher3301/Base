package study.strings;

import java.util.*;

public class StringS {

        public static List<Object> getMaxString(String str){
        String[] strings = str.split(" ");
        List<Object> list = new ArrayList<>();
        int max=0;
        String s = null;
        for (String string : strings) {
            if(string.length()>max) {
                max=string.length();
                s=string;
            }
        }
        list.add(s);
        list.add(max);
        return list;
    }

    public static boolean isPolindrom(String s){
//        int finish=s.length()-1;
        for (
                int start = 0, finish=s.length()-1;
                start < s.length()/2+1;
                start++, finish--) {
            if(finish-start>2){
                if(s.indexOf(start)!=s.indexOf(finish)) return false;
            }
            else break;
        }
        return true;
    }

    public static Map[] getFriquencyLetter(String s){
        s = s.toLowerCase();
        char[] strings = s.toCharArray();
        MySet set = new MySet();
        for (char string : strings) {
            set.add(string);
        }
        Map[] maps = new Map[set.size()];

        for (int i = 0; i < set.size(); i++) {
            int k=0;
            for (char string : strings) {
                if(set.getSet(i).equals(string)){
                    k++;
                }
            }
            maps[i] = new HashMap();
            List<Double> list = new ArrayList<>();
            list.add((double) k);
            list.add((double)k/(double)s.length());
            maps[i].put(set.getSet(i).toString(), list);
        }
        return maps;
    }


}
