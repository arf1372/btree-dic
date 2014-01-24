/** In The Name of Allah
 * 
 */
package ds;

import java.io.Serializable;

public class Pair<T1 extends Comparable<? super T1>, T2> implements
		Comparable<Pair<T1, ?>>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3698688287154201313L;
	protected T2 data = null;
	protected T1 key = null;

	public Pair(final T1 key, final T2 data) {
		this.key = key;
		this.data = data;
	}

	@Override
	public int compareTo(final Pair<T1, ?> o) {
		return this.key.compareTo(o.key);
	}

	public T2 getData() {
		return this.data;
	}

	public T1 getKey() {
		return this.key;
	}

	public void setData(final T2 data) {
		this.data = data;
	}

	public void setKey(final T1 key) {
		this.key = key;
	}

}
