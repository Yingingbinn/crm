package com.bin.controller;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bin.pojo.BaseDict;
import com.bin.pojo.QueryVo;
import com.bin.service.customerService;

@Controller
@RequestMapping("/cus")
public class customerController {
	@Autowired
	private customerService cs;
	@Value("customer.from.type")
	private String from;
	@Value("customer.industry.type")
	private String industry;
	@Value("customer.level.type")
	private String level;
	@RequestMapping("/list")
	public String list (QueryVo vo,Model model) throws Exception{
		  //客户来源
		List<BaseDict> fromlist = cs.findDictBycode(from);
		 //所属行业
		List<BaseDict> industrylist=cs.findDictBycode(industry);
		 //客户级别
		List<BaseDict> levellist=cs.findDictBycode(level);
		model.addAttribute("fromType", fromlist);
		model.addAttribute("industryType", industrylist);
		model.addAttribute("levelType", levellist);
		if(vo.getCustName()!=null){
			vo.setCustName(new String (vo.getCustName().getBytes("iso8859-1"),"utf-8"));
		}
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		return "customer";
	}
}
