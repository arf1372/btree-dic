/** In The Name of Allah
 * 
 */
package ds;

import java.io.Serializable;

/**
 * @author arf1372
 * 
 */
public class BTree<T extends Comparable<? super T>> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5736347009137190753L;
	private int degree;
	private BTreeNode<T> root = null;

	public BTree() {
		this(12);
	}

	public BTree(final int n) {
		this.degree = n;
		this.root = new BTreeNode<T>(n);
	}

	public void add(final T data) {
		final BTreeNode<T> curr = this.findNode(data);
		curr.add(data);
		this.restructure(curr);
	}

	public T find(final T data) {
		final BTreeNode<T> now = this.findHelper(data);
		return ((now == null) ? (null) : (now.data.get(now.contains(data))));
	}

	public BTreeNode<T> getRoot() {
		return this.root;
	}

	private BTreeNode<T> findHelper(final T data) {
		BTreeNode<T> curr = this.root;
		for (int idx = curr.contains(data); (curr != null) && (idx == -1); idx = ((curr == null) ? (-1)
				: curr.contains(data)), curr = (!curr.isLeaf() && (idx == -1)) ? (curr.childs
				.get(curr.findPos_add(data))) : (idx == -1 ? null : curr))
			;
		return curr;
	}

	private BTreeNode<T> findNode(final T data) {
		BTreeNode<T> curr = this.root;
		while (!curr.isLeaf())
			curr = curr.childs.get(curr.findPos_add(data));
		return curr;
	}

	private void restructure(final BTreeNode<T> node) {
		if (!(node.data.size() < this.degree)) {
			this.reStructure(node);
			this.restructure(node.parent);
		}
	}

	private void reStructure(final BTreeNode<T> node) {
		final T midean = node.getMidean();
		final BTreeNode<T> newNode = node.split();
		if (node == this.root) {
			final BTreeNode<T> newRoot = new BTreeNode<T>(this.degree);
			newRoot.add(midean);
			newRoot.childs.add(node);
			newRoot.childs.get(0).parent = newRoot;
			newRoot.childs.add(newNode);
			newRoot.childs.get(1).parent = newRoot;
			this.root = newRoot;
		} else {
			final int i = node.parent.add(midean);
			node.parent.childs.add(i + 1, newNode);
			newNode.parent = node.parent;
		}
	}

}
