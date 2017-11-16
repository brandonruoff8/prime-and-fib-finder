	
public class CustomQueue {
	
	private int[] queue = new int[10];
	private int first;
	private int last;
	private int size;
	
	public CustomQueue()
	{
		first = -1;
		last = -1;
		size = 0;
	}
	
	public CustomQueue(int num)
	{
		first = 0;
		last = 0;
		queue[first] = num;
		size = 1;
	}
	
	public void enQueue(int num)
	{
		if (size == 0)
		{
			first = 0;
			last = 0;
			queue[0] = num;
			size++;
			return;
		}
		if (size >= 10)
		{
			System.out.print("\nQueue can only hold 10 items.\n");
			return;
		}
		last++;
		if (last >= 10)
		{
			last = 0;
		}
		queue[last] = num;
		size++;
	}
	
	public void deQueue()
	{
		first++;
		if (first >= 10)
		{
			first = 0;
		}
		size--;
	}
	
	public int peek()
	{
		return queue[first];
	}
	
	public boolean isEmpty() 
	{
		return (size <= 0);
	}
	
	public void display()
	{
		if(isEmpty())
		{
			System.out.print("[empty]\n\n");
			return;
		}
		System.out.print("[");
		int index = first;
		while (index != last)
		{
			System.out.print(queue[index] + ", ");
			index++;
			if (index >= 10)
			{
				index = 0;
			}
		}
		System.out.print(queue[last] + "]\n\n");
	}
	
	public int getSize() {
		return size;
	}
}
