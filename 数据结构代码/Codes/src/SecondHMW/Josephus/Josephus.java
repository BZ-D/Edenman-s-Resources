package SecondHMW.Josephus;

import LinkedList.*;

public class Josephus {
    int numOfPeople;
    int everyMPerson;

    public void go(int numOfPeople, int everyMPerson) {
        this.numOfPeople = numOfPeople;
        this.everyMPerson = everyMPerson;
        Integer[] people = new Integer[numOfPeople];
        for (int i = 1; i <= numOfPeople; i++) {
            people[i - 1] = i;
        }

        CirLinkedList<Integer> josephusRing = new CirLinkedList<Integer>();
        josephusRing.create(people);
        ListIterator<Integer> iterator = josephusRing.getFirst();
        int leftPeople = numOfPeople;

        while (leftPeople >= 1) {
            int count = everyMPerson;
            while (count > 1) {
                iterator.advance();
                count--;
            }
            int position = iterator.getPosition();
            int number = iterator.retrieve();

            iterator = new ListIterator<Integer>(iterator.getNext(), (position) % leftPeople);
            josephusRing.delete(position % leftPeople);
            leftPeople--;
            if (leftPeople > 1)
                System.out.println("第" + number + "号的人出场。");
            else
                System.out.println("第" + number + "号的人获胜。");
        }

    }

    public static void main(String[] a) {
        Josephus test = new Josephus();
        test.go(8, 3);
    }

}
