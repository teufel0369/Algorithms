import java.util.*;
import static java.lang.System.out;

public class Merge {

    public static void main(String[] args) throws Exception{

        java.io.File file = new java.io.File(args[0]);
        Scanner inFile = new Scanner(file);
        ArrayList<Integer> list;

        try{

            list = readFile(inFile);

            int size = list.size();
            Integer[] numArray = new Integer[size];
            list.toArray(numArray);

            long startTime = System.currentTimeMillis(); //start the clock

            mergeSortRoutine(numArray); //do the sort

            long endTime = System.currentTimeMillis(); //stop the clock

            float totalTime = (float)(endTime - startTime);

            totalTime = totalTime / 1000;

            for(int i = 0; i < numArray.length-1; i++){
                out.println(numArray[i]);
            }

            out.println("\n\nMerge Sort Run Time: " + totalTime + " seconds");
        }
        catch(Exception e){
            out.println("[-]ERROR: Please see stack trace.");
            e.printStackTrace();
        }
        finally {
            inFile.close();
        }
    }

    //reads the file regardless of size
    private static ArrayList<Integer> readFile(Scanner in){
        ArrayList<Integer> list = new ArrayList<>();

        while(in.hasNextInt()){ //while there are still integers
            list.add(in.nextInt()); //add it to the list
        }

        return list; //return the list
    }

    //this function will merge two arrays
    private static void merge(Integer[] list1, Integer[] list2, Integer[] temp){
        int current1 = 0; //current index in list1
        int current2 = 0; //current index in list2
        int current3 = 0; //current index in temp

        //while loop to sort each hand before it is added to the sorted pile
        while((current1 < list1.length) && (current2 < list2.length)){
            if(list1[current1].intValue() < list2[current2].intValue()){ //if list1's value is less than list2's
                temp[current3++] = list1[current1++]; //assign it to temp
            }
            else{ //otherwise
                temp[current3++] = list2[current2++]; //
            }
        }

        while(current1 < list1.length){
            temp[current3++] = list1[current1++];
        }

        while(current2 < list2.length) {
            temp[current3++] = list2[current2++];
        }
    }

    //merge sort function
    private static void mergeSortRoutine(Integer[] list){

        if(list.length > 1){

            //merge sort the first half
            Integer[] firstHalf = new Integer[(list.length)/2];
            System.arraycopy(list, 0, firstHalf, 0, (list.length)/2);
            mergeSortRoutine(firstHalf);

            //merge sort the second half
            int secondHalfLength = list.length - ((list.length)/2);
            Integer[] secondHalf = new Integer[secondHalfLength];
            System.arraycopy(list, (list.length)/2, secondHalf, 0, secondHalfLength);
            mergeSortRoutine(secondHalf);

            //merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
    }
}
