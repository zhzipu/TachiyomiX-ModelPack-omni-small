# TachiyomiX Model Pack — Omni Small 模型

[TachiyomiX](https://github.com/zhzipu/TachiyomiX) 的图像增强模型包插件（单模型，独立分发）。

## 信息

- 模型 ID：`omni-small`
- 包名：`com.tachiyomix.modelpack.omnismall`
- 阅读器里的模型名：`Omni Small (HFA2k SPAN) x2`（模型一栏的 chip 文字）
- 说明：SPAN 2x 动漫超分（权重 2xHFA2kSPAN）。该插件位原本计划用 OmniSR 的 2xHFA2OmniSR，实测 pnnx 无法转换该架构（崩在 0xC0000005，且动态插值会被烘成固定尺寸），故改用同作者、同 HFA2k 数据集的 SPAN 版本；完整记录见主仓库 `.workbuddy/enhance-packs/README.md` §5.2。
- 权重来源：Philip Hofmann — 2xHFA2kSPAN（HFA2k 数据集，27'000 iterations / epoch 24 / batch 12，预训练 2x-span-anime-pretrain）
- 许可：CC BY 4.0（详见 `src/main/assets/omni-small/ATTRIBUTION.txt`）

## 构建

```bash
./gradlew assembleRelease
```

产物位于 `build/outputs/apk/release/TachiyomiX-modelpack-omni-small-release.apk`（单模块工程，没有 flavor 子目录）。
构建需要 Android SDK（`compileSdk 37`）与 `ANDROID_HOME`（或 `local.properties` 里的 `sdk.dir`）。

## 安装与使用

把构建出的 APK 装到设备后，打开 TachiyomiX → `设置 → 高级 → 模型包` 应当能看到「Omni Small 模型」；
阅读器内 →「增强设置」→ **模型**一栏选 `Omni Small (HFA2k SPAN) x2`。

> 注意：如果阅读器里的「处理后端」选的是 **骁龙 NPU**，列表只会显示声明支持 NPU 的模型；
> 本包没有 QNN context（`supportsNpu: false`），此时会看不到它 —— 把后端切回 **Vulkan** 即可。

## 许可证

模型文件版权归原作者所有，仅用于学习与研究，请遵循模型自身的许可证（见 `ATTRIBUTION.txt`）。
