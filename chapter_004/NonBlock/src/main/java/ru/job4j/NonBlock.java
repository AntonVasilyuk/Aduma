package ru.job4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**.
 * Task 7.5.1.
 * Create my realisation non blocking cash
 *
 * @author Anton Vasilyuk on 01.09.2017
 * @version 1.0.
 *
 * @param <K> is key for action
 * @param <T> is model for action
 */
public class NonBlock<K, T extends Model> {

    /**.
     * @cache is storage location of the models
     */
    private final Map<K, T> cache = new ConcurrentHashMap<>();

    /**.
     * Method for adding new model to our cache
     * @param key is key for adding
     * @param model is model for adding
     */
    public void add(K key, T model) {
        this.cache.putIfAbsent(key, model);
    }

    /**.
     * Method for delete model from our cache
     * @param key is key for delete the model
     */
    public void delete(K key) {
        cache.computeIfPresent(key, (k, v) -> null);
    }

    /**.
     * Method for update model
     * @param key is key for old model to the cache
     * @param model is new model
     * @return new model
     * @throws OptimisticException may be Exception
     */
    public T update(K key, T model) throws OptimisticException {
        return cache.computeIfPresent(key, (k, v) -> {
                if (model.getVersion() == v.getVersion()) {
                    model.updateVersion();
                    return model;
                } else {
                    throw new OptimisticException("Anvalid version");
                }
        });
    }

    /**.
     * Method for return needing model
     * @param key is key for search the model
     * @return model
     */
    public T getModel(K key) {
        return cache.get(key);
    }
}
