---
title: "Architecture Constraints"
readMode: required
priority: high
category: arch
keywords:
  - architecture
  - module
  - layer
  - boundary
  - dependency
  - structure
---

# Architecture Constraints

## Module Structure

## Layer Boundaries

## Dependency Rules

## Technology Constraints

## Entries



<spec-entry category="arch" keywords="" date="2026-09-30" sid="S-20260930-lw7g" title="Mojo 与 Shade 扩展边界" sourceRef="lodsve-javatemplate-maven-plugin/src/main/java/com/lodsve/maven/plugin/javatemplate/GenerateSourcesMojo.java" relatedPaths="lodsve-javatemplate-maven-plugin/src/main/java/com/lodsve/maven/plugin/javatemplate/GenerateSourcesMojo.java">

### Mojo 与 Shade 扩展边界

GenerateSourcesMojo 与 GenerateTestSourcesMojo 继承 AbstractGenerateSourcesMojo，共享模板过滤逻辑并分别注册主源码和测试源码目录；RegexAppendingTransformer、SpringFactoriesResourceTransformer 实现 ResourceTransformer，作为 Shade 插件扩展 JAR。保持 goal 名、参数、输出目录与 Transformer 类名兼容。

证据：`lodsve-javatemplate-maven-plugin/src/main/java/com/lodsve/maven/plugin/javatemplate/GenerateSourcesMojo.java`。

</spec-entry>
