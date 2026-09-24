import java.util.*;
public class cutINChuncks {
    public static List<String> cuttingInChunks(String text, int chunks, int overlaps){
        List<String> list = new ArrayList<>();
        int left = 0;
        for(int right =0; right<text.length(); right++){
            if(right-left+1 == chunks){
                String ans = text.substring(left, right+1);
                list.add(ans);
                left= left+overlaps;
            }

        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        int chunks = sc.nextInt();
        int overlaps = sc.nextInt();

        List<String> list = cuttingInChunks(text, chunks, overlaps);

        System.out.println(list);
    }
    
}
