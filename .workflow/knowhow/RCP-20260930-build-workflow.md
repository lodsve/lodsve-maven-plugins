---
title: lodsve-maven-plugins — 构建 Maven 插件
type: recipe
explicitId: rcp-20260930-build-workflow
created: 2026-09-30T15:42:47.394Z
keywords:
  - workflow
  - build-workflow
  - auto-generated
sourceRef: pom.xml
lifecycleStatus: active
relatedPaths:
  - pom.xml
---

## Goal

构建 Maven 插件。

## Prerequisites

使用 JDK 11 环境，并能访问 Maven 依赖仓库。

## Steps

在项目根目录执行：

```sh
./mvnw clean install
```

## Expected Outcome

生成 javatemplate Maven 插件和 Shade 扩展 JAR，安装到本地 Maven 仓库。

## Common Pitfalls

shade 模块是扩展 JAR，不能当作独立 Maven goal 使用；本次未执行构建或消费工程测试。

## Related

- `pom.xml`
- [[architecture-constraints]]
