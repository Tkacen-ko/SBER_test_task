class Solution {
    public static int trap(int[] height) {
        if(height==null||height.length==0)
            return 0;
        int[] left=new int[height.length];
        int[] right=new int[height.length];
        int ans=0;
        left[0]=height[0];
        for(int i=1;i<height.length;i++){
            left[i]=Math.max(height[i],left[i-1]);
        }
        right[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            right[i]=Math.max(height[i],right[i+1]);
        }
        for(int i=0;i<height.length;i++){
            int min = Math.min(left[i], right[i]);
            ans+=(min -height[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {4, 2, 0, 3, 2, 5};
        int[] arr2 = {1, 1, 4, 3, 0, 5, 2, 0, 4, 2, 5, 0, 3, 1, 1, 4, 4, 1, 0, 2};
        int[] arr3 = {2, 0, 1, 4, 1, 0, 1, 0, 3, 2, 1, 2, 1, 4, 0, 4};
        int[] arr4 = {2, 2, 2, 1, 2, 1, 0, 0};
        int[] arr5 = {4, 2, 3};
        int[] arr6 = {1, 0, 1, 1, 2, 1, 0, 2};
        int[] arr7 = {0, 1, 3, 3, 3, 0, 0, 1, 0, 2, 3, 2, 2, 2, 0, 2};
        System.out.println(trap(arr)); //9
        System.out.println(trap(arr2)); //31
        System.out.println(trap(arr3)); //32
        System.out.println(trap(arr4)); //1
        System.out.println(trap(arr5));
        System.out.println(trap(arr6));
        System.out.println(trap(arr7));
    }
}