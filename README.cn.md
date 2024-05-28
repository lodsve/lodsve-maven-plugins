# Lodsve Maven 插件

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
