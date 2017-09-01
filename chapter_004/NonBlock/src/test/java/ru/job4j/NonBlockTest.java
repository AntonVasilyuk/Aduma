package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class NonBlockTest {

    /**.
     * @link is link for NonBlock
     */
    private NonBlock<Integer, Model> link;

    /**.
     * Method for preparing for test
     */
    @Before
    public void preparingForTesting() {
        this.link = new NonBlock<>();
    }

    /**.
     * This is test method add
     */
    @Test
    public void whenNeedAddingModelToCache() {
        Model modelX = new Model("Mark");
        link.add(1, modelX);
        String test = link.getModel(1).getName();
        assertThat(test, is("Mark"));
    }

    /**.
     * This is test method delete
     */
    @Test
    public void whenNeedDeleteModelFromCache() {
        Model mod = new Model("Test");
        link.add(1, mod);
        link.delete(1);
        assertNull(link.getModel(1));
    }

    /**.
     * This is test method update
     * @throws OptimisticException is Exception different versions
     */
    @Test
    public void whenNeedUpdateModelToCache() throws OptimisticException {
        Model modFirst = new Model("Kirill");
        Model modSecond = new Model("Zeus");
        link.add(1, modFirst);
        link.update(1, modSecond);
        assertThat(link.getModel(1).getName(), is("Zeus"));
    }

    /**.
     * This is test method update when the models is different versions
     * @throws OptimisticException is Exception when to model have different version
     */
    @Test(expected = OptimisticException.class)
    public void whenOtherVersionModels() throws OptimisticException{
        Model modFirst = new Model("Fedor");
        Model modSecond = new Model("Adigun");
        modSecond.updateVersion();
        link.add(1, modFirst);
        link.update(1, modSecond);
    }
}