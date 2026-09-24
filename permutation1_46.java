import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class permutation1_46 {

    public static void backTracking(int[] nums, List<Integer> list,List<List<Integer>> result, boolean[] visited) {

        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);

                backTracking(nums, list, result, visited);

                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static  List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backTracking(nums, list, result, visited);

        return result;
    }

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int[] nums = new int[n];

    for (int i = 0; i < n; i++) {
        nums[i] = sc.nextInt();
    }

    List<List<Integer>> result = permute(nums);

    for (List<Integer> permutation : result) {
        System.out.println(permutation);
    }

    sc.close();
    }
}