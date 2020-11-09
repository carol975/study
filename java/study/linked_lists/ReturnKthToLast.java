package linked_lists;

import java.util.HashSet;

public class ReturnKthToLast {
	public class Node {
		int val;
		Node next;
		public Node(int val){
			this.val = val;
			this.next = null;
		}
	}
	public static int returnKthToLast (Node head, int k){
		int curTh = 1;
		Node last = head;
		
		while(last.next != null){
			if(curTh >= k){
				head = head.next;
			}
			curTh++;
			last = last.next;
		}
		return head.val;
	}
	
	public Node removeKthToLast(Node head, int k){
		int curTh = 1;
		Node curr = head;
		Node last = head;
		Node prev = null;
		while(last.next != null){
			if(curTh >= k){
				prev = curr;
				curr = curr.next;
			}
			curTh++;
			last = last.next;
		}
		
		if(prev == null){
			head = head.next;
		}
		else{
			prev.next= curr.next;
		}
		
		return head;
		
	}
	
	public void removeMiddleNode(Node node){
		node.val = node.next.val;
		node.next = node.next.next;
		
	}
	
	public Node partition(int part, Node head){
		Node end = head;
		while(end.next != null){
			end = end.next;
		}
		Node tail = end;
		Node curr = head;
		while(curr != end){
			if(curr.next.val >= part){
				Node next = curr.next;
				curr.next = next.next;
				tail.next = next;
				next.next = null;
				tail = next;
			}
			else{
				curr = curr.next;
			}
			
		}
		
		//check head
		if(head.val >= part){
			tail.next = head;
			head = head.next;
			tail.next.next = null;
		}
		
		return head;
	}
	
	
	public void partition2(int part, Node head){
		Node end = head;
		while(end.next != null){
			end = end.next;
		}
		Node tail = end;
		Node curr = head;
		while(curr != end){
			if(curr.val >= part){
				Node next = curr;
				curr = curr.next;
				tail.next = next;
				next.next = null;
				tail = next;
				head = curr;
			}
			else{
				curr = curr.next;
			}
			
		}
	}
	
	public void printLists(Node head){
		while(head!=null){
			System.out.print(head.val +" ");
			head = head.next;
		}
	}
	
	public Node sumListsForward(Node l1, Node l2){
		Node backWard = null;
		while(l1 != null){
			Node temp = l1;
			l1 = l1.next;
			temp.next = backWard;
			backWard = temp;
		}
		
		l1 = backWard;
		
		backWard = null;
		
		while(l2 != null){
			Node temp = l2;
			l2 = l2.next;
			temp.next = backWard;
			backWard = temp;
		}
		
		Node answerBW = sumLists(l1,backWard);
		backWard = null;
		while(answerBW != null){
			Node temp = answerBW;
			answerBW = answerBW.next;
			temp.next = backWard;
			backWard = temp;
		}
		return backWard;
		
	}
	public Node sumLists(Node l1,Node l2){
		int carry = 0;
		Node curr = new Node(-1);
		Node answer = curr;
		while(l1 != null){
			curr.next = new Node(carry + l1.val);
			l1 = l1.next;
			
			if(l2 != null ){
				curr.next.val += l2.val;
				l2 = l2.next;
			}
			carry = 0;
			if(curr.next.val >= 10){
				carry = 1;
				curr.next.val = Math.abs(curr.next.val - 10);
				
			}
			curr = curr.next;
		}
		
		while(l2 != null){
			curr.next = new Node(carry + l2.val);
			carry = 0;
			if(curr.next.val >= 10){
				carry = 1;
				curr.next.val = Math.abs(curr.next.val - 10);
			}
			l2 = l2.next;
		}
		
		if(carry > 0){
			curr.next = new Node(carry);
		}
		return answer.next;
	}
	
	public boolean isPalindrome(Node head){
		Node rev = null;
		Node curr = head;
		while(curr != null){
			Node temp = new Node(curr.val);
			curr = curr.next;
			temp.next = rev;
			rev = temp;
		}
		while(head != null){
			if(head.val != rev.val){
				return false;
			}
			head = head.next;
			rev = rev.next;
		}
		return true;
	}
	
	public Node intersects(Node l1, Node l2){
		Node t1 = l1;
		Node t2 = l2;
		int s1 = 1;
		int s2 = 1;
		
		while(t1.next != null){
			s1++;
			t1 = t1.next;
		}
		
		while(t2.next != null){
			s2++;
			t2=t2.next;
		}
		
		if(t1 != t2){
			return null;
		}
		
		while(s1 > s2){
			l1 = l1.next;
			s1--;
		}
		
		while(s2 > s1){
			l2 = l2.next;
			s2--;
		}
		
		while(l1 != l2){
			l1 = l1.next;
			l2 = l2.next;
		}
		
		return l2;
	}
	
	public Node loopDetection(Node head){
		HashSet<Node> exist = new HashSet<Node>();
		
		while(head != null){
			if(exist.contains(head)){
				return head;
			}
			exist.add(head);
			head = head.next;
		}
		return null;
	}
	
	public Node loopDetection2(Node head){
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null){
			if(fast == slow){
				break;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if(fast == null || fast.next == null){
			return null;
		}
		
		while(head != fast){
			head = head.next;
			fast = fast.next;
		}
		return head;
	}
	public static void main(String[] args){
		ReturnKthToLast r = new ReturnKthToLast();
		Node head= r.new Node(1);
		head.next= r.new Node(2);
		head.next.next = head;
		//head.next.next = r.new Node(6);
		
		Node l2 = r.new Node(6);
		l2.next= head.next;
		//l2.next.next = r.new Node(7);
		//Node answer = r.sumListsForward(head, l2);
		//head.next.next.next.next.next= r.new Node(6);
		//Node h = r.removeKthToLast(head, 1);
		//r.removeMiddleNode(head.next.next);
		//head = r.partition(3, head);
		System.out.println(r.loopDetection2(head).val);
		
	}
	
}
