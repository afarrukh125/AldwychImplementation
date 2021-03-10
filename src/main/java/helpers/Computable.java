package helpers;

/**
 * A computable is to be used by something that can return an explicit value
 */
public interface Computable<T> {

    T compute();
}
