import java.util.*;

/**
 * TYPES OF TWO POINTERS — Complete Reference
 * Each inner class demonstrates one subtype with a concrete problem + solution.
 */
public class TwoPointers {

    // ─────────────────────────────────────────────────────────────────────────
    // 1. OPPOSITE ENDS
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * 1a. CONVERGING — both move inward toward each other
     * Problem: Two Sum II (sorted array) — find pair that sums to target
     */
    static class OppositeEndsConverging {
        // [1, 2, 7, 11, 15], target=9 → indices [1,2] (1-based)
        static int[] twoSum(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target)  return new int[]{left + 1, right + 1};
                else if (sum < target) left++;
                else                   right--;
            }
            return new int[]{-1, -1};
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 7, 11, 15}, 9)));
            // [1, 2]
        }
    }

    /**
     * 1b. ONE FIXED, ONE MOVING — fix one end, slide the other
     * Problem: Valid Palindrome — check if string reads same both ways
     */
    static class OppositeEndsOneFixed {
        // "racecar" → true, "hello" → false
        static boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) return false;
                left++;
                right--;
            }
            return true;
        }

        // Problem variant: Container With Most Water — fix whichever side is shorter
        static int maxWater(int[] height) {
            int left = 0, right = height.length - 1, max = 0;
            while (left < right) {
                int water = Math.min(height[left], height[right]) * (right - left);
                max = Math.max(max, water);
                if (height[left] <= height[right]) left++;  // fix taller side, move shorter
                else                                right--;
            }
            return max;
        }

        public static void main(String[] args) {
            System.out.println(isPalindrome("racecar"));                    // true
            System.out.println(maxWater(new int[]{1,8,6,2,5,4,8,3,7}));    // 49
        }
    }


    // ─────────────────────────────────────────────────────────────────────────
    // 2. SAME DIRECTION
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * 2a. FIXED SPEED GAP — slow+1, fast+k (constant gap between them)
     * Problem: Kth Node from End of Linked List
     */
    static class SameDirectionFixedGap {
        static class ListNode {
            int val; ListNode next;
            ListNode(int val) { this.val = val; }
        }

        // advance fast by k steps first, then both move together
        static ListNode kthFromEnd(ListNode head, int k) {
            ListNode slow = head, fast = head;
            for (int i = 0; i < k; i++) fast = fast.next; // create gap of k
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
            System.out.println(kthFromEnd(head, 2).val); // 4
        }
    }

    /**
     * 2b. VARIABLE SPEED — fast moves 2x slow's speed
     * Problem: Middle of Linked List — slow+1 step, fast+2 steps
     */
    static class SameDirectionVariableSpeed {
        static class ListNode {
            int val; ListNode next;
            ListNode(int val) { this.val = val; }
        }

        static ListNode findMiddle(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;       // +1
                fast = fast.next.next;  // +2
            }
            return slow; // slow is at middle
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
            System.out.println(findMiddle(head).val); // 3
        }
    }


    // ─────────────────────────────────────────────────────────────────────────
    // 3. SLIDING WINDOW
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * 3a. FIXED SIZE WINDOW — window size stays constant
     * Problem: Maximum sum of subarray of size k
     */
    static class SlidingWindowFixed {
        // [2,1,5,1,3,2], k=3 → 9 (5+1+3)
        static int maxSumFixedWindow(int[] nums, int k) {
            int windowSum = 0, maxSum = 0;
            for (int i = 0; i < k; i++) windowSum += nums[i]; // first window
            maxSum = windowSum;
            for (int right = k; right < nums.length; right++) {
                windowSum += nums[right] - nums[right - k];    // slide: add right, drop left
                maxSum = Math.max(maxSum, windowSum);
            }
            return maxSum;
        }

        public static void main(String[] args) {
            System.out.println(maxSumFixedWindow(new int[]{2,1,5,1,3,2}, 3)); // 9
        }
    }

    /**
     * 3b. VARIABLE SIZE — shrink left on violation
     * Problem: Longest substring without repeating characters
     */
    static class SlidingWindowVariableShrink {
        // "abcabcbb" → 3 ("abc")
        static int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> freq = new HashMap<>();
            int left = 0, maxLen = 0;
            for (int right = 0; right < s.length(); right++) {
                freq.merge(s.charAt(right), 1, Integer::sum);  // expand right
                while (freq.get(s.charAt(right)) > 1) {        // violation: shrink left
                    freq.merge(s.charAt(left), -1, Integer::sum);
                    if (freq.get(s.charAt(left)) == 0) freq.remove(s.charAt(left));
                    left++;
                }
                maxLen = Math.max(maxLen, right - left + 1);
            }
            return maxLen;
        }

        public static void main(String[] args) {
            System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        }
    }

    /**
     * 3c. VARIABLE SIZE — expand until condition met
     * Problem: Minimum size subarray sum ≥ target
     */
    static class SlidingWindowVariableExpand {
        // [2,3,1,2,4,3], target=7 → 2 (subarray [4,3])
        static int minSubArrayLen(int target, int[] nums) {
            int left = 0, sum = 0, minLen = Integer.MAX_VALUE;
            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];                              // grow
                while (sum >= target) {                          // condition met → try shrinking
                    minLen = Math.min(minLen, right - left + 1);
                    sum -= nums[left++];
                }
            }
            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }

        public static void main(String[] args) {
            System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3})); // 2
        }
    }


    // ─────────────────────────────────────────────────────────────────────────
    // 4. MERGE STYLE
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * 4a. TWO SEPARATE ARRAYS — one pointer per array, advance smaller
     * Problem: Merge two sorted arrays into one sorted array
     */
    static class MergeTwoArrays {
        // [1,3,5] + [2,4,6] → [1,2,3,4,5,6]
        static int[] mergeSorted(int[] a, int[] b) {
            int i = 0, j = 0, k = 0;
            int[] result = new int[a.length + b.length];
            while (i < a.length && j < b.length) {
                result[k++] = (a[i] <= b[j]) ? a[i++] : b[j++]; // advance smaller
            }
            while (i < a.length) result[k++] = a[i++];
            while (j < b.length) result[k++] = b[j++];
            return result;
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(mergeSorted(
                new int[]{1,3,5}, new int[]{2,4,6}
            ))); // [1,2,3,4,5,6]
        }
    }

    /**
     * 4b. SAME ARRAY IN-PLACE — merge from END to avoid overwriting
     * Problem: Merge Sorted Array (nums1 has extra space at end)
     */
    static class MergeInPlace {
        // nums1=[1,2,3,0,0,0] m=3, nums2=[2,5,6] n=3 → [1,2,2,3,5,6]
        static void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1, j = n - 1, k = m + n - 1; // all three start from the end
            while (i >= 0 && j >= 0) {
                nums1[k--] = (nums1[i] >= nums2[j]) ? nums1[i--] : nums2[j--];
            }
            while (j >= 0) nums1[k--] = nums2[j--]; // only need to drain nums2
        }

        public static void main(String[] args) {
            int[] nums1 = {1, 2, 3, 0, 0, 0};
            merge(nums1, 3, new int[]{2, 5, 6}, 3);
            System.out.println(Arrays.toString(nums1)); // [1,2,2,3,5,6]
        }
    }


    // ─────────────────────────────────────────────────────────────────────────
    // 5. PARTITION
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * 5a. SINGLE PIVOT — one boundary pointer, one scan pointer
     * Problem: QuickSort partition (Lomuto scheme)
     */
    static class PartitionSinglePivot {
        // boundary = last valid ≤ pivot, scan = current element being checked
        static int partition(int[] arr, int lo, int hi) {
            int pivot = arr[hi];
            int boundary = lo - 1;
            for (int scan = lo; scan < hi; scan++) {
                if (arr[scan] <= pivot) {
                    boundary++;
                    int tmp = arr[boundary]; arr[boundary] = arr[scan]; arr[scan] = tmp;
                }
            }
            int tmp = arr[boundary+1]; arr[boundary+1] = arr[hi]; arr[hi] = tmp;
            return boundary + 1;
        }

        static void quickSort(int[] arr, int lo, int hi) {
            if (lo < hi) {
                int p = partition(arr, lo, hi);
                quickSort(arr, lo, p - 1);
                quickSort(arr, p + 1, hi);
            }
        }

        public static void main(String[] args) {
            int[] arr = {3, 6, 8, 10, 1, 2, 1};
            quickSort(arr, 0, arr.length - 1);
            System.out.println(Arrays.toString(arr)); // [1,1,2,3,6,8,10]
        }
    }

    /**
     * 5b. TWO PIVOT — two boundary pointers, one scan pointer
     * Problem: Dual-pivot sort (elements bucketed around two pivots)
     */
    static class PartitionTwoPivot {
        static void twoPivotSort(int[] arr) {
            if (arr.length < 2) return;
            int pivot1 = arr[0], pivot2 = arr[arr.length - 1];
            if (pivot1 > pivot2) { int t = pivot1; pivot1 = pivot2; pivot2 = t; }
            int left = 1, right = arr.length - 2, scan = 1;
            while (scan <= right) {
                if (arr[scan] < pivot1) {
                    int t = arr[scan]; arr[scan] = arr[left]; arr[left] = t;
                    left++; scan++;
                } else if (arr[scan] > pivot2) {
                    int t = arr[scan]; arr[scan] = arr[right]; arr[right] = t;
                    right--;              // don't advance scan — unknown what came from right
                } else {
                    scan++;
                }
            }
        }

        public static void main(String[] args) {
            int[] arr = {5, 3, 8, 4, 1, 7, 2, 6};
            twoPivotSort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 5c. THREE-WAY / DUTCH FLAG — lo, mid, hi — three strict regions
     * Problem: Sort array of 0s, 1s, 2s in one pass
     */
    static class PartitionThreeWay {
        // lo = right edge of 0s, mid = current, hi = left edge of 2s
        // [2,0,2,1,1,0] → [0,0,1,1,2,2]
        static void sortColors(int[] nums) {
            int lo = 0, mid = 0, hi = nums.length - 1;
            while (mid <= hi) {
                if (nums[mid] == 0) {
                    int t = nums[lo]; nums[lo] = nums[mid]; nums[mid] = t;
                    lo++; mid++;        // element from lo was 1 (safe), advance both
                } else if (nums[mid] == 2) {
                    int t = nums[mid]; nums[mid] = nums[hi]; nums[hi] = t;
                    hi--;               // unknown what came from hi, don't advance mid
                } else {
                    mid++;
                }
            }
        }

        public static void main(String[] args) {
            int[] arr = {2, 0, 2, 1, 1, 0};
            sortColors(arr);
            System.out.println(Arrays.toString(arr)); // [0,0,1,1,2,2]
        }
    }


    // ─────────────────────────────────────────────────────────────────────────
    // 6. LINKED LIST CYCLE (FLOYD'S)
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * 6a. CYCLE DETECTION ONLY — slow+1, fast+2 — meet inside cycle
     * Problem: Linked List Cycle (yes/no)
     */
    static class FloydCycleDetect {
        static class ListNode {
            int val; ListNode next;
            ListNode(int val) { this.val = val; }
        }

        static boolean hasCycle(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return true;
            }
            return false;
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(3);
            head.next = new ListNode(2);
            head.next.next = new ListNode(0);
            head.next.next.next = new ListNode(-4);
            head.next.next.next.next = head.next; // cycle: -4 → 2
            System.out.println(hasCycle(head)); // true
        }
    }

    /**
     * 6b. CYCLE + ENTRY POINT — after meeting, reset one to head, both move +1
     * Problem: Linked List Cycle II — find where the cycle begins
     *
     * Math: dist(head→entry) == dist(meetPoint→entry)
     *       so reset one pointer to head; both reach entry at same time.
     */
    static class FloydCycleEntryPoint {
        static class ListNode {
            int val; ListNode next;
            ListNode(int val) { this.val = val; }
        }

        static ListNode detectCycleEntry(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    slow = head;             // reset to head
                    while (slow != fast) {
                        slow = slow.next;
                        fast = fast.next;    // both +1
                    }
                    return slow;             // cycle entry
                }
            }
            return null;
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(3);
            head.next = new ListNode(2);
            head.next.next = new ListNode(0);
            head.next.next.next = new ListNode(-4);
            head.next.next.next.next = head.next; // entry = node(2)
            ListNode entry = detectCycleEntry(head);
            System.out.println(entry != null ? entry.val : "no cycle"); // 2
        }
    }

    /**
     * 6c. DUPLICATE IN ARRAY — treat array as linked list, same Floyd logic
     * Problem: Find the Duplicate Number (n+1 ints in range [1..n])
     * index → value acts as "next pointer"; duplicate value = cycle entry
     */
    static class FloydDuplicateInArray {
        // [1,3,4,2,2] → 2
        static int findDuplicate(int[] nums) {
            int slow = nums[0], fast = nums[0];

            // phase 1: find meeting point inside cycle
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);

            // phase 2: find cycle entry = duplicate
            slow = nums[0];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }

        public static void main(String[] args) {
            System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2})); // 2
            System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2})); // 3
        }
    }


    // ─────────────────────────────────────────────────────────────────────────
    // RUNNER
    // ─────────────────────────────────────────────────────────────────────────
    public static void main(String[] args) throws Exception {
        System.out.println("=== 1a. Opposite Ends — Converging ===");
        OppositeEndsConverging.main(null);

        System.out.println("\n=== 1b. Opposite Ends — One Fixed ===");
        OppositeEndsOneFixed.main(null);

        System.out.println("\n=== 2a. Same Direction — Fixed Gap ===");
        SameDirectionFixedGap.main(null);

        System.out.println("\n=== 2b. Same Direction — Variable Speed ===");
        SameDirectionVariableSpeed.main(null);

        System.out.println("\n=== 3a. Sliding Window — Fixed Size ===");
        SlidingWindowFixed.main(null);

        System.out.println("\n=== 3b. Sliding Window — Shrink on Violation ===");
        SlidingWindowVariableShrink.main(null);

        System.out.println("\n=== 3c. Sliding Window — Expand Until Condition ===");
        SlidingWindowVariableExpand.main(null);

        System.out.println("\n=== 4a. Merge — Two Separate Arrays ===");
        MergeTwoArrays.main(null);

        System.out.println("\n=== 4b. Merge — In-Place From End ===");
        MergeInPlace.main(null);

        System.out.println("\n=== 5a. Partition — Single Pivot ===");
        PartitionSinglePivot.main(null);

        System.out.println("\n=== 5b. Partition — Two Pivot ===");
        PartitionTwoPivot.main(null);

        System.out.println("\n=== 5c. Partition — Three-Way Dutch Flag ===");
        PartitionThreeWay.main(null);

        System.out.println("\n=== 6a. Floyd — Cycle Detection Only ===");
        FloydCycleDetect.main(null);

        System.out.println("\n=== 6b. Floyd — Cycle + Entry Point ===");
        FloydCycleEntryPoint.main(null);

        System.out.println("\n=== 6c. Floyd — Duplicate in Array ===");
        FloydDuplicateInArray.main(null);
    }
}