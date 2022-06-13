package Tree;


    public class MaximumBinaryTree {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return fusion(nums,0, nums.length-1);
        }
        public TreeNode fusion(int[] nums,int lo,int hi){
            if (lo > hi){
                return null;
            }
            int maxCursor = -1, max = Integer.MIN_VALUE;
            for (int i = lo; i <= hi; i++){
                if (nums[i] > max){
                    maxCursor = i;
                    max = nums[i];
                }
            }
            TreeNode root = new TreeNode(max);
            root.left=fusion(nums, lo,maxCursor - 1);
            root.right=fusion(nums,maxCursor+1, hi);
            return root;
        }
    }
