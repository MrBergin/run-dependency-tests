package dev.mrbergin.rdt

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Suppressing unused as this is the main class and not intended to be instantiated directly.
 */
@Suppress("unused")
class RunDependencyTestsPlugin: Plugin<Project> {
    override fun apply(target: Project) {
    }
}


