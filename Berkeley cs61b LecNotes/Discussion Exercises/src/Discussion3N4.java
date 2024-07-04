public class Discussion3N4 {
    /** Static Electricity */
    public class Pokemon{

        
    }
    /** Discussion4 - Rotate Array */
    public static int[] rotate(int[] A, int k) {
        int[] returnArray = new int[A.length];
        for(int i = 0; i < A.length; i++){
            int index = (i + k)%A.length;
            returnArray[index] = A[i];
        }
        return returnArray;
    }
    // Codes above are the unchecked version
    /** Scope, static, and more */
    interface Vehicle{
        void revEngine();
    }
    interface Honker{
        default void honk(){
            System.out.println("HONQUE!");
        }
    }
    public class CatBus implements Vehicle, Honker{
        @Override
        public void revEngine(){
            System.out.println("Purrrrrrr");
        }
        @Override
        public void honk(){
            System.out.println("CatBus says HONK");
        }
        public void conversation(Honker target) {
            honk();
            target.honk();
        }
    }

    public class Plane implements Vehicle {
        @Override
        public void revEngine(){
            System.out.println("Haha engines go brrr");
        }
        public void honk() {
            System.out.println("Getting ready for takeoff!");
        }
    }

    public class Goose implements Honker {
        public void pester(Vehicle victim){
            System.out.println("BEP!");
        }
        public void pester(Plane p) {
            System.out.println("SQUAKE!");
        }
    }

    public class Fight{
        public /* static */ void main(String[] args){
            CatBus c = new CatBus();
            Honker m = new CatBus();
            Goose g = new Goose();
            Plane p = new Plane();
            Vehicle v = new Plane();

            c.conversation(g);
            // Honker h = new Honker(); Honker is abstract. It can not be instantiated.
            g.pester(c);
            g.pester(p);
            // m.revEngine(); Location: variable m of a type Honker
            g.pester(v);
            // v = m; Incompatible type - Honker can not be converted to Vehicle type
            // c.conversation(p); Incompatible type -
            p.honk();

        }
    }
}
/** Problems for Discussion 4 are about the java visualizer ; how box-pointer diagram goes in
    java visualizer; static type and others
 */