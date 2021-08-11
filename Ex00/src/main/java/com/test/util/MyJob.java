package com.test.util;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.test.dto.MemberDto;
import com.test.service.MemberService;

public class MyJob implements Job {
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
		MemberService service = ctx.getBean(MemberService.class);
		List<MemberDto> memberList = service.showall();
		int result =0;
		for(MemberDto dto : memberList) {
			result++;
		}
		System.out.println("Quartz�� Job�� �����/"+result+"���� ����Ʈ 1���ο�");
		
	}

}