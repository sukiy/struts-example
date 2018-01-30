package com.struts.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.struts.dao.StuDao;
import com.struts.entity.TbStu;
import com.struts.service.StuService;
import com.struts.service.TbClassService;

/**
 * 处理学生相关请求的Action
 * @author Administrator
 *
 */
public class StuAction extends ActionSupport{

	private TbStu stu;
	private String message;
	
	private File stuImage;
	private String stuImageFileName;
	
	private int[] id;
	
	//查询出所有学生信息
	public String findStuList(){
		//调用服务层方法查询所有学生
		List stuList=new StuService().findStuList();
		ActionContext.getContext().put("stuList", stuList);
		return "main";
	}
	
	//根据用户名模糊查询
	public String findStuListByName(){
		//调用服务层方法查询所有学生
		List stuList=new StuService().findStuList(stu.getSname());
		ActionContext.getContext().put("stuList", stuList);
		return "main";
	}
	
	//去到添加学生页面的方法
	public String toAddStu(){
		//查询出所有的班级
		List clsList=new TbClassService().findClassList();
		ActionContext.getContext().put("clsList", clsList);
		return "addStu";
	}
	
	//处理添加学生
	public String addStu(){
		//判断有没有上传图像同时执行上传操作
		uploadImge();
		//保存学生
		if(new StuService().addStu(stu)){
			message="1";
		}else{
			message="2";
		}
		return "toAddStu";
	}
	//执行图像上传操作
	private void uploadImge(){
		if(stuImage!=null&&stuImageFileName!=null){
			ServletContext ctx=ServletActionContext.getServletContext();
			String path=ctx.getRealPath("/upload");
			String filePath=path+"/"+stuImageFileName;//获取文件要上传的路径
			try {
				FileUtils.copyFile(stuImage, new File(filePath));//执行上传
				//记录文件路径
				stu.setSimage("upload/"+stuImageFileName);//记录图片路径
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	//处理去到修改学生页面的请求
	public String toUpdateStu(){
		//查询出要修改的学生信息
		stu=new StuService().getStuById(stu.getSno());
		
		//查询出所有的班级
		List clsList=new TbClassService().findClassList();
		ActionContext.getContext().put("clsList", clsList);
		return "updateStu";
	}
	
	//处理修改学生
	public String updateStu(){
		//判断有没有上传图像同时执行上传操作
		uploadImge();
		//修改学生
		if(new StuService().updateStu(stu)){
			message="1";
		}else{
			message="2";
		}
		return "tomain";
	}

	//处理批量删除
	public String deleteStus(){
		//调用后台服务方法执行删除多个学生
		if(new StuService().deleteStus(id)){
			message="1";
		}else{
			message="2";
		}
		return "tomain";
	}
	
	public TbStu getStu() {
		return stu;
	}

	public void setStu(TbStu stu) {
		this.stu = stu;
	}

	public File getStuImage() {
		return stuImage;
	}

	public void setStuImage(File stuImage) {
		this.stuImage = stuImage;
	}

	public String getStuImageFileName() {
		return stuImageFileName;
	}

	public void setStuImageFileName(String stuImageFileName) {
		this.stuImageFileName = stuImageFileName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int[] getId() {
		return id;
	}

	public void setId(int[] id) {
		this.id = id;
	}
	
}





