package com.lodsve.maven.plugin.javatemplate;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;

/**
 * This mojo helps adding a generate source folder in one go. This is typically useful if you want to use properties
 * coming from the POM inside parts of your test source code that requires real constants, like annotations for example.
 */
@Mojo(name = "generate-test-sources", defaultPhase = LifecyclePhase.GENERATE_TEST_SOURCES, threadSafe = true)
public class GenerateTestSourcesMojo extends AbstractGenerateSourcesMojo {
    /**
     * Source directory that will be first generate and then added as a classical source folder.
     */
    @Parameter(defaultValue = "${basedir}/src/test/java-templates")
    private File testSourceDirectory;

    /**
     * Output folder where generate test sources will land.
     */
    @Parameter(defaultValue = "${project.build.directory}/generated-test-sources")
    private File testOutputDirectory;

    @Override
    protected File getSourceDirectory() {
        return testSourceDirectory;
    }

    @Override
    protected File getOutputDirectory() {
        return testOutputDirectory;
    }

    @Override
    protected void addSourceFolderToProject(MavenProject mavenProject) {
        mavenProject.addTestCompileSourceRoot(getOutputDirectory().getAbsolutePath());
    }
}
