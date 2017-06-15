package ru.job4j;

import java.util.Iterator;

/**
 * Task 5.3.2.
 * Create my realisation for LinkedList
 *
 * Created by ANTON on 14.06.2017.
 * @version 1.0
 */
public class PseodoLinkedList<E> implements SimpleContainers<E> {

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
