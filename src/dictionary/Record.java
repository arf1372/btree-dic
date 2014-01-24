/** In The Name of Allah
 * 
 */
package dictionary;

import java.util.Collection;
import java.util.LinkedList;

import ds.Pair;

public class Record extends Pair<String, LinkedList<String>> {

	public Record(String key) {
		this(key, null);
	}

	public Record(String key, String... datas) {
		super(key, new LinkedList<String>());
		if (datas != null)
			for (String str : data)
				this.data.add(str);
	}

	public String getWord() {
		return this.key;
	}

	public String[] getMeanings() {
		return this.data.toArray(new String[0]);
	}

	public void setWord(String word) {
		this.key = word;
	}

	public void setMeaning(String[] meanings) {
		this.data.clear();
		for (String str : meanings)
			this.data.add(str);
	}

	public void addMeaning(String meaning) {
		this.data.add(meaning);
	}

}
