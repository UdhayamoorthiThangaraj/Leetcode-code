class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int indx=Math.abs(nums[i])-1;
            if(nums[indx]>0){
                nums[indx]=-nums[indx];
           }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }
}