package ru.job4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**.
 * Task 5.6.3.
 * Create my Binary Tree
 *
 * Created by Anton Vasilyuk on 30.06.2017.
 * @version 1.0
 * @param <E> generic type implements comparable
 */
public class BinaryTree<E extends Comparable<E>> implements Iterable<E> {

    /**.
     * @cursorIterator is position the iterator
     */
    private int cursorIterator = 0;

    /**.
     * @firstNode is first node in the tree
     */
    private Node<E> firstNode = null;

    /**.
     * @nodeForPaste is node  for paste element
     */
    //private Node<E> nodeForPaste;

    /**.
     * @list is container for elements
     */
    private List<E> list;

    /**.
     * Constructor for class BinaryTree
     */
    public BinaryTree() {
        list = new ArrayList<>();
    }

    /**.
     * Class Node is container for elements and link to other elements
     * @param <E> it's generic type
     */
    private class Node<E> {

        /**.
         * @childenLefr is left child
         */
        private Node<E> childenLeft;

        /**.
         * @childenRight is right child
         */
        private Node<E> childenRight;

        /**.
         * @value is value for keeping
         */
        private E value;

        /**.
         * @parentNode is parent
         */
        private Node<E> parentNode;

        /**.
         * Constructor
         * @param value is value for keeping
         * @param node is node
         */
        private Node(E value, Node<E> node) {
            this.value = value;
            this.parentNode = node;
        }
    }

    /**.
     * Method for adding element to the tree
     * @param value is element
     */
    public void add(E value) {
        if (value == null) {
            throw new NullPointerException("Value is null");
        }
        if (firstNode == null) {
            firstNode = new Node(value, null);
        } else {
            searchAndPaste(firstNode, value);
        }
    }

    /**.
     * Method for search node for paste the element
     * @param node is node
     * @param value is element
     */
    private void searchAndPaste(Node<E> node, E value) {
        if (node.value.compareTo(value) == 1) {
            if (node.childenLeft == null) {
                node.childenLeft = new Node(value, node);
            } else {
                searchAndPaste(node.childenLeft, value);
            }
        } else {
            if (node.childenRight == null) {
                node.childenRight = new Node(value, node);
            } else {
                searchAndPaste(node.childenRight, value);
            }
        }
    }

    /**.
     * Method for fill and sorting the list
     * @param node storage nodes
     */
    public void fillListTwo(Node<E> node) {

        if (firstNode.childenLeft == null && firstNode.childenRight == null) {
            list.add(node.value);
        }
        if (list.size() != 0) {
            if (list.contains(node.value)) {
                if (node.parentNode != null) {
                    fillListTwo(node.parentNode);
                } else {
                    return;
                }
            }
        }

        if (node.childenLeft != null && !list.contains(node.childenLeft.value)) {
            if (node.childenLeft.childenLeft == null && node.childenLeft.childenRight == null) {
                list.add(node.childenLeft.value);
                list.add(node.value);
                if (node.childenRight != null) {
                    if (node.childenRight.childenLeft != null || node.childenRight.childenRight != null) {
                        fillListTwo(node.childenRight);
                    } else {
                        list.add(node.childenRight.value);
                        if (node.parentNode != null) {
                            fillListTwo(node.parentNode);
                        } else {
                            return;
                        }
                    }
                }
            } else {
                fillListTwo(node.childenLeft);
            }
        }

        if (node.childenRight != null && !list.contains(node.childenRight.value)) {
            if (node.childenRight.childenLeft == null && node.childenRight.childenRight == null) {
                list.add(node.childenRight.value);
                fillListTwo(node.parentNode);
            } else {
                fillListTwo(node.childenRight);
            }
        }
    }

    /**.
     * Realisation iterator for binary tree
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return list.size() > cursorIterator;
            }

            @Override
            public E next() {
                fillListTwo(firstNode);
                if (hasNext()) {
                    return list.get(cursorIterator++);
                } else {
                    throw new NoSuchElementException("No more elements");
                }
            }
        };
        return it;
    }
}
