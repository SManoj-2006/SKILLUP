import java.util.*;
public class Consecutive {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for(int i = 1; i <=num/2; i++){
            int start = i;
            int sum = 0;
            ArrayList<Integer> result = new ArrayList<>();
            for(int j = start; sum<num; j++){
                result.add(j);
                sum += j;
            }
            if(sum == num){
                arr.add(result);
            }
        }
        System.out.println(arr);
    }
}

