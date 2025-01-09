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
            url: "",
            checksum: "0529daea00462d986c6b4f1d8c83dcdc3134e101b1fb153953254e6b64588994"
        )
    ]
)