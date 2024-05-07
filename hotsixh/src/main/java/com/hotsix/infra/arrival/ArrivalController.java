package com.hotsix.infra.arrival;

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
import com.hotsix.infra.member.MemberService;
import com.hotsix.infra.member.MemberVo;
import com.hotsix.infra.placingorder.PlacingOrderDto;
import com.hotsix.infra.placingorder.PlacingOrderService;
import com.hotsix.infra.placingorder.PlacingOrderVo;
import com.hotsix.infra.product.ProductService;
import com.hotsix.infra.product.ProductVo;

@Controller
public class ArrivalController {
	@Autowired
	ArrivalService service;
	@Autowired
	MemberService memberService;
	@Autowired
	ProductService productService;
	@Autowired
	CompanyService companyService;
	
	@Autowired 
	PlacingOrderService poService;
	
	public void setSearch(ArrivalVo vo) throws Exception {
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
	
	
	
	@RequestMapping(value="arrivalXdmList")
	public String arrivalXdmList(@ModelAttribute("vo") ArrivalVo vo,Model model) throws Exception{
		
		setSearch(vo);
		
		model.addAttribute("count", service.selectOneCount(vo));
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		
		
		
		return "/adm/infra/arrival/arrivalXdmList";
	}
	
	@RequestMapping(value="arrivalForm")
	public String arrivalForm(ArrivalDto dto,Model model)throws Exception{
		
		model.addAttribute("item", service.selectOne(dto));
		
		return "/adm/infra/arrival/arrivalForm";
	}
	
	@RequestMapping(value="arrivalAdd")
	public String arrivalAdd(ArrivalVo vo,ArrivalDto dto,CompanyVo cvo,MemberVo mvo,PlacingOrderVo povo ,ProductVo pvo, Model model)throws Exception{
		
		model.addAttribute("list", companyService.selectList(cvo));
		model.addAttribute("mlist", memberService.memberList(mvo));
		model.addAttribute("plist", productService.productList(pvo));
		model.addAttribute("polist",service.placingOrderList(dto));
		
		
		return "/adm/infra/arrival/arrivalAdd";
	}
	
	@ResponseBody
	@RequestMapping(value = "placingSelect")
	public Map<String, Object> placingSelect(ArrivalDto dto,PlacingOrderDto pdto,Model model) throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
			System.out.println(pdto.getPoProductSeq());
			System.out.println("------------------");
			System.out.println("------------------");
			System.out.println("------------------");
			System.out.println("------------------");
		if(pdto.getPoProductSeq() != null) {
			
	        // returnMap에도 성공 여부와 함께 데이터를 담아 전달
	        returnMap.put("rt", "success");
	        returnMap.put("itemPo", service.placingOrderOne(dto));
		} else {
			System.out.println(pdto.getPoProductSeq());
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	
	
	
	
	@RequestMapping(value="/arrivalInsert")
	public String arrivalInsert(ArrivalDto dto) throws Exception {
		
		service.insert(dto);
	
		return "redirect:/arrivalXdmList";
	}
	
	@RequestMapping(value="/arrivalUpdate")
	public String arrivalUpdate(ArrivalDto dto) throws Exception {
		
		service.update(dto);
	
		return "redirect:/arrivalXdmList";
	}
	@RequestMapping(value="/arrivalUelete")
	public String arrivalUelete(ArrivalDto dto) throws Exception {
		
		service.update(dto);
	
		return "redirect:/arrivalXdmList";
	}
	@RequestMapping(value="/arrivalDelete")
	public String arrivalDelete(ArrivalDto dto) throws Exception {
		
		service.delete(dto);
	
		return "redirect:/arrivalXdmList";
	}
}
