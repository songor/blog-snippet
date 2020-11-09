package com.songor.blog.snippet.java8;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * java8 stream 替代嵌套 for 循环
 *
 * @author chensongyu
 */
public class UseStreamInsteadOfNestedForLoop {
  /**
   * 拿全国省市区 JSON 文件作为输入，获取全部的区编码
   *
   * @param args args
   */
  public static void main(String[] args) throws IOException {
    String result =
        new String(
            Files.readAllBytes(Paths.get("src/main/resources/resp.json")),
            Charset.forName("UTF-8"));
    Resp resp = new ObjectMapper().readValue(result, Resp.class);
    List<String> areaCodes =
        Optional.ofNullable(resp.getProvinceList()).orElse(Collections.emptyList()).stream()
            .map(Province::getCityList)
            .flatMap(List::stream)
            .map(City::getAreaList)
            .flatMap(List::stream)
            .map(Area::getAreaCode)
            .collect(Collectors.toList());
    System.out.println(areaCodes.size());
  }

  /** JSON 对象 */
  @Getter
  private static class Resp {
    private List<Province> provinceList;
  }

  /** 省 */
  @Getter
  private static class Province {
    private String provinceCode;
    private String provinceName;
    private List<City> cityList;
  }

  /** 市 */
  @Getter
  private static class City {
    private String cityCode;
    private String cityName;
    private List<Area> areaList;
  }

  /** 区 */
  @Getter
  private static class Area {
    private String areaCode;
    private String areaName;
  }
}
