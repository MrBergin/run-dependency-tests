import org.gradle.api.GradleException
import org.gradle.api.artifacts.Dependency
import org.gradle.api.internal.artifacts.dependencies.AbstractModuleDependency
import org.gradle.api.tasks.testing.Test

typealias NamesAndDependencies = List<Pair<String, Dependency>>

fun Test.includeTestsFrom(vararg moduleDependencies: String) = with(project) {
    val dependencies = moduleDependencies.map { it to dependencies.create(it) }
        .ensureAllModuleDependencies()
        .toTypedArray()
    val configuration = configurations.detachedConfiguration(*dependencies)
    val nonTransitiveConfiguration = configurations.detachedConfiguration(*dependencies).setTransitive(false)
    testClassesDirs += zipTree(nonTransitiveConfiguration.singleFile)
    classpath += configuration
}

private fun NamesAndDependencies.ensureAllModuleDependencies(): List<Dependency> {
    val nonModuleDependencies = filter { it.second !is AbstractModuleDependency }
    if (nonModuleDependencies.isNotEmpty()) {
        val nonModuleDependencyNames = nonModuleDependencies.map { it.second }.joinToString(", ")
        throw GradleException("Only module dependencies are supported, cannot process $nonModuleDependencyNames")
    }
    return map { it.second }
}