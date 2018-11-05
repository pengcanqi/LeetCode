class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Num2_TwoNumAdd {

/*	代码美观点的写法
 * public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	ListNode resultList = new ListNode(0);
	ListNode tail = resultList;
	boolean carryBitFlag = false;
	int carryBit = 0;
	while (l1 != null || l2 != null) {
		carryBit = carryBitFlag == false ? 0 : 1;
		carryBitFlag = false;
		int tempValue = (l1 == null ? 0 : l1.val) + (l2== null ? 0 : l2.val) + carryBit;
		if (tempValue < 10) {
			tail.next = new ListNode(tempValue);
		} else {
			tail.next = new ListNode(tempValue - 10);
			carryBitFlag = true;
		}
		tail = tail.next;
		l1 = l1 == null ? null : l1.next;
		l2 = l2 == null ? null : l2.next；
	}*/

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode resultList = new ListNode(0);
		ListNode tail = resultList;
		boolean carryBitFlag = false;
		int carryBit = 0;
		while (l1 != null && l2 != null) {
			carryBit = carryBitFlag == false ? 0 : 1;
			carryBitFlag = false;
			int tempValue = l1.val + l2.val + carryBit;
			if (tempValue < 10) {
				tail.next = new ListNode(tempValue);
			} else {
				tail.next = new ListNode(tempValue - 10);
				carryBitFlag = true;
			}
			tail = tail.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		ListNode restList = null;
		if (l1 == null && l2 != null) {
			restList = l2;
		} else if (l1 != null && l2 == null) {
			restList = l1;
		}

		if (!carryBitFlag) {
			tail.next = restList;
		} else {
			while (restList != null) {
				carryBit = carryBitFlag == false ? 0 : 1;
				int tempValue = restList.val + carryBit;
				if (tempValue < 10) {
					restList.val = tempValue;
					tail.next = restList;
					carryBitFlag = false;
					break;
				} else {
					tail.next = new ListNode(0);
					tail = tail.next;
					restList = restList.next;
				}
			}
		}

		if (carryBitFlag) {
			tail.next = new ListNode(1);
		}

		return resultList.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1Head = new ListNode(0);
		ListNode l1Node1 = new ListNode(4);
		ListNode l1Node2 = new ListNode(3);
		l1Head.next = l1Node1;
		l1Node1.next = l1Node2;
		ListNode l2Head = new ListNode(1);
		ListNode l2Node1 = new ListNode(6);
		ListNode l2Node2 = new ListNode(4);
		l2Head.next = l2Node1;
		l2Node1.next = l2Node2;
		ListNode result = addTwoNumbers(l1Head, l2Head);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

}
