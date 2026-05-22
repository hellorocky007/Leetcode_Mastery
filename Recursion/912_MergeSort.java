
//912. Sort an Array
class Solution {
   public void merge(int[] nums,int start,int mid,int end){
    int n1 = mid-start+1;
    int n2 = end-mid;
    int left[] = new int[n1];
    int right[] = new int[n2];
    for(int i=0;i<n1;i++){
        left[i]=nums[start+i];
    }
    for(int i=0;i<n2;i++){
        right[i]=nums[mid+1+i];
    }
    int i=0;
    int j=0;
    int k=start;
    while(i<n1 && j<n2){
        if(left[i]<right[j]){
            nums[k]=left[i];
            i++;
        }else{
            nums[k]=right[j];
            j++;
        }
        k++;
    }
    while(i<n1){
        nums[k]=left[i];
        i++;
        k++;
    }
    while(j<n2){
        nums[k]=right[j];
        j++;
        k++;
    }
    

   }
    public void mergeSort(int[] nums,int start,int end){
        if(start<end){
            int mid = start+(end-start)/2;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
    }
    public int[] sortArray(int[] nums) {
        int start=0;
        int end = nums.length-1;
        mergeSort(nums,start,end);
        return nums;
        
    }
}