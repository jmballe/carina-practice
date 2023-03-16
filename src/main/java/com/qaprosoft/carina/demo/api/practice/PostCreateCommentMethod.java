/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.api.practice;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.*;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

@Endpoint(url = "${base_url}/comments/add", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/comments/_post/rq.json")
@ResponseTemplatePath(path = "api/comments/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
@Header(key = "Content-Type", value = "application/json")
public class PostCreateCommentMethod extends AbstractApiMethodV2 {

    public PostCreateCommentMethod() {
        super("api/comments/_post/rq.json", "api/comments/_post/rs.json", "api/comments/comments.properties");
        replaceUrlPlaceholder("base_url", "https://dummyjson.com");
    }
}