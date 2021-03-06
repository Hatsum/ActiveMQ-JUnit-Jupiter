/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pm.hatsum.activemq.junit;

import pm.hatsum.activemq.junit.jupiter.EmbeddedActiveMQBroker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Verify the get/set operations are working properly
 */
class EmbeddedActiveMQBrokerConfigTest {

    // Don't use @Rule in this case - just testing getters/setters
    EmbeddedActiveMQBroker instance;

    @BeforeEach
    public void setUp() {
        instance = new EmbeddedActiveMQBroker() {
            @Override
            protected void configure() {

            }
        };
    }

    @Test
    void testGetVmURL() {
        assertEquals("failover:(vm://embedded-broker?create=false)", instance.getVmURL(), "Default VM URL in incorrect");
    }

    @Test
    void testGetBrokerName() {
        assertEquals("embedded-broker", instance.getBrokerName(), "Default Broker Name in incorrect");
    }

    @Test
    void testBrokerNameConfig() {
        String dummyName = "test-broker-name";

        instance.setBrokerName(dummyName);

        assertEquals(dummyName, instance.getBrokerName(), "Broker Name not set correctly");
    }

    @Test
    void testStatisticsPluginConfig() {
        assertFalse(instance.isStatisticsPluginEnabled(), "Statistics plugin should not be enabled by default");
        instance.enableStatisticsPlugin();
        assertTrue(instance.isStatisticsPluginEnabled(), "Statistics plugin not enabled");
        instance.disableStatisticsPlugin();
        assertFalse(instance.isStatisticsPluginEnabled(), "Statistics plugin not disabled");
    }

    @Test
    void testAdvisoryForDeliveryConfig() {
        assertFalse(instance.isAdvisoryForDeliveryEnabled(), "Advisory messages for delivery should not be enabled by default");
        instance.enableAdvisoryForDelivery();
        assertTrue(instance.isAdvisoryForDeliveryEnabled(), "Advisory messages for delivery not enabled");
        instance.disableAdvisoryForDelivery();
        assertFalse(instance.isAdvisoryForDeliveryEnabled(), "Advisory messages for delivery not disabled");
    }

    @Test
    void testAdvisoryForConsumedConfig() {
        assertFalse(instance.isAdvisoryForConsumedEnabled(), "Advisory messages for consumed should not be enabled by default");
        instance.enableAdvisoryForConsumed();
        assertTrue(instance.isAdvisoryForConsumedEnabled(), "Advisory messages for consumed not enabled");
        instance.disableAdvisoryForConsumed();
        assertFalse(instance.isAdvisoryForConsumedEnabled(), "Advisory messages for consumed not disabled");
    }

    @Test
    void testAdvisoryForDiscardingMessagesConfig() {
        assertFalse(instance.isAdvisoryForDiscardingMessagesEnabled(), "Advisory messages for discarding messages should not be enabled by default");
        instance.enableAdvisoryForDiscardingMessages();
        assertTrue(instance.isAdvisoryForDiscardingMessagesEnabled(), "Advisory messages for discarding messages not enabled");
        instance.disableAdvisoryForDiscardingMessages();
        assertFalse(instance.isAdvisoryForDiscardingMessagesEnabled(), "Advisory messages for discarding messages not disabled");
    }

    @Test
    void testAdvisoryForFastProducersConfig() {
        assertFalse(instance.isAdvisoryForFastProducersEnabled(), "Advisory messages for fast producers should not be enabled by default");
        instance.enableAdvisoryForFastProducers();
        assertTrue(instance.isAdvisoryForFastProducersEnabled(), "Advisory messages for fast producers not enabled");
        instance.disableAdvisoryForFastProducers();
        assertFalse(instance.isAdvisoryForFastProducersEnabled(), "Advisory messages for fast producers not disabled");
    }

    @Test
    void testAdvisoryForSlowConsumersConfig() {
        assertFalse(instance.isAdvisoryForSlowConsumersEnabled(), "Advisory messages for slow consumers should not be enabled by default");
        instance.enableAdvisoryForSlowConsumers();
        assertTrue(instance.isAdvisoryForSlowConsumersEnabled(), "Advisory messages for slow consumers not enabled");
        instance.disableAdvisoryForSlowConsumers();
        assertFalse(instance.isAdvisoryForSlowConsumersEnabled(), "Advisory messages for slow consumers not disabled");
    }

}