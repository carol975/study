package daily_coding_problem;

public class AddTwoLists {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        int carry = 0;
        ListNode s = new ListNode(0);
        s.next = null;
        ListNode t = s;
        ListNode prev = t;
        
        while(a != null && b != null){
            int sum = a.val + b.val + carry;
            if(sum >= 10){
                carry = 1;
                sum = sum % 10;
            }
            else{
                carry = 0;
            }
            t.val = sum;
            t.next = new ListNode(carry);
            prev = t;
            t = t.next;
            a = a.next;
            b = b.next;
        }
        
        if(a != null){
            while(a != null){
                int sum = a.val + carry;
                if(sum >= 10){
                    carry = 1;
                    sum = sum % 10;
                }
                else {
                    carry = 0;
                }
                t.val = sum;
                t.next = new ListNode(carry);
                prev = t;
                t = t.next;
                a = a.next;
            }
        }
        else if(b != null){
            while(b != null){
                int sum = b.val + carry;
                if(sum >= 10){
                    carry = 1;
                    sum = sum % 10;
                }
                else {
                    carry = 0;
                }
                t.val = sum;
                t.next = new ListNode(carry);
                prev=t;
                t = t.next;
                b = b.next;
            }
        }
        
        
        
        if(t.val == 0){ //delete leading zero
        	prev.next = null;
        }
        return s;
        
    }
	
	public void print(ListNode l){
		ListNode t = l;
		while(t!=null){
			System.out.print(t.val);
			t = t.next;
		}
		System.out.println("\r\n");
	}
	
	public static void main(String[] args){
		AddTwoLists obj = new AddTwoLists();
		ListNode l1 = obj.new ListNode(2);
		ListNode t = l1;
		t.next = obj.new ListNode(4);
		t = t.next;
		t.next = obj.new ListNode(3);
		
		obj.print(l1);
	
		ListNode l2 = obj.new ListNode(5);
		t = l2;
		t.next = obj.new ListNode(6);
		t = t.next;
		t.next = obj.new ListNode(9);
		t = t.next;
		t.next = obj.new ListNode(4);
		
		ListNode s = obj.addTwoNumbers(l1,l2);
		if(s == null){
			System.out.print("null");
		}
		obj.print(s);
	}
}
