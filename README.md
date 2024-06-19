# Lodsve Maven plugins

[![LICENSE](https://img.shields.io/github/license/lodsve/lodsve-maven-plugins)](https://github.com/lodsve/lodsve-maven-plugins/blob/master/LICENSE)
[![GitHub stars](https://img.shields.io/github/stars/lodsve/lodsve-maven-plugins.svg)](https://github.com/lodsve/lodsve-maven-plugins/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/lodsve/lodsve-maven-plugins.svg)](https://github.com/lodsve/lodsve-maven-plugins/network)
[![GitHub issues](https://img.shields.io/github/issues/lodsve/lodsve-maven-plugins.svg)](https://github.com/lodsve/lodsve-maven-plugins/issues)
[![GitHub pull requests](https://img.shields.io/github/issues-pr/lodsve/lodsve-maven-plugins.svg)](https://github.com/lodsve/lodsve-maven-plugins/pulls)
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Flodsve%2Flodsve-maven-plugins.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2Flodsve%2Flodsve-maven-plugins?ref=badge_shield)

## Component Versions

1. lodsve-javatemplate-maven-plugin

   [![Maven Central](https://img.shields.io/maven-central/v/com.lodsve.maven.plugins/lodsve-javatemplate-maven-plugin.svg)](https://search.maven.org/artifact/com.lodsve.maven.plugins/lodsve-javatemplate-maven-plugin)
2. lodsve-shade-maven-plugin

   [![Maven Central](https://img.shields.io/maven-central/v/com.lodsve.maven.plugins/lodsve-shade-maven-plugin.svg)](https://search.maven.org/artifact/com.lodsve.maven.plugins/lodsve-shade-maven-plugin)

## Expand maven plugins `maven-shade-plugin`

- `com.lodsve.maven.plugin.shade.SpringFactoriesResourceTransformer`

  merge `spring.factories`
- `com.lodsve.maven.plugin.shade.RegexAppendingTransformer`

  merge resources with regex
- How to use it?

        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-shade-plugin</artifactId>
            <version>${maven.shade.plugin.version}</version>
            <dependencies>
                <!-- add dependency -->
                <dependency>
                    <groupId>com.lodsve.maven.plugins</groupId>
                    <artifactId>lodsve-shade-maven-plugin</artifactId>
                    <version>${lastest.version}</version>
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
                        <!-- use it as transformer -->
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

## Maven Plugin: `lodsve-javatemplate-maven-plugin`

```text
To be improved
```

## Thanks

The `Lodsve Boot` was created using awesome [JetBrains IDEA][].

![JetBrains logo](https://resources.jetbrains.com/storage/products/company/brand/logos/jetbrains.svg)

[JetBrains IDEA]: https://www.jetbrains.com/?from=lodsve-boot
