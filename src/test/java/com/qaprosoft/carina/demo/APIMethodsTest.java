package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.apimethods.*;
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

    @Test()
    @MethodOwner(owner = "dbozdas")
    public void testGetAlbums() {
        GetAlbumMethod getAlbumMethod = new GetAlbumMethod();
        getAlbumMethod.callAPIExpectSuccess();
        getAlbumMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getAlbumMethod.validateResponseAgainstSchema("api/albums/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "dbozdas")
    @TestPriority(Priority.P1)
    public void testDeleteAlbums() {
        DeleteAlbumMethod deleteAlbumMethod = new DeleteAlbumMethod();
        deleteAlbumMethod .setProperties("api/albums/album.properties");
        deleteAlbumMethod .callAPIExpectSuccess();
        deleteAlbumMethod .validateResponse();
    }

    @Test()
    @MethodOwner(owner = "dbozdas")
    public void testCreateAlbums() throws Exception {
        PostAlbumMethod postAlbumMethod = new PostAlbumMethod();
        postAlbumMethod.setProperties("api/albums/album.properties");
        postAlbumMethod.getProperties().remove("userId");
        postAlbumMethod.getProperties().remove("id");
        postAlbumMethod.getProperties().remove("title");
        postAlbumMethod.callAPIExpectSuccess();
        postAlbumMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "dbozdas")
    public void testGetPhotos() {
        GetPhotoMethod getPhotoMethod = new GetPhotoMethod();
        getPhotoMethod.callAPIExpectSuccess();
        getPhotoMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPhotoMethod.validateResponseAgainstSchema("api/photos/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "dbozdas")
    @TestPriority(Priority.P1)
    public void testDeletePhotos() {
        DeletePhotoMethod deletePhotoMethod  = new DeletePhotoMethod ();
        deletePhotoMethod .setProperties("api/photos/photo.properties");
        deletePhotoMethod .callAPIExpectSuccess();
        deletePhotoMethod .validateResponse();
    }

    @Test()
    @MethodOwner(owner = "dbozdas")
    public void testCreatePhotos() throws Exception {
        PostPhotoMethod postPhotoMethod = new PostPhotoMethod();
        postPhotoMethod .setProperties("api/photos/photo.properties");
        postPhotoMethod .getProperties().remove("albumId");
        postPhotoMethod .getProperties().remove("id");
        postPhotoMethod .getProperties().remove("title");
        postPhotoMethod .getProperties().remove("url");
        postPhotoMethod .getProperties().remove("thumbnailUrl");
        postPhotoMethod .callAPIExpectSuccess();
        postPhotoMethod .validateResponse();
    }
}