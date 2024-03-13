package source.DataStructures;

import java.util.Iterator;

public class LoopsForEachLoopsAndIterators {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        LinkedPositionalList<Integer> pl = new LinkedPositionalList<>();

        //fill both sequences with values [0, 9]
        for(int i=0; i<10; i++){
            al.add(i);
            pl.addLast(i);
        }


        //print al values using indices

        for(int i=0; i<al.size(); i++){
            System.out.print(al.get(i)+" ");
        }

        System.out.println();

        //print pl values using positions

        Position<Integer> p = pl.first();

        while (p!=null){
            System.out.print(p.getElement()+" ");
            p = pl.after(p);
        }

        System.out.println();

        //use for-each loops to ITERATE over each sequence
        //note the exact same syntax being used in both cases

        for(Integer element: al)
            System.out.print(element+" ");

        System.out.println();

        for(Integer element: pl)
            System.out.print(element+" ");

        System.out.println();

        //use ITERATORS to iterate over each sequence
        //note the exact same syntax being used in both cases
        //the same process is applied by Java each time you write a for-each loop for an ITERABLE container (sequence)

        Iterator<Integer> alIterator = al.iterator();

        while (alIterator.hasNext())
            System.out.print(alIterator.next()+" ");

        System.out.println();

        Iterator<Integer> plIterator = pl.iterator();

        while (plIterator.hasNext())
            System.out.print(plIterator.next()+" ");

        System.out.println();


        System.out.println(al instanceof Iterable); //can I use an ITERATOR to iterate over this collection?
        System.out.println(pl instanceof Iterable); //can I use an ITERATOR to iterate over this collection?

        System.out.println(alIterator instanceof Iterator); //can I use this to iterate over an ITERABLE collection?
        System.out.println(plIterator instanceof Iterator); //can I use this to iterate over an ITERABLE collection?
    }
}
