import java.util.*;

public class Main {
    public static void main(String[] args) {
        //take user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number...");

        int num = scanner.nextInt();

        int num2 = (num * 2);
        int num3 = (num * 3);

        int conCat = Integer.valueOf(String.valueOf(num) + String.valueOf(num2) + String.valueOf(num3));

        System.out.println(conCat);

        List <Integer> list = new ArrayList<Integer>(conCat);

        Set set = new HashSet<>(list);
        if (set.size()== list.size()){
            System.out.println(conCat + " does not have duplicate values");
        } else {
            System.out.println(conCat + " has duplicated");
        }

    }
}