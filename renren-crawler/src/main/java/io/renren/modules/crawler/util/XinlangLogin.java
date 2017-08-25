package io.renren.modules.crawler.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.message.BasicNameValuePair;

import io.renren.common.request.constant.HeaderConstant;
import io.renren.common.request.constant.UrlConstant;
import io.renren.common.request.httpclient.HttpClientUtil;

public class XinlangLogin {

	public static void login(Map<String, String> header,String username, String password) throws Exception {
		// 初始化参数
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair("password", password));
		params.add(new BasicNameValuePair("savestate", "1"));
		params.add(new BasicNameValuePair("r", ""));
		params.add(new BasicNameValuePair("ec", "0"));
		params.add(new BasicNameValuePair("pagerefer", ""));
		params.add(new BasicNameValuePair("entry", "mweibo"));
		params.add(new BasicNameValuePair("loginfrom", ""));
		params.add(new BasicNameValuePair("client_id", ""));
		params.add(new BasicNameValuePair("code", ""));
		params.add(new BasicNameValuePair("qq", ""));
		params.add(new BasicNameValuePair("mainpageflag", "1"));
		params.add(new BasicNameValuePair("hff", ""));
		params.add(new BasicNameValuePair("hfp", ""));

		Header[] postFormDataHead = HttpClientUtil.postFormDataHead(UrlConstant.urlLoginRequest,
				HeaderConstant.base_html, params);

		for (Header head : postFormDataHead) {
			if("Set-Cookie".equalsIgnoreCase(head.getName())){
				String cookie = header.get("Cookie");
				// 获取相应的cookie
				String responeCookie = head.getValue();
				// 截取相应cookie,去除多余的参数
				responeCookie=responeCookie.substring(0,responeCookie.indexOf(';')+1);
				if(null==cookie||"".equals(cookie)){
					header.put("Cookie", responeCookie);
				}else{
					header.put("Cookie", cookie+responeCookie);
				}
			}
		}
	}

	public static void main(String[] args) {
		String responeCookie="SINAGLOBAL=7495797993399.591.1498102147729; UM_distinctid=15d34c6fc3640f-0a09aff2545462-5d4e211f-100200-15d34c6fc3754c; _s_tentry=news.ifeng.com; UOR=www.csdn.net,widget.weibo.com,news.ifeng.com; TC-Page-G0=4c4b51307dd4a2e262171871fe64f295; Apache=157994066298.3126.1503652229062; ULV=1503652229156:19:9:6:157994066298.3126.1503652229062:1503642844969; YF-Page-G0=46f5b98560a83dd9bfdd28c040a3673e; YF-V5-G0=bb389e7e25cccb1fadd4b1334ab013c1; WBStorage=0c663978e8e51f06|undefined; login_sid_t=841748b29852b5e9b60636152e909389; YF-Ugrow-G0=1eba44dbebf62c27ae66e16d40e02964; WBtopGlobal_register_version=d2d69d0b990c2b17; SSOLoginState=1503652475; un=15382894342; SCF=ApXhGL1r0ZhY4HWXbTUZhDHYGOEs9ZM-0dMGJqWaLVTZ8cH6Efx0RLazeb7e4I7GEtShRWu-ur47NBgrbZDkDJY.; SUB=_2A250m5reDeRhGeNJ6lIZ8ybMzj2IHXVX0IsWrDV8PUJbmtAKLRChkW9DGmu5Pb1zSUUM65lJvVJi4fXDWw..; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WWBwyvDsKK8IfwD0mX4yw3v5JpX5o2p5NHD95QfS0271heReh-pWs4Dqcj1MGHbdsLodNHXMGiDdrBt; SUHB=079jJSd5Q_6R9Y; ALF=1535188475; wvr=6; wb_cusLike_5710838051=N";
	/*	responeCookie=responeCookie.substring(0,responeCookie.indexOf(';')+1);
		System.out.println(responeCookie);*/
		String[] split = responeCookie.split(";");
		for (String string : split) {
			System.out.println(string);
		}
	}
	
	/*
	 * 
	 * SUB=_2A250m6a8DeRhGeBN7lEZ9CjPyT-IHXVUZ8r0rDV6PUJbkdANLU_nkW02PcSJTjumxeVj3I3aIjR2-rwF5Q..; 
	 * SUHB=0V5V9nIaKVjzD5;
	 * SCF=AiVbcXXHrrvWtKl599aq5bQsCkvewnVTOCTRy66tVTLv2SeSwtZZYCwzde4j8baZ6coko9Bb4PgQC0rMHxY-bpM.;
	 *  _T_WM=7fd236bd7f52fac5be69afc843f4134d; 
	 *  H5_INDEX=0_all; 
	 *  H5_INDEX_TITLE=%E9%91%AB%E7%A9%BAOne; 
	 *  SSOLoginState=1503647468; 
	 *  M_WEIBOCN_PARAMS=lfid%3D102803_ctg1_8999_-_ctg1_8999_home%26luicode%3D20000174%26uicode%3D20000174%26featurecode%3D20000320%26fid%3Dhotword
	 * 
Set-Cookie:SUB=_2A250m7kJDeRhGeBN7lEZ9CjPyT-IHXVUZ8dBrDV6PUJbkdAKLWOkkW08TgcEZuIYHOyh6cG9XCu3dgH7Rg..; Path=/; Domain=.weibo.cn; Expires=Sat, 25 Aug 2018 06:53:13 GMT; HttpOnly
Set-Cookie:SUHB=0S7yFMDkUugT2s; expires=Saturday, 25-Aug-2018 06:53:13 GMT; path=/; domain=.weibo.cn
Set-Cookie:SCF=AiVbcXXHrrvWtKl599aq5bQsCkvewnVTOCTRy66tVTLvw8UtfcraCg7tvItnds7fG-azQCjGSWKHc9wwpELzWUs.; expires=Monday, 23-Aug-2027 06:53:13 GMT; path=/; domain=.weibo.cn; httponly
Set-Cookie:SSOLoginState=1503643993; path=/; domain=weibo.cn
Set-Cookie:ALF=1506235993; expires=Sunday, 24-Sep-2017 06:53:13 GMT; path=/; domain=.sina.cn

DPOOL_HEADER:lich78
SINA-LB:aGEuMTY3LmcxLnRjLmxiLnNpbmFub2RlLmNvbQ==
SINA-TS:YmZkYTlhY2UgMCAwIDAgMyA3OAo=
{"retcode":20000000,"msg":"","data":{"crossdomainlist":{"weibo.com":"https:\/\/passport.weibo.com\/sso\/crossdomain?entry=mweibo&action=login&proj=1&ticket=ST-NjM1Mzg0NjMyMw%3D%3D-1503643993-tc-CA0DE1EEEDE4B4E8ADEDC11AA3B2F088-1","sina.com.cn":"https:\/\/login.sina.com.cn\/sso\/crossdomain?entry=mweibo&action=login&proj=1&ticket=ST-NjM1Mzg0NjMyMw%3D%3D-1503643993-tc-E68B9225C36CE524AAFC3123ADC12364-1","weibo.cn":"https:\/\/passport.sina.cn\/sso\/crossdomain?entry=mweibo&action=login&ticket=ST-NjM1Mzg0NjMyMw%3D%3D-1503643993-tc-3B99A471F1DDB810CBFD5F317C042F35-1"},"loginresulturl":"","uid":"6353846323"}}
	 */
}
