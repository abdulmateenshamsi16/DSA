package clink.dclink;
class Node
{ 
    public int value ; 
    Node prev ; 
    Node next ; 
}
public class dclink {
    public Node head ; 
    public Node tail ; 
    public int size; 
    public Node create(int value) 
    { 
          Node node= new Node() ; 
          node.value = value ; 
           
          node.prev= node ; 
          node.next=node; 
          head=tail=node;
          size=1;
          return head ;   
    }
    public void  insert(int value,int pos)
    {    Node node = new Node() ; 
         node.value= value ; 
        if(head==null)
        { 
            create(value); 
            return ;
        }
        if(pos==0)
        { 
            node.next = head ; 
            head.prev= node; 
            node.prev=tail ; 
            tail.next= node; 
            head= node ; 
        }
        else if(pos>=size)
        { 
            node.prev= tail ; 
            tail.next= node; 
            node.next= head; 
            head.prev=node; 
            tail=node ; 
        }
        else
        {  Node curr=head ; 
           int i=0 ; 
           while(i!=pos-1)
           { 
            curr = curr.next ; 
            i++;   
           }    
           node.prev = curr; 
           node.next = curr.next ; 
           curr.next.prev= node; 
           curr.next=node ; 
        }
        size++ ; 
    }
    public void traverse()
    { 
        Node curr =head; 
        while(curr.next!=head)
        { 
            System.out.print(curr.value+"->");
            curr=curr.next ;
        }
        System.out.print(curr.value+" ");
        System.out.println(" "); 
    }
    public void revtraverse() 
    { 
        Node curr =tail ;
        if(head==null)
        { 
            System.out.println("Circular link  list does not exist"); 
        } 
        while(curr.prev!=tail)
        { 
            System.out.print(curr.value+"<-");
            curr=curr.prev; 
        }
        System.out.print(curr.value); 
    }
    public boolean  search(int value)
    {   if(head==null)
        { 
            System.out.println("Circular double link does not exist"); 
            return false ; 
        }
        Node curr =head ; 
         
        for(int i =0 ; i<size ; i++)
        { 
           if(curr.value==value)
           { 
            System.out.println("Node found at location"+i); 
            return true ; 
           }
           curr = curr.next ; 
        }
        System.out.println("Node is not found"); 
        return false ; 
    }
    public void delete(int pos)
    { 
        if(head == null)
        { 
            System.out.println("CLL does not exist"); 
        }
        if(pos==0)
        { 
            head=head.next ; 
            tail.next=head ; 
            head.prev= tail ; 
        }
        else if(pos==size)
        { 
           tail = tail.prev; 
           tail.next=head ; 
           head.prev= tail ; 
        }
        else
        { 
            int i= 0; 
            Node temp = head; 
            while(i!=pos-1)
            { 
                temp=temp.next ; 
                i++; 
            }
            
            temp.next = temp.next.next ; 
            temp.next.prev= temp ; 
            
        }
    }
    public static void main(String[] args) {
     dclink link = new dclink()  ;
     link.create(5);             
     link.insert(2,1); 
     link.insert(1,0); 
     link.insert(3,3); 
     link.traverse();
     link.revtraverse();
     link.search(6); 
     link.delete(3); 
     link.traverse();
    }
}
