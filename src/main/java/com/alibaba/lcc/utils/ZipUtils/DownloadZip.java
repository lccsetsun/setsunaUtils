package com.alibaba.lcc.utils.ZipUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * 下载压缩包至页面
 *
 */
public class DownloadZip {

    public static void main(String[] args) {
        String str = "/Users/setsun/IdeaProjects/school_code/alibaba_lcc_client/target/releases/client_lcc-0.0.5-SNAPSHOT.tar.gz";
        File file = new File(str);
        HttpServletResponse httpServletResponse = null;
        downloadZip(file,httpServletResponse);
    }

    /**
     * 以流的形式下载文件
     *
     * @param file
     * @param response
     * @return
     */
    public static HttpServletResponse downloadZip(File file, HttpServletResponse response) {

        try {
            // 以流的形式下载文件。
            System.out.println(file.getName()+file.getPath());
            InputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            //如果输出的是中文名的文件，在此处就要用URLEncoder.encode方法进行处理
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            //方法执行完成后执行的
            System.out.println("关闭下载流");
        }
        return response;
    }

}
