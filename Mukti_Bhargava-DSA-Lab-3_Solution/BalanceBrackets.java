import java.util.Scanner;
import java.util.Stack;

public class BalanceBrackets {

    private static final String BALANCED = "The entered String has Balanced Brackets";
    private static final String NOT_BALANCED = "The entered Strings do not contain Balanced Brackets";

    public static String checkBracketBalance(String str) {

        // System.out.println(str);
        Stack<Character> bracketsStack = new Stack<Character>();
        int strLen = str.length();
        if (strLen % 2 != 0) {
            return NOT_BALANCED;
        }
        // System.out.println(strLen);
        char temp;
        char[] chArr = str.toCharArray();
        // System.out.println(chArr.length);

        for (int i = 0; i < strLen; i++) {
            char bracket = chArr[i];
            // System.out.println(i);
            // System.out.println(bracket);
            switch (bracket) {
                case ']':
                    temp = bracketsStack.pop();
                    // System.out.println(temp);
                    if (temp != '[') {
                        // System.out.println("Ret1");
                        return NOT_BALANCED;
                    }
                    break;
                case ')':
                    temp = bracketsStack.pop();
                    // System.out.println(temp);
                    if (temp != '(') {
                        // System.out.println("Ret2");
                        return NOT_BALANCED;
                    }
                    break;
                case '}':
                    // System.out.println(bracket);
                    temp = bracketsStack.pop();
                    // System.out.println(temp);
                    if (temp != '{') {
                        // System.out.println("Ret3");
                        return NOT_BALANCED;
                    }
                    break;
                case '{':
                    bracketsStack.push(bracket);
                    break;
                case '[':
                    bracketsStack.push(bracket);
                    break;
                case '(':
                    bracketsStack.push(bracket);
                    break;
                default:
                    if (!bracketsStack.isEmpty())
                        return NOT_BALANCED;
            }
        }
        if (!bracketsStack.isEmpty())
            return NOT_BALANCED;
        return BALANCED;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your input ");
        String output = checkBracketBalance(sc.nextLine());
        System.out.println("Output: " + output);
        sc.close();
    }
}
