import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        checkWord(word);
    }
    public static void checkWord (String word) {
        var count = 0;
        var currentTypeCount = 0;
        var lastTypeVowel = true;
        String[] arr = word.split("");
        for (var c : arr) {
            if (isVowel(c) == lastTypeVowel) {
                currentTypeCount++;
                //System.out.println("character "+ c + " current count" + currentTypeCount);
                if (currentTypeCount >= 3) {
                    count++;
                    currentTypeCount = 1;

                    //System.out.println(count + " character "+ c + " ---" + currentTypeCount);
                }
            } else {
                lastTypeVowel = !lastTypeVowel;
                currentTypeCount = 1;
            }
        }
        System.out.println(count);
    }

    public static boolean isVowel(String c) {

        return "aeiouyAEIOUY".contains(c);
    }
}