package proyectomeia.Clases;

import java.util.Comparator;

public class ComparatorS implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String l1 = o1.split("\\|")[0];
        String l2 = o2.split("\\|")[0];
        int result = l1.compareTo(l2);
        if(result == 0){
            l1 = o1.split("\\|")[1];
            l2 = o2.split("\\|")[1];
            result = o1.compareTo(l2);
        }
        return result;
    }
}
