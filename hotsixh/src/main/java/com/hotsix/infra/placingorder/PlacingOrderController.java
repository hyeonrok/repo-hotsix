package com.hotsix.infra.placingorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotsix.common.constants.Constants;
import com.hotsix.common.util.UtilDateTime;
import com.hotsix.infra.codegroup.CodeGroupService;
import com.hotsix.infra.exits.ExitsVo;
import com.hotsix.infra.member.MemberDto;
import com.hotsix.infra.member.MemberService;
import com.hotsix.infra.member.MemberVo;
import com.hotsix.infra.order.OrderDto;
import com.hotsix.infra.order.OrderService;
import com.hotsix.infra.product.ProductDto;
import com.hotsix.infra.product.ProductService;
import com.hotsix.infra.product.ProductVo;



@Controller
public class PlacingOrderController {
	@Autowired
	PlacingOrderService service;
	
	@Autowired
	CodeGroupService codeGroupService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	ProductService productService;
	
	public void setSearch(PlacingOrderVo vo) throws Exception {
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
	
	@RequestMapping(value = "/placingOrderXdmList")
	public String placingOrderXdmList(@ModelAttribute("vo") PlacingOrderVo vo,PlacingOrderDto dto, Model model) throws Exception {
		
		setSearch(vo);
		
		vo.setParamsPaging(service.selectOneCount(vo));		
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		
		return "adm/infra/placingorder/placingOrderXdmList";
	}
	
	@RequestMapping(value = "/placingOrderForm")
	public String placingOrderFrom(PlacingOrderDto dto, Model model) throws Exception {
		
		
		
		model.addAttribute("item", service.selectOne(dto));
		
		return "adm/infra/placingorder/placingOrderForm";
	}
	
	@RequestMapping(value = "/placingOrderAdd")
	public String placingOrderAdd(PlacingOrderDto dto,MemberVo mvo,ProductVo pvo,  Model model) throws Exception {
		
		model.addAttribute("list", memberService.memberList(mvo));
		model.addAttribute("plist", productService.productList(pvo));
		
		return "adm/infra/placingorder/placingOrderAdd";
	}
	
	@RequestMapping(value="/placingInsert")
	public String placingInsert(PlacingOrderDto dto) throws Exception {
		
		service.insert(dto);
	
		return "redirect:/placingOrderXdmList";
	}
	
	@RequestMapping(value="/placingUpdate")
	public String placingUpdate(PlacingOrderDto dto) throws Exception {
		
		service.update(dto);
	
		return "redirect:/placingOrderXdmList";
	}
	
	@RequestMapping(value="/placingDelete")
	public String placingDelete(PlacingOrderDto dto) throws Exception {
		
		service.delete(dto);
	
		return "redirect:/placingOrderXdmList";
	}
	
	@RequestMapping(value="/placingUelete")
	public String placingUelete(PlacingOrderDto dto) throws Exception {
		
		service.uelete(dto);
	
		return "redirect:/placingOrderXdmList";
	}
	
}
