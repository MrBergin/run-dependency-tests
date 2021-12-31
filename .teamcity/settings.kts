import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

version = "2021.2"

project {
    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        gradle {
            tasks = ":build"
            jdkHome = "%env.JDK_11_0_x64%"
        }
    }

    triggers {
        vcs {
        }
    }
})