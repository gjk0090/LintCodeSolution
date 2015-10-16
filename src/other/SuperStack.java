package other;

import java.io.*;
import java.util.*;

public class SuperStack {

	private static Stack<Integer> stack = new Stack<Integer>();

	private static Stack<Integer> stack2 = new Stack<Integer>();

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String command = sc.nextLine();
			System.out.println(execute(command));
		}
	}

	private static String execute(String command) {
		String[] array = command.split(" ");
		if (array[0].equals("push")) {
			return push(Integer.parseInt(array[1]));
		}

		if (array[0].equals("pop")) {
			return pop();
		}

		if (array[0].equals("inc")) {
			return inc(Integer.parseInt(array[1]), Integer.parseInt(array[2]));
		}

		return null;
	}

	private static String push(int x) {
		stack.push(x);
		if (!stack.isEmpty()) {
			return stack.peek() + "";
		} else {
			return ("EMPTY");
		}
	}

	private static String pop() {
		
		if (!stack.isEmpty()) {
			stack.pop();	
		}
		
		if (!stack.isEmpty()) {
			return stack.peek() + "";
		} else {
			return ("EMPTY");
		}
	}

	private static String inc(int n, int x) {
		while (!stack.isEmpty()) {
			stack2.push(stack.pop());
		}
		for (int i = 0; i < n; i++) {
			stack.push(stack2.pop() + x);
		}
		while (!stack2.isEmpty()) {
			stack.push(stack2.pop());

		}
		if (!stack.isEmpty()) {
			return stack.peek() + "";
		} else {
			return ("EMPTY");
		}
	}
}