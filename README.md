# GLSLC

GLSL shader version conversion tool

### Versions

| GLSL        | OpenGL    | Code      | Status |
|-------------|-----------|-----------|--------|
| 1.20 → 1.50 | 2.1 → 3.2 | 120 → 150 | DONE   |
| 1.50 → 1.20 | 3.2 → 2.1 | 150 → 120 | TODO   |

# GRAB IT TODAY

In `build.gradle` add:

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.SnakerBone:glslc:${glslcVersion}'
}
```

In `gradle.properties` (or similar) add:

```properties
# Replace with your desired version
glslVersion=1.0.1
```