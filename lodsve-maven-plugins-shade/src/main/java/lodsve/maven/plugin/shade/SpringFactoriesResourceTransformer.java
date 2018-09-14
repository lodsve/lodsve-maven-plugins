package lodsve.maven.plugin.shade;

import org.apache.maven.plugins.shade.relocation.Relocator;
import org.apache.maven.plugins.shade.resource.ResourceTransformer;
import org.codehaus.plexus.util.IOUtil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

/**
 * Spring Factories ResourceTransformer.
 *
 * @author sunhao(sunhao.java @ gmail.com)
 * @version V1.0, 2018-1-16-0016 10:17
 */
public class SpringFactoriesResourceTransformer implements ResourceTransformer {
    private static final String SPRING_FACTORIES_PATH = "META-INF/spring.factories";
    private static final String LINE_SEPARATOR = ",\\\n";
    private static final Properties SPRING_FACTORIES_CACHE = new Properties();

    @Override
    public boolean canTransformResource(String resource) {
        return SPRING_FACTORIES_PATH.equalsIgnoreCase(resource);
    }

    @Override
    public void processResource(String resource, InputStream is, List<Relocator> relocators) throws IOException {
        Properties prop = new Properties();
        prop.load(is);

        for (Object key : prop.keySet()) {
            if (!SPRING_FACTORIES_CACHE.containsKey(key)) {
                SPRING_FACTORIES_CACHE.put(key, prop.get(key));
                continue;
            }

            Object inCacheValue = SPRING_FACTORIES_CACHE.get(key);
            Object inResourceValue = prop.get(key);

            mergePropValue(key, inCacheValue, inResourceValue);
        }
    }

    @Override
    public boolean hasTransformedResource() {
        return !SPRING_FACTORIES_CACHE.isEmpty();
    }

    @Override
    public void modifyOutputStream(JarOutputStream os) throws IOException {
        os.putNextEntry(new JarEntry(SPRING_FACTORIES_PATH));

        String content = parseString();
        IOUtil.copy(new ByteArrayInputStream(content.getBytes()), os);
    }

    private void mergePropValue(Object key, Object inCacheValue, Object inResourceValue) {
        String inCacheValueString = (inCacheValue != null ? inCacheValue.toString() : "");
        String inResourceValueString = (inResourceValue != null ? inResourceValue.toString() : "");

        if (!inCacheValueString.trim().endsWith(",")) {
            inCacheValueString += (LINE_SEPARATOR + inResourceValueString);
        }

        SPRING_FACTORIES_CACHE.put(key, inCacheValueString);
    }

    private String parseString() {
        StringBuilder sb = new StringBuilder();
        for (Object key : SPRING_FACTORIES_CACHE.keySet()) {
            Object value = SPRING_FACTORIES_CACHE.get(key);

            sb.append(key).append("=").append(value).append("\n\n");
        }

        return sb.toString();
    }
}
