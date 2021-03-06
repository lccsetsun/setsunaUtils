package com.alibaba.lcc.utils.ZipUtils;

// 解决乱码
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.zip.ZipException;

/**
 * Zip 解压 压缩工具
 *
 * 解决中文路径转换乱码问题  org.apache.tools.zip.ZipOutputStream;
 *
 *
 *
 *
 */
public class ZipUtils {

        /**缓冲字节--1M*/
        private static final int BUFF_SIZE = 1024 * 1024;

        /**
         * 批量压缩文件(文件夹)
         * @param resFileList 要压缩的文件(夹)列表
         * @param zipFile 生成的压缩文件
         * @throws IOException 当压缩过程出错时抛出
         */
        public static void zipFiles(Collection<File> resFileList, File zipFile) throws IOException {
            ZipOutputStream zipOut = new ZipOutputStream(
                    new BufferedOutputStream(new FileOutputStream(zipFile), BUFF_SIZE));

            for (File resFile : resFileList) {
                zipFile(resFile, zipOut, "");
            }
            zipOut.close();
        }

        /**
         * 批量压缩文件(文件夹)
         * @param resFileList 要压缩的文件(夹)列表
         * @param zipFile 生成的压缩文件
         * @param comment 压缩文件的注释
         * @throws IOException 当压缩过程出错时抛出
         */
        public static void zipFiles(Collection<File> resFileList, File zipFile, String comment) throws IOException {
            ZipOutputStream zipOut = new ZipOutputStream(
                    new BufferedOutputStream(new FileOutputStream(zipFile), BUFF_SIZE));
//            zipOut.setEncoding("UTF-8");
            for (File resFile : resFileList) {
                zipFile(resFile, zipOut, "");
            }

            zipOut.setComment(comment);
            zipOut.close();
        }

        /**
         * 解压缩一个文件
         * @param zipFile 压缩文件
         * @param folderPath 解压缩的目标目录
         * @throws IOException
         * @throws ZipException
         */
        public static void upZipFile(File zipFile, String folderPath) throws ZipException, IOException {
            // 根据路径创建一个文件
            File desDir = new File(folderPath);
            // 判断文件是否存在，如果不存在则创建
            if (!desDir.exists()) {
                desDir.mkdirs();
            }
            // 创建一个压缩文件
            ZipFile zFile = new ZipFile(zipFile);
            // 循环遍历
            for (Enumeration<?> entries = zFile.getEntries(); entries.hasMoreElements(); ){
                ZipEntry entry = (ZipEntry) entries.nextElement();
                InputStream in = zFile.getInputStream(entry);
                String str = folderPath  + entry.getName();
                System.out.println(str);
                System.out.println(folderPath);
                System.out.println(File.separator);
                System.out.println(entry.getName());
                File desFile = new File(str);
                isolne(desFile);
                OutputStream out = new FileOutputStream(desFile);

                byte[] buffer = new byte[BUFF_SIZE];
                int realLength;
                while ((realLength = in.read(buffer)) >0) {
                    out.write(buffer, 0, realLength);
                }
                in.close();
                out.close();
            }

        }

