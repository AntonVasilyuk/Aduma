package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Task 5.3.3.
 * Create my realisation for Queue
 *
 * Created by ANTON on 15.06.2017.
 * @version 1.0
 */
public class Queue<E> implements SimpleContainers<E>{


    /**.
     * @previosElement is previos element for this position
     */
    private Node<E> previosElement;

    /**.
     * @headNode is first position
     */
    private Node<E> headNode;

    /**.
     * @size is size list
     */
    private int size = 0;

    /**.
     * Method for add element to link
     * @param value is elemnt for adding
     */
    @Override
    public void add(E value) {
        if (size == 0) {
            Node<E> node = new Node<E>(value, null, null);
            headNode = node;
            previosElement = node;
            size++;
        } else {
            Node<E> node = new Node<E>(value, previosElement, null);
            previosElement.setNext(node);
            size++;
        }
    }

    /**.
     * Method return element on this position
     * @param index is position
     * @return element
     */
    @Override
    public E get(int index) {
        Node<E> result = null;
        for (int i = 0; i <= index; i++) {
            result = (Node<E>) iterator().next();
        }
        return result.getElement();
    }

    /**.
     * Method for return element from the begining of the queue
     * @return element
     */
    public E element() {
        if (size == 0) {throw new NullPointerException("It is empty container");}
        return headNode.getElement();
    }

    /**.
     * Method for add element at the end of the queue
     * @param value
     * @return
     */
    public boolean offer(E value) {
        int first = this.size;
        if (size == 0) {
            Node<E> node = new Node<E>(value, null, null);
            headNode = node;
            previosElement = node;
            size++;
        } else {
            Node<E> node = new Node<E>(value, previosElement, null);
            previosElement.setNext(node);
            size++;
        }
        int second = this.size;
        return second > first;
    }

    /**.
     * Method for return element from begining of the queue
     * @return
     */
    public E peek() {
        return headNode.getElement();
    }

    /**.
     * Method for return element first node and delete this node from the queue
     * @return first element
     */
    public E poll() {
        E result;
        if (headNode != null) {
            result = headNode.getElement();
            headNode = headNode.getNext();
            headNode.setPrevios(null);
            this.size = size - 1;
            return result;
        } else {result = null;}
        return result;
    }

    /**.
     * Method for return element first node and delete this node from the queue
     * @return first element
     */
    public E remove() {
        if (headNode == null) {throw new NoSuchElementException("The queue is empty");}
        E result = headNode.getElement();
        headNode = headNode.getNext();
        headNode.setPrevios(null);
        this.size = size - 1;
        return result;
    }

    /**.
     * Realisation iterator
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = (Iterator<E>) new Iterator<Object>() {

            private int cursorIter = 0;
            Node<E> tempPrevios = null;
            Node<E> tempNext = null;
            Node<E> tempNow = null;

            @Override
            public boolean hasNext() {
                if (headNode == null) {throw new NullPointerException("It is empty container");}
                return tempNow.getNext() != null;
            }

            @Override
            public Object next() {
                Node<E> result = null;
                if (tempNow == null) {
                    tempNow = headNode;
                    result = tempNow;
                    cursorIter++;
                } else {
                    if (hasNext()) {
                        tempNow = tempNow.getNext();
                        result = tempNow;
                        if (tempNow.getNext() != null) {tempNext = tempNow.getNext();}
                        tempPrevios = tempNow.getPrevios();
                        cursorIter++;
                    }
                }
                return result;
            }
        };
        return it;
    }

    /**.
     * Method for check size list
     * @return size this list
     */
    public int getSize() {return this.size;}

    /**.
     * Class for create new container
     * @param <E> is element for storage
     */
    private class Node<E> {

        /**.
         * @value is element for storage
         */
        private E value;

        /**.
         * Link on previos node
         */
        private Node<E> first;

        /**.
         * Link on next node
         */
        private Node<E> last;

        /**.
         * Constructor for Node
         * @param value is element for storage
         * @param previos link on previos node
         * @param next link on next node
         */
        public Node(E value, Node<E> previos, Node<E> next) {
            this.value = value;
            this.first = previos;
            this.last = next;
        }

        /**.
         * Method set previos node
         * @param previos is previos node
         */
        public void setPrevios(Node<E> previos) {
            this.first = previos;
        }

        /**.
         * Method set next node
         * @param next is next node
         */
        public void setNext(Node<E> next) {
            this.last = next;
        }

        /**.
         * Method for get previos node
         * @return link previos node
         */
        public Node<E> getPrevios() {
            return this.first;
        }

        /**.
         * Method for get next node
         * @return link next node
         */
        public Node<E> getNext() {
            return this.last;
        }

        /**.
         * Method for get storage element
         * @return this element
         */
        public E getElement() {return this.value;}
    }
}