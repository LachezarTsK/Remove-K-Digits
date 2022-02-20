
import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {

    public String removeKdigits(String num, int k) {

        if (num == null || k == num.length()) {
            return "0";
        }

        Deque<Character> stack = new ArrayDeque<>();
        final int size = num.length();

        for (int i = 0; i < size; i++) {
            while (k > 0 && !stack.isEmpty() && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        while (k-- > 0) {
            stack.pop();
        }

        removeLeadingZeros(stack);
        var smallestIntegerAfter_k_removals = new StringBuilder();

        while (!stack.isEmpty()) {
            smallestIntegerAfter_k_removals.append(stack.pollLast());
        }

        return smallestIntegerAfter_k_removals.length() > 0 ? smallestIntegerAfter_k_removals.toString() : "0";
    }

    public void removeLeadingZeros(Deque<Character> stack) {
        while (!stack.isEmpty() && stack.peekLast() == '0') {
            stack.pollLast();
        }
    }
}
