package LinkedList.LeetCode;

import java.util.Arrays;

public class SplitLinkedListParts {
    public static ListNode[] splitList (ListNode head, int k) {
        ListNode[] listNodes = new ListNode[k];

        if ( head == null ) {
            Arrays.fill(listNodes, null);
        }
        else {
        int len = findLength(head);
            if( len == k) {
                int i = 0;
                ListNode curr = head;
                while (curr != null) {
                    ListNode next = curr.getNext();
                    curr.setNext(null);
                    listNodes[i++] = curr;
                    curr = next;
                }
            }
            if( len < k ) {
                int i = 0;
                ListNode curr = head;
                while (curr != null) {
                    ListNode next = curr.getNext();
                    curr.setNext(null);
                    listNodes[i++] = curr;
                    curr = next;
                }
                while (i < k) {
                    listNodes[i++] = null;
                }
            }

            if(len > k) {
                int[] lens = new int[k];
                int partlen = len / k;
                Arrays.fill(lens, partlen);
                int rem = len % k;
                int x = 0;
                while (rem > 0) {
                    lens[x++] = lens[x]+1;
                    rem--;
                }
                int i = 0;
                ListNode curr = head;
                int m = 0;
                while (curr != null && curr.getNext() != null ){
                    listNodes[i++] = curr;
                    for ( int j = 0 ; j < lens[m]-1 ; j++) {
                            curr = curr.getNext();
                        }
                        if(curr != null) {
                            ListNode next = curr.getNext();
                            curr.setNext(null);
                            curr = next;
                        }
                    m++;
                }
                if (curr != null) {
                    listNodes[i] = curr;
                }
            }

        }
        return listNodes;

    }

    private static int findLength(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while ( curr != null) {
            curr = curr.getNext();
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(3));
        head.getNext().getNext().setNext(new ListNode(4));
        head.getNext().getNext().getNext().setNext(new ListNode(5));
//        head.getNext().getNext().getNext().getNext().setNext(new ListNode(6));
//        head.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(7));
//        head.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(8));
//        head.getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(9));
//        head.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(10));

        System.out.print(Arrays.toString(splitList(head, 3)));
    }
}
