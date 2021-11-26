package classes;

public class List {
    private ListElement head;
    private ListElement tail;

    public void addFront(String data)
    {
        ListElement a = new ListElement();
        a.data = data;
        if (head == null)
        {
            head = a;
            tail = a;
        }
        else {
            a.next = head;
            head = a;
        }
    }

    public void addBack(String data){
        ListElement a = new ListElement();
        a.data = data;
        if (tail == null){
            head = a;
            tail = a;
        }
        else {
            tail.next = a;
            tail = a;
        }
    }

    public void delBack(){
        ListElement a;
        a = head;
        if (a == null )
            return;
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        else if (a != null){
            while (a.next != tail) {
                a = a.next;
            }
            tail = a;
        }
    }

    public String lastEl(){
        if (tail != null) {
            return tail.data;
        }
        else return "error";
    }

    public void printList()
    {
        ListElement t = this.head;
        while (t != null)
        {
            System.out.println(t.data + " ");
            t = t.next;
        }
        System.out.println();
    }

    public void addAfter (String prevEl, String nextEl){
        ListElement t = this.head;
        while (t != null){
            if (prevEl == t.data){
                ListElement e = new ListElement();
                e.data = nextEl;
                e.next = t.next;
                t.next = e;
                t = e;
            }
            t = t.next;
        }
    }

    public void delEl(String data)
    {
        if (head == null)
            return;

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        ListElement t = head;
        while (t.next != null) {
            if (t.next.data == data){
                if (tail == t.next){
                    tail = t;
                }
                t.next = t.next.next;
                return;
            }
            t = t.next;
        }
    }
}
