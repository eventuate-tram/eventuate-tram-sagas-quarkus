import org.apache.tools.ant.filters.ReplaceTokens
import org.gradle.api.Plugin
import org.gradle.api.Project

class SetEventuateDatabasePlugin implements Plugin<Project> {

    void apply(Project project) {
        project.processTestResources {
            outputs.upToDateWhen { false }
            filter ReplaceTokens, tokens: ["EVENTUATEDATABASE": System.env.EVENTUATEDATABASE ?: "mysql"]
        }

    }
}
