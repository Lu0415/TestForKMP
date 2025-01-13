// swift-tools-version:5.3
import PackageDescription

let package = Package(
    name: "Shared",
    platforms: [
        .iOS(.v14),
    ],
    products: [
        .library(name: "shared", targets: ["shared"])
    ],
    targets: [
        .binaryTarget(
            name: "shared",
            url: "https://github.com/Lu0415/TestForKMP/releases/tag/1.0.3#:~:text=shared.xcframework.zip",
            checksum: "0529daea00462d986c6b4f1d8c83dcdc3134e101b1fb153953254e6b64588994"
        )
    ]
)
