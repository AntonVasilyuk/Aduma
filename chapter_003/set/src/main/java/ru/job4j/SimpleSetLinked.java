package ru.job4j;

import java.util.Iterator;

/**
 * Task 5.4.2.
 * Create my LinkedSet
 *
 * Created by ANTON on 17.06.2017.
 * @version 1.0
 * @param <E> generic type
 */
public class SimpleSetLinked<E> implements Iterable<E> {

    /**.
     * @size is size list
     */
    private int size = 0;

    /**.
     * @cursorIter is location iterator
     */
    private int cursorIter = 0;

    /**.
     * @link it's link to pseodolinked list
     */
    private PseodoLinkedList link;

    /**.
     * Constructor
     */
    public SimpleSetLinked() {
        link = new PseodoLinkedList();
    }

    /**.
     * Method for add element to link
     * @param value is elemnt for adding
     */
    public void add(E value) {
        if (value == null) {
            throw new NullPointerException("Element is null");
        }
        boolean check = true;
        for (int i = 0; i < size; i++) {
            E temp = (E) link.iterator().next();
            if (temp.equals(value)) {
                check = false;
            }
        }
        if (check) {
            link.add(value);
            size++;
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
                if (size == 0) {
                    throw new NullPointerException("It is empty container");
                }
                return cursorIter < size;
            }

            @Override
            public Object next() {
                E result = null;
                if (hasNext()) {
                    result = (E) link.iterator().next();
                    cursorIter++;
                } else {
                    throw new NullPointerException("No more element");
                }
                return result;
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
        private Node(E value, Node<E> previos, Node<E> next) {
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
        public E getElement() {
            return this.value;
        }
    }
}
