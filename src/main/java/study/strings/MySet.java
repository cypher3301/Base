package study.strings;

import java.util.*;

public class MySet{
    private List<Character> set = null;

    public MySet() {
        set = new ArrayList();
    }

    public Character getSet(int index) {
        return set.get(index);
    }

    public int size() {
        return set.size();
    }


    public boolean contains(Object o) {
        for (char o1 : set) {
            if (o.equals(o1)) {
                return true;
            }
        }
        return false;
    }

    public boolean add(Object o) {
        if (!set.contains(o)) {
            set.add((Character) o);
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        return set!=null;
    }

}
