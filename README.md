# Expand maven plugins for lodsve-framework

## maven-shade-plugin

- `lodsve.maven.plugin.shade.SpringFactoriesResourceTransformer` 

    merge spring.factories
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
                    </configuration>
                </execution>
            </executions>
        </plugin>