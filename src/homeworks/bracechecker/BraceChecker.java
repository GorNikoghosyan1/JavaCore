package homeworks.bracechecker;

import java.util.Stack;

public class BraceChecker {
    private String str;

    public BraceChecker(String str) {
        this.str = str;
    }

    public boolean check() {
        Stack stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(i);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    System.out.println("Error: closed " + ch + " but opened nothing at " + i);
                    return false;
                } else {
                    int lastIndex = (int) stack.pop();
                    char last = str.charAt(lastIndex);
                    if (!validationOpenClose(last, ch)) {
                        System.out.println("Error: opened " + last + " but closed " + ch + " at " + i);
                        return false;
                    }
                }
            }
        }
        return stackIsEmpty(stack);
    }

    private boolean stackIsEmpty(Stack stack) {
        if (!stack.isEmpty()) {
            int lastIndex = (int) stack.pop();
            char last = str.charAt(lastIndex);
            System.out.println("Error: opened " + last + " but never closed at " + lastIndex);
            return false;
        }
        System.out.println("No errors");
        return true;
    }

    private boolean validationOpenClose(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }
}
