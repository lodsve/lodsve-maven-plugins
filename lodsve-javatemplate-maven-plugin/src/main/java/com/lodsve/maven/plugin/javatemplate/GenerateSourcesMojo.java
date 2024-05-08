package com.lodsve.maven.plugin.javatemplate;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;

/**
 * This mojo helps adding a generate source folder in one go. This is typically useful if you want to use properties
 * coming from the POM inside parts of your source code that requires real constants, like annotations for example.
 */
@Mojo(name = "generate-sources", defaultPhase = LifecyclePhase.GENERATE_SOURCES, threadSafe = true)
public class GenerateSourcesMojo extends AbstractGenerateSourcesMojo {
    /**
     * Source directory that will be first generate and then added as a classical source folder.
     */
    @Parameter(defaultValue = "${basedir}/src/main/java-templates")
    File sourceDirectory;

    /**
     * Output folder where generate sources will land.
     */
    @Parameter(defaultValue = "${project.build.directory}/generated-sources")
    private File outputDirectory;

    @Override
    protected File getSourceDirectory() {
        return sourceDirectory;
    }

    @Override
    protected File getOutputDirectory() {
        return outputDirectory;
    }

    @Override
    protected void addSourceFolderToProject(MavenProject mavenProject) {
        mavenProject.addCompileSourceRoot(getOutputDirectory().getAbsolutePath());
    }
}
