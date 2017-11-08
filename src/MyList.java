import java.util.AbstractCollection;
import java.util.Arrays;

public class MyList<E>  {

    private Object[] elementData = new Object[1];
    private int size;
    public int size() {
        return size;
    }

    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    public void add(E e) {
        size++;
        Object[] elementTemp = new Object[size];
        for (int i = 0; i < size - 1; i++) {
            elementTemp[i] = elementData[i];
        }
        elementData = elementTemp;
        elementData[size - 1] = e;
        sort();
    }

    private void sort() {
        try {
            Arrays.sort(elementData);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean remove(int index) {
        if (index >= size){
            return false;
        }
        elementData[index] = elementData[elementData.length - 1];
        size--;
        Object[] elementTemp = new Object[size];

        for (int i = 0; i < size; i++) {
            elementTemp[i] = elementData[i];
        }
        elementData = new Object[size];
        elementData = elementTemp;
        sort();
        return true;
    }

    public boolean remove(Object o) {
        int index = 0;
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i].equals(o)) {
                return remove(i);
            }
        }
            return false;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void rangeCheck(int index) {
        if (index >= size){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }


    private E elementData(int index) {
        return (E) elementData[index];
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++){
                if (elementData[i] == null){
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--){
                if (elementData[i] == null){
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--){
                if (o.equals(elementData[i])){
                    return i;
                }
            }
        }
        return -1;
    }


    @Override
    public String toString() {
        String s = "";
        for (Object i : elementData){
            s = s + ", " + i;
        }
        s = s.substring(2, s.length());
        if (size == 0){
            return "null";
        }
        else{
            return s;
        }
    }
}
