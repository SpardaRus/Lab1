public class SimpleMerger {



    private Comparable[] unsorted, sorted;



    public SimpleMerger( Comparable[] unsorted ) {

        this.unsorted = unsorted;

    }



    /**

     * Собственно здесь производится разбиение входного массива и запуск рекурсивного алгоритма

     */

    public void sort() {

        int middle;

        Comparable[] left, right;



        if ( unsorted.length <= 1 ) {

            sorted = unsorted;

        } else {

            middle = unsorted.length / 2;



            left = new Comparable[middle];

            right = new Comparable[unsorted.length - middle];



            System.arraycopy( unsorted, 0, left, 0, middle );

            System.arraycopy( unsorted, middle, right, 0, unsorted.length - middle );



            // Внимание! Опа, рекурсия :)

            SimpleMerger leftSort = new SimpleMerger( left );

            SimpleMerger rightSort = new SimpleMerger( right );



            leftSort.sort();

            rightSort.sort();



            sorted = merge( leftSort.getSorted(), rightSort.getSorted() );

        }

    }



    /**

     * Статический метод. Мержит два отсортированных массива

     * Используется и в многопоточной версии сортировки

     */

    public static Comparable[] merge( Comparable[] leftPart, Comparable[] rightPart ) {

        int cursorLeft = 0, cursorRight = 0, counter = 0;

        Comparable[] merged = new Comparable[leftPart.length + rightPart.length];



        while ( cursorLeft < leftPart.length && cursorRight < rightPart.length ) {

            if ( leftPart[cursorLeft].compareTo(rightPart[cursorRight])<0) {

                merged[counter] = leftPart[cursorLeft];

                cursorLeft++;

            } else {

                merged[counter] = rightPart[cursorRight];

                cursorRight++;

            }

            counter++;

        }



        if ( cursorLeft < leftPart.length ) {

            System.arraycopy( leftPart, cursorLeft, merged, counter, merged.length - counter );

        }

        if ( cursorRight < rightPart.length ) {

            System.arraycopy( rightPart, cursorRight, merged, counter, merged.length - counter );

        }



        return merged;

    }



    public Comparable[] getSorted() {

        return sorted;

    }

}