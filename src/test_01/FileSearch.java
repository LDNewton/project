package test_01;

import java.util.*;
import java.io.*;

public class FileSearch {	
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Pls input the path");
		String path=sc.next();
		System.out.print("Pls input the matcher");
		String matcher=sc.next();
		File root =new File(path);
		if(true==root.exists()){
			showAllFiles(root,matcher);
		}
		else{
			System.out.println("invalid path");
		}
		sc.close();
		
	}
	public static void showAllFiles(File dir,String macther){
		File [] f=dir.listFiles();
		for(int i=0;i<f.length;i++){
			if(f[i].isDirectory()){
				try{
					showAllFiles(f[i],macther);
				}
				catch(Exception e){
					
				}
			}
			else if(f[i].getName().contains(macther)){
				System.out.println(f[i].getAbsolutePath());
			}
			else{
				
			}
		}
		
	}
}