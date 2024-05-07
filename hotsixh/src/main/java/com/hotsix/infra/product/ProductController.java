package com.hotsix.infra.product;

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
import com.hotsix.infra.order.OrderVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {

	@Autowired
	ProductService service;
	
	public void setSearch(ProductVo vo) throws Exception {
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
	
	@RequestMapping(value = "/productXdmList")
	public String productXdmList(@ModelAttribute("vo") ProductVo vo, Model model) throws Exception {
		
		setSearch(vo);
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		
		return "adm/infra/product/productXdmList";
	}
	
//	@RequestMapping(value = "/orderAdd")
//	public String orderAdd(@ModelAttribute("vo") MemberVo mvo, Model model) throws Exception {
//		
//		model.addAttribute("list", mservice.selectList(mvo));
//		
//		return "adm/infra/order/orderAdd";
//	}
	
	@RequestMapping(value = "/productAdd")
	public String productAdd(ProductVo vo, ProductDto dto,Model model) throws Exception {
		
		model.addAttribute("list", service.companyList(vo));
		
		return "adm/infra/product/productAdd";
	}
	
		@ResponseBody
		@RequestMapping(value = "memberSelect")
		public Map<String, Object> memberSelect(ProductDto dto, Model model) throws Exception {
			
			Map<String, Object> returnMap = new HashMap<String, Object>();
					
			if(dto.getCompanySeqF() != null) {
					        
		        // returnMap에도 성공 여부와 함께 데이터를 담아 전달
		        returnMap.put("rt", "success");
		        returnMap.put("itemMember", service.memberOne(dto));
			} else {
				returnMap.put("rt", "fail");
			}
			return returnMap;
		}
	@RequestMapping(value ="/productForm")
	public String productForm(ProductDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto));
		
		return "adm/infra/product/productForm";
	}
	
	@RequestMapping(value = "/productInsert")
	public String productInsert(ProductDto dto) throws Exception {
		
		service.insert(dto);
		
		return "redirect:/productXdmList";
	}
	@RequestMapping(value = "/productDelete")
	public String productDelete(ProductDto dto) throws Exception {
		
		service.delete(dto);
		
		return "redirect:/productXdmList";
	}
	@RequestMapping(value = "/productUelete")
	public String productUelete(ProductDto dto) throws Exception {
		
		service.uelete(dto);
		
		return "redirect:/productXdmList";
	}
	@RequestMapping(value = "/productUpDate")
	public String productUpDate(ProductDto dto) throws Exception {
		
		service.update(dto);
		
		return "redirect:/productXdmList";
	}
}
