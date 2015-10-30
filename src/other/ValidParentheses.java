package other;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if("{[(".indexOf(c) != -1){
                stack.push(c);
            }else if(c==')'){
                if(stack.isEmpty() || stack.pop()!='('){return false;}
            }else if(c==']'){
                if(stack.isEmpty() || stack.pop()!='['){return false;}
            }else if(c=='}'){
                if(stack.isEmpty() || stack.pop()!='{'){return false;}
            }
        }
        return stack.isEmpty();
    }
}
