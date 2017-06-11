package ru.job4j;

/**
 * Task 5.2.2
 * This is basis for outher containers
 * @author  Anton Vasilyuk on 10.06.2017.
 * @version 1.0
 */
public class BaseStore<T extends Base> implements Store<T> {

    /**.
     * capacityArray is size container
     */
    private static final int capacityArray = 10;

    /**.
     * aList is object for class SimpleList
     */
    SimpleList sList = new SimpleList(capacityArray);

    /**.
     * Method for add element to containers
     * @param t is element
     */
    @Override
    public void add(T t) {
        sList.add(t);
    }

    /**.
     * Method for update element on this position
     * @param position is position in array
     * @param t is element
     */
    @Override
    public void update(int position, T t) {
        sList.update(position, t);
    }

    /**.
     * Method for delete element from container
     * @param position is position for removing
     */
    @Override
    public void remove(int position) {
        sList.delete(position);
    }

    /**.
     * Method for show element on this position
     * @param position is position in container
     * @return element
     */
    public Base showByPosition(int position) {
        return (Base) sList.get(position);
    }
}
