import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.Entry<K, V>> {
    private Node root;
    private int size;

    private class Node
    {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static class Entry<K, V> {
        private K key;
        private V val;

        public Entry(K key, V val) {
            this.key = key;
            this.val = val;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return val;
        }
    }

    public void put(K key, V val) {
        if(root == null) {
            root = new Node(key,val);
            size++;
            return;
        }
        Node current = root;
        Node parent = null;

        while(current != null) {
            parent = current;
            int compare = key.compareTo(current.key);

            if(compare < 0) {
                current = current.left;
            }
            else if(compare > 0) {
                current = current.right;
            }
            else {
                current.val = val;
                return;
            }
        }

        if(key.compareTo(parent.key) < 0) {
            parent.left = new Node(key, val);
        }
        else {
            parent.right = new Node(key,val);
        }
        size++;
    }

    public V get(K key) {
        Node current = root;

        while(current != null) {
            int compare = key.compareTo(current.key);

            if(compare < 0) {
                current = current.left;
            }
            else if(compare > 0) {
                current = current.right;
            }
            else {
                return current.val;
            }
        }
        return null;
    }

    public void delete(K key) {
        Node current = root;
        Node parent = null;

        while(current != null && !current.key.equals(key)) {
            parent = current;
            if(key.compareTo(current.key) < 0) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }

        if(current == null) {
            return;
        }

        if(current.left == null && current.right == null) {
            if(current == root) {
                root = null;
            }
            else if(parent.left == current) {
                parent.left = null;
            }
            else {
                parent.right = null;
            }
        }
        else if(current.left == null) {
            if(current == root) {
                root = current.right;
            }
            else if(parent.left == current) {
                parent.left = current.right;
            }
            else {
                parent.right = current.right;
            }
        }
        else if(current.right == null) {
            if(current == root) {
                root = current.left;
            }
            else if(parent.left == current) {
                parent.left = current.left;
            }
            else {
                parent.right = current.left;
            }
        }
        else {
            Node minParent = current;
            Node min = current.right;

            while(min.left != null) {
                minParent = min;
                min = min.left;
            }

            current.key = min.key;
            current.val = min.val;

            if(minParent.left == min) {
                minParent.left = min.right;
            }
            else {
                minParent.right = min.right;
            }
        }
        size--;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        List<Entry<K, V>> elements = new ArrayList<>();
        List<Node> stack = new ArrayList<>();

        Node current = root;
        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.add(current);
                current = current.left;
            }

            current = stack.remove(stack.size() - 1);
            elements.add(new Entry<>(current.key, current.val));
            current = current.right;
        }
        return elements.iterator();
    }
    public int size() {
        return size;
    }
}
