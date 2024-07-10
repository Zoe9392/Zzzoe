/**
  From lecture 10:
     Objects can not be compared with ">", "<" or any other
  Naive Solution to the problem: create a method to return the "max" dog there.
  Applicable solution to the problem:
        Step1: Creates an interface that contains a comparison method
        Step2: use it to implement the max method in it
 */
public class Maximizer{
    /** max method returns OurComparable and takes in an array of OurComparable */
    public static OurComparable max(OurComparable[] items){
        int maxDex = 0;
        for (int i = 0; i < items.length; i += 1) {
            if(items[i].compareTo(items[maxDex]) > 0)
           // if (items[i] > items[maxDex]) { // This is actually wrong, Objects can not be compared in this way
                maxDex = i;
            }
        return items[maxDex];
        }

    public static void main(String[] args) {
        Dog[] dogs = {};
        Dog maxDog = (Dog) max(dogs);
        maxDog.bark();
    }

    /** Solution 1: write a method to specifically return the max dog in the dog array */
    /*  Disadvantages of the solution below, the reference type can only be DOG.
        So it is a huge restriction. Small changes can lead to many repetition work. */
    public static Dog maxDog (Dog[] dogs){
        if (dogs.length == 0 || dogs == null) {
            return null;
        }
        Dog maxDog = dogs[0];
        for(Dog d: dogs){
            if (d.weightInPounds >= maxDog.weightInPounds) {
                maxDog = d;
            }
        }
        return maxDog;
    }
}



