/** In The Name of Allah
 * 
 */
package parser;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.StringTokenizer;

import dictionary.Dictionary;
import dictionary.Record;
import ds.ItemAlredyExistExeption;

/**
 * @author arf1372
 * 
 */
public final class Parser {
	public static void parseCSV() throws BadFilePathException,
			ItemAlredyExistExeption, IOException {
		Parser.parseCSV(".//data//source.csv");
	}

	public static void parseCSV(final String filePath)
			throws BadFilePathException, ItemAlredyExistExeption, IOException {
		final Dictionary dic = new Dictionary();
		BufferedReader sourcefile = null;
		try {
			sourcefile = new BufferedReader(new FileReader(new File(filePath)));
		} catch (final FileNotFoundException e) {
			throw new BadFilePathException();
		}
		for (String line = sourcefile.readLine(); line != null; line = sourcefile
				.readLine())
			dic.add(Parser.parseline(line));
		sourcefile.close();
		final ObjectOutputStream dic_out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(new File(
						".//data//dictionary.dict"))));
		dic_out.writeObject(dic);
		dic_out.close();
	}

	private static Record parseline(final String line) {
		final StringTokenizer strtok = new StringTokenizer(line, "|~");
		final String key = strtok.nextToken();
		final LinkedList<String> list = new LinkedList<String>();
		while (strtok.hasMoreTokens())
			list.add(strtok.nextToken());
		final Record rec = new Record(key);
		for (final String meaning : list)
			if ((meaning != null) && (meaning.length() != 0))
				rec.addMeaning(meaning);
		return rec;
	}

}
