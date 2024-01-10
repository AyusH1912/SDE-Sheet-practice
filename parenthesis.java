// GFG Practice - Parenthesis Checker
// Using Stack [LIFO]
// We have to check the string containing parenthesis is balanced or not.
// Explanation: https://takeuforward.org/data-structure/check-for-balanced-parentheses/

class Solution {
    // Function to check if brackets are balanced or not.
    static boolean ispar(String x) {
        // add your code here
        char a[] = x.toCharArray();
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '{' || a[i] == '[' || a[i] == '(')
                stk.push(a[i]);
            else {
                if (stk.isEmpty())
                    return false;
                char ch = stk.pop();
                if (ch == '(' && a[i] == ')' || ch == '[' && a[i] == ']' || ch == '{' && a[i] == '}')
                    continue;
                else
                    return false;
            }
        }
        return stk.isEmpty();
    }
}
