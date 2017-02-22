package com.bin.controller;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bin.pojo.BaseDict;
import com.bin.pojo.Customer;
import com.bin.pojo.QueryVo;
import com.bin.service.customerService;

import cn.itcast.utils.Page;




@Controller
@RequestMapping("/cus")
public class customerController {
	@Autowired
	private customerService cs;
	
	@Value("${customer.from.type}")
	private String from;
	@Value("${customer.industry.type}")
	private String industry;
	@Value("${customer.level.type}")
	private String level;
	@RequestMapping("/list")
	public String list (QueryVo vo,Model model) throws Exception{
		  //客户来源
		List<BaseDict> fromlist = cs.findDictBycode(from);
		 //所属行业
		List<BaseDict> industrylist=cs.findDictBycode(industry);
		 //客户级别
		List<BaseDict> levellist=cs.findDictBycode(level);
		
		/*if(vo.getCustName() != null){
			vo.setCustName(new String(vo.getCustName().getBytes("iso8859-1"), "utf-8"));
		}*/
		if(vo.getCustName()!=null){
			vo.setCustName(new String (vo.getCustName().getBytes("iso8859-1"),"utf-8"));
		}
		
		if (vo.getPage()==null){
			vo.setPage(1);
		}
		//设置查询的起始记录条数
		vo.setStart((vo.getPage()-1)*vo.getSize());
		//查询数据列表和数据总数
		List<Customer> resultlist= cs.findcusByVo(vo);
		Integer count =cs.findCustomerByVoCount(vo);
		
		Page<Customer> page =new Page<Customer>();
			    page.setTotal(count);		//数据总数
				page.setSize(vo.getSize());//每页显示条数
				page.setPage(vo.getPage());//当前页数
				page.setRows(resultlist);//数据列表
				model.addAttribute("page", page);
				//高级查询下拉列表数据
				model.addAttribute("fromType", fromlist);
				model.addAttribute("industryType", industrylist);
				model.addAttribute("levelType", levellist);
				//高级查询选中数据回显
				model.addAttribute("custName", vo.getCustName());
				model.addAttribute("custSource", vo.getCustSource());
				model.addAttribute("custIndustry", vo.getCustIndustry());
				model.addAttribute("custLevel", vo.getCustLevel());
		return "customer";
	}
	@RequestMapping("/detail")
	@ResponseBody
	public Customer detail(Long id) throws Exception{
		Customer customer = cs.findCustomerById(id);
		return customer;
	}
	
	@RequestMapping("/update")
	public String update(Customer customer)throws Exception{
		cs.updateCustomerById(customer);
		return "customer";
	}
	
	@RequestMapping("/delete")
	public String delete(Long id) throws Exception{
		cs.delCustomerById(id);
		return "customer";
	}
}
