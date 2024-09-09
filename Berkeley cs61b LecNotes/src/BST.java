/** Assumes the generic content*/
public class BST<Key> {
    public Key key;
    public BST left;
    public BST right;

    // tree constructor
    public BST(Key key, BST left, BST right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    // root constructor
    public BST(Key key) {
        this.key = key;
        this.right = null;
        this.left = null;
    }

}


/**
 * BinarySearchTrees: BSTs
 *  linked list: 1->2->3->4->5->6->7 to a tree:      4
 *                                                3     5
 *                                              1  2  6   7
 * Properties of BSTs:
 *      Every key in the left subtree is less than parent key
 *      Every key in the right subtree is greater than parent key
 *      No duplicate trees
 * Functionality :
 *      BST --- search (the tree )
 *      BST --- insert (the given key into correct position in the tree)
 *      BST --- delete( after deleting the certain key(set to null), have to adjust to maintain BST
 *                      property. There are 3 cases here
 *                      [i]: no children [ii]: )
 *
 * BST runtime analysis:
 *     height:
 *     depth(of a certain node):
 *     average depth:
 *
 * B-Trees:
 *   Add nodes/items to the tree-->will cause spindly tree-->avoid spindly via "overstuffing" node
 *  --> tackle with overstuffed nodes via split and move the middle ite up to the node
 *
 *
 * B-Tree invariants -- (i)All leaves must be the same distance from the source ;
 *                      (ii) A non-leaf node with k items must have exactly k+1
 *                          children to guarantee its balance
 * operations: add, contains, (and deletions)
 *  N:= the numbers of nodes ; H:= the height of B-trees ; L:= maximum number of items 
 *
 *
 */
