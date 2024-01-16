// Recursive Traversal Solution
// Time Complexity: O(n) n = no. of nodes
// Space Complexity: O(n) auxiliary space of nodes

// class Node {
//     int data;
//     Node left;
//     Node right;
//     public Node(int key) {
//         data = key;
//     }
// }

// Pseudocode
void preOrder(node) {
    if(node == null) return;

    print(node.data);
    preOrder(node.left);
    preOrder(node.right);
}