/** Write the test of Sort above; a String array to test the sorting problem */
// import org.junit.Test;
// import static org.junit.Assert*;

public class TestSort {

    public static void TestSort() {
        String[] input = {"They", "changed", "the", "system"};
        String[] expected = {"changed","system", "They","system"};

        Sort.sort(input);

        // org.junit.Assert.assertEquals();
    }

    public static void TestFindSmallest(){
        String[] input = {"They", "changed", "the", "system"};
        String expected = "changed";

        int actual = Sort.findSmallest(input,0);

    }
    public static void TestSwap(){

    }
    

}
