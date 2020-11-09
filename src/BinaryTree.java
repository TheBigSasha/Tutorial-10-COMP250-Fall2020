import java.util.Iterator;
import java.util.List;

public class BinaryTree<E extends Comparable> implements Iterable<E> {
    private TreeNode<E> root;

    public BinaryTree(){

    }

    public void add(E data){

    }

    public List<E> inOrder(){
        return null;
    }

    public List<E> reverseOrder(){
        return null;
    }

    private List<E> inOrder(TreeNode<E> root, List<E> list){
        return null;
    }

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
