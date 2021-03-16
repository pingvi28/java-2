import java.util.Comparator;

public class BreedComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        int flag = 0;
        int index = 0;

        if (o1.breed.equals(o2)){
            return 0;
        }
        else if(true){
            while ((flag == 0) && (o1.breed.length() != (index+1))) {
                if ((int)o1.breed.charAt(index) == (int)o2.breed.charAt(index)){ flag = 0;}
                if ((int)o1.breed.charAt(index) > (int)o2.breed.charAt(index)){ flag = 1;}
                if ((int)o1.breed.charAt(index) < (int)o2.breed.charAt(index)){ flag = -1;}
                index++;
            }
            return flag;
        }
        else return -1;
    }

}
