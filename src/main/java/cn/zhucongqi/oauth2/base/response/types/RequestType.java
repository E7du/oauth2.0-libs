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
package cn.zhucongqi.oauth2.base.response.types;

/**
 * @author Jobsz [zcq@zhucongqi.cn]
 * @version
 */
public enum RequestType {

	// link OAuthGrantRequst
	GRANT_REQUEST("grant_request"),
	// link OAuthRequest
	CODE_TOKEN_REQUEST("code_token_request");

    private String parameterStyle;

	RequestType(String parameterStyle) {
        this.parameterStyle = parameterStyle;
    }

    @Override
    public String toString() {
        return parameterStyle;
    }
}
