#!groovy

// imports
import hudson.plugins.git.*
import hudson.plugins.git.extensions.*
import hudson.plugins.git.extensions.impl.*
import jenkins.model.Jenkins

// parameters
def env = System.getenv()
def job_name = env['JENKINS_JOB_NAME']
def branch = env['GIT_BRANCH']
def repository = env['GIT_REPO_URL']
def credentialId = env['GIT_CREDENTIAL_ID']
def job_description = env['JENKINS_JOB_DESCRIPTION']

//def jobParameters = [
//  name:          'MyJob',
//  description:   'Build of my STG environment : https://stg.mycompany.com',
//  repository:    'https://github.com/tapansirol/jpet-store.git',
//  branch:        'master',
//  credentialId:  'test-github'
//]

// define repo configuration
def branchConfig                =   [new BranchSpec(branch)]
def userConfig                  =   [new UserRemoteConfig(repository, null, null, credentialId)]
def cleanBeforeCheckOutConfig   =   new CleanBeforeCheckout()
def sparseCheckoutPathConfig    =   new SparseCheckoutPaths([new SparseCheckoutPath("Jenkinsfile")])
def cloneConfig                 =   new CloneOption(true, true, null, 3)
def extensionsConfig            =   [cleanBeforeCheckOutConfig,sparseCheckoutPathConfig,cloneConfig]
def scm                         =   new GitSCM(userConfig, branchConfig, false, [], null, null, extensionsConfig)

// define SCM flow
def flowDefinition = new org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition(scm, "Jenkinsfile")

// set lightweight checkout
//flowDefinition.setLightweight(true)

// get Jenkins instance
Jenkins jenkins = Jenkins.getInstance()

// create the job
def job = new org.jenkinsci.plugins.workflow.job.WorkflowJob(jenkins,job_name)

// define job type
job.definition = flowDefinition

// set job description
job.setDescription(job_description)

// save to disk
jenkins.save()
jenkins.reload()
