/*
 * Copyright 2018 Jobsz(zhucongqi.cn)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
*/
package cn.zhucongqi.oauth2.response;

import cn.zhucongqi.oauth2.base.response.OAuthResponse;
import cn.zhucongqi.oauth2.base.validator.OAuthValidator;
import cn.zhucongqi.oauth2.consts.OAuthConsts;

/**
 * @author Jobsz [zcq@zhucongqi.cn]
 * @version
 */
public class OAuthCodeResponse extends OAuthResponse {

	@Override
	protected void init() {
		this.setAuthorizationCode(this.issuer.authorizationCode());
	}
	
	public OAuthCodeResponse(OAuthValidator validator) {
		super(validator);
	}

	/**
	 * Set code
	 * @param code
	 */
	private OAuthCodeResponse setAuthorizationCode(String code) {
		this.putParameter(OAuthConsts.OAuth.OAUTH_AUTHORIZATION_CODE, code);
		return this;
	}

	public String getAuthorizationCode() {
		return this.getParamter(OAuthConsts.OAuth.OAUTH_AUTHORIZATION_CODE);
	}
}
