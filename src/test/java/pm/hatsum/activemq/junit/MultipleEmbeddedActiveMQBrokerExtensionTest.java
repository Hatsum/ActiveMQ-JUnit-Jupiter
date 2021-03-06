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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MultipleEmbeddedActiveMQBrokerExtensionTest {
    final String brokerOneName = "broker-one";
    final String brokerTwoName = "broker-two";

    @RegisterExtension
    final public EmbeddedActiveMQBroker brokerOne = new EmbeddedActiveMQBroker();

    @RegisterExtension
    final public EmbeddedActiveMQBroker brokerTwo = new EmbeddedActiveMQBroker();

    public MultipleEmbeddedActiveMQBrokerExtensionTest() {
        // Perform and broker configuration here before JUnit starts the brokers
        brokerOne.setBrokerName(brokerOneName);
        brokerTwo.setBrokerName(brokerTwoName);
    }

    @BeforeEach
    public void setUp() {
        assertTrue(brokerOne.getBrokerService().isStarted(), "Broker One should be started");
        assertTrue(brokerTwo.getBrokerService().isStarted(), "Broker Two should be started");
    }

    @AfterEach
    public void tearDown() {
        assertTrue(brokerOne.getBrokerService().isStarted(), "Broker One should still be running");
        assertTrue(brokerTwo.getBrokerService().isStarted(), "Broker Two should still be running");
    }

    @Test
    void testStart() {
        assertEquals(brokerOneName, brokerOne.getBrokerName(), "Broker One name is incorrect");
        assertEquals(brokerTwoName, brokerTwo.getBrokerName(), "Broker Two name is incorrect");
    }
}