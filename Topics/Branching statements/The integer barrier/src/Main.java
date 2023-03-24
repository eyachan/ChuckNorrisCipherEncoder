import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		while (true) {
			int input = scanner.nextInt();
			sum += input;
			if (sum >= 1000) {
				sum -= 1000;
				break;
			}
			if (input == 0) {
				break;
			}
		}
		System.out.println(sum);
	}
}