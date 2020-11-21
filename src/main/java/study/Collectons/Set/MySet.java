package study.Collectons.Set;

import java.util.Collection;
import java.util.HashSet;

public class MySet {

    public static <T> Collection<T> removeDuplicates(Collection<T> collection){
        return new HashSet<>(collection);
    }


}
