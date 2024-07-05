/**
 * Exercises from Discussion02 */

public class mystery {
    /* The given method in fa22-cs61b discussion 2; The iterative method by swapping */
    public static int mystery (int[] inputArray, int k){
        int x = inputArray[k];
        int answer = k;
        int index = k + 1;
        while(index < inputArray.length){
            if(inputArray[index] < x){
                x = inputArray[index];
                answer = index;
            }
            index += 1;
        }
        return answer;
    }
    /** The recursive way of mystery */
    /* My way of writing, using the given skeleton */
    public static int mysteryRecursive(int[] inputArray, int k){
        return mysteryRecursiveHelper(inputArray, k, inputArray.length);
    }

    public static int mysteryRecursiveHelper(int[] inputArray, int i, int j) {
        if ( i == j - 1 ){
            return i;
        }
        int index = mysteryRecursiveHelper(inputArray, i+1, j);
        if (inputArray[index] > inputArray[i]){
            return i;
        }
        return index;
        /* The codes below are my way of coding
        int index = i + 1;
        if (inputArray[index] < inputArray[i]){
            return mysteryRecursiveHelper(inputArray, index, j);
        }
        return i;
         */
    }

    public class main {
        int[] input= new int[]{3,5,0,8,7,2,1};
        int actual = mysteryRecursive(input, 2);
        int expected = 6;

    }

}
