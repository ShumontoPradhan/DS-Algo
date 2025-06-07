import java.util.Stack;

class Solution {
    public String robotWithString(String s) {
        Stack<Character> t = new Stack<>();
        StringBuilder paper = new StringBuilder();
        int n = s.length();

        char[] minRight = new char[n];
        minRight[n - 1] = s.charAt(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = (char) Math.min(s.charAt(i), minRight[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            t.push(s.charAt(i));

            while (!t.isEmpty() && (i == n - 1 || t.peek() <= minRight[i + 1])) {
                paper.append(t.pop());
            }
        }

        return paper.toString();
    }
}
