# Lodsve Maven 插件

[![LICENSE](https://img.shields.io/github/license/lodsve/lodsve-maven-plugins)](https://github.com/lodsve/lodsve-maven-plugins/blob/master/LICENSE)
[![GitHub stars](https://img.shields.io/github/stars/lodsve/lodsve-maven-plugins.svg)](https://github.com/lodsve/lodsve-maven-plugins/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/lodsve/lodsve-maven-plugins.svg)](https://github.com/lodsve/lodsve-maven-plugins/network)
[![GitHub issues](https://img.shields.io/github/issues/lodsve/lodsve-maven-plugins.svg)](https://github.com/lodsve/lodsve-maven-plugins/issues)
[![GitHub pull requests](https://img.shields.io/github/issues-pr/lodsve/lodsve-maven-plugins.svg)](https://github.com/lodsve/lodsve-maven-plugins/pulls)
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Flodsve%2Flodsve-maven-plugins.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2Flodsve%2Flodsve-maven-plugins?ref=badge_shield)

## 组件版本

1. lodsve-javatemplate-maven-plugin

   [![Maven Central](https://img.shields.io/maven-central/v/com.lodsve.maven.plugins/lodsve-javatemplate-maven-plugin.svg)](https://search.maven.org/artifact/com.lodsve.maven.plugins/lodsve-javatemplate-maven-plugin)
2. lodsve-shade-maven-plugin

   [![Maven Central](https://img.shields.io/maven-central/v/com.lodsve.maven.plugins/lodsve-shade-maven-plugin.svg)](https://search.maven.org/artifact/com.lodsve.maven.plugins/lodsve-shade-maven-plugin)

## 扩展 Maven 插件 `maven-shade-plugin`

- `com.lodsve.maven.plugin.shade.SpringFactoriesResourceTransformer`

  合并 `spring.factories`
- `com.lodsve.maven.plugin.shade.RegexAppendingTransformer`

  使用正则表达式合并资源
- 如何使用？

    ```xml
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-shade-plugin</artifactId>
        <version>${maven.shade.plugin.version}</version>
        <dependencies>
            <!-- 添加依赖 -->
            <dependency>
                <groupId>com.lodsve.maven.plugins</groupId>
                <artifactId>lodsve-shade-maven-plugin</artifactId>
                <version>${latest.version}</version>
            </dependency>
        </dependencies>
        <executions>
            <execution>
                <phase>package</phase>
                <goals>
                    <goal>shade</goal>
                </goals>
                <configuration>
                    ...
                    <!-- 作为转换器使用 -->
                    <transformers>
                        <transformer implementation="com.lodsve.maven.plugin.shade.SpringFactoriesResourceTransformer"/>
                    </transformers>
                    <transformer implementation="com.lodsve.maven.plugin.shade.RegexAppendingTransformer">
                        <regex>META-INF/error/.*.properties</regex>
                    </transformer>
                </configuration>
            </execution>
        </executions>
    </plugin>
    ```

## Maven 插件: `lodsve-javatemplate-maven-plugin`

```text
待改进
```

## 特别鸣谢

`Lodsve Boot` 是基于 [JetBrains IDEA][] 创建的。

![JetBrains logo](https://resources.jetbrains.com/storage/products/company/brand/logos/jetbrains.svg)

[JetBrains IDEA]: https://www.jetbrains.com/?from=lodsve-boot
