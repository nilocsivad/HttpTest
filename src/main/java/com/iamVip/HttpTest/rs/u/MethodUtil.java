/**
 * 
 */
package com.iamVip.HttpTest.rs.u;

import java.util.List;

/**
 * @author Colin
 */
public class MethodUtil {
	
	private static boolean			enable;
	private static List< String >	methods;
									
									
	/**
	 * 
	 */
	public MethodUtil( boolean enable, List< String > methods ) {
		MethodUtil.enable = enable;
		MethodUtil.methods = methods;
	}
	
	/**
	 * @return the methods
	 */
	public static List< String > getMethods() {
		
		return methods;
	}
	
	
	/**
	 * @return the enable
	 */
	public static boolean isEnable() {
		
		return enable;
	}
	
}
