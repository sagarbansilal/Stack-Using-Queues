import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sagar
 */

public class Stack<E> {
	E element;
	Queue<E> queue1;
	Queue<E> queue2;
	
	public Stack(){
		queue1=new LinkedList<E>();
		queue2=new LinkedList<E>();
	}
	
	public void push(E element){
		if(queue1.isEmpty()){
			queue2.add(element);
		}else{
			queue1.add(element);
		}
	}
	
	public E pop(){
		if(queue1.isEmpty() && queue2.isEmpty()) return null;
		if(queue1.isEmpty()){
			while(queue2.size()>1){
				queue1.add(queue2.poll());
			}
			return queue2.poll();
		}else{
			while(queue1.size()>1){
				queue2.add(queue1.poll());
			}
			return queue1.poll();
		}
	}
	
	public E peek(){
		if(queue1.isEmpty() && queue2.isEmpty()) return null;
		if(queue1.isEmpty()){
			while(queue2.size()>1){
				queue1.add(queue2.poll());
			}
			E element=queue2.poll();
			queue1.add(element);
			return element;
		}else{
			while(queue1.size()>1){
				queue2.add(queue1.poll());
			}
			E element=queue1.poll();
			queue2.add(element);
			return element;
		}
	}
	
	public boolean isEmpty(){
		return queue1.isEmpty() && queue2.isEmpty();
	}
	
	public int size(){
		if(queue1.isEmpty()) return queue2.size();
		return queue1.size();
	}
}
