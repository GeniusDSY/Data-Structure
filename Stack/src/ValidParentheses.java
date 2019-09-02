import java.util.Stack;

/**
 * @author :DengSiYuan
 * @date :2019/8/12 17:53
 * @desc : 括号匹配验证
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses parentheses = new ValidParentheses();
        System.out.println(parentheses.isValid("{[()()]}"));
        System.out.println(parentheses.isValid("{()[()(]}"));
    }

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '('){
                    return false;
                }
                if (c == ']' && top != '['){
                    return false;
                }
                if (c == '}' && top != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
