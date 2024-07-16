class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Insert a new key into the BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in BST
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Search for a key in the BST
    boolean search(int key) {
        return searchRec(root, key);
    }

    // A recursive function to search a key in BST
    boolean searchRec(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        if (root.key > key)
            return searchRec(root.left, key);
        return searchRec(root.right, key);
    }

    // Delete a key from the BST
    void delete(int key) {
        root = deleteRec(root, key);
    }

    // A recursive function to delete a key in BST
    Node deleteRec(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    // Inorder traversal of the BST
    void inorder() {
        inorderRec(root);
    }

    // A recursive function to do inorder traversal
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insert elements
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print inorder traversal
        System.out.println("Inorder traversal:");
        tree.inorder();

        // Search for a key
        System.out.println("\nSearch 40: " + tree.search(40));
        System.out.println("Search 100: " + tree.search(100));

        // Delete a key
        System.out.println("Delete 20:");
        tree.delete(20);
        System.out.println("Inorder traversal after deletion:");
        tree.inorder();
    }
}




