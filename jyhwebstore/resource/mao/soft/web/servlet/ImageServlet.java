package mao.soft.web.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {
	
			// 图片的宽和高
			private static int WIDTH = 130;
			private static int HEIGHT = 43;
			private String[] str = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
					"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
					"X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
			private Random r = new Random();
	public ImageServlet() {
		super();
	}

	 
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		 this.doPost(request, response);
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("进入");
		ServletOutputStream sos = response.getOutputStream();
		//内存中缓存的图片对象
		BufferedImage bmi = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB );
		//用来拼接随机的验证码
		StringBuffer sb = new StringBuffer();
		//
		StringBuffer sbs = new StringBuffer();
		//总共生成4位数的随机码
		for (int i = 0; i < 4; i++) {
			int index = r.nextInt(str.length);
			sb.append(str[index]);
			sbs.append(str[index]+" ");
		}
		String content = sb.toString();
		request.getSession().setAttribute("code", content);
		//获得图片的画笔
		Graphics g = bmi.getGraphics();
		//上色
		g.setColor(Color.BLACK);
		//画个框框
		g.drawRect(0, 0, WIDTH, HEIGHT);
		//给外框填充背景颜色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//写内容
		g.setColor(Color.red);
		g.setFont(new Font("微软雅黑", Font.BOLD, 20));
		g.drawString(sbs.toString(), 10, 22);
		//画干扰点
		for (int i = 0; i < 600; i++) {
			int x = r.nextInt(WIDTH);
			int y = r.nextInt(HEIGHT);
			g.drawLine(x, y, x, y);
		}
		//将内容写入输出流中
		ImageIO.write(bmi, "jpg", sos);
		sos.flush();
		sos.close();
	
	}

	 
	public void init() throws ServletException {
		// Put your code here
	}

}
