/** In The Name of Allah
 * 
 */

import dictionary.Dictionary;
import dictionary.Record;

/**
 * @author arf1372
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dictionary dic = new Dictionary();
		dic.add(new Record("Hello", "Salam"));
		System.err.println(dic.lookup("Hello"));
		System.err.println(dic.lookup("Bye"));
		dic.add(new Record("Bye", "khodafez"));
		System.err.println(dic.lookup("Bye"));
	}

}
