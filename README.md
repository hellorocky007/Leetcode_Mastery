# LeetCode 1498 - Number of Subsequences That Satisfy the Given Sum Condition

## Problem Description

Given an array of integers `nums` and an integer `target`, return the number of **non-empty** subsequences of `nums` such that the sum of the minimum element and the maximum element of the subsequence is less than or equal to `target`.

A **subsequence** is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

**Example:**
```
Input: nums = [3,5,6,7], target = 9
Output: 4
Explanation: The subsequences that satisfy the condition are:
[3], [3,5], [3,6], [3,7]
```

## Solution Approach

### Algorithm: Two-Pointer with Precomputed Powers

1. **Sort the array** - Sorting helps identify min and max elements easily in subsequences
2. **Precompute powers of 2** - Since each middle element can either be included or excluded, we have $2^k$ subsequences for $k$ elements between min and max
3. **Two-pointer technique** - Use pointers from start and end of the sorted array:
   - If `nums[start] + nums[end] <= target`: All subsequences starting with `nums[start]` and ending at or before `nums[end]` are valid. Count them as $2^{(end-start)}$ and move start pointer right
   - If `nums[start] + nums[end] > target`: Move end pointer left

### Key Insight

For a valid pair `(start, end)` where `nums[start] + nums[end] <= target`:
- `nums[start]` is the minimum and `nums[end]` is the maximum
- Any element between `start` and `end` can be included or excluded
- This gives us $2^{(end-start)}$ valid subsequences

## Complexity Analysis

- **Time Complexity:** $O(n \log n)$ - Due to sorting; the two-pointer traversal is $O(n)$
- **Space Complexity:** $O(n)$ - For the power array to store precomputed powers of 2

## Code Structure

```java
public int numSubseq(int[] nums, int target)
```

**Parameters:**
- `nums` - Array of positive integers
- `target` - Target sum for min + max of subsequences

**Returns:**
- Integer count of valid subsequences modulo $10^9 + 7$

## Implementation Details

- All arithmetic is done modulo $10^9 + 7$ to handle large numbers
- Powers of 2 are precomputed to avoid recalculation in the loop
- The two-pointer approach ensures linear traversal after sorting
