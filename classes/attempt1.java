package classes;


import java.util.ArrayList;
import java.util.Scanner;


public class attempt1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Stack stack1 = new Stack();
        Scanner in = new Scanner(System.in);

        arrayList.add("pop");
        arrayList.add("it");

        List linkedList = new List();
        linkedList.addBack("filinoe");
        linkedList.addBack("kure");
        System.out.println("linked list");
        linkedList.printList();

        System.out.println("array:");
        for (String s: arrayList){
            System.out.println(s);
        }

        System.out.println("Enter expression, use space as separator");
        String str = in.nextLine();
        String[] tokens = str.split("\\s");

        for (String s1: tokens){
            if (s1.matches("\\d")){
                System.out.print(s1);
            }
            else if(s1.matches("[a-z][a-z][a-z]")){
                stack1.push(s1);
            }
            else if (s1.matches("[+\\-*/^]")) {
                if (s1.matches("[+\\-]")) {
                    while (stack1.peek() == "+" || stack1.peek() == "-" || stack1.peek() == "*" || stack1.peek() == "/"
                            || stack1.peek() == "^") {
                        System.out.print(stack1.pop());
                    }
                } else if (s1.matches("[*/]")) {
                    while (stack1.peek() == "*" || stack1.peek() == "/" || stack1.peek() == "^") {
                        System.out.print(stack1.pop());
                    }
                } else if (s1.matches("[\\^]")) {
                    while (stack1.peek() == "^") {
                        System.out.print(stack1.pop());
                    }
                }
                stack1.push(s1);
            }
            else if (s1.matches("[(]")){
                stack1.push(s1);
            }
            else if (s1.matches("[)]")){
                if (stack1.peek() != "error") {

                    while (!stack1.peek().equals("(") && !stack1.peek().equals("error")) {
                        String tempStr = stack1.pop();
                        System.out.print(tempStr);
                    }
                }
                if (stack1.peek().equals("error")){
                    System.out.println("expression is not correct");
                }
                if (stack1.peek().equals("(")) {
                    stack1.pop();
                }
                if (stack1.peek().equals("sin") || stack1.peek().equals("cos")){
                    System.out.println(stack1.pop());
                }
            }
        }
        while(!stack1.peek().equals("error")){
            if (stack1.peek().equals("(")){
                System.out.println("expression is not correct");
            }
            else {
                System.out.print(stack1.pop());
            }
        }
    }
}
// test sin ( 2 + 3 ^ 4 ^ 5 )