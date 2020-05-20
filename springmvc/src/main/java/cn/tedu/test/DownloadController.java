package cn.tedu.test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

@RequestMapping("demo")
@Controller
public class DownloadController {

    @RequestMapping("download.do")
    @ResponseBody
    public byte[] download(HttpServletResponse resp) throws Exception{
        //resp.setHeader("Content-Type","image/png");与下方resp.setContentType("image/png")方法一样

        /*
        URLEncoder.encode（）：此方法专门用来解决http协议的头部编码问题
         */
        String fileName = "演示图片.png";
        fileName = URLEncoder.encode(fileName,"UTF-8");

        //下载图片，需设置ContentType类型为"image/png"
        resp.setContentType("image/png");
        /*
        字符串中的双引号中带双引号用转义字符，\"
        如果要下载的文件名是英文名字，可直接写，如果是中文空格等特殊字符，需要对中文进行编码，
        因为http协议头部必须是ISO8859-1编码的
         */
        resp.setHeader("Content-Disposition","attachment; filename=\""+fileName+"\"");
        byte[] bytes = createPNG();
        return bytes;
    }

    private byte[] createPNG() throws IOException{
        /*
        用BufferedImage创建一个图片
        BufferedImage.TYPE_3BYTE_BGR：100x50的每个像素占用3个字节，3个字节 = 3个8位（1字节 = 8位数）
        第一个八位代表蓝色，依次推绿色，红色，BGR代表三种颜色
         */
        BufferedImage img = new BufferedImage(100,50,BufferedImage.TYPE_3BYTE_BGR);
        img.setRGB(50,25,0xffffff);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //把img数据按照png编码放到out容器（比喻）中
        ImageIO.write(img,"png",out);
        out.close();
        /*
        以后把流转换为byte数组，都可以用以下方法
        1、ByteArrayOutputStream out = new ByteArrayOutputStream();比喻成瓶子
        2、把数据装到瓶子里，流关掉out.close()
        3、byte[] png = out.toByteArray();从瓶子里面把数据倒出来，转换为byte数组
         */
        byte[] png = out.toByteArray();
        return png;
    }

    @RequestMapping(value = "export.do",
            //效果和resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")一样
            produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    public byte[] export(HttpServletResponse resp) throws Exception{
        String fileName  = "excel表格.xlsx";
        fileName = URLEncoder.encode(fileName,"UTF-8");
        resp.setHeader("Content-Disposition","attachment; filename=\""+fileName+"\"");
        byte[] bytes = createExcel();
        return bytes;
    }

    private byte[] createExcel() throws IOException{
        //POI API 生成Excel

        //计算机内存中已经有excel文件了
        XSSFWorkbook workbook = new XSSFWorkbook();
        //在Excel工作簿中创建一个工作表(sheet)
        XSSFSheet sheet = workbook.createSheet("Demo");
        //createRow创建行，参数行号从0开始，1 2 3 ...
        XSSFRow row = sheet.createRow(0);
        //在行中创建列,参数是序号：0 1 2 ...
        XSSFCell cell = row.createCell(0);
        //向格子中填写数据
        cell.setCellValue("Hello World");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();
        out.close();
        byte[] excel = out.toByteArray();
        return excel;
    }
}
