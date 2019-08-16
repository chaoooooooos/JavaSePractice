package gc.leetcode;


import gc.tree.TreeNode;

class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 8, 9};
        TreeNode root = helper(arr, 0, arr.length - 1);
        print(root);
    }

    private static void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.val + "  ");
            print(root.right);
        }
    }

    public static TreeNode helper(int[] arr, int start, int end) {
        if (arr.length == 0) return null;
        if (start > end) return null;
        if (start == end) {
            return new TreeNode(arr[start]);
        }
        int mid = (end - start) / 2 + start;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = helper(arr, start, mid - 1);
        root.right = helper(arr, mid + 1, end);

        return root;
    }
}

