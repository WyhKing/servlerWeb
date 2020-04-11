package com.huazhou.util;

import com.alibaba.druid.util.Base64;
import com.sun.javafx.geom.transform.GeneralTransform3D;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

public class ImgUtil {

    private static final String imgArray = "0123456789abcdefghijkmnpqrtyABCDEFGHIJLMNQRTY";
    private static final Random RANDOM = new Random();

    private static final int WIDTH = 300;
    private static final int HEIGHT = 40;
    private static final int STRNUM = 4;
    private static final int LINENUM = 10;

    /**
     * 获取指定位置的字符，转化为字符串并返回
     * @param index
     * @return
     */
    private static String getRandomChar(int index){
        return String.valueOf(imgArray.charAt(index));
    }

    /**
     * 获取图片验证码，封装为验证码对象
     * @return
     */
    public static ImageModel createImgModel() {
        ImageModel imageModel = new ImageModel();

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        graphics.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
        graphics.setColor(getRandColor(110, 133));

        for (int i = 0; i <= LINENUM; i++){
            graphics.setColor(new Color(RANDOM.nextFloat(), RANDOM.nextFloat(), RANDOM.nextFloat()));
            graphics.drawLine(RANDOM.nextInt(WIDTH), RANDOM.nextInt(HEIGHT), RANDOM.nextInt(WIDTH), RANDOM.nextInt(HEIGHT));
        }

        StringBuffer stringBuffer = new StringBuffer();
        int rot = 0;
        for (int i = 1; i <= STRNUM; i++){
            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.setFont(new Font("Fixedsys", Font.CENTER_BASELINE, 25));
            graphics2D.setColor(new Color(RANDOM.nextFloat(), RANDOM.nextFloat(), RANDOM.nextFloat()));
            String randChar = getRandomChar(RANDOM.nextInt(imgArray.length()));
            stringBuffer.append(randChar);
            graphics2D.translate(RANDOM.nextInt(3), RANDOM.nextInt(3));
            rot = RANDOM.nextInt(5);
            graphics2D.rotate(rot * Math.PI / 180);
            graphics2D.drawString(randChar, 50 * i, 20);
            graphics2D.rotate(-rot * Math.PI/ 180);
        }
        imageModel.setImgVal(stringBuffer.toString());
        graphics.dispose();
        ByteArrayOutputStream outputStream = null;
        try{
            outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", outputStream);
            String imgsrc = Base64.byteArrayToBase64(outputStream.toByteArray());
            imageModel.setBase64Str(imgsrc);
        }catch (Exception e){

        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imageModel;
    }

    /**
     * 获得随机颜色
     * @param foreColor
     * @param backColor
     * @return
     */
    private static Color getRandColor(int foreColor, int backColor){
       int red = foreColor + RANDOM.nextInt(backColor - foreColor - RANDOM.nextInt(20));
       int green = foreColor + RANDOM.nextInt(backColor - foreColor - RANDOM.nextInt(20));
       int blue = foreColor + RANDOM.nextInt(backColor - foreColor - RANDOM.nextInt(20));
       return new Color(red, green, blue);
    }
}
