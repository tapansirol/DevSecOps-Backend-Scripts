import jenkins.model.*
import groovy.json.JsonSlurper
import com.ibm.devops.connect.DevOpsGlobalConfiguration

//import urbancode.jenkins.plugins.ucdeploy.*

def ucvConfig = Jenkins.instance.getDescriptor('com.ibm.devops.connect.DevOpsGlobalConfiguration');
ucvConfig.setSyncId("test-id")
ucvConfig.setSyncToken("test-token")
ucvConfig.setCredentialsId("uvelocity")
ucvConfig.setBaseUrl("https://localhost")
ucvConfig.save()

