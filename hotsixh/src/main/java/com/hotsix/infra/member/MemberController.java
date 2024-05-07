package com.hotsix.infra.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotsix.common.constants.Constants;
import com.hotsix.common.util.UtilDateTime;
import com.hotsix.infra.company.CompanyService;
import com.hotsix.infra.company.CompanyVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	@Autowired
	CompanyService companyService;
	
	
	public void setSearch(MemberVo vo) throws Exception {
		/* 최초 화면 로딩시에 세팅은 문제가 없지만 */
		/*이후 전체적으로 데이터를 조회를 하려면 null 값이 넘어 오는 관계로 문제가 전체 데이터 조회가 되지 못한다.*/
		/*해서 BaseVo.java 에서 기본값을 주어서 처리*/
//		vo.setShUseNy(vo.getShUseNy() == null ? 1 : vo.getShUseNy());
//		vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
//		vo.setShOptionDate(vo.getShOptionDate() == null ? 2 : vo.getShOptionDate());
		
		/* 초기값 세팅이 있는 경우 사용 */
		vo.setShDateStart(vo.getShDateStart() == null
		    ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
		    : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null
		    ? UtilDateTime.nowString()
		    : UtilDateTime.add59TimeString(vo.getShDateEnd()));		
		
//		/* 초기값 세팅이 없는 경우 사용 */
//		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
//		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
		
		
	}
	
	
	
	@RequestMapping(value = "/memberXdmList")
	public String memberXdmList(@ModelAttribute("vo") MemberVo vo,MemberDto dto, Model model) throws Exception {
		
		setSearch(vo);
		
		model.addAttribute("count", service.selectOneCount(vo));
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		
		return "adm/infra/member/memberXdmList";
	}
	
	@RequestMapping(value = "/memberForm")
	public String memberForm(MemberDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto));
		
		return "adm/infra/member/memberForm";
	}
	
	@RequestMapping(value = "/memberAdd")
	public String memberAdd(CompanyVo vo,Model model) throws Exception {
		
		model.addAttribute("list", companyService.selectList(vo));
		
		return "adm/infra/member/memberAdd";
	}
	
	@RequestMapping(value = "/insert")
	public String insert(MemberDto dto) {
		
		service.insert(dto);
		return "redirect:/memberXdmList";
	}
	
	@RequestMapping(value = "/update")
	public String update(MemberDto dto) {
		
		service.update(dto);
		return "redirect:/memberXdmList";
	}
	
	@RequestMapping(value = "/uelete")
	public String uelete(MemberDto dto) {
		
		service.uelete(dto);
		return "redirect:/memberXdmList";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(MemberDto dto) {
		
		service.delete(dto);
		return "redirect:/memberXdmList";
	}
	
	@ResponseBody
	@RequestMapping(value = "/signinAdm")
	public Map<String, Object> signinAdm(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		System.out.println("aaaaaaaaaaa");
		System.out.println(dto.getMemberId());
		
		
		MemberDto rtDto = service.selectLogin(dto);
		
//		System.out.println(service.selectLogin(dto).getMemberPassword());
		
		
		if(rtDto != null) {
			
			String loginId = dto.getMemberId();
			String loginpwd = dto.getMemberPwd();
			
			
			httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
			httpSession.setAttribute("sessSeqXdm", rtDto.getMemberSeq());
			httpSession.setAttribute("sessIdXdm", rtDto.getMemberId());
			httpSession.setAttribute("sessNameXdm", rtDto.getMemberName());
			
			System.out.println("---------------------");
			System.out.println("httpSession.getAttribute(\"sessNameXdm\"): " + httpSession.getAttribute("sessNameXdm"));
			System.out.println("---------------------");
			
			if(loginId.equals(rtDto.getMemberId())) {
				
				if(loginpwd.equals(rtDto.getMemberPwd())) {
					returnMap.put("rt","success");
				} else {
					returnMap.put("rt", "passfail");
				}
				
			} else {
				returnMap.put("rt", "idfail");
			}
		} else {
			returnMap.put("rt", "notId");
		}
		return returnMap;
	}

	@RequestMapping(value = "/admindex")
	public String admindex() {
		
		return "adm/infra/member/admindex";
	}
	
	@RequestMapping(value = "/admlogin")
	public String admlogin() {
		
		return "adm/infra/member/admlogin";
	}
	
	@ResponseBody
	@RequestMapping(value = "/signoutAdm")
	public Map<String, Object> signoutAdm(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		httpSession.invalidate();
		returnMap.put("rt", "success");
		return returnMap;
	}
	
}
