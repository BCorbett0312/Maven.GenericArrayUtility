package com.zipcodewilmington.arrayutility;


import java.lang.reflect.Array;


/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E>{
    E[] testArray;

    private E[] mergedArray;
    private E[] arrayToWork;

    public ArrayUtility(E[] inputArray){
        testArray = inputArray;

    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToEvaluate){
        Integer counter = 0;
        arrayToWork = mergeArray(arrayToMerge);

        for (int i = 0; i < arrayToWork.length; i++) {
            if(arrayToWork[i] == valueToEvaluate){
                counter++;
            }
        }
        return counter;
    }





    public E[] removeValue(E toRemove){
        Integer sizeLess = this.getNumberOfOccurrences(toRemove);

        arrayToWork = (E[]) Array.newInstance(toRemove.getClass(), testArray.length-sizeLess);



        int j = 0;
        for (int i = 0; i < testArray.length; i++) {
            if(!testArray[i].equals(toRemove)){
                arrayToWork[j] = testArray[i];
                j++;
            }

        }
        return arrayToWork;
    }




    public Integer getNumberOfOccurrences(E toEvaluate){
        Integer counter = 0;
        for (int i = 0; i < testArray.length ; i++) {
            if(testArray[i] == toEvaluate){
                counter++;
            }

        }
        return counter;
    }

    public E getMostCommonFromMerge(E[] arrayToMerge){
        arrayToWork = this.mergeArray(arrayToMerge);
        E highValue = null;
        int highCounter = 0;

        for (int i = 0; i < arrayToWork.length; i++) {
            int counter = 0;
            for (int j = 1; j < arrayToWork.length; j++) {
                if(arrayToWork[i].equals(arrayToWork[j])){
                    counter++;
                    if(counter > highCounter){
                        highCounter = counter;
                        highValue = arrayToWork[i];
                    }
                }
            }
        }
        return highValue;
    }




    public E[] mergeArray(E[] inputArray){
        int arrLength = testArray.length + inputArray.length;

        mergedArray = (E[]) new Object[arrLength];

        int index;
        for(index = 0; index < testArray.length; index++){
            mergedArray[index] = testArray[index];

        }

        for (int j = 0; j< inputArray.length; j++){
            mergedArray[index] = inputArray[j];
            index++;
        }

        return mergedArray;


    }


}
