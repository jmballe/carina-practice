package com.qaprosoft.carina.demo.practiceAPI;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.qaprosoft.carina.demo.api.practice.DeleteCommentsMethod;
import com.qaprosoft.carina.demo.api.practice.GetCommentsMethod;
import com.qaprosoft.carina.demo.api.practice.PostCreateCommentMethod;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PracticeAPITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testCreateComment(){
        LOGGER.info("test");
        PostCreateCommentMethod createCommentMethod = new PostCreateCommentMethod();
//        createCommentMethod.setProperties("api/comments/comments.properties");

        AtomicInteger counter = new AtomicInteger(0);

        createCommentMethod.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 1)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        createCommentMethod.validateResponse();
    }

    @Test
    public void testGetComments() {
        LOGGER.info("test");
        GetCommentsMethod getCommentsMethod = new GetCommentsMethod();
        getCommentsMethod.callAPIExpectSuccess();
        getCommentsMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getCommentsMethod.validateResponseAgainstSchema("api/comments/_get/rs.schema");
    }

    @Test
    public void testDeleteComment() {
        LOGGER.info("test");
        DeleteCommentsMethod deleteCommentsMethod = new DeleteCommentsMethod();
        deleteCommentsMethod.callAPIExpectSuccess();
        deleteCommentsMethod.validateResponse();
    }
}
