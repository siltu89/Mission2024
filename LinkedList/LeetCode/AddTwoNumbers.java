package LinkedList.LeetCode;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers( ListNode l1, ListNode l2 ) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode res = null;
        ListNode curr = null;
        ListNode newNode;
        int carry = 0;

        while (head1 != null && head2 != null) {
            int val = ( head1.getData() + head2.getData() + carry ) % 10;
            carry = ( head1.getData() + head2.getData() + carry ) /10;

            newNode = new ListNode(val);
            if( res == null ){
                res = newNode;
            }
            else  curr.setNext(newNode);
            curr = newNode;
            head1 = head1.getNext();
            head2 = head2.getNext();
        }

        while (head1 != null ) {
            int val = ( head1.getData() + carry ) % 10;
            carry = ( head1.getData() + carry ) /10;

            newNode = new ListNode(val);
            if( res == null ){
                res = newNode;
            }
            else  curr.setNext(newNode);
            curr = newNode;
            head1 = head1.getNext();
        }

        while (head2 != null ) {
            int val = ( head2.getData() + carry ) % 10;
            carry = ( head2.getData() + carry ) /10;

            newNode = new ListNode(val);

            if( res == null ){
                res = newNode;
            }
            else  curr.setNext(newNode);
            curr = newNode;

            head2 = head2.getNext();
        }

        if ( carry > 0 ) {
            curr.setNext(new ListNode(carry));
        }
        return res;

    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
        head1.setNext(new ListNode(9));
        head1.getNext().setNext(new ListNode(9));

        ListNode head2 = new ListNode(1);
//        head2.setNext( new ListNode(6));
//        head2.getNext().setNext(new ListNode(2));

        ListNode res = addTwoNumbers(head1, head2);

        while (res != null) {
            System.out.print(res.getData());
            if(res.getNext() != null)
                System.out.print("->");
            res = res.getNext();
        }

    }
}
