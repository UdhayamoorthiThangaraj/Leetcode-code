class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        list.add(new ArrayList<>());
        for(int n : nums){
            int d=list.size();
            for(int i=0;i<d;i++){
                List<Integer>res=new ArrayList<>(list.get(i));
                res.add(n);
                list.add(res);
            }
        }
        return list;  
    }
}