package com.alibaba.lcc.utils.pdfUtils;

import javax.imageio.ImageIO;


import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class pdfTest {

    public static String pngPath = "/Users/lccsetsun/Desktop/weichat.png";
    public static String newPdfPath = "/Users/lccsetsun/Desktop/test.pdf";

    public static void main(String[] args) {
        try {
            File PDFFilePath = new File(newPdfPath);
            if (PDFFilePath.exists()) {
                PDFFilePath.delete();
            }
            PDFFilePath.createNewFile();
             String fontPath = "/System/Library/Fonts/SFCompactDisplay.ttf";
//            BaseFont bfChinese = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Integer discountId =1;
            Font fonttitle = new Font(bfChinese, 18, Font.BOLD, BaseColor.BLACK);
            Font fonttitlemin = new Font(bfChinese, 12, Font.BOLD, BaseColor.BLACK);
            Font bottom = new Font(bfChinese, 12, Font.BOLD, BaseColor.BLACK);
            Font fontbold = new Font(bfChinese, 10, Font.BOLD, BaseColor.BLACK);
            Font discount=new Font(bfChinese, 15, Font.BOLD, BaseColor.RED);
            Font flicking = new Font(bfChinese, 10, Font.NORMAL, BaseColor.BLACK);
            ExportTemplateCreateTag(PDFFilePath, fonttitle,fonttitlemin, fontbold, flicking,bottom,discount);
            // 设置红章坐标 以调整好
            imagePdf(pngPath,newPdfPath);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void ExportTemplateCreateTag(File PDFFilePath, Font fontTitle, Font fontTitleMin, Font fontbold, Font flicking, Font bottom,Font discount) {
        try {
            Document document = new Document(PageSize.A4, 0, 0, 0, 0);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(PDFFilePath.getPath()));
            document.open();

            PdfPTable columnKeyTable = new PdfPTable(3);
            columnKeyTable.setWidthPercentage(100);
            columnKeyTable.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell orderMain1Box = new PdfPCell();
            orderMain1Box.setBorder(2);
            orderMain1Box.setFixedHeight(70);
            orderMain1Box.setPaddingTop(30);
            Paragraph orderRemark = new Paragraph("吴兴区学位使用情况查询记录", fontTitle);
            orderRemark.setAlignment(Element.ALIGN_CENTER);
            orderMain1Box.addElement(orderRemark);

            PdfPCell orderMain1Box2 = new PdfPCell();
//            getstyle(orderMain1Box2);
//            orderMain1Box2.setFixedHeight(30);
//            orderMain1Box2.setPaddingTop(10);
            Paragraph orderRemark2 = new Paragraph("查询编号：2020xx-xx-xx", fontTitleMin);
            orderRemark2.setAlignment(Element.ALIGN_RIGHT);
            orderMain1Box2.addElement(orderRemark2);
            columnKeyTable.addCell(orderMain1Box);
            columnKeyTable.addCell(orderMain1Box2);

            PdfPCell orderMain1Box3 = new PdfPCell();
            getstyle(orderMain1Box3);
            orderMain1Box3.setPaddingLeft(100f);
            orderMain1Box3.setImage(Image.getInstance("/Users/lccsetsun/Pictures/35591431.jpg"));
            columnKeyTable.addCell(orderMain1Box3);
            document.add(columnKeyTable);

            //详细信息字段
            for (int i = 0; i < 10 ; i++) {
                PdfPCell orderMain2Box = new PdfPCell();
                orderMain2Box.setBorder(0);
                orderMain2Box.setPaddingBottom(5);
                orderMain2Box.setPadding(0);
                //四列 宽度百分比100
                PdfPTable detailColumnTable = new PdfPTable(5);
                detailColumnTable.setWidthPercentage(100);

                PdfPCell column3box = new PdfPCell();
                getstyle(column3box);
//            column3box.setBackgroundColor(BaseColor.BLUE);
                Paragraph column3key = new Paragraph("versionName", flicking);
                column3key.setAlignment(Element.ALIGN_CENTER);
                column3box.addElement(column3key);
                detailColumnTable.addCell(column3box);

                PdfPCell column4box = new PdfPCell();
                getstyle(column4box);
//            column4box.setBackgroundColor(BaseColor.BLUE);
                Paragraph column4key = new Paragraph("姓名", flicking);
                column4key.setAlignment(Element.ALIGN_CENTER);
                column4box.addElement(column4key);
                detailColumnTable.addCell(column4box);

                PdfPCell column5box = new PdfPCell();
                getstyle(column5box);
//            column5box.setBackgroundColor(BaseColor.BLUE);
                Paragraph column5key = new Paragraph("文生刚", flicking);
                column5key.setAlignment(Element.ALIGN_CENTER);
                column5box.addElement(column5key);
                detailColumnTable.addCell(column5box);

                PdfPCell column6box = new PdfPCell();
                getstyle(column6box);
//            column6box.setBackgroundColor(BaseColor.BLUE);
                Paragraph column6key = new Paragraph("身份证号", flicking);
                column6key.setAlignment(Element.ALIGN_CENTER);
                column6box.addElement(column6key);
                detailColumnTable.addCell(column6box);

                PdfPCell column7box = new PdfPCell();
                column7box.setFixedHeight(30);
                column7box.setBorderWidth(0.5f);
                column7box.setBorderColor(BaseColor.GRAY);
                Paragraph column7key = new Paragraph("4128102381", flicking);
                column7key.setAlignment(Element.ALIGN_CENTER);
                column7box.addElement(column7key);
                detailColumnTable.addCell(column7box);
                document.add(detailColumnTable);
            }

//            PdfReader reader = new PdfReader("/Users/lccsetsun/Desktop/test3.pdf");
//            System.out.println(JSONObject.toJSONString(reader));

            // 下面不变文本信息 不用管

            document.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void getstyle(PdfPCell column) {
        column.setFixedHeight(30);
        column.setBorderWidth(0.5f);
        column.setBorderColor(BaseColor.GRAY);
    }

    /**
     * 功能描述:
     * @Description:
     * @param urljPG 水印图片
     * @param urlPdf PDF路径
     * @Author: lcc
     */
    public static void imagePdf(String urljPG, String urlPdf) throws Exception {
        // 获取去除后缀的文件路径
        String fileName = urlPdf.substring(0, urlPdf.lastIndexOf("."));
        //把截取的路径，后面追加四位随机数
        String pdfUrl = fileName + "sy.pdf";
        //要加水印的原pdf文件路径
        PdfReader reader = new PdfReader(urlPdf);
        //加了水印后要输出的路径
        PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(pdfUrl));
        // 插入水印
        Image img = Image.getInstance(urljPG);
        //原pdf文件的总页数
        int pageSize = reader.getNumberOfPages();
        System.out.println(pageSize);
        //印章位置
        img.setAbsolutePosition(350, 610);
        //印章大小
        img.scalePercent(40);
            //背景被覆盖
//            PdfContentByte under = stamp.getUnderContent(i);
            //文字被覆盖
            PdfContentByte under = stamp.getOverContent(1);
            //添加电子印章
            under.addImage(img);
        // 关闭
        stamp.close();
        //关闭
        reader.close();
    }

        private static List<Map<String, Object>> getdata() {
        List<Map<String,Object>> list = new ArrayList<>(16);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name","版本一");
        map1.put("size","1");
        map1.put("unit","人");
        list.add(map1);
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("name","版本二");
        map2.put("size","2");
        map2.put("unit","人");
        list.add(map2);
        HashMap<String, Object> map3 = new HashMap<>();
        map3.put("name","版本三");
        map3.put("size","3");
        map3.put("unit","人");
        list.add(map3);
        return list;
    }
}
