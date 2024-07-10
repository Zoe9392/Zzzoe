public class ExamPrep1 {
    public class Foo {
         public int x, y;
         public Foo (int x, int y) {
             this.x = x;
             this.y = y;
         }
         public /*static*/ void switcheroo (Foo a, Foo b) {
            Foo temp = a;
            a = b;
            b = temp;
             }
         public /*static*/void fliperoo(Foo a, Foo b) {
            Foo temp = new Foo(a.x, a.y);
            a.x = b.x;
            a.y = b.y;
            b.x = temp.x;
            b.y = temp.y;
             }
         public /*static*/void swaperoo (Foo a, Foo b) {
             Foo temp = a;
             a.x = b.x;
             a.y = b.y;
             b.x = temp.x;
             b.y = temp.y;
         }
         public /*static*/  void main (String[] args) {
            Foo foobar = new Foo(10, 20);
            Foo baz = new Foo(30, 40);
            // The foobar and baz were initiated in main scope
            switcheroo(foobar, baz);  // Story happened in switcheroo scope
            fliperoo(foobar, baz);    // Story happened in fliperoo scope
            swaperoo(foobar, baz);    // Story happened in swaperoo scope
            }
            // foobar.x: 10 foobar.y: 20 baz.x: 30 baz.y: 40
            // foobar.x: 30 foobar.y: 40 baz.x: 10 baz.y: 20
            // foobar.x: 10 foobar.y: 20 baz.x: 10 baz.y: 20
        }
        /** Be Sure to use JAVA VISUALIZER to see what is going on at each step */
    public class QuikMaths {
        public static void multiplyBy3(int[] A) {
            for (int x: A) {
                x = x * 3;
                }
            }

        public static void multiplyBy2(int[] A) {
            int[] B = A;
            for (int i = 0; i < B.length; i += 1) {
                B[i] *= 2;
            }
        }
        public static void swap (int A, int B ) {
            int temp = B;
            B = A;
            A = temp;
        }
        public static void main(String[] args) {
             int[] arr;
             arr = new int[]{2, 3, 3, 4};
             multiplyBy3(arr);
             /* Value of arr: {____2,3,3,4__________} */
             arr = new int[]{2, 3, 3, 4};
             multiplyBy2(arr);
             /* Value of arr: {____4,6,6,8__________} */
             int a = 6;
             int b = 7;
             // The integers a and b were initialized in main SCOPE
             swap(a, b); // The swap things happened in swap scope. And it doesn't affect the value in
                         // main scope.
             /* Value of a: __6__ Value of b: __7__ */
             }
 }



}
