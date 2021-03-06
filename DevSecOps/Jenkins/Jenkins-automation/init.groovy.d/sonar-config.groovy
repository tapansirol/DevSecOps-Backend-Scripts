import jenkins.model.*
import groovy.json.JsonSlurper
import hudson.plugins.sonar.SonarInstallation
import hudson.plugins.sonar.SonarRunnerInstallation
import hudson.plugins.sonar.SonarRunnerInstaller
import hudson.plugins.sonar.model.TriggersConfig
import hudson.tools.InstallSourceProperty

def env = System.getenv()
def ip = env['HOST_IP']
def port = env['SONAR_PORT']
def sonarHost = "http://" + ip + ":" + port
def token = System.getenv("SONAR_AUTH_TOKEN");

def sonarConfig = Jenkins.instance.getDescriptor('hudson.plugins.sonar.SonarGlobalConfiguration')

SonarInstallation sonarInst = new SonarInstallation(
        "sonar-server", sonarHost, token, "", "", new TriggersConfig(), "")
sonarConfig.setInstallations(sonarInst)
sonarConfig.setBuildWrapperEnabled(true)
sonarConfig.save()
