plugins {
    id("dev.kikugie.stonecutter")
    alias(libs.plugins.loom) apply false
}

stonecutter active "1.21.8"


// See https://stonecutter.kikugie.dev/wiki/config/params
stonecutter parameters {
    swaps["mod_version"] = "\"${property("mod.version")}\";"
    swaps["mod_id"] = "\"" + property("mod.id") + "\""
    swaps["minecraft"] = "\"${node.metadata.version}\";"

    replacements {
        string(current.parsed >= "1.21.11") {
            replace("ResourceLocation", "Identifier")
        }
    }
}
