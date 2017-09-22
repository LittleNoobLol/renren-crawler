package io.renren.modules.crawler.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {

	/**
	 * 
	 * @Description 读取文件
	 * @param 文件路径
	 * @return 文件内容
	 */
	public static String fileRead(String path) {
		File file = new File(path);
		StringBuilder result = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
			String s = null;
			while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
				result.append(System.lineSeparator() + s);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	/**
	 * 
	 * @Description 写入文件
	 * @param 文件路径
	 */
	public static void fileWrite(String path, String content) {
		FileOutputStream fop = null;
		File file;
		try {
			file = new File(path);
			fop = new FileOutputStream(file);
			if (!file.exists()) {
				file.createNewFile();
			}
			byte[] contentInBytes = content.getBytes();
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将图片写到 硬盘指定目录下
	 * 
	 * @param in
	 * @param dirPath
	 * @param filePath
	 */
	public static boolean savePicToDisk(InputStream in, String dirPath, String filePath) {

		try {
			File dir = new File(dirPath);
			if (dir == null || !dir.exists()) {
				dir.mkdirs();
			}

			// 文件真实路径
			String realPath = dirPath.concat(filePath);
			File file = new File(realPath);
			if (file == null || !file.exists()) {
				file.createNewFile();
			}

			FileOutputStream fos = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = in.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}
			fos.flush();
			fos.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
