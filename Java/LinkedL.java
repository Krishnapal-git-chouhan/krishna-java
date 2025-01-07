 class Linkedlist1{
    private Node head;
    private Node tail;
    private int size;

    public Linkedlist1() {
        this.size = 0;
    }
    
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
    

    if(tail == null){
        tail = head;
    }

    size += 1;
}
    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size ++;
    }

    public void insertBetween(int val,int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for(int i = 1; i < index; i++){
            temp = temp.next;
        }
        
        Node node = new Node(val,temp.next);
        temp.next = node;
        size++;
    } 

    public void deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
    }

    public int deleteLast(){
        if(size <= 1){
            deleteFirst();
        }
        Node secondlast = getIndex(size-2);
        int val = tail.value;
        tail = secondlast;
        tail.next = null;
        size--;
        return val;
    }

    public int deletebetween(int index){
        if(index == 0){
            deleteFirst();
        }
        if(index == size-1){
            deleteLast();
        }
        Node prev = getIndex(index-1);
        int val = prev.next.value;        

        prev.next = prev.next.next;
        return val;
    }
    public void removeDuplicate(){
        Node node = head;

        while(node.next != null){
            if(node.value == node.next.value){
                node.next = node.next.next;
                size--;
            }else{
                node = node.next;
            }            
        }
        tail = node;
        tail.next = null;
    }
    public static Linkedlist1 Merge(Linkedlist1 first, Linkedlist1 second){
        Node f = first.head;
        Node s = second.head;
        Linkedlist1 ans = new Linkedlist1();
        while(f != null && s != null){
            if(f.value < s.value){
                ans.insertLast(f.value);
                f = f.next;
            }else{
                ans.insertLast(s.value);
                s=s.next;
            }
        }
        while(f != null){
            ans.insertLast(f.value);
            f = f.next;
        }
        while(s != null){
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
    }
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + "-> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node getIndex(int index){
        Node node = head;
        for(int i = 1; i < index; i++){
            node = node.next;
        }
        return node;
    }
    public Node find(int val){
        Node node = head;
        while(node != null){
            if(node.value == val){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private class Node{
        private int value;
        private Node next;
        private int index;

       public Node(int value){
            this.value = value;
        
        }
       public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
       public Node(int value, int index){
        this.value = value;
        this.index = index;
       }     
    }
}

public class LinkedL {

    public static void main(String[] args) {
        Linkedlist1 l1 = new Linkedlist1();
        Linkedlist1 l2 = new Linkedlist1();
        // l1.insertFirst(2);
        // l1.insertFirst(3);
        // l1.insertFirst(4);
        // l1.insertFirst(0);
        // l1.insertLast(9);
        // l1.insertBetween(0,0);
        // l1.insertBetween(1,0);
        // // l1.display();
        // // l1.deleteFirst();
        // // l1.display();
        // // l1.deleteLast();
        // // l1.display();
        // // l1.deletebetween(3);
        // // l1.display();
        // l1.find(8);
        // l1.display();
        // l1.removeDuplicate();
        // l1.display();
        l1.insertLast(1);
        l1.insertLast(3);
        l1.insertLast(5);

        l2.insertLast(1);
        l2.insertLast(2);
        l2.insertLast(9);
        l2.insertLast(14);
        Linkedlist1 ans = Linkedlist1.Merge(l1, l2);
        ans.display();
    }
}