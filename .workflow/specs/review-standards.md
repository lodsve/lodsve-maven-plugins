---
title: "Review Standards"
readMode: required
priority: medium
category: review
keywords:
  - review
  - checklist
  - gate
  - approval
  - standard
---

# Review Standards

## Entries



<spec-entry category="review" keywords="" date="2026-09-30" sid="S-20260930-mc2o" title="插件质量与兼容性" sourceRef="pom.xml" relatedPaths="pom.xml">

### 插件质量与兼容性

沿用父 POM 中 Checkstyle、PMD 和许可证检查，规则由 tools/ 维护。编译配置使用 JDK 11 profile，Maven API 依赖版本为 3.6.3；此 API 版本与 Wrapper 的 Maven 3.8.7 不混为一谈。

证据：`pom.xml`。

</spec-entry>
