package util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import vo.BookVo;

public class MySearchUtilBook {

	public static List<BookVo> search_book(String b_name,int start,int display)
	{
		List<BookVo> list = new ArrayList<BookVo>();
		//네이버 검색API 발급
		String clientId = "UmWMvrPBzXi29OjOaZfs";
		String clientSecret = "h4F1PGw_qU";

		try {
			b_name = URLEncoder.encode(b_name, "utf-8");
			String urlStr = String.format("https://openapi.naver.com/v1/search/book.xml?query=%s&start=%d&display=%d",
					         b_name,start,display
					);
			
			//header 설정
			URL url = new URL(urlStr);	//20버전부터 변경,기존 21버전 쓰면 취소선 생김>17버전으로 설정하기(properties-facet-java)
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			//발급받은 ID
			connection.setRequestProperty("X-Naver-Client-Id", clientId); 
			//발급받은 PW
			connection.setRequestProperty("X-Naver-Client-Secret", clientSecret); 
			// 받을요청타입
			connection.setRequestProperty("Content-Type", "application/xml"); 
			connection.connect();

			SAXBuilder builder = new SAXBuilder();
			Document   doc = builder.build (connection.getInputStream());

			Element  root     = doc.getRootElement();
			List<Element>   element_list = root.getChild("channel").getChildren("item");

			for(Element item : element_list){
				String title = item.getChildText("title");
				String link  = item.getChildText("link");
				String image = item.getChildText("image");
				String author = item.getChildText("author");
				int discount=0;
				try {
					discount = Integer.parseInt(item.getChildText("discount"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				String publisher = item.getChildText("publisher");
				
				//상품목록을 포장		//생성자 만들어서 한 줄로 끝 또는 이렇게 setter로 넣을 수도 있음
				BookVo vo = new BookVo();
				vo.setTitle(title);
				vo.setLink(link);
				vo.setImage(image);
				vo.setAuthor(author);
				vo.setDiscount(discount);
				vo.setPublisher(publisher);
								
				//ArrayList에 넣기
				list.add(vo);
				

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}
	
	
}
