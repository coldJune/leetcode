package array;

import java.util.*;

/**
 * K个数之和，但无法保证输出顺序
 */
public class KSum {
    public static void main(String[] args) {
        int[] nums={1, 0, -1, 0, -2, 2};
        System.out.println(ksum(nums, 0,0,4,true));
    }

    private static List<List<Integer>> ksum(int[] nums, int target,int index, int k, boolean first){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(first){
            Arrays.sort(nums);
        }
        if(k==2){
            int left = index;
            int right = nums.length-1;
            while(left<right){
                if(nums[left]+nums[right]==target){
                    List<Integer> tmpList = new ArrayList<Integer>();
                    tmpList.add(nums[left]);
                    tmpList.add(nums[right]);
                    result.add(tmpList);
                    left++;
                    right--;
                }else if(nums[left]+nums[right]<target){
                    left++;
                }else{
                    right--;
                }
            }
            return new ArrayList<List<Integer>>(new HashSet<List<Integer>>(result));
        }else{
            for(int i=index;i<nums.length-1;i++){
                List<List<Integer>> subList = ksum(nums,target-nums[i],i+1,k-1,false);
                    if(subList!=null){
                        for(List<Integer> l:subList){
                            l.add(0,nums[i]);
                            result.add(l);
                        }
                    }

            }
            return new ArrayList<List<Integer>>(new HashSet<List<Integer>>(result));
        }
    }
}
