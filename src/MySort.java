import java.lang.reflect.Array;
import java.util.Arrays;

public class MySort {

    public static Comparable[] sort(Comparable[] a){
        SortUnsorted(a,0,a.length-1);
        return a;
    }
    private static void SortUnsorted(Comparable[] a, int lo, int hi) {

        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        SortUnsorted(a, lo, mid);
        SortUnsorted(a, mid + 1, hi);

        Comparable[] buf = Arrays.copyOf(a, a.length);


        for (int k = lo; k <= hi; k++)
            buf[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {

            if (i > mid) {
                a[k] = buf[j];
                j++;
            } else if (j > hi) {
                a[k] = buf[i];
                i++;
            } else if (buf[j].compareTo(buf[i])<0) {
                a[k] = buf[j];
                j++;
            } else {
                a[k] = buf[i];
                i++;
            }
        }
    }
}
