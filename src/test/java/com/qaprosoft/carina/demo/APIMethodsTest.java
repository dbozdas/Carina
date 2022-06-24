package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.api.DeleteUserMethod;
import com.qaprosoft.carina.demo.apimethods.GetPostMethods;
import com.qaprosoft.carina.demo.api.GetUserMethods;
import com.qaprosoft.carina.demo.api.PostUserMethod;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This sample shows how create REST API tests.
 *
 * @author dbozdas
 */
public class APIMethodsTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "dbozdas")
    public void testGetPosts() {
        GetPostMethods getPostMethods = new GetPostMethods();
        getPostMethods.callAPIExpectSuccess();
        getPostMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPostMethods.validateResponseAgainstSchema("api/posts/_get/rs.schema");
    }
}