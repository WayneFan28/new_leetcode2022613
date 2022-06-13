package Array;

import java.util.*;

public class KthLargestElementArray {
    /**
     Given an integer array nums and an integer k,
     return the kth largest element in the array.
     */
    public int findKthLargest(int[] nums, int k) {//leetcode 215
        PriorityQueue<Integer> pq = new PriorityQueue<>();//小顶堆
        for (int i : nums){
            pq.offer(i);
            if (pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
    /**
     Given an integer array nums,
     return the third distinct maximum number in this array.
     If the third maximum does not exist, return the maximum number.
     */
    public int thirdMax(int[] nums) {//leetcode 414
        int max = Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums){
            max = Math.max(i, max);
            while (!pq.contains(i)){
                pq.offer(i);
            }
            if (pq.size() > 3){
                pq.poll();
            }
        }
        return (pq.size() < 3)? max : pq.peek();
    }
    /**
     Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
     return the k closest points to the origin (0, 0).
     The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
     */
    public int[][] kClosest(int[][] points, int k) {//leetcode 973
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return (p1[0] * p1[0] + p1[1] * p1[1]) -
                        (p2[0] * p2[0]  + p2[1] * p2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, k);
    }

    /**
     Given an integer array nums and an integer k, return the k most frequent elements.
     You may return the answer in any order.
     */
    class Pair{
        int freq;
        int val;

        public Pair(int val, int freq) {
            this.freq = freq;
            this.val = val;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();//
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (a.freq == b.freq){
                    return a.val - b.val;
                }
                return a.freq - b.freq;
            }
        });
        for (int i : nums){
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        for (int key : map.keySet()){
            pq.add(new Pair(key, map.get(key)));
            if (pq.size() > k){
                pq.poll();
            }
        }
        int i = 0;
        while (pq.size() > 0){
            ans[i++] = pq.poll().val;
        }
        return ans;
    }
}
