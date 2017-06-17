package ru.job4j;

import java.util.Iterator;

/**
 * Task 5.4.2.
 * Create my LinkedSet
 *
 * Created by ANTON on 17.06.2017.
 * @version 1.0
 */
public class SimpleSetLinked<E> implements Iterable<E>{


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
     * @cursorIter is location iterator
     */
    private int cursorIter = 0;

    /**.
     * @tempPrevios is link on back element for iterator
     */
    private Node<E> tempPrevios = null;

    /**.
     * @tempNext is link on next element for iterator
     */
    private Node<E> tempNext = null;

    /**.
     * @tempNow is link on now element for iterator
     */
    private Node<E> tempNow = null;

    /**.
     * Method for add element to link
     * @param value is elemnt for adding
     */
    public void add(E value) {
        if (value == null) {throw new NullPointerException("Element is null");}
        boolean check = true;
        Node<E> temp = headNode;

        if (size != 0) {
            for(int i = 0; i < size; i++) {
                E tempValue = temp.getElement();
                if(tempValue.equals(value)) {check = false;}
                temp = temp.getNext();
            }
        }

        if (check) {
            if (size == 0) {
                Node<E> node = new Node<E>(value, null, null);
                headNode = node;
                previosElement = node;
                size++;
            } else {
                Node<E> node = new Node<E>(value, previosElement, null);
                previosElement.setNext(node);
                previosElement = node;
                size++;
            }
        }
    }

    /**.
     * Realisation iterator
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = (Iterator<E>) new Iterator<Object>() {

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
                return result.getElement();
            }
        };
        return it;
    }

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
