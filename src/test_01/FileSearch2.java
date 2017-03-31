package test_01;

import java.io.*;
import java.util.*;

public class FileSearch2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Pls enter the dir for search");
		String dir = s.next();
		System.out.print("Pls enter the filetype for search");
		String ext = s.next();
		System.out.print("Pls enter the keyword for search");
		String keyword = s.next();
		List<File> fileList = new ArrayList<File>();
		File desFile = new File("G:/finder_result.txt");
		File root = new File(dir);
		showResult(root, ext, keyword, fileList);
		try {
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeFile(fileList, desFile);
		System.out.println(desFile.getAbsolutePath());
	}

	public static void showResult(File file, String s, String s1, List<File> fileList) {
		if (file.isDirectory()) {
			File[] f = file.listFiles();
			for (int i = 0; i < f.length; i++) {
				if (f[i].isDirectory()) {
					showResult(f[i], s, s1, fileList);
				} else if (f[i].getName().endsWith(s)) {
					readFile(f[i], s1, fileList);
				}
			}
		}
	}

	public static String readFile(File file, String s1, List<File> fileList) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.contains(s1)) {
					fileList.add(file);
					break;
				}
			}
			// fileList.add(file);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void writeFile(List<File> fileList, File desFile) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(desFile));
			for (File file : fileList) {
				bw.write(file.getAbsolutePath());
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}