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

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 *
 * @author Olivier Grégoire
 */
public class Simulation {

  final int width;
  final int height;
  final ImmutableList<Nest> nests;
  final ImmutableList<Food> foods;
  final ImmutableList<Ant> ants;

  Simulation(Builder builder) {
    width = builder.width;
    height = builder.height;
    nests = ImmutableList.copyOf(builder.nests.stream().map(Nest.Builder::build).iterator());
    ants = ImmutableList.copyOf(nests.stream().flatMap(n -> n.ants.stream()).iterator());
    foods = ImmutableList.copyOf(builder.foods.stream().map(Food.Builder::build).iterator());
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public ImmutableList<Nest> getNests() {
    return nests;
  }

  public ImmutableList<Food> getFoods() {
    return foods;
  }

  public ImmutableList<Ant> getAnts() {
    return ants;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("width", width)
        .add("height", height)
        .add("nests", nests)
        .add("foods", foods)
        .add("ants", ants)
        .toString();
  }

  public static class Builder {

    int width;
    int height;
    List<Nest.Builder> nests;
    List<Food.Builder> foods;

    public Simulation build() {
      return new Simulation(this);
    }
  }

}
