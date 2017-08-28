import java.util.*;
import static java.lang.System.out;

public class Bubble {

    public static void main(String[] args) throws Exception{

        java.io.File file = new java.io.File(args[0]);
        Scanner inFile = new Scanner(file);
        ArrayList<Integer> list;

        try{

            list = readFile(inFile); //returns the list from readFile()

            int size = list.size(); //get the size of the list
            Integer[] numArray = new Integer[size]; //create another array
            Integer[] sortedArray = new Integer[size];
            list.toArray(numArray); //convert the list to an array

            long startTime = System.currentTimeMillis();

            sortedArray = bubbleSortRoutine(numArray);

            long endTime = System.currentTimeMillis();

            for(int i = 0; i < sortedArray.length; i++){
                out.println(sortedArray[i]);
            }

            float totalTime = (float)(endTime - startTime);

            totalTime = totalTime / 1000;

            out.println("\n\nBubble Sort Run Time: " + totalTime + " seconds");
        }
        catch(Exception e){ //will probably throw FileNotFoundException but I use Exception as a catch-all
            out.println("[-]ERROR: Please see stack trace.");
            e.printStackTrace();
        }
        finally{
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

    //bubble sort algorithm
    private static Integer[] bubbleSortRoutine(Integer[] numArray){
        Integer temp;

        for(int i = 0; i < numArray.length - 1; i++){
            for(int j = 1; j < numArray.length; j++){

                if(numArray[j-1].intValue() > numArray[j].intValue()){
                    temp = numArray[j-1];
                    numArray[j-1] = numArray[j];
                    numArray[j] = temp;
                }
            }
        }

        return numArray;
    }
}
