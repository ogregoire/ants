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

import com.google.common.io.CharSource;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author Olivier Grégoire
 */
public class SimulationFactory {

  public static Simulation newInstanceFromJson(CharSource source) throws IOException {
    try (Reader reader = source.openStream()) {
      return new Gson().fromJson(reader, Simulation.Builder.class).build();
    }
  }

}
