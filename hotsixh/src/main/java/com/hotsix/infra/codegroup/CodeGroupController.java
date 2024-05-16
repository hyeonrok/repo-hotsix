package com.hotsix.infra.codegroup;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotsix.common.constants.Constants;
import com.hotsix.common.util.UtilDateTime;




@Controller
public class CodeGroupController {

	@Autowired
	CodeGroupService service;
	
	
	public void setSearch(CodeGroupVo vo) throws Exception {
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
	
	
	@RequestMapping(value = "/codeGroupXdmList")
	public String codeGroupAdmList(@ModelAttribute("vo") CodeGroupVo vo,Model model)throws Exception{
		
		
		setSearch(vo);
		
		
		model.addAttribute("count", service.selectOneCount(vo));
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		
		return "adm/infra/codegroup/codeGroupXdmList";
	}
	
	
	
	@RequestMapping(value = "/codeGroupAdd")
	public String codeGroupAdd() throws Exception{
		
		return "adm/infra/codegroup/codeGroupAdd"; //
		
	}
	
	@RequestMapping(value = "/codeGroupInsert")
	public String codeGroupInsert(CodeGroupDto dto) throws Exception{
		
		service.insert(dto);
		return "redirect:/codeGroupXdmList"; //
		
	}
	
	@RequestMapping(value = "/codeGroupForm")
	public String codeGroupForm(CodeGroupDto dto, Model model) throws Exception{
		model.addAttribute("item", service.selectOne(dto));
	
		return "adm/infra/codegroup/codeGroupForm"; //
		
	}
	
	@RequestMapping(value = "/codeGroupUpdate")
	public String codeGroupUpdate(CodeGroupDto dto) throws Exception{

		service.update(dto);
		
		return "redirect:/codeGroupXdmList"; //
		
	}
	
	@RequestMapping(value = "/codeGroupDelete")
	public String codeGroupDelete(CodeGroupDto dto) throws Exception{

		service.delete(dto);
		
		return "redirect:/codeGroupXdmList"; //
		
	}
	
	@RequestMapping(value = "/codeGroupUelete")
	public String codeGroupUelete(CodeGroupDto dto) throws Exception{

		service.uelete(dto);
		
		return "redirect:/codeGroupXdmList"; //
		
	}
}
