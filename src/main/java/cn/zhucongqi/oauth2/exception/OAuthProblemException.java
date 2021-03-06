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
package cn.zhucongqi.oauth2.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import cn.zhucongqi.oauth2.kit.StrKit;

/**
 * 
 * @author Jobsz [zcq@zhucongqi.cn]
 * @version
 */
public class OAuthProblemException extends IllegalArgumentException {

	private static final long serialVersionUID = 1536483571040822380L;
	private String error;
    private String description;

    private int responseStatus;

    private Map<String, String> parameters = new HashMap<String, String>();

    protected OAuthProblemException(String error) {
        this(error, "OAuthProblemException ERROR");
    }

    protected OAuthProblemException(String error, String description) {
        super(error + " " + description);
        this.description = description;
        this.error = error;
    }

    public static OAuthProblemException error(String error) {
        return new OAuthProblemException(error).responseStatus(HttpServletResponse.SC_FORBIDDEN);
    }

    public static OAuthProblemException error(String error, String description) {
        return new OAuthProblemException(error, description).responseStatus(HttpServletResponse.SC_FORBIDDEN);
    }

    public OAuthProblemException description(String description) {
        this.description = description;
        return this;
    }

    public OAuthProblemException responseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
        return this;
    }

    public OAuthProblemException setParameter(String name, String value) {
        parameters.put(name, value);
        return this;
    }

    public String getError() {
        return error;
    }

    public String getDescription() {
        return description;
    }

    public int getResponseStatus() {
        return responseStatus == 0 ? 400 : responseStatus;
    }

    public String get(String name) {
        return parameters.get(name);
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    @Override
    public String getMessage() {
        StringBuilder b = new StringBuilder();
        if (StrKit.notBlank(error)) {
            b.append(error);
        }

        if (StrKit.notBlank(description)) {
            b.append(", ").append(description);
        }
        return b.toString();
    }

    @Override
    public String toString() {
        return "OAuthProblemException{" +
                "error='" + error + '\'' +
                ", description='" + description + '\'' +
                ", responseStatus=" + responseStatus +
                ", parameters=" + parameters +
                '}';
    }
}
