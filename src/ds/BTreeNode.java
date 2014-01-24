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
// FIXME IT'S NOT A PUBLIC CLASS! `public` SHOULD BE REMOVED!! >:(
public final class BTreeNode<T extends Comparable<? super T>> implements
		Serializable {
	protected static int degree;
	protected ArrayList<T> data = null;
	protected ArrayList<BTreeNode<T>> childs = null;
	protected BTreeNode<T> parent = null;

	public BTreeNode() {
		this(12);
	}

	public BTreeNode(int n) {
		this(n, null);
	}

	public BTreeNode(int n, BTreeNode<T> par) {
		degree = n;
		this.data = new ArrayList<T>(degree);
		this.childs = new ArrayList<BTreeNode<T>>(degree - 1);
		this.parent = par;
	}

	public BTreeNode<T> split() {
		// System.err.println("SPLIT:");
		// System.err.println("DEGREE: " + degree);
		BTreeNode<T> newNode = new BTreeNode<T>(degree);
		newNode.data.addAll(this.data.subList((degree / 2) + 1,
				this.data.size()));
		this.data.removeAll(newNode.data);
		this.data.remove(this.data.size() - 1);
		if (!isLeaf()) {
			newNode.childs.addAll(this.childs.subList((degree / 2) + 1,
					this.childs.size()));
			this.childs.removeAll(newNode.childs);
		}
		return newNode;
	}

	public BTreeNode<T> getParent() {
		return this.parent;
	}

	public void setParent(BTreeNode<T> a) {
		this.parent = a;
	}

	protected boolean isLeaf() {
		return this.childs.isEmpty();
	}

	protected int add(T data) {
		int i = findPos(data);
		this.data.add(i, data);
		return i;
	}

	protected int findPos(T data) {
		int i = 0;
		while (i < this.data.size() && this.data.get(i).compareTo(data) < 0)
			i++;
		return i;
	}

	public T getMidean() {
		return this.data.get(this.data.size() / 2);
	}

	// FIXME remove these two methods
	public ArrayList<T> getData() {
		return this.data;
	}

	public ArrayList<BTreeNode<T>> getchilds() {
		return this.childs;
	}
	// public static void main(String[] args) {
	// ArrayList<Integer> alist = new ArrayList<Integer>();
	// for (int i = 1; i <= 10; i++)
	// alist.add(i);
	// alist.add(9, 11);
	// for (Integer i : alist) {
	// System.err.println(i);
	// }
	// }
}
