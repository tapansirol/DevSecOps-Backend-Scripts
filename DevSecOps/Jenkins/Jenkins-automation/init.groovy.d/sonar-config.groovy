import jenkins.model.*
import groovy.json.JsonSlurper
import hudson.plugins.sonar.SonarInstallation
import hudson.plugins.sonar.SonarRunnerInstallation
import hudson.plugins.sonar.SonarRunnerInstaller
import hudson.plugins.sonar.model.TriggersConfig
import hudson.tools.InstallSourceProperty


def env = System.getenv()
def ip = env['IP']
def sonar_port = env['SONAR_PORT']

//Creating sonar server url
sonar_url = 'http://'+ ip + ':' + sonar_port

//Retrieving  sonar sonar authentication token. This is the token generated through shell script and set as environment variable
def token = System.getenv("SONAR_AUTH_TOKEN");

def sonarConfig = Jenkins.instance.getDescriptor('hudson.plugins.sonar.SonarGlobalConfiguration')

SonarInstallation sonarInst = new SonarInstallation(
        "sonar-server", sonar_url, token, "", "", new TriggersConfig(), "")
sonarConfig.setInstallations(sonarInst)
sonarConfig.setBuildWrapperEnabled(true)
sonarConfig.save()

