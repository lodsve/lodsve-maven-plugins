package lodsve.maven.plugin.shade;

import org.apache.maven.plugins.shade.relocation.Relocator;
import org.apache.maven.plugins.shade.resource.ResourceTransformer;
import org.codehaus.plexus.util.IOUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.regex.Pattern;

/**
 * 按照路径来合并文件(正则匹配).
 *
 * @author sunhao(sunhao.java @ gmail.com)
 * @version 1.0 2018/1/16 下午9:50
 */
public class RegexAppendingTransformer implements ResourceTransformer {
    private Map<String, ByteArrayOutputStream> dataMap = new HashMap<>();
    private Pattern pattern;

    public void setRegex(String regex) {
        if (regex == null || "".equals(regex)) {
            throw new IllegalArgumentException("regex must not be null!");
        }
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean canTransformResource(String resource) {
        return resource != null && pattern.matcher(resource).matches();
    }

    @Override
    public void processResource(String resource, InputStream is, List<Relocator> relocators) throws IOException {
        ByteArrayOutputStream data = dataMap.get(resource);
        if (data == null) {
            data = new ByteArrayOutputStream();
            dataMap.put(resource, data);
        }

        IOUtil.copy(is, data);
        data.write('\n');
    }

    @Override
    public boolean hasTransformedResource() {
        return !dataMap.isEmpty();
    }

    @Override
    public void modifyOutputStream(JarOutputStream jos) throws IOException {
        for (Map.Entry<String, ByteArrayOutputStream> dataEntry : dataMap.entrySet()) {
            jos.putNextEntry(new JarEntry(dataEntry.getKey()));

            IOUtil.copy(new ByteArrayInputStream(dataEntry.getValue().toByteArray()), jos);
            dataEntry.getValue().reset();
        }
    }
}
