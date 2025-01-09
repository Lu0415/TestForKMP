// swift-tools-version:5.3
import PackageDescription

let package = Package(
    name: "Shared",
    platforms: [
        .iOS(.v14),
    ],
    products: [
        .library(name: "Shared", targets: ["Shared"])
    ],
    targets: [
        .binaryTarget(
            name: "Shared",
            url: "https://github.com/Lu0415/TestForKMP/releases/tag/1.0.0#:~:text=shared.xcframework.zip",
            checksum: "7442e368a0ad36936bedfc36b57a8ce2140318dfec89344d5183d14bc09cc673"
        )
    ]
)
