/**
  From lecture 10:
     Objects can not be compared with ">", "<" or any other
 */
public class Maximizer {
    public static Object max(Object[] items){
        int maxDex = 0;
        for (int i = 0; i < items.length; i += 1) {
            if (items[i] > items[maxDex]) { // This is actually wrong
                maxDex = i;
            }
        }
        return items[maxDex];
    }
    public static void main(String[] args) {
        Dog[] dogs = {};
        Dog maxDog = (Dog) max(dogs);
        maxDog.bark();
    }

}
