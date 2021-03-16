import java.util.Iterator;
import java.util.NoSuchElementException;

public class OddItemsIterator implements Iterator<Integer> {
    private Integer[] arr;
    private int cur = 0;

    public OddItemsIterator(Integer[] arr){
        this.arr = arr;
        this.cur = cur;
    }

    @Override
    public boolean hasNext() {
        return this.cur < this.arr.length;
    }

    @Override
    public Integer next() {
        while(arr[cur] % 2 == 0){
            cur++;
        }
        if (cur <(this.arr.length)) {
            int r = arr[cur];
            cur++;
            return r;
        }
        else{
            throw new NoSuchElementException("you are out of the array");
        }
    }
}
