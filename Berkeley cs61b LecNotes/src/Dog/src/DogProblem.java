public class DogProblem {
    /** Suggestion by Josh Hug and lecture prompts: HELPER FUNCTION  */
    /** My Thoughts: just if-else_if -else  sentence; The problem: too many edge cases */

    /** Josh Hug's Method */
    public static Dog[] largerThanFourNeighbors_withHelper(Dog[] dogs) {
        Dog[] res = new Dog[dogs.length];
        int curr = 0;
        for (int i = 0; i < dogs.length; i++){
            if(isBiggestFour(dogs,i)) {
                res[curr] = dogs[i];
                curr += 1;
            }
        }
        return res;
    }

    /** Return Value is to examine the biggest in Neighbor Four      */
    public static boolean isBiggestFour (Dog[] dogs, int i ) {
        boolean isMax = true;
        for (int j = -2; j < 2; j++) { // a moving index to indicate
            if (j == 0) {
                continue;
            }
            if (validIndex(dogs, i + j)){
                if(dogs[i].weightInPounds <= dogs[i+j].weightInPounds){
                    isMax = false;
                }
            }
        }
        return isMax;
    }

    // Note: deal with edge cases --- [y,y, ......,y,y] will not be applicable
    // [x,x,y,x,x,...,x,x] the pointer is at y.However, [x,y,x,...,x,x] is an edge case


    public static boolean validIndex(Dog[] dogs, int i){
        return (i >= 0) || (i < dogs.length);
    }

    public static void main(String[] args) {
        Dog[] dogs = new Dog[]{
                new Dog(10,0), new Dog(15,0),
                new Dog(20,0), new Dog(15,0),
                new Dog(10,0), new Dog(5,0),
                new Dog(10,0), new Dog(15,0),
                new Dog(22,0), new Dog(15,0),
                new Dog(20,0)
        };
        Dog[] bigDogs1 = largerThanFourNeighbors_withHelper(dogs);

        /** When you run this program you should get "20 22" */
        for (int k = 0; k < bigDogs1.length; k += 1) {
            System.out.print(bigDogs1[k].weightInPounds + " ");
        }
        System.out.println();
    }
}
