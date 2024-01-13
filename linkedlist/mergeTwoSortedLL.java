// Problem link: https://leetcode.com/problems/merge-two-sorted-lists/
// Explanation: https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Using an extra arraylist to store and store and then sort and put into a new
        // linkedlist and return
        // List<Integer> a = new ArrayList<>();
        // while(list1 != null){
        // a.add(list1.val);
        // list1 = list1.next;
        // }
        // while(list2 != null){
        // a.add(list2.val);
        // list2 = list2.next;
        // }
        // Collections.sort(a);
        // ListNode res = new ListNode(-1);
        // ListNode temp = res;
        // for(int i=0; i<a.size(); i++){
        // res.next = new ListNode(a.get(i));
        // res = res.next;
        // }
        // temp = temp.next;
        // return temp;

        // Using recursion
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}