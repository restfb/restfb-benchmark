/*
 * Copyright (c) 2010-2015 Mark Allen, Norbert Bartels.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.restfb.benchmark;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

import org.json.JSONObject;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Benchmark)
@Fork(value = 5, jvmArgsAppend = { "-Xms512m", "-Xmx1024m" })
public class JsonMapperBasicBenchmark {

  private String json;

  @Setup
  public void setup() {
    json = JsonHelper.jsonFromClasspath("post-with-normal-comments");
  }

  @Benchmark
  public JSONObject toJavaObjectJsonOrg() {
    JSONObject obj = new JSONObject(json);
    obj.getString("type");
    return obj;
  }

  @Benchmark
  public JsonObject toJavaObjectMinimalJson() {
    JsonObject obj = Json.parse(json).asObject();
    obj.get("type").asString();
    return obj;
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder().include(JsonMapperBasicBenchmark.class.getSimpleName()).warmupIterations(5)
      .measurementIterations(15).forks(5).jvmArgs("-ea").build();

    new Runner(opt).run();
  }
}
