public class Main {

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.addElement(1);
        pq.addElement(2);
        pq.addElement(3);
        pq.addElement(4);
        pq.addElement(6);
        pq.addElement(9);
        System.out.println();
        pq.print();
        System.out.println();
        System.out.println();
        if (pq.option.equalsIgnoreCase("a")){
            pq.printAscending();
        } else{
            pq.printDescending();
        }

    }
}
