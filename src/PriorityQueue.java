import java.util.Scanner;

public class PriorityQueue {
    int [] array;
    int size;
    String option;
    Scanner s;
    public PriorityQueue(){
        this.array = new int[11];
        this.size = 0;
        System.out.print("In which order do you wanna build the priority queue?\nA: (Ascending)\nD: (Descending)\n");
        s = new Scanner(System.in);
        option = s.nextLine();
        option = option.toUpperCase();
    }

    public void addElement(int num){
        if (size == array.length){
            int [] temp = new int[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
        array[size] = num;
        size++;
        heapify();
    }

    public void heapify(){
        if (option.equals("A")){
            min();
        } else if (option.equals("D")){
            max();
        } else if(size > 1) {
            System.out.print("Please type the correct option!!!\n A for (Ascending)\n D for (Descending)\n");
            option = s.nextLine();
            heapify();
        }
    }

    /**
     *  Top most is the element with the smallest value
     */
    public void min(){
        if (size > 1){
            int curr = size - 1;
            int parent = findParent(curr);
            while (parent >= 0 && array[parent] > array[curr]){
                swap(parent, curr);
                curr = parent;
                parent = findParent(curr);
            }

        }
    }


    /**
     * Top most is the element with the largest value
     */
    public void max(){
        if (size > 1){
            int curr = size - 1;
            int parent = findParent(curr);
            while (parent >= 0 && array[parent] < array[curr]){
                swap(parent, curr);
                curr = parent;
                parent = findParent(curr);
            }

        }
    }

    public void printAscending(){
        while(size != 0){
            size--;
            swap(0, size);

            System.out.println(array[size]);
            sinkAsc(0);


        }
    }

    public void printDescending(){
        while(size != 0){
            size--;
            swap(0, size);

            System.out.println(array[size]);
            sinkDesc(0);
        }
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public int findParent(int index){
        if (index < 0){
            return -1;
        }
        int pos;

        if (index % 2 == 1){
            pos = (index - 1)/2;
        } else {
            pos = (index - 2)/2;
        }

        return pos;
    }

    public void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void sinkAsc(int pos){
        int index = pos;
        boolean check = true;
        while(((2 * index)+1) < size && check){
            if ((2 * index + 2 >= size) || (isLess(array[index * 2 + 1], array[index * 2 + 2]))){
                if (isLess(array[index * 2 + 1], array[index])){
                    swap(index, index * 2 + 1);
                    index = index * 2 + 1;
                } else {
                    check = false;
                }

            }else if (isLess(array[index * 2 + 2], array[index])){
               swap(index, index * 2 + 2);
               index = index * 2 + 2;
            } else {
                check = false;
            }
        }
    }

    public void sinkDesc(int pos){
        int index = pos;
        boolean check = true;

        while (((2 * index) + 1) < size && check){
            if ((2 * index + 2 >= size) || (!isLess(array[index * 2 + 1], array[index * 2 + 2]))){
                if (!isLess(array[index * 2 + 1], array[index])){
                    swap(index, index * 2 + 1);
                    index = index * 2 + 1;
                } else {
                    check = false;
                }

            }else if (!isLess(array[index * 2 + 2], array[index])){
                swap(index, index * 2 + 2);
                index = index * 2 + 2;
            } else {
                check = false;
            }
        }
    }


    public boolean isLess(int first, int second){
        if (first <= second){
            return true;
        }
        return false;
    }
}
