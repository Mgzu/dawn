package org.dawn;

import java.io.IOException;
import java.io.InputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ReadHtml {

	public static void main(String[] args) {
		InputStream in = ReadHtml.class.getClassLoader().getResourceAsStream("static\\pulllog.html");
		try {
			Document doc = Jsoup.parse(in, "UTF-8", "");
			Elements eles = doc.getElementsByTag("link");
			System.out.println(eles.size());
			eles.forEach(e -> {
				System.out.println(e.data());
				System.out.println(e.getElementsByAttribute("href"));
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
