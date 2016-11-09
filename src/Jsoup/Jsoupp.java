package Jsoup;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Jsoupp {
	
	private static String[] readFromFile(String fileName) {
	       try {
	    	   
	    	 File file = new File(fileName);
	         Scanner scanner = new Scanner(file);

	         LineNumberReader lnr = new LineNumberReader(new FileReader(file));
	         lnr.skip(Long.MAX_VALUE);
	         int lengthOfList = lnr.getLineNumber()+1;//+1 for starting from 0
	         lnr.close();//resource leak

	         String[] list = new String[lengthOfList];
	         int i = 0;
	         while (scanner.hasNextLine()) {
	        	list[i] = scanner.nextLine();
	        	i++;
	         }
	         scanner.close();
	      return list;
	       } catch (Exception e) {
	         e.printStackTrace();
	       }
		return null;
	}

	public static void main(String[] args) throws IOException {
		
		
			String fileName = "src/data.txt";
			String[] list = readFromFile(fileName);
			
			for (int i = 0; i < list.length; i++) {
				System.out.print(list[i]);
				String html = "http://qpublic5.qpublic.net/sc_display2.php?county=sc_edgefield&KEY="+list[i];
				Connection conn = Jsoup.connect(html);
				conn.userAgent("Mozilla/5.0");
				Document doc = conn.get();
				
			//	System.out.println(doc);
				System.out.println(doc.getElementsByClass("tax_value").text().trim()); 
			}
			
			for (String s : list) {
				//System.out.println(s);
//				//System.out.println(html);
//				
//					
//			
			}
//			   
//	
//			String html = "http://qpublic5.qpublic.net/sc_display2.php?county=sc_edgefield&KEY=116-11-01-027-000";
//			System.out.println(html);
//			Connection conn = Jsoup.connect(html);
//				conn.userAgent("Mozilla/5.0");
//				Document doc = conn.get();
//			//System.out.println(doc);
//			System.out.println(doc.getElementsByClass("tax_value").text()); 
				
//			Elements element = document.getElementsByClass("tax_value");
//			for (Element e : element) {
//		System.out.println(e.text());
//				
//			}
//			//System.out.println(element.text());
	}

}
