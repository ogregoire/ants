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

/**
 *
 * @author Olivier Grégoire
 */
public class Nest {

  final int x;
  final int y;
  final ImmutableList<Ant> ants;

  Nest(Builder builder) {
    x = builder.x;
    y = builder.y;
    ImmutableList.Builder<Ant> antsBuilder = ImmutableList.builder();
    Ant.Builder antBuilder = new Ant.Builder();
    for (int i = 0; i < builder.ants; i++) {
      antsBuilder.add(antBuilder.build());
    }
    ants = antsBuilder.build();
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public ImmutableList<Ant> getAnts() {
    return ants;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("x", x)
        .add("y", y)
        .add("ants", ants)
        .toString();
  }

  public static class Builder {

    int x;
    int y;
    int ants;

    public Nest build() {
      return new Nest(this);
    }

  }

}
