package com.songor.blog.snippet.java8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * java8 stream 在 Map 和 List 之间转换
 *
 * @author songor
 */
public class UseStreamToConvertBetweenMapAndList {
  /**
   * 读取 ASCII 码对照表文件，得到行字符串流，然后转为 ASCII 值和控制字符的映射，最后转为 {@link Ascii} 对象集合
   *
   * @param args args
   */
  public static void main(String[] args) {
    try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/ascii.txt"))) {
      Map<String, String> map =
          lines.collect(
              Collectors.toMap(line -> line.split(",", 2)[0], line -> line.split(",", 2)[1]));
      List<Ascii> list =
          map.entrySet().stream()
              .map(entry -> new Ascii(Integer.valueOf(entry.getKey()), entry.getValue()))
              .sorted()
              .collect(Collectors.toList());
      System.out.println(list);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @AllArgsConstructor
  @Getter
  @ToString
  private static class Ascii implements Comparable<Ascii> {
    private Integer value;
    private String character;

    @Override
    public int compareTo(Ascii obj) {
      return Integer.compare(getValue(), obj.getValue());
    }
  }
}
