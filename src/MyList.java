import java.util.Arrays;

public class MyList<E> {

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

        for (int i = 0; i < size - 1; i++) elementTemp[i] = elementData[i];

        elementData = elementTemp;
        elementData[size - 1] = e;
        try {
            Arrays.sort(elementData);
        } catch (Exception b) {
            System.out.println(b);
        }

    }

    public void remove(int index) {
        rangeCheck(index);
        elementData[index] = elementData[elementData.length - 1];
        size--;
        Object[] elementTemp = new Object[size];

        for (int i = 0; i < size; i++) elementTemp[i] = elementData[i];

        elementData = new Object[size];

        elementData = elementTemp;
        try {
            Arrays.sort(elementData);
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }


    private E elementData(int index) {
        return (E) elementData[index];
    }


    @Override
    public String toString() {
        String s = "";
        for (Object i : elementData)
            s = s + ", " + i;
        s = s.substring(2, s.length());
        return s;
    }
}
