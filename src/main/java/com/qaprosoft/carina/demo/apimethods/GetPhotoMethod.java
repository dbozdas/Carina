package com.qaprosoft.carina.demo.apimethods;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/photos", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/photos/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetPhotoMethod extends AbstractApiMethodV2 {

    public GetPhotoMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}