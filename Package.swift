// swift-tools-version:5.3
import PackageDescription

let package = Package(
    name: "shared",
    platforms: [
        .iOS(.v14),
    ],
    products: [
        .library(name: "shared", targets: ["shared"])
    ],
    targets: [
        .binaryTarget(
            name: "shared",
            url: "https://github.com/Lu0415/TestForKMP/releases/tag/1.0.0#:~:text=shared.xcframework.zip",
            checksum: "7442e368a0ad36936bedfc36b57a8ce2140318dfec89344d5183d14bc09cc673"
        )
    ]
)
