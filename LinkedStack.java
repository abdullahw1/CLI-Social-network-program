


public final class LinkedStack < T > implements StackInterface < T >
{
private Node topNode;		// References the first node in the chain

//default constructor
public LinkedStack ()
{
  topNode = null;
}

// Implement the unimplemented methods
private class Node
{
  T value;
  Node next;

  public Node ()
  {
    next = null;
  }
}				// end Node

public void push (T newEntry)
{
  if (topNode == null)
    {
	topNode = new Node ();
	topNode.value = newEntry;
    }
  else
    {
	Node newNode = new Node ();
	newNode.value = newEntry;
	newNode.next = topNode;
	topNode = newNode;
    }
}

public T pop ()
{
  if (topNode == null)
    {
	throw new
	  EmptyStackException
	  ("Pop operation is not possible on empty stack");
    }
  else
    {
	Node node = topNode;
	topNode = topNode.next;
	return node.value;
    }
}

public T peek ()
{
  if (topNode == null)
    {
	throw new
	  EmptyStackException
	  ("Peek operation is not possible on empty stack");
    }
  else
    {
	return topNode.value;
    }
}

public boolean isEmpty ()
{
  return topNode == null;
}

public void clear ()
{
  topNode = null;
}
}				
//end LinkedStack
