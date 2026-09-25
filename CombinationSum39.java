import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSum39 {

    public static void combination(int[] candidates, int i, int target,List<List<Integer>> result,List<Integer> list) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (i >= candidates.length || target < 0) return;
        list.add(candidates[i]);
        combination(candidates, i, target - candidates[i], result, list);
        list.remove(list.size() - 1);
        combination(candidates, i + 1, target, result, list);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        combination(candidates, 0, target, result, list);

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] candidates = new int[n];
        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        List<List<Integer>> result = combinationSum(candidates, target);
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
        sc.close();
    }
}