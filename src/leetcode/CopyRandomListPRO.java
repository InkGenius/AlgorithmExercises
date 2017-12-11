package leetcode;

/**
 *	To summarize, we need three iterations over the list:
	i. Create a copy of each of the original node and insert them in between two
	original nodes in an alternate fashion.
	ii. Assign random pointer of each node copy.
	iii. Restore the input to its original configuration.
	We have achieved O(n) runtime complexity with using only constant extra space.
 */
public class CopyRandomListPRO {
	
	public static RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode p = head;
		// 第一次遍历对每个结点进行复制，然后把复制出来的新节点接在原结点的next，也就是让链表变成一个重复链表
		while (p != null) {
			RandomListNode next = p.next;
			RandomListNode copy = new RandomListNode(p.label);
			p.next = copy;
			copy.next = next;
			p = next;
		}
		p = head;
		// 第二次遍历中我们把旧结点的随机指针赋给新节点的随机指针
		while (p != null) {
			p.next.random = (p.random != null) ? p.random.next : null;
			p = p.next.next;
		}
		p = head;
		RandomListNode headCopy = (p != null) ? p.next : null;
		// 第三次遍历我们把链表拆成两个，第一个还原原链表，而第二个就是复制链表
		while (p != null) {
			RandomListNode copy = p.next;
			p.next = copy.next;
			p = p.next;
			copy.next = (p != null) ? p.next : null;
		}
		return headCopy;
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
		while (newNode != null) {
			System.out.println("Label: " + newNode.label);
			if (newNode.next != null) {
				System.out.println(" Next " + newNode.next.label);
			} else {
				System.out.println(" Next = NULL");
			}

			if (newNode.random != null) {
				System.out.println(" Random: " + newNode.random.label);
			} else {
				System.out.println(" Random = NULL");
			}
			newNode = newNode.next;
		}
	}
}
