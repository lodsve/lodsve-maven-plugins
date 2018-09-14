# Maven plugins for lodsve-framework!

## Expand maven plugins `maven-shade-plugin`
- `lodsve.maven.plugin.shade.SpringFactoriesResourceTransformer` 

    merge spring.factories
- `lodsve.maven.plugin.shade.RegexAppendingTransformer`    
    
    merge resources with regex
- How to use it?

        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-shade-plugin</artifactId>
            <version>${maven.shade.plugin.version}</version>
            <dependencies>
                <!-- add dependency -->
                <dependency>
                    <groupId>com.lodsve</groupId>
                    <artifactId>lodsve-maven-plugins</artifactId>
                    <version>${project.version}</version>
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
                            <transformer implementation="lodsve.maven.plugin.shade.SpringFactoriesResourceTransformer"/>
                        </transformers>
                        <transformer implementation="lodsve.maven.plugin.shade.RegexAppendingTransformer">
                            <regex>META-INF/error/.*.properties</regex>
                        </transformer>
                    </configuration>
                </execution>
            </executions>
        </plugin>