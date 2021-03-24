import java.util.Comparator;

public class MyComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int flag = 0;

        if (o1.toString().length() == o2.toString().length()){
            return 0;
        }
        else{
            if (o1.toString().length() > o2.toString().length()){ flag = 1;}
            if (o1.toString().length() < o2.toString().length()){ flag = -1;}
        }
        return flag;
    }
}
