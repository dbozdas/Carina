package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.apimethods.DeletePostMethod;
import com.qaprosoft.carina.demo.apimethods.GetPostMethod;
import com.qaprosoft.carina.demo.apimethods.PostPostMethod;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

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
        GetPostMethod getPostMethod = new GetPostMethod();
        getPostMethod.callAPIExpectSuccess();
        getPostMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPostMethod.validateResponseAgainstSchema("api/posts/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "dbozdas")
    @TestPriority(Priority.P1)
    public void testDeletePosts() {
        DeletePostMethod deletePostMethod = new DeletePostMethod();
        deletePostMethod .setProperties("api/posts/post.properties");
        deletePostMethod .callAPIExpectSuccess();
        deletePostMethod .validateResponse();
    }

    @Test()
    @MethodOwner(owner = "dbozdas")
    public void testCreatePosts() throws Exception {
        PostPostMethod postPostMethod = new PostPostMethod();
        postPostMethod.setProperties("api/posts/post.properties");
        postPostMethod.getProperties().remove("userId");
        postPostMethod.getProperties().remove("id");
        postPostMethod.getProperties().remove("title");
        postPostMethod.callAPIExpectSuccess();
        postPostMethod.validateResponse();
    }
}