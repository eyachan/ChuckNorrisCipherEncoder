import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String x = sc.next();
        String[] arr = x.split("");
        StringBuilder rt = new StringBuilder();
        for (String y : arr
             ) {
            rt.append(y.repeat(2));

        }
        System.out.println(rt);
    }
}