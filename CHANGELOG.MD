# 📜 Changelog

All notable changes to this project will be documented in this file.

This project adheres to [Semantic Versioning](https://semver.org/).

---

## [0.3.0-rc1] - 2025-09-10

### Added
- Automated publishing to Maven Central via GitHub Actions
- Integration with `com.gradleup.nmcp.aggregation` for ZIP-based deployment
- Root-level signing using in-memory GPG keys
- OSS-compliant metadata (license, developer, SCM, etc.)
- CI workflow with tag-triggered release and secrets validation

### Changed
- Migrated from `com.vanniktech.maven.publish` to `nmcpAggregation`
- Refactored module publishing logic to use `singleVariant("release")`

---

## [0.2.0] - 2025-09-05

### Added
- Manual publishing setup using legacy staging repository
- Initial Maven Central release with signed `.aar` and metadata
- Preview annotations for Compose UI components

---

## [0.1.0] - 2025-08-30

### Added
- First public release of All Variants Preview
- Support for multi-orientation and UI mode previews
- Compose annotation processor for preview expansion
