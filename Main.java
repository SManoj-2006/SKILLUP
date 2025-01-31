import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(i==0 && arr[i] == 'W'){
                int j=1;
                while(j<arr.length){
                    if(arr[j] != 'W'){
                        arr[i] = arr[j];
                        break;
                    }
                    j++;
                }
            }else if(arr[i] == 'W'){
                    arr[i] = arr[i-1];
                }
            }
            int badness=0;
            for(int i = 1; i < arr.length-1; i++){
                if(arr[i] != arr[i+1]){
                    badness++;
                }
            }
        System.out.println(Arrays.toString(arr));
        System.out.println(badness);
    }
}
