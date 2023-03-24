package chucknorris;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
	private static final String NORRIS_ENCODED_SEQUENCE_REGEX = "(0{1,2} 0*)";
	private static final String SEVEN_BIT_CHUNK_REGEX_PATTERN = "(?<=\\G.{7})";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Please input operation (encode/decode/exit):");
			String option = scanner.nextLine();
			switch (option) {
				case "encode" -> {
					System.out.println("Input string:");
					String message = scanner.nextLine();
					convertChuckNorris(message);
				}
				case "decode" -> {
					System.out.println("Input encoded string:");
					String message = scanner.nextLine();
					reverseConversion(message);
				}
				case "exit" -> {
					System.out.println("Bye!");
					System.exit(-1);
				}
				default -> System.out.println("There is no '" + option + "' operation");
			}
		}
	}

	public static void reverseConversion(String input) {
		Pattern pattern = Pattern.compile(NORRIS_ENCODED_SEQUENCE_REGEX);
		Matcher matcher = pattern.matcher(input);
		String word = input.replace(" ","");
		if (input.contains("1")) {
			System.out.println("Encoded string is not valid.");
		} else if (input.split(" ").length % 2 != 0) {
			System.out.println("Encoded string is not valid.");
		} else if(input.length() % 7 == 0){
			System.out.println("Encoded string is not valid.");
		}
		else {
			try {
				List<Character> collect = Arrays.stream(matcher.results()
								.map(MatchResult::group)
								.map(s -> s.split(" "))
								.map(s -> s[0].equals("0") ? "1".repeat(s[1].length()) : "0".repeat(s[1].length()))
								.collect(Collectors.joining())
								.split(SEVEN_BIT_CHUNK_REGEX_PATTERN))
						.map(s -> (char) Integer.parseInt(s, 2))
						.toList();
				String str = collect.stream()
						.map(Object::toString)
						.collect(Collectors.joining());
				System.out.println("Decoded string:");
				System.out.println(str);
			} catch (NumberFormatException ex) {
				System.out.println("Encoded string is not valid.");
			}
		}
	}

	public static void convertChuckNorris(String message) {
		StringBuilder binaryMessage = new StringBuilder();
		for (char c : message.toCharArray()) {
			binaryMessage.append(String.format("%07d", Integer.parseInt(Integer.toBinaryString(c))));
		}
		Pattern p = Pattern.compile("(0+|1+)");
		Matcher m = p.matcher(binaryMessage);
		StringBuilder result = new StringBuilder();
		while (m.find())
			result.append(m.group().contains("1") ? "0" : "00").append(" ").append("0".repeat(m.group().length())).append(" ");
		System.out.printf("Encoded string:\n%s%n", result);
	}
}