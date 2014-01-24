/** In The Name of Allah
 * 
 */
package dictionary;

import ds.BTree;
import ds.BTreeNode;

/**
 * @author arf1372
 * 
 */
public final class Dictionary extends BTree<Record> {

	public Dictionary(int i) {
		super(i);
	}

	public Dictionary() {
		super();
	}

	public void add(String word, String... meanings) {
		if (word != null && meanings != null)
			if (word.length() != 0 && meanings.length != 0) {
				Record rec = new Record(word);
				for (String str : meanings)
					if (str.length() != 0)
						rec.addMeaning(str);
				if (rec.getMeanings().length != 0)
					super.add(rec);
			}
	}

	public String[] lookup(String word) {
		Record curr = find(new Record(word));
		return (curr == null ? null : curr.getMeanings());
	}

	private void printAll() {
		printnode(this.getRoot(), 0);
	}

	private void printnode(BTreeNode<Record> curr, int lvl) {
		for (Record rec : curr.getData()) {
			System.out.print(rec.getWord() + " means: ");
			for (String meaning : rec.getMeanings())
				System.out.print(meaning + " // ");
			System.out.println();
		}
		System.out.println("END OF NODE AT LEVEL " + lvl + "!");
		for (BTreeNode<Record> node : curr.getchilds())
			printnode(node, lvl + 1);
	}

	// FIXME remove main
	public static void main(String[] args) {
		Dictionary dic = new Dictionary(3);
		dic.add("Hello", "Salam");
		dic.add("Bye", "khodafez");
		dic.add("Editor", "Virayeshgar");
		dic.add("Babylon", "Babel");
		dic.add("Find", "Yaftan", "Peyda kardan");
		dic.add("GF", "Doost2khtar! :\">");
		dic.add("tara", "a persian girl name", "a CS student in UT! :D");
		dic.add("tat", "a crew in ancient persia",
				"shortened name of a Math student in UT! :-\"");
		dic.printAll();
		System.out.println();
		System.err.println();
		for (String str : dic.lookup("tara"))
			System.out.println(str);
	}

}
