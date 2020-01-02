package com.xy.image.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author xiayun
 * @version V1.0.0
 * @description Pdf2Utils
 * @date   2019/12/31 10:27
 */
public class Pdf2Utils {

    //经过测试,dpi为96,100,105,120,150,200中,105显示效果较为清晰,体积稳定,dpi越高图片体积越大,一般电脑显示分辨率为96
    public static final float DEFAULT_DPI = 105;
    //默认转换的图片格式为jpg
    public static final String DEFAULT_FORMAT = "jpg";

    /**
     * 传入一个.pdf文件
     *
     * @param file
     * @throws Exception
     */
    public static void readPdf(String file) throws Exception {
        // 是否排序
        boolean sort = false;
        // pdf文件名
        String pdfFile = file;
        File f = new File(pdfFile);
        // 输入文本文件名称
        String textFile = null;
        // 编码方式
        String encoding = "UTF-8";
        // 开始提取页数
        int startPage = 1;
        // 结束提取页数
        int endPage = Integer.MAX_VALUE;
        // 文件输入流，生成文本文件
        Writer output = null;
        // 内存中存储的PDF Document
        PDDocument document = null;
        try {
            try {
                // 首先当作一个URL来装载文件，如果得到异常再从本地文件系统//去装载文件
                URL url = new URL(pdfFile);
                //注意参数已不是以前版本中的URL.而是File。

                document = PDDocument.load(f);
                // 获取PDF的文件名
                String fileName = url.getFile();
                // 以原来PDF的名称来命名新产生的txt文件
                if (fileName.length() > 4) {
                    File outputFile = new File(fileName.substring(0, fileName.length() - 4) + ".txt");
                    textFile = "F:/SJXLX/" + outputFile.getName();
                }
            } catch (MalformedURLException e) {
                // 如果作为URL装载得到异常则从文件系统装载
                //注意参数已不是以前版本中的URL.而是File。
                document = PDDocument.load(f);
                if (pdfFile.length() > 4) {
                    textFile = pdfFile.substring(0, pdfFile.length() - 4) + ".txt";
                }
            }
            // 文件输入流，写入文件倒textFile
            output = new OutputStreamWriter(new FileOutputStream(textFile), encoding);
            // PDFTextStripper来提取文本
            PDFTextStripper stripper = null;
            stripper = new PDFTextStripper();
            // 设置是否排序
            stripper.setSortByPosition(sort);
            // 设置起始页
            stripper.setStartPage(startPage);
            // 设置结束页
            stripper.setEndPage(endPage);
            // 调用PDFTextStripper的writeText提取并输出文本
            stripper.writeText(document, output);

            System.out.println(textFile + " 输出成功！");
        } finally {
            if (output != null) {
                // 关闭输出流
                output.close();
            }
            if (document != null) {
                // 关闭PDF Document
                document.close();
            }
        }
    }

    /**
     * 将pdf转换成图片
     * @param pdfPath :  pdf路径
     * @param imgPath : 图片的保存文件夹
     * @return : 返回pdf的页数，即图片张数，从0开始
     */
    public static int pdfToImage(String pdfPath, String imgPath) {
        int page = 0;
        try {

            //图像合并使用参数
            // 总宽度
            int width = 0;
            // 保存一张图片中的RGB数据
            int[] singleImgRGB;
            int shiftHeight = 0;
            //保存每张图片的像素值
            BufferedImage imageResult = null;
            //利用PdfBox生成图像
            PDDocument pdDocument = PDDocument.load(new File(pdfPath));
            PDFRenderer renderer = new PDFRenderer(pdDocument);
            //循环每个页码
            for (int i = 0, len = pdDocument.getNumberOfPages(); i < 20; i++) {

                BufferedImage image = renderer.renderImageWithDPI(i, 300, ImageType.RGB);
                int imageHeight = image.getHeight();
                int imageWidth = image.getWidth();
                //计算高度和偏移量
                //使用第一张图片宽度;
                width = imageWidth;
                //保存每页图片的像素值
                imageResult = new BufferedImage(width, imageHeight, BufferedImage.TYPE_INT_RGB);
                //这里有高度，可以将imageHeight*len，我这里值提取一页所以不需要
                singleImgRGB = image.getRGB(0, 0, width, imageHeight, null, 0, width);
                // 写入流中
                imageResult.setRGB(0, shiftHeight, width, imageHeight, singleImgRGB, 0, width);
                String filePath = imgPath + "/" + i + ".jpg";
                ImageIO.write(imageResult, DEFAULT_FORMAT, new File(filePath));
                page = i;
            }
            pdDocument.close();
            // 写图片
        } catch (Exception e) {
            e.printStackTrace();
        }
        //OVER
        return page;
    }


    public static void main(String[] args) {
        try {
            File file = new File("E:\\素材模板\\pdf\\pdf2\\lbqdw.txt");
            String imgPath = "E:\\素材模板\\pdf\\pdf2";
            //int page = pdfToImage("E:\\素材模板\\pdf\\了不起的我_[陈海贤] .pdf", imgPath);
            PrintWriter writer = new PrintWriter(new FileWriter(file),true);
            //PrintWriter writer = new PrintWriter(file);
            int page = 19;
            for (int i = 19; i <= page; i++) {
                String txt = ImageUtils.image2Txt(imgPath + "/" + i + ".jpg" ,"E:\\tessdata");
                writer.print(txt);
                writer.flush();
            }

            writer.close();

            // readPdf("E:\\素材模板\\pdf\\样章  Kotlin核心编程 .pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
