/** In The Name of Allah
 * 
 */
package dictionary;

import java.util.Locale;

import ds.BTree;
import ds.ItemAlredyExistExeption;

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
	public void add(final Record a) throws ItemAlredyExistExeption {
		this.add(a.getWord(), a.getMeanings());
	}

	public void add(final String word, final String... meanings)
			throws ItemAlredyExistExeption {
		if ((word != null) && (meanings != null) && (word.length() != 0)
				&& (meanings.length != 0)) {
			final Record tmprec = this.addhelper(word);
			if (tmprec == null) {
				final Record rec = new Record(word.toLowerCase(Locale.ENGLISH));
				for (final String str : meanings)
					if (str.length() != 0)
						rec.addMeaning(str);
				if (rec.getMeanings().length != 0)
					super.add(rec);
			} else
				for (final String meaning : meanings)
					if (meaning.length() != 0)
						tmprec.addMeaning(meaning);
		}
	}

	public String[] lookup(final String word) {
		final Record curr = this.find(new Record(word
				.toLowerCase(Locale.ENGLISH)));
		return (curr == null ? null : curr.getMeanings());
	}

	private Record addhelper(final String word) {
		final Record curr = this.find(new Record(word
				.toLowerCase(Locale.ENGLISH)));
		return curr;
	}

}
