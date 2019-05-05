package ru.job4j;

/**.
 * Task 5.2.2
 * This is basis for outher containers
 * @author  Anton Vasilyuk on 10.06.2017.
 * @version 1.0
 * @param <T> type extends Base
 */

public class BaseStore<T extends Base> implements Store<T> {

    /**.
     * capacityArray is size container
     */
    private static final int SIZE = 10;

    /**.
     * aList is object for class SimpleList
     */
    private SimpleList<T> sList = new SimpleList(SIZE);

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
     * @param t is element
     */
    @Override
    public void update(String id, T t) {
        int position = findPositionByElement(t);
        if (position != 99) {
            t.setId(id);
            sList.update(position, t);
        }
    }

    /**.
     * Method for delete element from container
     * @param id is id element for removing
     */
    @Override
    public void remove(String id) {
        int position = findPositionById(id);
        sList.delete(position);
    }

    /**.
     * Method for show element on this position
     * @param id is id element in container
     * @return element
     */
    public Base showByPosition(String id) {
        T vaue = null;
        int position = findPositionById(id);
        if (position >= 0) {
            vaue = sList.get(position);
        }
        return vaue;
    }

    /**.
     * Find position by element
     * @param t is element for find
     * @return position
     */
    public int findPositionByElement(T t) {
        int position = 99;
        for (int i = 0; i < SIZE; i++) {
            T value = sList.get(i);
            if (value != null) {
                if (value.getId().equals(t.getId())) {
                    position = i;
                    break;
                }
            }
        }
        return position;
    }

    /**.
     * Find position by id
     * @param id is id for find
     * @return position
     */
    public int findPositionById(String id) {
        int position = -1;
        for (int i = 0; i < SIZE; i++) {
            T value = sList.get(i);
            if (value != null) {
                if (value.getId().equals(id)) {
                    position = i;
                    break;
                }
            }
        }
        return position;
    }
}