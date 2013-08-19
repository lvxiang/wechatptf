package com.dt.wechatptf.util.test;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.dt.wechatptf.util.WechatXMLUtil;
import com.dt.wechatptf.util.WechatXMLUtil.WechatMsg;

public class WechatXMLUtilTest {
//
//	@Test
//	public void testGetType(){
//		for(Method method : WechatMsg.class.getMethods()){
//			if(method.getName().equals("getType")){
//				method.setAccessible(true);
//				try {
//					int type1 = (Integer) method.invoke(null, "image");
//					int type2 = (Integer) method.invoke(null, "link");
//					int type3 = (Integer) method.invoke(null, "unknown");
//					assertEquals(type1, WechatXMLUtil.MSG_TYPE_IMG);
//					assertEquals(type2, WechatXMLUtil.MSG_TYPE_LINK);
//					assertEquals(type3, WechatXMLUtil.MSG_TYPE_UNKNOWN);
//				} catch (IllegalAccessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IllegalArgumentException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (InvocationTargetException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//	
	@Test
	public void testParseXml(){
		
		WechatMsg wm = WechatXMLUtil.parseMsg("<xml>" + 
 "<ToUserName><![CDATA[toUser]]></ToUserName>" +
 "<FromUserName><![CDATA[fromUser]]></FromUserName>" +
 "<CreateTime>1348831860</CreateTime>" +
 "<MsgType><![CDATA[image]]></MsgType>" +
 "<PicUrl><![CDATA[this is a url]]></PicUrl>" +
 "<MsgId>1234567890123456</MsgId>" +
 "</xml>");
		assertEquals(wm.valueOf(WechatXMLUtil.KEY_MSG_TYPE_LOWER), "image");
		assertEquals(wm.getType(), WechatXMLUtil.MSG_TYPE_IMG);
		assertEquals(wm.valueOf(WechatXMLUtil.KEY_FROM_USER_LOWER), "fromUser");
		
	}
	
}
