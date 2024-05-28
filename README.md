# Lodsve Maven plugins

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
