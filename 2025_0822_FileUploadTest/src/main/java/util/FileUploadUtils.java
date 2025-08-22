package util;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.http.Part;

public class FileUploadUtils {
	
	
	public static String saveFile(Part part,String saveDir,String photo) throws IOException {
		
		String filename = extractFileName(part.getHeader("Content-Disposition"), photo);
	    if(part.getSize()>0) {
	    	
	    	File  f = new File(saveDir,filename);
	    	
	    	//동일화일명이 존재하냐?
	    	if(f.exists()) {
	    		long tm = System.currentTimeMillis();
	    		filename = String.format("%d_%s", tm,filename);
	    		f = new File(saveDir,filename);
	    	}
	    	//임시화일내용 저장
			part.write(saveDir + File.separator + filename);
			//임시화일삭제
			part.delete();
		}
		
		return filename;
	}
	
	
	static String extractFileName(String partHeader,String name) {
		
		//System.out.println(partHeader);
		
		if(partHeader.contains(name)) {
			for(String cd : partHeader.split(";")) {
				
				if(cd.contains("filename")) {
					//System.out.println(cd);
					//                01234567890123456789  
					//                filename="병아리.png"                      => 병아리.png  
					String fileName = cd.substring(cd.lastIndexOf("=")+1).trim().replace("\"","");
					return fileName;
				}
				//int index = fileName.lastIndexOf(File.separator);
				//return fileName.substring(index+1);
			}
		}
		return null;
	}
	

}
