import com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl
import com.cloudbees.plugins.credentials.domains.Domain
import com.cloudbees.plugins.credentials.CredentialsScope
import jenkins.model.Jenkins

def env = System.getenv()
def credentialId = env['GIT_CREDENTIAL_ID']
def git_username = env['GIT_USERNAME']
def git_token = env['GIT_TOKEN']
def domain = Domain.global()

def store = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()
def githubAccount = new UsernamePasswordCredentialsImpl(
        CredentialsScope.GLOBAL, credentialId, "Test Github Account",
        git_username,
        git_token
)
store.addCredentials(domain, githubAccount)

