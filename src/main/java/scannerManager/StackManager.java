package scannerManager;

import java.util.Stack;

public class StackManager {
    private static Stack<String> stack = new Stack<>();

    public static void addFilename(String filename) {
        stack.add(filename);
    }

    public static void pop() {
        stack.pop();
    }

    public static boolean checkOnRecursion(String filename) {
        return stack.contains(filename);
    }
}
