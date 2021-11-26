package classes;

public class Stack{
    //private ListElement topOfStack;
    List stack1 = new List();
    private ListElement head;


    public void push(String data){
        stack1.addBack(data);
    }

    public String peek(){
        String tmp1;
        tmp1 = stack1.lastEl();
        return tmp1;
    }

    public String pop(){
        String tmp1;
        tmp1 = stack1.lastEl();
        stack1.delBack();
        return tmp1;
    }
}
