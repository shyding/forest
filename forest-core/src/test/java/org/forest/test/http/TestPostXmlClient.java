package org.forest.test.http;

import org.forest.backend.HttpBackend;
import org.forest.backend.okhttp3.OkHttp3Backend;
import org.forest.config.ForestConfiguration;
import org.forest.test.http.client.PostClient;
import org.forest.test.http.model.XmlTestParam;
import org.forest.test.mock.PostMockServer;
import org.forest.test.mock.PostXmlMockServer;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author gongjun[jun.gong@thebeastshop.com]
 * @since 2017-05-11 16:55
 */
public class TestPostXmlClient extends BaseClientTest {

    private final static Logger log = LoggerFactory.getLogger(TestPostXmlClient.class);

    @Rule
    public PostXmlMockServer server = new PostXmlMockServer(this);

    private static ForestConfiguration configuration;

    private static PostClient postClient;


    @BeforeClass
    public static void prepareClient() {
        configuration = ForestConfiguration.configuration();
    }

    public TestPostXmlClient(HttpBackend backend) {
        super(backend, configuration);
        postClient = configuration.createInstance(PostClient.class);
    }

    @Before
    public void prepareMockServer() {
        server.initServer();
    }

    @Test
    public void testXmlPost() {
        XmlTestParam testParam = new XmlTestParam();
        testParam.setA(1);
        testParam.setB(2);
        String result = postClient.postXml(testParam);
        log.info("response: " + result);
        assertNotNull(result);
        assertEquals(PostMockServer.EXPECTED, result);
    }


    @Test
    public void testXmlPost2() {
        XmlTestParam testParam = new XmlTestParam();
        testParam.setA(1);
        testParam.setB(2);
        String result = postClient.postXml2(testParam);
        log.info("response: " + result);
        assertNotNull(result);
        assertEquals(PostMockServer.EXPECTED, result);
    }


    @Test
    public void testXmlPost3() {
        XmlTestParam testParam = new XmlTestParam();
        testParam.setA(1);
        testParam.setB(2);
        String result = postClient.postXml3(testParam);
        log.info("response: " + result);
        assertNotNull(result);
        assertEquals(PostMockServer.EXPECTED, result);
    }


}
