class node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree
{
    Node root;
    BinaryTree(int data)
    {
        this.root = new Node(data);
    }

    int TreeSum(Node root)
    {
        if(root == null) return 0;
        return root.data + TreeSum(root.left) + TreeSum(root.right);
    }

    int countNodes(Node root)
    {
        if(root == null) return 0;
        return 1 + countNodes(root.left) + leafNodes(root.right);
    }

    int leafNodes(Node root)
    {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return leafNodes(root.left) + leafNodes(root.right);
    }

    int height(Node root)
    {
        if(root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    void printAtLevel(Node root, int level)
    {
        if(root == null) return;
        if(level == 0)
        {
            System.out.println(root.data + " ");
            return;
        }
        printAtLevel(root.left, level - 1);
        printAtLevel(root.right, level - 1);
        System.out.println();
    }

    public static void main(String[] args)
    {
        BinaryTree bt = new BinaryTree(2);
        bt.root.left = new Node(3);
        bt.root.right = new Node(5);
        bt.root.left.right = new Node(9);
        bt.root.right.left = new Node(7);

        System.out.println(bt.treeSum(bt.root));
        System.out.println(bt.countNodes(bt.root));
        System.out.println(bt.leafNodes(bt.root));
        System.out.println(bt.height(bt.root));
        bt.printAtLevel(bt.root, 0);
        bt.printAtLevel(bt.root, 1);
        bt.printAtLevel(bt.root, 2);
    }
}