/** In The Name of Allah
 * 
 */
package dictionary;

import java.util.Locale;

import ds.BTree;

/**
 * @author arf1372
 * 
 */
public final class Dictionary extends BTree<Record> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1820863222015509538L;

	public Dictionary() {
		super();
	}

	public Dictionary(final int i) {
		super(i);
	}

	@Override
	public void add(final Record a) {
		this.add(a.getWord(), a.getMeanings());
	}

	public void add(final String word, final String... meanings) {
		if ((word != null) && (meanings != null))
			if ((word.length() != 0) && (meanings.length != 0)) {
				final Record rec = new Record(word.toLowerCase(Locale.ENGLISH));
				for (final String str : meanings)
					if (str.length() != 0)
						rec.addMeaning(str);
				if (rec.getMeanings().length != 0)
					super.add(rec);
			}
	}

	public String[] lookup(final String word) {
		final Record curr = this.find(new Record(word
				.toLowerCase(Locale.ENGLISH)));
		return (curr == null ? null : curr.getMeanings());
	}

}
