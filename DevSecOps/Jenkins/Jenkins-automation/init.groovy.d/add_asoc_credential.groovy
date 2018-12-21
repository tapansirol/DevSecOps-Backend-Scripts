import com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl
import com.cloudbees.plugins.credentials.domains.Domain
import com.cloudbees.plugins.credentials.CredentialsScope
import jenkins.model.Jenkins
import com.ibm.appscan.jenkins.plugin.auth.ASoCCredentials

def env = System.getenv()
def id = env['ASOC_ID']
def secret = env['ASOC_SECRET']
def domain = Domain.global()
def store = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()
def asocCredential = new ASoCCredentials("ASOC_Staging", "Credential for ASOC", id, secret)
store.addCredentials(domain, asocCredential)
