public class MoveZeroesToEnd{
    public void moveZeroes(int[] nums){
        //moveZeroesShift(nums);
        //moveZeroesSwap(nums);
        moveZeroesSnowball(nums);

    }
    /**
     * we just move all the non zeroes to one side 
     * insert remaining space with zero
     */
    public void moveZeroesShift(int[] nums){
        int lastNonZeroIdx = 0;
        for(int i =0; i< nums.length;i++){
            if(nums[i] != 0){
                nums[lastNonZeroIdx] = nums[i];//so if 1st element is non zero then it writes itself and keeps looking for 1st zero and then non zero
                lastNonZeroIdx++;
            }
        }
        //lastNonZeroIdx will contain 1st zero value. 
        for(int i = lastNonZeroIdx; i< nums.length; i++){
            nums[i] = 0;
        }

    }
    /*
     * move all non zeroes by swapping to one side
     * non zeroes will maintain order 
     * right side of partition will not maintain order//in this case the zeroes
     */
    public void moveZeroesSwap(int[] nums){

        int nonZeroIdx = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i]!= 0){
                //swap with ith element , i.e swap with last zero idx
                swap(i, nonZeroIdx,nums);
                nonZeroIdx++;
            }
        }

    }
    public void moveZeroesSnowball(int [] nums){
        int snowballSize = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i]==0){
                snowballSize++;
            }
            else if (nums[i]!= 0 && snowballSize > 0){
                swap(i,i-snowballSize,nums);
            }
        }
    }

    /**
     * Program to swap 2 elements of an array
     * @param index1
     * @param index2
     * @param arr
     */
    public void swap (int index1, int index2, int[] arr){
        if(index1 < 0 || index2 < 0 || index1 > arr.length ||  index2 > arr.length)
            return ;
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        
    }
}