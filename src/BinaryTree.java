import java.util.Iterator;
import java.util.List;

/**
 * This data structures adds stuff to it in a way that keeps it in order,
 * or rather easy to get into order quickly. Good for homies with chaotic
 * energy who may want to spontaneously add and remove items from their
 * dataset but still need to be able to quickly get their s*** together
 * in case someone wants things in order.
 */
public class BinaryTree<E extends Comparable> implements Iterable<E> {
    private TreeNode<E> root;

    public BinaryTree(){

    }

    /**
     * Adds an item to the tree, it puts it in its place right away
     * @param data what is being added
     */
    public void add(E data){

    }

    /**
     * We return the contents of the tree in sort order!
     * @return a list of the items in the tree in order
     */
    public List<E> inOrder(){
        return null;
    }

    /**
     * We return the contents of the tree in reverse sort order!
     * @return a list of the items in the tree in reverse order
     */
    public List<E> reverseOrder(){
        return null;
    }


    private List<E> inOrder(TreeNode<E> root, List<E> list){
        return null;
    }

    /**
     * Shh! We are being sneaky with our recursion and hiding it.
     * This is helping us with reverseOrder()
     * @return a list of the items in the tree in reverse order
     */
    private List<E> reverseOrder(TreeNode<E> root, List<E> list){
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {

                //TODO: This
                return false;
            }

            @Override
            public E next() {
                //TODO: This
                return null;
            }
        };
    }


    class TreeNode<E>{
        private TreeNode<E> left;
        private TreeNode<E> right;
        private E data;

        public TreeNode(E data) {
            this.data = data;
        }

        public TreeNode<E> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<E> left) {
            this.left = left;
        }

        public TreeNode<E> getRight() {
            return right;
        }

        public void setRight(TreeNode<E> right) {
            this.right = right;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }
    }
}
