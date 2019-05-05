package ru.job4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**.
 * Task 5.6.1.
 * Create my Tree
 *
 * Created by Anton Vasilyuk on 24.06.2017.
 * @version 1.0
 * @param <E> it's generic type must be extends comparable and implements class SimpleTree
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**.
     * @cursorIter is cursor in the iterator
     */
    private int cursorIter = 0;

    /**.
     * @elements is container for iterator
     */
    private List<E> elements;

    /**.
     * @firstNode is first node
     */
    private Node<E> firstNode;

    /**.
     * @isBinary is checked is binary tree
     */
    private boolean isBinary = true;

    /**.
     * Constructor for this class
     */
    public Tree() {
        elements = new ArrayList<E>() {
        };
    }

    /**.
     * Class Node is container for elements and link to other elements
     * @param <E> it's generic type
     */
    class Node<E> {

        /**.
         * @childen is list for nodes
         */
        private List<Node<E>> childen;

        /**.
         * @value is current element
         */
        private E value;

        /**.
         * @parentNode is parent for current node
         */
        private Node<E> parentNode;

        /**.
         * Constructor for node
         * @param value is value
         * @param node is node for value
         */
        Node(E value, Node<E> node) {
            this.value = value;
            this.parentNode = node;
            childen = new ArrayList<>();
        }
    }

    /**.
     * Method for adding element
     * @param parent parent.
     * @param child child.
     * @return result
     */
    @Override
    public boolean add(E parent, E child) {
        if (firstNode != null && parent == null) {
            throw new NullPointerException("Parent is null!");
        }
        if (child == null) {
            throw new NullPointerException("Child is null");
        }
        if (firstNode == null) {
            Node<E> node = new Node<>(child, null);
            firstNode = node;
            return true;
        } else {
            Node<E> node = searchParent(firstNode, parent);
            if (node != null) {
                node.childen.add(new Node<E>(child, node));
                return true;
            } else {
                return false;
            }
        }
    }

    /**.
     * Method for check on binary the tree
     * @return boolean result
     */
    public boolean isBinary() {
        if (firstNode != null) {
            return checkIsBinary(firstNode);
        } else {
            throw new NoSuchElementException("This Tree is empty");
        }
    }

    /**.
     * Recursive method for search parent element
     * @param node is node for checking
     * @param parent is parent
     * @return node for add element
     */
    private Node<E> searchParent(Node<E> node, E parent) {
        Node<E> result = null;
        if (node.value.equals(parent)) {
            result = node;
        } else if (node.childen.size() > 0) {
            for (Node<E> tempNode : node.childen) {
                result = searchParent(tempNode, parent);
            }
        } else {
            result = null;
        }
        return result;
    }

    /**.
     * Checking is binary
     * @param node node for starting
     * @return result
     */
    private boolean checkIsBinary(Node<E> node) {
        if (node.childen.size() > 2) {
            isBinary = false;
        }
        if (node.childen.size() > 0) {
            for (Node<E> tempNode : node.childen) {
                isBinary = checkIsBinary(tempNode);
            }
        }
        return isBinary;
    }

    /**.
     * Recursive method for fill List
     * @param node is list nodes
     */
    private void fillList(Node<E> node) {
        if (node != null) {
            if (!elements.contains(node.value)) {
                elements.add(node.value);
            }
            for (Node<E> tempNode : node.childen) {
                if (tempNode.value != null) {
                    fillList(tempNode);
                }
            }
        } else {
            throw new NullPointerException("Node is null!");
        }
    }

    /**.
     * Realisation Iterator
     * @return elements
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (cursorIter < elements.size()) {
                    result = true;
                }
                return result;
            }

            @Override
            public E next() {
                fillList(firstNode);
                if (hasNext()) {
                    return elements.get(cursorIter++);
                } else {
                    throw new NoSuchElementException("No more elements!");
                }
            }
        };
        return iterator;
    }
}
