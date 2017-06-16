package ru.job4j;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Task 5.3.4.
 * Create check for cyclicity
 *
 * Created by ANTON VASILYUK on 16.06.2017.
 * @version 1.0
 */

public class CycleList<T> {

    private Node<T> hadNode;
    private Node<T> previos;
    private Node<T> nowNode;
    private int size = 0;

    public void add(T value) {
        if (value == null) {throw new NullPointerException("Element is null");}
        if (hadNode == null) {
            Node<T> node = new Node(value, null, null);
            hadNode = node;
            previos = node;
            nowNode = node;
            this.size++;
        } else {
            Node<T> node = new Node(value, previos, null);
            previos.setNext(node);
            nowNode = node;
            this.size++;
        }
    }

    public boolean hasCycle(){
        boolean result = true;
        Node<T> temp = hadNode;
        if (size == 1) {throw new NoSuchElementException("Add more element!");}
        if (temp != null) {
            for (int i = 0; i < size + 2; i++) {
                if (temp.getNext() != null) {temp = temp.getNext();}
                else {result = false; break;}
            }
        } else {throw new NoSuchElementException("It list is empty");}
        return result;
    }

    public void makeCycle() {
        nowNode.setNext(hadNode);
        hadNode.setPrevios(nowNode);
    }

    class Node<T> {

        /**.
         * @value is element for storage
         */
        private T value;

        /**.
         * Link on previos node
         */
        private Node<T> first;

        /**.
         * Link on next node
         */
        private Node<T> last;

        /**.
         * Constructor for Node
         * @param value is element for storage
         * @param previos link on previos node
         * @param next link on next node
         */
        public Node(T value, Node<T> previos, Node<T> next) {
            this.value = value;
            this.first = previos;
            this.last = next;
        }

        /**.
         * Method set previos node
         * @param previos is previos node
         */
        public void setPrevios(Node<T> previos) {
            this.first = previos;
        }

        /**.
         * Method set next node
         * @param next is next node
         */
        public void setNext(Node<T> next) {
            this.last = next;
        }

        /**.
         * Method for get previos node
         * @return link previos node
         */
        public Node<T> getPrevios() {
            return this.first;
        }

        /**.
         * Method for get next node
         * @return link next node
         */
        public Node<T> getNext() {
            return this.last;
        }

        /**.
         * Method for get storage element
         * @return this element
         */
        public T getElement() {return this.value;}
    }
}

