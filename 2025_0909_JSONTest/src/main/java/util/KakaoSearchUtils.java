package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import vo.LocalVo;

public class KakaoSearchUtils {

	public static List<LocalVo> getSearchLocal(String query,int page,int size,int radius,String x,String y){
		
		List<LocalVo> list = new ArrayList<LocalVo>();
		
		try {
		
			query = URLEncoder.encode(query, "utf-8");
			String str_url = String.format("https://dapi.kakao.com/v2/local/search/keyword.json?query=%s&x=%s&y=%s&page=%d&size=%d&radius=%d&sort=distance", 
					       query,x,y,page,size,radius                                                                
					);
			
			URL  url = new URL(str_url);
			
			//사용하는 이유 : header에 ID and password정보 설정
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			urlConn.setRequestProperty("Authorization", "KakaoAK d659f4526fcf7eb3a7bd2e5bd96ca6af");
			urlConn.setRequestProperty("Content-Type", "application/json");
			urlConn.connect();
	
			InputStream 	  is	= urlConn.getInputStream();
			InputStreamReader isr 	= new InputStreamReader(is, "utf-8");
			BufferedReader    br    = new BufferedReader(isr);
			
			StringBuffer sb 		= new StringBuffer();
			while(true) {
				
				String data = br.readLine();
				if(data==null) break;
				sb.append(data.trim());
			}
			String json_data = sb.toString();
			
			//JSON Parsing....
			JSONObject json = new JSONObject(json_data);
			
			JSONArray  localArray = json.getJSONArray("documents");
			
			for(int i=0; i< localArray.length();i++) {
				
				JSONObject local = localArray.getJSONObject(i);
				
				String place_name	=	local.getString("place_name");
				String place_url	=	local.getString("place_url");
				String address_name	=	local.getString("address_name");
				String road_address_name = local.getString("road_address_name");
				String phone		=	local.getString("phone");
				String x1			=	local.getString("x");
				String y1			=	local.getString("y");
				
				int    distance     =   0;
				
				try {
					distance = Integer.parseInt(local.getString("distance"));
				} catch (Exception e) {
					
				}
				
				LocalVo vo = new LocalVo();
				
				vo.setPlace_name(place_name);
				vo.setPlace_url(place_url);
				vo.setAddress_name(address_name);
				vo.setRoad_address_name(road_address_name);
				vo.setPhone(phone);
				vo.setX(x1);
				vo.setY(y1);
				vo.setDistance(distance);
				
				list.add(vo);
				
				
			}//end:for
			
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
}
