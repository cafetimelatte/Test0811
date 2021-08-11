package com.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.dto.MemberDto;
import com.test.service.MemberService;
import com.test.util.MyJob;

@Controller
public class HomeController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/")
	public String homeLogin() {
		
		return "homeLogin";
	}
	@RequestMapping(value = "/LoginAction")
	public String loginAction(String id, String pw, HttpServletRequest requset) {
		boolean result = memberService.loginCheck(id, pw);
		List<MemberDto>list = memberService.showall();
		requset.setAttribute("memberList", list);
		String ret = "";
		if(result) {
			if("admin".equals(id))
				ret = "adminPage";	
			else
				ret = "main";
		}else {
			requset.setAttribute("msg", "���̵� �Ǵ� ��й�ȣ Ȯ�����ּ���.");
			ret = "homeLogin";
		}
		return ret;
	}
	
	@RequestMapping(value = "/register")
	public String register() {
		
		return "register";
	}
	@RequestMapping(value = "/registerAction")
	public String registerAction(MemberDto dto,HttpServletRequest request) {
		request.setAttribute("msg", "���ԵǾ����ϴ� �α������ּ���");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int point = Integer.parseInt(request.getParameter("point"));
		memberService.registerMember(new MemberDto(id,pw,name,point));
		return "homeLogin";
	}
	@RequestMapping(value = "/update")
	public String updateMember(HttpServletRequest request) {
		String cid = request.getParameter("id");
		String cpw = request.getParameter("pw");
		String cname = request.getParameter("name");
		int point = Integer.parseInt(request.getParameter("point"));
		memberService.updateMember(new MemberDto(cid, cpw, cname, point));
		return "adminPage";
	}
	@RequestMapping(value = "/delete")
	public String deleteMember(HttpServletRequest request) {
		String id = request.getParameter("id");
		request.setAttribute("msg", "�����Ǿ����ϴ�");
		memberService.deletMember(id);
		return "adminPage";
	}
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		
		return "homeLogin";
	}
	@RequestMapping(value = "/start")  // �����ٷ� �����ҰԿ� (= 10�ʸ��� MyJob �����ҰԿ�).
	public String homeStart() throws SchedulerException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		  JobDetail job = JobBuilder.newJob(MyJob.class)
		      .withIdentity("job1", "group1")
		      .build();
		  Trigger trigger = TriggerBuilder.newTrigger()
		      .withIdentity("trigger1", "group1")
		      .startNow()
		      .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?"))
		      .build();

		  // Tell quartz to schedule the job using our trigger
		  scheduler.scheduleJob(job, trigger);
		  scheduler.start();
		  System.out.println("�����ٷ��� ���۵�.");
		return "home";
	}
	
	@RequestMapping(value = "/end")    // �����ٷ� �����Կ� (= MyJob �׸� �ҰԿ�).
	public String homeEnd() throws SchedulerException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.shutdown();
		System.out.println("�����ٷ��� �����.");
		return "home";
	}

}
