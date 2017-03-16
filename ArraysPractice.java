package commonInterviewQuestions;

public class ArraysPractice {
	public static void main(String[] args) {
		int[] arr = { -7, -5, -6, -8, -2, -4, -11 };
		// System.out.println(elementAppearsOnceInArray(arr));
		// System.out.println(magicIndexDistinctValues(arr));
		// System.out.println(duplicateInArray(arr));
		// System.out.println(elementInArrayDifferenceOfOne(arr, 8));
		System.out.println(maxContSum(arr));
	}

	/*
	 * Find the element that appears once in a sorted array where all the other
	 * elements appear twice one after another. Find that element in O(logn)
	 * complexity. Input: arr[] = {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8} Output: 4
	 */
	public static int elementAppearsOnceInArray(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (mid % 2 != 0) {
				if (mid + 1 < arr.length && arr[mid] == arr[mid - 1])
					left = mid + 1;
				else if (mid - 1 >= 0 && arr[mid] == arr[mid + 1])
					right = mid - 1;
				else
					return arr[mid];
			} else {
				if (mid + 1 < arr.length && arr[mid] == arr[mid + 1])
					left = mid + 1;
				else if (mid - 1 >= 0 && arr[mid] == arr[mid - 1])
					right = mid - 1;
				else
					return arr[mid];
			}
		}
		return -1;
	}

	/*
	 * A magic index in an array A[0….n-1] is defined to be an index such that
	 * A[i] = i. Given a sorted array of distinct integers, write a method to
	 * find a magic index if once exists, in an array A. FOLLOW UP: What if the
	 * values are not distinct? Return the first
	 */
	public static int magicIndexDistinctValues(int[] arr) {
		if (arr[0] > 0)
			return -1;
		if (arr[0] == 0)
			return 0;
		else {
			int left = 1;
			int right = arr.length - 2;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (arr[mid] < mid)
					left = mid + 1;
				else if (arr[mid] > mid)
					right = mid - 1;
				else
					return mid;
			}
		}
		return -1;
	}

	/*
	 * Given an array that contains numbers from 1 to n-1 and exactly 1
	 * duplicate, find that duplicate. {1,2,3,4,4,5}
	 */
	public static int duplicateInArray(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (mid % 2 == 0) {
				if (arr[mid] % 2 == 0) {
					if (mid - 1 >= 0 && arr[mid] == arr[mid - 1])
						return arr[mid];
					else
						right = mid - 1;
				} else {
					if (mid + 1 < arr.length && arr[mid] == arr[mid + 1])
						return arr[mid];
					else
						left = mid + 1;
				}
			} else {
				if (arr[mid] % 2 != 0) {
					if (mid - 1 >= 0 && arr[mid] == arr[mid - 1])
						return arr[mid];
					else
						right = mid - 1;
				} else {
					if (mid + 1 < arr.length && arr[mid] == arr[mid + 1])
						return arr[mid];
					else
						left = mid + 1;
				}
			}
		}
		return -1;
	}

	/*
	 * Search an element in an array where difference between adjacent elements
	 * is 1. For example: arr[] = {8,7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3} return the
	 * index
	 */
	public static int elementInArrayDifferenceOfOne(int[] arr, int n) {
		int targetIndex = Math.abs(arr[0] - n);
		while (targetIndex < arr.length) {
			if (arr[targetIndex] == n)
				return targetIndex;
			else
				targetIndex = targetIndex + Math.abs(arr[targetIndex] - n);
		}
		return -1;
	}

	/*
	 * Return the maximum sum of set of contiguous values within an array
	 * { -1, 5, 6, -7, -8, -2, -4, -11, -1 } == 11
	 */
	public static int maxContSum(int[] arr) {
		int largestSum = arr[0];
		int sum=0;
		int i = 0;
		while (i < arr.length - 1) {
			if (arr[i] < 0) {
				if (arr[i] > largestSum) {
					largestSum = arr[i];
				}
				i++;
			} else {
				largestSum = arr[i];
				sum = largestSum;
				while (sum > -1) {
					sum = arr[i + 1] + sum;
					if (sum > largestSum)
						largestSum = sum;
					i++;
				}
				sum=0;
			}
		}
		return largestSum;
	}
}
