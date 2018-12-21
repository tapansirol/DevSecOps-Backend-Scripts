import com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl
import com.cloudbees.plugins.credentials.domains.Domain
import com.cloudbees.plugins.credentials.CredentialsScope
import jenkins.model.Jenkins

def env = System.getenv()
def uvelocity_user_name = env['UCV_USER_NAME']
def uvelocity_password = env['UCV_PASSWORD']

def domain = Domain.global()
def store = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()
def credential = new UsernamePasswordCredentialsImpl(
        CredentialsScope.GLOBAL, "uvelocity", "required to integrate uvelocity",
        uvelocity_user_name,
        uvelocity_password
)

store.addCredentials(domain, credential)

