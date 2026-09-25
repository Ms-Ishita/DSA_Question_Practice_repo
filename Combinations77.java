import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combinations77 {

    public static void backtraking(int n, int k, int start,List<Integer> list,List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtraking(n, k, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        backtraking(n, k, 1, list, result);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<List<Integer>> result = combine(n, k);
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }

        sc.close();
    }
}
