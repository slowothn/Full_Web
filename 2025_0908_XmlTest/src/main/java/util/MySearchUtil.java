package util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import vo.ProductVo;

public class MySearchUtil {

	public static List<ProductVo> search_shop(String p_name,int start,int display)
	{
		List<ProductVo> list = new ArrayList<ProductVo>();
		//네이버 검색API 발급
		String clientId = "UmWMvrPBzXi29OjOaZfs";
		String clientSecret = "h4F1PGw_qU";

		try {
			p_name = URLEncoder.encode(p_name, "utf-8");
			String urlStr = String.format("https://openapi.naver.com/v1/search/shop.xml?query=%s&start=%d&display=%d",
					         p_name,start,display
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
			//root element 읽어옴 > 하위 리스트 읽어옴
			Element  root     = doc.getRootElement();
			List<Element>   element_list = root.getChild("channel").getChildren("item");

			for(Element item : element_list){
				String title = item.getChildText("title");
				String link  = item.getChildText("link");
				String image = item.getChildText("image");
				int lprice=0,hprice=0;
				try {
					lprice = Integer.parseInt(item.getChildText("lprice"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				try {
					hprice = Integer.parseInt(item.getChildText("hprice"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				String mallName = item.getChildText("mallName");
				
				//상품목록을 포장		//생성자 만들어서 한 줄로 끝 또는 이렇게 setter로 넣을 수도 있음
				ProductVo vo = new ProductVo();
				vo.setTitle(title);
				vo.setLink(link);
				vo.setImage(image);
				vo.setLprice(lprice);
				vo.setHprice(hprice);
				vo.setMallName(mallName);
								
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
