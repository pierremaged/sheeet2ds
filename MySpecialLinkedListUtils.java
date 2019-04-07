
public class MySpecialLinkedListUtils {
    public static double[] summary(LinkedListNode head) {
        LinkedListNode node = head;
        double[] ans = {0, 0, 0, head.value, head.value};
        int size = 0;
        int x = 1;
        while (node != null) {
            size++;
            node = node.next;
        }
        while (head != null) {
            ans[0] += head.value;
            ans[1] += (double) head.value / size;
            if (size % 2 == 1) {
                if (x == (size / 2) + 1) {
                    ans[2] = head.value;
                }
            } else if (size % 2 == 0) {
                if (x == size / 2) {
                    ans[2] += (double) head.value / 2;
                } else if (x == (size / 2) + 1) {
                    ans[2] += (double) head.value / 2;
                }
            }
            if (head.value > ans[3]) {
                ans[3] = head.value;
            }
            if (head.value < ans[4]) {
                ans[4] = head.value;
            }
            x++;
            head = head.next;
        }
        return ans;
    }

    public static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode prev = null;
        LinkedListNode current = head;
        LinkedListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public static LinkedListNode evenIndexedElements(LinkedListNode head) {
        LinkedListNode prev = null;
        LinkedListNode current = head;
        LinkedListNode next = null;
        while (current != null) {
            next = current.next.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        head = reverse(head);
        return head;
    }

    public static LinkedListNode insertionSort(LinkedListNode head) {
        if (head == null)
            return null;
        LinkedListNode sorted = head;
        head = head.next;
        sorted.next = null;

        while (head != null) {
            final LinkedListNode current = head;
            head = head.next;
            if (current.value < sorted.value) {
                current.next = sorted;
                sorted = current;
            } else {
                LinkedListNode search = sorted;
                while (search.next != null && current.value > search.next.value)
                    search = search.next;
                current.next = search.next;
                search.next = current;
            }
        }
        return sorted;
    }

    LinkedListNode sortedMerge(LinkedListNode a, LinkedListNode b) {
        LinkedListNode result = null;
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (a.value <= b.value) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    public LinkedListNode mergeSort(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode middle = getMiddle(head);
        LinkedListNode nextofmiddle = middle.next;
        middle.next = null;
        LinkedListNode left = mergeSort(head);
        LinkedListNode right = mergeSort(nextofmiddle);
        LinkedListNode sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    LinkedListNode getMiddle(LinkedListNode h) {
        if (h == null)
            return h;
        LinkedListNode fastptr = h.next;
        LinkedListNode slowptr = h;
        while (fastptr != null) {
            fastptr = fastptr.next;
            if (fastptr != null) {
                slowptr = slowptr.next;
                fastptr = fastptr.next;
            }
        }
        return slowptr;
    }

    public static LinkedListNode removeCentralNode(LinkedListNode head) {
        LinkedListNode prev = null;
        LinkedListNode current = head;
        LinkedListNode node = head;
        LinkedListNode next = null;
        int size = 0;
        int x = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        while (current != null) {
            if (x == size / 2) {
                next = current.next;
            }
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            x++;
        }
        head = prev;
        head = reverse(head);
        return head;
    }

    public static boolean palindrome(LinkedListNode head) {
        int size = 0;
        int i;
        LinkedListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        int[] arr = new int[size];
        int x = size;
        for (i = 0; i < size; i++) {
            arr[i] = head.value;
            head = head.next;
        }
        for (i = 0; i < (size / 2); i++) {
            if (arr[i] != arr[x - 1]) {
                return false;
            }
            x--;
        }
        return true;
    }
}




