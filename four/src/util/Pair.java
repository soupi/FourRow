package util;

/**
 * a utility class that holds two parameters
 * @author Gil Mizrahi
 *
 * @param <K> first
 * @param <V> second
 */
public class Pair<K,V> {
    public K first;
    public V second;
    public Pair() { }
    public Pair(K first, V second)
    {
    	this.first  = first;
    	this.second = second;
    }
    
}
