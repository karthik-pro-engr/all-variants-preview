# 📦 All Variants Preview

![Maven Central](https://img.shields.io/maven-central/v/io.github.karthik-pro-engr/preview)
![CI](https://github.com/karthik-pro-engr/all-variants-preview/actions/workflows/publish.yml/badge.svg)

**All Variants Preview** is a lightweight Android library that simplifies multi-orientation and UI mode previews in Jetpack Compose. It helps developers visualize their components across different device configurations — without writing repetitive preview annotations.

---

## ✨ Features

- ✅ Compose preview annotations for multiple orientations and UI modes  
- ✅ Works seamlessly with Android Studio's preview tooling  
- ✅ Minimal setup, no runtime dependencies  
- ✅ OSS-compliant metadata and automated Maven Central publishing

---

## 🤔 Why Use This?

Avoid repetitive preview annotations and improve UI testing coverage across device configurations.  
Perfect for teams building scalable Compose UI libraries.

---

## 🚀 Installation

This library is published to [Maven Central](https://central.sonatype.com/artifact/io.github.karthik-pro-engr/preview) and can be added directly to your project.

### 🔧 Gradle Kotlin DSL

```kotlin
dependencies {
    implementation("io.github.karthik-pro-engr:preview:0.3.0-rc1")
}
```

### 📦 TOML (Version Catalog)

In your `libs.versions.toml`:

```toml
[versions]
preview = "0.3.0-rc1"

[libraries]
preview = { module = "io.github.karthik-pro-engr:preview", version.ref = "preview" }
```

Then in your module:

```kotlin
implementation(libs.preview)
```

> ✅ Fully signed and verified via Sonatype Central Portal  
> ✅ Published automatically using GitHub Actions and `nmcpAggregation`

---

## 🛠️ Usage

```kotlin
@AllVariantsPreview
@Composable
fun MyComponentPreview() {
    MyComponent()
}
```

This annotation expands your preview to include:
- Portrait and landscape orientations
- Light and dark UI modes
- DayNight themes (if applicable)

---

## 📦 Artifact Details

| Artifact            | Type             | Published         |
|---------------------|------------------|-------------------|
| `preview.aar`       | Android Library  | ✅ Maven Central   |
| `preview.pom`       | Metadata         | ✅ Signed          |
| `preview.aar.asc`   | GPG Signature    | ✅ Verified        |
| `preview.aar.sha1`  | Checksum         | ✅ Included        |
| `preview.aar.md5`   | Checksum         | ✅ Included        |

---

## 🔗 Links

- 📦 [Maven Central Artifact Page](https://central.sonatype.com/artifact/io.github.karthik-pro-engr/preview)
- 🧑‍💻 [Source Code on GitHub](https://github.com/karthik-pro-engr/all-variants-preview)
- 🧪 [CI/CD Workflow](https://github.com/karthik-pro-engr/all-variants-preview/actions)
- 📜 [Changelog](https://github.com/karthik-pro-engr/all-variants-preview/blob/main/CHANGELOG.md)

> ⚠️ If your `CHANGELOG.md` link shows a 404, make sure the file is committed to the `main` branch and pushed.  
> You can verify it by browsing your repo manually or running `git log -- CHANGELOG.md`.

---

## 🤝 Support & Contributions

I’m committed to maintaining this library with professional standards and OSS best practices.  
If you face any issues, need help integrating, or want to contribute:

- 🐞 [Open an issue](https://github.com/karthik-pro-engr/all-variants-preview/issues)
- 💬 [Start a discussion](https://github.com/karthik-pro-engr/all-variants-preview/discussions)
- 📩 Reach out via GitHub if you need guidance or clarification

Your feedback is always welcome, and I’m happy to support developers using this library in real-world projects.

---

## 📄 License

Licensed under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).

---

## 🙋 Maintainer

**Karthikkumar**  
Android Developer | OSS Publisher | CI/CD Architect  
[GitHub Profile](https://github.com/karthik-pro-engr)

---
```