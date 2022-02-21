package Baekjoon;


import java.util.Scanner;
import java.util.Stack;

public class N_4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String s = sc.nextLine();

            if(s.equals(".")) {
                break;
            }
            if(checkVPS(s)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static boolean checkVPS(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }

            // 닫는 괄호가 소괄호 일 경우
            if (s.charAt(i) == ')') {
                // 스택이 비어있는데 닫는 괄호가 올 경우 또는 스택의 top이 짝을 이루지 못할 경우 false 반환.
                if(stack.empty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if (s.charAt(i) == ']') {  // 닫는 괄호가 대괄호 일 경우
                // 스택이 비어있는데 닫는 괄호가 올 경우 또는 스택의 top이 짝을 이루지 못할 경우 false 반환.
                if(stack.empty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
        }


        return stack.empty();
    }
}
