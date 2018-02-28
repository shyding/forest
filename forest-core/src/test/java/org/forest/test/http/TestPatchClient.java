package org.forest.test.http;

import org.forest.backend.HttpBackend;
import org.forest.backend.okhttp3.OkHttp3Backend;
import org.forest.config.ForestConfiguration;
import org.forest.test.http.client.PatchClient;
import org.forest.test.mock.PatchMockServer;
import org.forest.test.mock.PutMockServer;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * @author gongjun[jun.gong@thebeastshop.com]
 * @since 2017-05-11 17:13
 */
public class TestPatchClient extends BaseClientTest {

    private final static Logger log = LoggerFactory.getLogger(TestPatchClient.class);

    @Rule
    public PatchMockServer server = new PatchMockServer(this);

    private static ForestConfiguration configuration;

    private static PatchClient patchClient;


    @BeforeClass
    public static void prepareClient() {
        configuration = ForestConfiguration.configuration();
    }

    public TestPatchClient(HttpBackend backend) {
        super(backend, configuration);
        patchClient = configuration.createInstance(PatchClient.class);
    }

    @Before
    public void prepareMockServer() {
        server.initServer();
    }

    @Test
    public void testSimplePatch() {
        String result = patchClient.simplePatch();
        log.info("response: " + result);
        assertNotNull(result);
        assertEquals(PutMockServer.EXPECTED, result);
    }

    @Test
    public void testTextParamPatch() {
        String result = patchClient.textParamPatch("foo", "123456");
        log.info("response: " + result);
        assertNotNull(result);
        assertEquals(PutMockServer.EXPECTED, result);
    }

    @Test
    public void testAnnParamPatch() {
        String result = patchClient.annParamPatch("foo", "123456");
        log.info("response: " + result);
        assertNotNull(result);
        assertEquals(PutMockServer.EXPECTED, result);
    }


}
