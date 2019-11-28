package chao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import chao.service.SearchGoodsService;
import dto.IndexGoodsDto;

public class SearchGoodsServlet extends HttpServlet {
	public SearchGoodsServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isnum = false;
		String content = request.getParameter("content");
		String p = request.getParameter("page");
		int page =1;
		//判断page是否为整形
		try {
			Integer.parseInt(p);
			isnum =true;
		} catch (Exception e) {
			isnum =false;
		}
		if(p != null && isnum)
		{
			page = Integer.parseInt(p);
		}
		List<IndexGoodsDto>  list = new ArrayList<IndexGoodsDto>();
		list = SearchGoodsService.getSearch(content, page);
		PrintWriter out = response.getWriter();
		for (IndexGoodsDto indexGoodsDto : list) {
			System.out.println(indexGoodsDto.getComname());
		}
		
		//转化成json格式传给前端
		JSONArray ja = JSONArray.fromObject(list);
		out.print(ja.toString());
		//写入完毕
		
		
//		SearchGoodsService.getSearch(content, page);
		
	}

	public void init() throws ServletException {
		
	}

}
