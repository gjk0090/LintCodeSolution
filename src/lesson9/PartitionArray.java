package lesson9;

public class PartitionArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int partitionArray(int[] nums, int k) {
		if (nums.length == 0) {
			return 0;
		}
		int size = nums.length;
		int start = 0;
		int end = size - 1;

		while (start < end) {
			while (start < end && nums[start] < k) {
				start++;
			}
			while (start < end && nums[end] >= k) {
				end--;
			}
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;

		}
		return nums[start] >= k ? start : start + 1;
	}
}
