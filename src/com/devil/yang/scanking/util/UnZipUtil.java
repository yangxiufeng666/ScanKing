package com.devil.yang.scanking.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

public class UnZipUtil {
	public static String dstPath(Context context){
		String cachePath;
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
        	cachePath = context.getExternalCacheDir().getPath();
        }else{
        	cachePath = context.getCacheDir().getPath();
        }
        return cachePath;
	}
	public static boolean unzipFile(Context context){
		try {
			InputStream is = context.getAssets().open("tessdata.zip");
			boolean result = unzipFile(is,dstPath(context)+File.separator+"tessdata");
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
     * 解压文件
     * @param destDir   解压目录
     * @param fis  解压的文件流
     * **/
    public static boolean unzipFile(InputStream fis, String destDir) {
        final byte[] buffer = new byte[4096];
        ZipInputStream zis = null;
        Log.e("Unzip", "destDir = "+ destDir);
        try {
            // make sure the directory is existent
        	File dstFile = new File(destDir);
        	if(!dstFile.exists()){
        		dstFile.mkdirs();
        	}else{
        		int fileLenght = dstFile.listFiles().length;
        		if(fileLenght >= 2){
        			return true;
        		}
        	}
            zis = new ZipInputStream(fis);
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                String fileName = entry.getName();

                if (entry.isDirectory()) {
                    new File(destDir, fileName).mkdirs();

                } else {
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(destDir, fileName)));
                    int lenRead;

                    while ((lenRead = zis.read(buffer)) != -1) {
                        bos.write(buffer, 0, lenRead);
                    }

                    bos.close();
                }

                zis.closeEntry();
            }

            return true;

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if(zis!=null){
            	try {
					zis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        }
        return false;
    }

}
