package test_01;

import java.io.*;
import java.util.*;

public class FileSearch1 {
	public static void main(String [] args){
		Scanner sc1=new Scanner(System.in);
		System.out.print("Pls enter the dir for search");
		String dir=sc1.next();
		System.out.print("Pls enter the ext for search");
		String ext=sc1.next();
		System.out.print("Pls enter the keyword for search");
		String keyword=sc1.next();
		List<File> fileList = new ArrayList<File>();
		File desFile = new File("G:/finder_result.txt");
		File root =new File(dir);
		if(true==root.exists()){
			showResult(root,ext,fileList,keyword);
		}
		else{
			System.out.println("invalid path");
		}
		sc1.close();
		writeFile(fileList, desFile);
		System.out.println(desFile.getAbsolutePath());
		
	}
	

	public static void showResult(File root,String ext,List<File>fileList,String keyword){
		File[] f=root.listFiles();
		for(int i=0;i<f.length;i++){
			if(f[i].isDirectory()){
					showResult(f[i],ext,fileList,keyword);
			}
			else if(f[i].getName().endsWith(ext)){
				readFile(f[i],fileList,keyword);
				
			}
		}
	}
	
	public static String readFile(File file,List<File>fileList,String keyword){
		BufferedReader br = null;  
        try {  
            br = new BufferedReader(new FileReader(file));  
            String line = "";  
            while ((line = br.readLine()) != null) {  
                if (line.contains(keyword)) {  
                	fileList.add(file);  
                }  
                 
            }  
  
        }
        catch (Exception e) {  
            e.printStackTrace();  
        }
        finally {  
            try {  
                br.close();  
            }
            catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return null; 
	}
	
	public static void writeFile(List<File>fileList,File desFile){
		BufferedWriter bw = null;
		try{
			bw = new BufferedWriter(new FileWriter(desFile));
			for(File file:fileList){
				bw.write(file.getAbsolutePath());
				bw.newLine();
				bw.flush();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(bw != null){
					bw.close();
				}
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
}