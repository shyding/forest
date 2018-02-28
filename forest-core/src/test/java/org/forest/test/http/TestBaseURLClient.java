package org.forest.test.http;

import org.forest.backend.HttpBackend;
import org.forest.config.ForestConfiguration;
import org.forest.test.http.client.BaseURLClient;
import org.forest.test.http.client.BaseURLVarClient;
import org.forest.test.mock.GetMockServer;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.Assert.assertEquals;

/**
 * @author gongjun[jun.gong@thebeastshop.com]
 * @since 2017-05-17 16:12
 */
public class TestBaseURLClient extends BaseClientTest {


    private final static Logger log = LoggerFactory.getLogger(TestGetClient.class);

    @Rule
    public GetMockServer server = new GetMockServer(this);

    private static ForestConfiguration configuration;

    private static BaseURLClient baseURLClient;

    private static BaseURLVarClient baseURLVarClient;

    @BeforeClass
    public static void prepareClient() {
        configuration = ForestConfiguration.configuration();
        configuration.setVariableValue("baseURL", "http://localhost:5000/");
    }

    public TestBaseURLClient(HttpBackend backend) {
        super(backend, configuration);
        baseURLClient = configuration.createInstance(BaseURLClient.class);
        baseURLVarClient = configuration.createInstance(BaseURLVarClient.class);
    }

    @Before
    public void prepareMockServer() {
        server.initServer();
    }

    @Test
    public void testBaseURL() {
        String result = baseURLClient.simpleGet();
        assertEquals(GetMockServer.EXPECTED, result);
    }

    @Test
    public void testBaseURLVar() {
        String result = baseURLVarClient.simpleGet();
        assertEquals(GetMockServer.EXPECTED, result);
    }

}
