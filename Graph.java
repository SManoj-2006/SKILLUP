import java.util.*;
class Graph{
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    
    public List<List<Integer>> findConsecutiveSum(int num) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Try different starting numbers up to num/2
        for (int start = 1; start <= num/2; start++) {
            int sum = 0;
            List<Integer> current = new ArrayList<>();
            
            // Add consecutive numbers until sum >= num
            for (int i = start; sum < num; i++) {
                sum += i;
                current.add(i);
                
                // If we found a valid sequence
                if (sum == num) {
                    result.add(new ArrayList<>(current));
                    break;
                }
            }
        }
        
        return result;
    }
}

public class Graph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a,b;
        for(int i = 0; i < n; i++){
            a = scanner.nextInt();
            b = scanner.nextInt();
        }
    }
}
