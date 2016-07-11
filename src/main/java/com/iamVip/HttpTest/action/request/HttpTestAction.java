/**
 * 
 */
package com.iamVip.HttpTest.action.request;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iamVip.HttpTest.action.ActionBase;
import com.iamVip.HttpTest.rs.u.DTUtil;

/**
 * @author Colin
 */
@Controller
@RequestMapping(value = { "http/test" })
public class HttpTestAction extends ActionBase {

	/**
	 * 
	 */
	public HttpTestAction() {
	}

	@ResponseBody
	@RequestMapping(value = { "location/{latitude}/{longitude}/{macAddr}" })
	public Map<String, Object> location(@PathVariable double latitude, @PathVariable double longitude, @PathVariable String macAddr, HttpServletRequest req, HttpSession session, HttpServletResponse response, ModelMap model) {
		Map<String, Object> map = new HashMap<String, Object>(5);

		String nowDT = DTUtil.nowDT();
		System.out.println("================ " + nowDT + " --- " + macAddr);
		
		map.put("datetime", nowDT);
		map.put("longitude", longitude);
		map.put("latitude", latitude);
		map.put("macAddr", macAddr);

		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = { "request" })
	public Map<String, Object> locationNone(HttpServletRequest req, HttpSession session, HttpServletResponse response, ModelMap model) {
		Map<String, Object> map = new HashMap<String, Object>(8);
		
		String nowDT = DTUtil.nowDT();
		System.out.println("================ " + nowDT);
		
		map.put("nowDT", nowDT);
		
		req.getParameterMap().forEach((String key, String[] value) -> {
			map.put(key, value[0]);
			System.out.println(key + " -- " + value[0]);
		});
		
		return map;
	}

}
