class QuickSort {

    public int partition(int[] nums, int start, int end) {

        int pivot = nums[start];

        int i = start + 1;
        int j = end;

        while (i <= j) {

            while (i <= end && nums[i] < pivot) {
                i++;
            }

            while (j >= start && nums[j] > pivot) {
                j--;
            }

            if (i < j) {

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j--;
            }
        }

        int temp = nums[start];
        nums[start] = nums[j];
        nums[j] = temp;

        return j;
    }

    public void quickSort(int[] nums, int start, int end) {

        if (start < end) {

            int partition = partition(nums, start, end);

            quickSort(nums, start, partition - 1);

            quickSort(nums, partition + 1, end);
        }
    }

    public int[] sortArray(int[] nums) {

        quickSort(nums, 0, nums.length - 1);

        return nums;
    }
}