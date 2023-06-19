


//Abdullah Waheed

public class LinkedQueue < T > implements QueueInterface < T >
{

class Node
{
    T data;
    // reference to next node
    Node next;
    // constructor pointer value for data
    public Node (T data)
    {
        this.data = data;
    }
}
//end Node

//defining two references of Node class as head & tail

private Node head, tail;

//initializing empty queue
public LinkedQueue ()
{
  head = tail = null;
}

@Override

public void enqueue (T newEntry)
{
  // creating new node with value = newEntry
  Node n = new Node (newEntry);
  // seting as both head and tail if queue is empty
  if (isEmpty ())
  {
      

	    head = tail = n;
  }
  else{
	    tail.next = n;
  	tail = n;
  }
}


@Override 

public T dequeue (){
  if (isEmpty ())
  {
      //seting
	    throw new EmptyQueueException ("Queue is empty!");
  }
  
  T data = head.data;
  head = head.next;
  if (head == null){

	    tail = null;
  }

  // returning removed data
  return data;
}


@Override 

public T getFront (){
  // throwing exception if queue is empty
  if (isEmpty ())
    {
	      throw new EmptyQueueException ("Queue is empty!");

    }
  // returning data of head node
  return head.data;
}

@Override 

public boolean isEmpty ()
{
  // queue is empty if head is null
  return head == null;

}

@Override 

public void clear (){
  // setting head and tail to null
  head = tail = null;

}

}				
//end LinkedQueue
