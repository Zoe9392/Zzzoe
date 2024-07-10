
import java.util.Comparator;

/** Dog class implements OurComparable */
public class Dog implements OurComparable{
    // instance variables and class variables
    // Add one more instance variable
    public int weightInPounds;
    public int size;
    public static String binomen = " Canis familaries";
    // The Constructor
    public Dog(int startingWeight, int size){
        weightInPounds = startingWeight; size = size;
    }
    // this is a CLASS METHOD
    public static Dog maxDog(Dog d1, Dog d2){
        if(d1.weightInPounds > d2.weightInPounds){
            return d1;
        }
        return d2;
    }
    public void bark(){
        System.out.println("bark! bark! bark!");
    }

    /** Returns negative numbers if this is smaller than k; 0 for equal; positive numbers if
        this is greater than k.
     */
    @Override
    public int compareTo(Object k) {
        // redundant version of codes
        /*
        if (this.weightInPounds == ((Dog) k).weightInPounds){
            // The static type of k is an OBJECT. But the static type of ((Dog) k) is Dog
            return 0;
        } else if (this.weightInPounds > ((Dog) k).weightInPounds ){
            return 1;
        }
        return -1;
    } */
       return this.size - ((Dog) k).size;
    }

    /** A class, implements built-in interface in java,compares Dogs names' length of string */
    public class NameComparator implements Comparator<Dog> {
        public int compare(Dog a, Dog b){
            /* Compare "String" otherwise there arises complaints */
            return a.binomen.compareTo(b.binomen);
        }
    }
    /** Returns a new NameComparator (keep convention normally with what people do) */
    public Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }




}
