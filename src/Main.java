/** In The Name of Allah
 * 
 */

import gui.Graphics;

import java.awt.EventQueue;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import parser.BadFilePathException;
import parser.Parser;
import dictionary.Dictionary;
import ds.ItemAlredyExistExeption;

/**
 * @author arf1372
 * 
 */
public class Main {

	/**
	 * @param args
	 * @throws Exception
	 *             All unhandled exceptions may thrown.
	 */
	public static void main(final String[] args) throws Exception {
		if (args.length == 0)
			// System.out.println("usage: java Main parse|[word]");
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Graphics frame = new Graphics();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace(System.err);
						System.exit(-1);
					}
				}
			});
		if (args.length == 1)
			if (args[0].equalsIgnoreCase("--parse"))
				try {
					Parser.parseCSV();
				} catch (final BadFilePathException e) {
					System.err.println("INVALID FILE PATH!");
				} catch (final ItemAlredyExistExeption e) {
					System.err
							.println("DUPLICATE ENTRIES ARE AVAILABLE IN YOUR FILE! (mistyped file)");
				} catch (final IOException e) {
					System.err.println("STH. GOES WRONG!");
					e.printStackTrace();
				}
			else {
				Dictionary dic;
				try {
					dic = ((Dictionary) (new ObjectInputStream(
							new BufferedInputStream(new FileInputStream(
									new File(".//data//dictionary.dict")))))
							.readObject());
				} catch (ClassNotFoundException | IOException e) {
					System.err.println("STH. WENT WRONG!!!");
					e.printStackTrace();
					throw e;
				}
				final String[] meanings = dic.lookup(args[0]);
				if (meanings != null) {
					System.out.println("The Word: " + args[0] + " means:\n");
					int line = 1;
					for (final String meaning : meanings) {
						System.out.println("\t" + line++ + ": " + meaning);
						System.out.println();
					}
				} else
					System.out.println("The Word \"" + args[0]
							+ "\" Not Found!");
			}
		else if (args.length == 2)
			if (args[0].equalsIgnoreCase("--parse"))
				try {
					Parser.parseCSV(args[1]);
				} catch (final BadFilePathException e) {
					System.err.println("INVALID FILE PATH!");
				} catch (final ItemAlredyExistExeption e) {
					System.err
							.println("DUPLICATE ENTRIES ARE AVAILABLE IN YOUR FILE! (mistyped file)");
				} catch (final IOException e) {
					System.err.println("STH. GOES WRONG!");
					e.printStackTrace();
				}
	}
}
