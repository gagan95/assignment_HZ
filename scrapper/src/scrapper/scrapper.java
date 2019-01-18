package scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class scrapper {

	public static void main(String args[]) throws Exception {

		// scraping page from given link 
		
		final Document document= Jsoup.connect("https://www.thehindu.com/archive/").get();
		
		for(Element d1 :document.select("div.archiveBorder ul.archiveMonthList li")) {
			
			final Elements a =d1.select("a");
				
			for (Element link : a){
			
			  
        //	scraping page of referenced link tier-1	(particular month)  
			  
			  
				final Document document1= Jsoup.connect(link.attr("abs:href")).get();
				for(Element d2 :document1.select("table.archiveTable tbody tr")) {
					final Elements a1 =d2.select("a");
					for (Element link1 : a1){
						
						
						  String ul=link1.attr("abs:href");
						// System.out.println("link  :"+ul);
						  
						  if(ul == "") {
							
							  //  if null links appearers
							  
						  }else {
							  
          //			scraping page of referenced link tier-2 (particular day)	  
						  
						final Document document3= Jsoup.connect(ul).get();
		
						for(Element d3 :document3.select("div.tpaper-container section div.section-container div div div ul li")) {           
							final Elements a2 =d3.select("a");  
							for (Element link2 : a2){
								 System.out.println("=======       Article     ========");
							  System.out.println("Article link :"+link2.attr("abs:href"));
							  final Document document4= Jsoup.connect(link2.attr("abs:href")).get();
							 
							  
							for(Element d4 :document4.select("div.article")) {           
								final String title4 =d4.select("div h1.title").text(); 
								final String updated =d4.select("div div.author-container div.ut-container span.ksl-time-stamp none").text(); 
								final String Last_updated =d4.select("div div.author-container div.ut-container div.update-time span none").text(); 
								final String author =d4.select("div div.author-container span.author-img-name a.auth-nm").text(); 
								final String intro =d4.select("div h2.intro").text(); 
								final String desc =d4.select("div div p").text(); 
								  System.out.println("Title :"+title4);
								  System.out.println("Author :"+author);
								  System.out.println("Time :"+updated);
								  System.out.println("Last updated :"+Last_updated);
								  System.out.println("Intro :"+intro);
								  System.out.println("Description :"+desc);
								  System.out.println(" ");
								  System.out.println(" ");
								  System.out.println(" ");
								
								}
						}
						}
				}}
				}
				}
		}
	}
}
