/*
 * Copyright 2016 Olivier Grégoire.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package be.ogregoire.ants.core;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.io.CharSource;

import com.google.common.io.Resources;

import java.nio.charset.StandardCharsets;

/**
 *
 * @author Olivier Grégoire
 */
public class SimulationFactoryTest {

  public SimulationFactoryTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testNewInstanceFromJson() throws Exception {
    CharSource source = Resources.asCharSource(Resources.getResource("test.json"), StandardCharsets.UTF_8);

    Simulation sim = SimulationFactory.newInstanceFromJson(source);
    System.out.println(sim);

    assertThat(sim, is(notNullValue()));
    assertThat(sim.getNests(), is(notNullValue()));
    assertThat(sim.getNests().size(), is(1));
  }

}
