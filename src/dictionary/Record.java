/** In The Name of Allah
 * 
 */
package dictionary;

import java.util.Arrays;
import java.util.LinkedList;

import ds.Pair;

public class Record extends Pair<String, LinkedList<String>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3982170224960063974L;

	public Record(final String key) {
		this(key, (String[]) null);
	}

	public Record(final String key, final String... datas) {
		super(key, ((datas == null) ? (new LinkedList<String>())
				: (new LinkedList<String>(Arrays.asList(datas)))));
	}

	public void addMeaning(final String meaning) {
		this.data.add(meaning);
	}

	public String[] getMeanings() {
		return this.data.toArray(new String[0]);
	}

	public String getWord() {
		return this.key;
	}

	public void setMeaning(final String[] meanings) {
		this.data.clear();
		for (final String str : meanings)
			this.data.add(str);
	}

	public void setWord(final String word) {
		this.key = word;
	}

}
