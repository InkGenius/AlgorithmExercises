package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomListMAX {

	public static RandomListNode copyRandomList(RandomListNode head) {
		if (head == null){
			return head;
		}
		
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode newHead = new RandomListNode(head.label);
		map.put(head, newHead);
		
		RandomListNode q = newHead;
		RandomListNode p = head.next;
		
		while (p != null) {
			q.next = new RandomListNode(p.label);
			map.put(p, q.next);
			q = q.next;
			p = p.next;
		}
		p = head;
		q = newHead;
		while (p != null) {
			q.random = map.get(p.random);
			q = q.next;
			p = p.next;
		}
		return newHead;
	}
	
	
	public static void main(String[] args) {
		RandomListNode n0 = new RandomListNode(0);
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		n0.next = n1;
		n0.random = n1;
		n1.next = n2;
		n1.random = n0;
		n2.random = n2;
		
		RandomListNode NF1 = new RandomListNode(-1);
		RandomListNode N8 = new RandomListNode(8);
		RandomListNode N7 = new RandomListNode(7);
		RandomListNode NF3 = new RandomListNode(-3);
		RandomListNode N4 = new RandomListNode(4);
		
		NF1.next = N8;
		N8.next = N7;
		N7.next = NF3;
		NF3.next = N4;
		
		NF1.random = N4;
		N8.random = NF3;
		N7.random = null;
		NF3.random = null;
		N4.random = NF1;
		
		
		RandomListNode newNode = copyRandomList(NF1);
		while(newNode != null){
			System.out.println("Label: " + newNode.label);
			if(newNode.next  != null){
				System.out.println(" Next " + newNode.next.label);
			}else{
				System.out.println(" Next = NULL");
			}
			
			if(newNode.random  != null){
				System.out.println(" Random: " + newNode.random.label);
			}else{
				System.out.println(" Random = NULL");
			}
			newNode = newNode.next;
		}
	}
}
