import java.util.Comparator;

public class StringComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        int flag = 0;
        int index = 0;

        if (o1.equals(o2)){
            return 0;
        }
        else if(true){
            while ((flag == 0) && (o1.length() != (index+1))) {
                if ((int)o1.charAt(index) == (int)o2.charAt(index)){ flag = 0;}
                if ((int)o1.charAt(index) > (int)o2.charAt(index)){ flag = 1;}
                if ((int)o1.charAt(index) < (int)o2.charAt(index)){ flag = -1;}
                index++;
            }
            return flag;
        }
        else return -1;
    }

}
