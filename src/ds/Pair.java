/** In The Name of Allah
 * 
 */
package ds;

import java.io.Serializable;

public class Pair<T1 extends Comparable<? super T1>, T2> implements
		Comparable<Pair<T1, ?>>, Serializable {
	protected T1 key = null;
	protected T2 data = null;

	public Pair(T1 key, T2 data) {
		this.key = key;
		this.data = data;
	}

	public T1 getKey() {
		return this.key;
	}

	public void setKey(T1 key) {
		this.key = key;
	}

	public T2 getData() {
		return this.data;
	}

	public void setData(T2 data) {
		this.data = data;
	}

	@Override
	public int compareTo(Pair<T1, ?> o) {
		return this.key.compareTo(o.key);
	}

}
