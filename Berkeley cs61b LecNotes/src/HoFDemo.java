
/**
 * Notes created via Zoe
 * Demonstrates higher order function in Java
 *  prototype is the higher order function in java
 */
public class HoFDemo {
    public static int do_twice(IntUnaryFunction f, int x) {
        return f.apply(f.apply(x));
    }
    public static void main(String[] args){
        IntUnaryFunction tenX = new TenX();
        System.out.println(do_twice(tenX,2));
    }
}
/* The PYTHON  version of HOF function above is written below :
*       def tenX(x):
*           return 10* x
*       def do_twice(f,x):
*           return f(f(x))
*       print (do_twice(tenX,2))
*
*  The JAVA  version of HOP function is constructed via 3 java files:
*      interface : IntUnaryFunction
*      class: TenX
*      class: HoFDemo
*
*/

