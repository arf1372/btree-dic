/** In The Name of Allah
 * 
 */
package ds;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author arf1372
 * 
 */
final class BTreeNode<T extends Comparable<? super T>> implements Serializable {
	protected static int degree;
	/**
	 * 
	 */
	private static final long serialVersionUID = -9069508549382256556L;
	protected ArrayList<BTreeNode<T>> childs = null;
	protected ArrayList<T> data = null;
	protected BTreeNode<T> parent = null;

	public BTreeNode() {
		this(12);
	}

	public BTreeNode(final int n) {
		this(n, null);
	}

	public BTreeNode(final int n, final BTreeNode<T> par) {
		BTreeNode.degree = n;
		this.data = new ArrayList<T>(BTreeNode.degree);
		this.childs = new ArrayList<BTreeNode<T>>(BTreeNode.degree - 1);
		this.parent = par;
	}

	public T getMidean() {
		return this.data.get(this.data.size() / 2);
	}

	public BTreeNode<T> getParent() {
		return this.parent;
	}

	public void setParent(final BTreeNode<T> a) {
		this.parent = a;
	}

	public BTreeNode<T> split() {
		final BTreeNode<T> newNode = new BTreeNode<T>(BTreeNode.degree);
		newNode.data.addAll(this.data.subList((BTreeNode.degree / 2) + 1,
				this.data.size()));
		this.data.removeAll(newNode.data);
		this.data.remove(this.data.size() - 1);
		if (!this.isLeaf()) {
			newNode.childs.addAll(this.childs.subList(
					(BTreeNode.degree / 2) + 1, this.childs.size()));
			this.childs.removeAll(newNode.childs);
		}
		return newNode;
	}

	protected int add(final T data) {
		final int i = this.findPos_add(data);
		this.data.add(i, data);
		return i;
	}

	protected int contains(final T data) {
		int res = 0;
		while (res < this.data.size())
			if (this.data.get(res).compareTo(data) != 0)
				res++;
			else
				break;
		return ((res == this.data.size()) ? (-1) : (res));
	}

	protected int findPos_add(final T data) {
		int i = 0;
		while ((i < this.data.size())
				&& (this.data.get(i).compareTo(data) <= 0))
			i++;
		return i;
	}

	protected int findPos_search(final T data) {
		int i = 0;
		while ((i < this.data.size())
				&& (this.data.get(i).compareTo(data) <= 0))
			i++;
		return i;
	}

	protected boolean isLeaf() {
		return this.childs.isEmpty();
	}

}
