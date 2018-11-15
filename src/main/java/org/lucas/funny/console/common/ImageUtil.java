package org.lucas.funny.console.common;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import com.google.common.primitives.Bytes;

/**
 * 生成验证码图片公共方法
 * Created by pt on 2017/4/22.
 */
public class ImageUtil {
    /** 使用指定源生成验证码
     * @param verifySize    验证码长度
     * @param sources   验证码字符源
     * @return
     */
    public static String generateVerifyCode(int verifySize, String sources){
        int codesLen = sources.length();
        Random rand = new Random();
        StringBuilder verifyCode = new StringBuilder(verifySize);
        for(int i = 0; i < verifySize; i++){
            verifyCode.append(sources.charAt(rand.nextInt(codesLen-1)));
        }
        return verifyCode.toString();
    }
    /**
     * 输出指定验证码图片流
     * @param w
     * @param h
     * @param code
     * @throws IOException
     */
    public static BufferedImage outputImage(int w, int h, String code) throws IOException {
        int verifySize = code.length();
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Random rand = new Random();
        Graphics g2 = image.createGraphics();
        Color[] colors = new Color[5];
        Color[] colorSpaces = new Color[] { Color.WHITE, Color.CYAN, Color.GRAY, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.YELLOW };
        float[] fractions = new float[colors.length];
        for(int i = 0; i < colors.length; i++){
            colors[i] = colorSpaces[rand.nextInt(colorSpaces.length)];
            fractions[i] = rand.nextFloat();
        }
        Arrays.sort(fractions);

        g2.setColor(Color.GRAY);// 设置边框色
        g2.fillRect(0, 0, w, h);

        Color c = getRandColor(200, 250);
        g2.setColor(c);// 设置背景色
        g2.fillRect(0, 2, w, h-4);

        //绘制干扰线
        Random random = new Random();
        g2.setColor(getRandColor(100, 160));// 设置线条的颜色
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(w - 1);
            int y = random.nextInt(h - 1);
            int xl = random.nextInt(6) + 1;
            int yl = random.nextInt(12) + 1;
            g2.drawLine(x, y, x + xl + 40, y + yl + 20);
        }

        // 添加噪点
        float yawpRate = 0.05f;// 噪声率
        int area = (int) (yawpRate * w * h);
        for (int i = 0; i < area; i++) {
            int x = random.nextInt(w);
            int y = random.nextInt(h);
            int rgb = getRandomIntColor();
            image.setRGB(x, y, rgb);
        }

        g2.setColor(getRandColor(40, 100));
        int fontSize = h-4;
        Font font = new Font("Algerian", Font.ITALIC, fontSize);
        g2.setFont(font);
        char[] chars = code.toCharArray();
        for(int i = 0; i < verifySize; i++){
            g2.drawChars(chars, i, 1, ((w-10) / verifySize) * i + 5, (h+fontSize)/2-5);
        }
        g2.dispose();
        return image;
    }

    private static Color getRandColor(int fc, int bc) {
        Random random =new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    private static int getRandomIntColor() {
        int[] rgb = getRandomRgb();
        int color = 0;
        for (int c : rgb) {
            color = color << 8;
            color = color | c;
        }
        return color;
    }

    private static int[] getRandomRgb() {
        Random random =new Random();
        int[] rgb = new int[3];
        for (int i = 0; i < 3; i++) {
            rgb[i] = random.nextInt(255);
        }
        return rgb;
    }

}