    /**
     * 判断文件是否存在 
     * @param desFile
     */
    private static void isolne(File desFile) {
        if (!desFile.exists()) {
            File fileParentDir = desFile.getParentFile();
            // 判断父文件夹是否存在
            if (!fileParentDir.exists()) {
                fileParentDir.mkdirs();
            }
            // 创建新文件
            try {
                desFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
         * 解压文件名包含传入文字的文件
         * @param zipFile 压缩文件
         * @param folderPath 目标文件夹
         * @param nameContains 传入的文件匹配名
         * @throws ZipException 压缩格式有误时抛出
         * @throws IOException IO错误时抛出
         */
        public static ArrayList<File> upZipSelectedFile(File zipFile, String folderPath,
                                                        String nameContains) throws ZipException, IOException {
            ArrayList<File> fileList = new ArrayList<File>();

            File desDir = new File(folderPath);
            if (!desDir.exists()) {
                desDir.mkdir();
            }

            ZipFile zf = new ZipFile(zipFile);
            for (Enumeration<?> entries = zf.getEntries();
              entries.hasMoreElements();) {
                ZipEntry entry = ((ZipEntry)entries.nextElement());
                if (entry.getName().contains(nameContains)) {
                    InputStream in = zf.getInputStream(entry);
                    String str = folderPath + File.separator + entry.getName();
//                    str = new String(str.getBytes("8859_1"), "GB2312");
                    // str.getBytes("GB2312"),"8859_1" 输出
                    // str.getBytes("8859_1"),"GB2312" 输入
                    File desFile = new File(str);
                    isolne(desFile);
                    OutputStream out = new FileOutputStream(desFile);
                    byte buffer[] = new byte[BUFF_SIZE];
                    int realLength;
                    while ((realLength = in.read(buffer)) > 0) {
                        out.write(buffer, 0, realLength);
                    }
                    in.close();
                    out.close();
                    fileList.add(desFile);
                }
            }
            return fileList;
        }


        /**
         * 压缩文件
         * @param resFile 需要压缩的文件(夹)
         * @param zipOut 压缩的目的文件
         * @param rootPath 压缩的文件路径
         * @throws IOException
         */
        private static void zipFile(File resFile, ZipOutputStream zipOut, String rootPath) throws IOException {
            // 判断文件路径长度是否大于0， 大于0时string为"/", 等于0时为""
            String string = rootPath.trim().length() == 0 ? "" : File.separator;
            // 压缩文件生成的路径
            rootPath = rootPath + string + resFile.getName();
            zipOut.setEncoding("UTF-8");
            // 判断压缩的是否是路径
            if (resFile.isDirectory()) {
                // 获取当前路径下的所有文件
                File[] listFiles = resFile.listFiles();
                for (File file : listFiles) {
                    zipFile(file, zipOut, rootPath);
                }
            } else {
                byte[] buffer = new byte[BUFF_SIZE];
                BufferedInputStream in = new BufferedInputStream(
                        new FileInputStream(resFile), BUFF_SIZE);
                zipOut.putNextEntry(new ZipEntry(rootPath));

                int realLength;
                while ((realLength = in.read(buffer)) != -1) {
                    zipOut.write(buffer, 0, realLength);
                }
                in.close();
                zipOut.flush();
                zipOut.closeEntry();
            }
        }

        /**
         * 获得压缩文件内文件列表
         * @param zipFile 压缩文件
         * @return 压缩文件内文件名称
         * @throws IOException
         * @throws ZipException
         */
        public static ArrayList<String> getEntriesNames(File zipFile) throws ZipException, IOException {
            ArrayList<String> entryNames = new ArrayList<>();
            Enumeration<?> entries = getEntriesEnumeration(zipFile);
            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                entryNames.add(new String(
                        getEntryName(entry).getBytes("8859_1"), "GB2312"));
            }
            return entryNames;
        }

        /**
         * 获得压缩文件对象的名称
         * @param entry 压缩文件对象
         * @return 压缩文件对象的名称
         * @throws UnsupportedEncodingException
         */
        private static String getEntryName(ZipEntry entry) throws UnsupportedEncodingException {
            return new String(entry.getName().getBytes("GB2312"), "8859_1");
        }

        /**
         * 取得压缩文件对象的注释
         * @param entry 压缩文件对象
         * @return 压缩文件对象的注释
         * @throws UnsupportedEncodingException
         */
        public static String getEntryComment(ZipEntry entry) throws UnsupportedEncodingException {
            return new String(entry.getComment().getBytes("GB2312"), "8859_1");
        }

        /**
         * 获得压缩文件内压缩文件对象以取得其属性
         * @param zipFile 压缩文件
         * @return 返回一个压缩文件列表
         * @throws IOException
         * @throws ZipException
         */
        private static Enumeration<?> getEntriesEnumeration(File zipFile) throws ZipException, IOException {
            ZipFile zf = new ZipFile(zipFile);
            return zf.getEntries();
        }

}
