public class ArrayDequeTest {

    public static boolean checkEqual(int expect, int actual){
        if(expect == actual)
            return true;
        else
            return false;
    }

    public static void IsemptyTes   t(){
        ArrayDeque<Integer> test = new ArrayDeque<Integer>();
        boolean passed = checkEqual(0, test.size());

        test.addfirst(2);
        test.addLast(3);
        passed = checkEqual(2, test.size()) && passed;

        test.removeFirst();
        passed = checkEqual(1, test.size());

        if(passed)
            System.out.println("Test PASS");
        else
            System.out.println("Test FAILED");
    }

    public static void main(String[] args){
        IsemptyTest();
    }
}
