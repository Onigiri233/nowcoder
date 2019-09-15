package 算法储备;

/**
 * Created by fantuan on 2019/9/15.
 */


class TreeNode {
    int val;
    int sum;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class 二叉树构建与遍历 {
    static int[]preOrder ={1,2,4,7,3,5,6,8};
    static int[]inOrder ={4,7,2,1,5,3,8,6};
    static int[]postOrder ={7,4,2,5,8,6,3,1};

    public static void main(String[] args) {
        int length=preOrder.length;
//        前序+中序
        TreeNode node=creatTreeByPreIn(0,0,length-1);
        preTraverse(node);
        inTraverse(node);
        postTraverse(node);
//        中序+后序
        node=creatTreeByInPost(length-1,0,length-1);
        System.out.println();
        preTraverse(node);
        inTraverse(node);
        postTraverse(node);

    }



    //根据先序和中序遍历构建二叉树。
    private static TreeNode creatTreeByPreIn(int root, int beg, int end) {
        if (beg > end) return null;
        TreeNode node = new TreeNode(preOrder[root]);
        int loc = 0;
        int count = 0;
        for (loc = beg; loc <= end; loc++) {
            count++;
            if (preOrder[root] == inOrder[loc])
                break;
        }
        node.left = creatTreeByPreIn(root + 1, beg, loc - 1);
        node.right = creatTreeByPreIn(root + count, loc + 1, end);
        return node;
    }

    //根据中序和后序遍历构建二叉树。
    private static TreeNode creatTreeByInPost(int root, int beg, int end) {
        if (beg > end) return null;
        TreeNode node = new TreeNode(postOrder[root]);
        int loc = 0;
        int count = 0;
        for (loc = end; loc >= beg; loc--) {
            count++;
            if (postOrder[root] == inOrder[loc])
                break;
        }
        node.left = creatTreeByInPost(root -count, beg, loc - 1);
        node.right = creatTreeByInPost(root -1, loc + 1, end);
        return node;
    }

    // 先序遍历
    public static void preTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        if (node.left != null) {
            preTraverse(node.left);
        }
        if (node.right != null) {
            preTraverse(node.right);
        }
    }
    // 中序遍历
    public static void inTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inTraverse(node.left);
        }
        System.out.print(node.val + " ");
        if (node.right != null) {
            inTraverse(node.right);
        }
    }

    // 后序遍历
    public static void postTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            postTraverse(node.left);
        }
        if (node.right != null) {
            postTraverse(node.right);
        }
        System.out.print(node.val + " ");
    }
}
