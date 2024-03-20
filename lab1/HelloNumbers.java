public class HelloNumbers {
    public static void main(String[] args) {
        int index;
        for(index = 0; index < 10; index++){
            int sum = 0;
            for(int i = 0; i <= index; i++)
                sum += i;
            System.out.print(sum + " ");
        }
    }
}