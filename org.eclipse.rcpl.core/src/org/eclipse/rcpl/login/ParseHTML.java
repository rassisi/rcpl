package org.eclipse.rcpl.login;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ParseHTML {

	public static void main(String args[]) throws IOException {
		Document doc = Jsoup.connect("https://www.wikipedia.org/").get();
//		String text = doc.body().text();

		String text = doc.toString();

		System.out.print(text);
	}
}