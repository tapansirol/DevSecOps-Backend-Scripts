import hudson.model.JDK

import hudson.tools.InstallSourceProperty

import hudson.tools.ZipExtractionInstaller

def descriptor = new JDK.DescriptorImpl();

def List<JDK> installations = []

javaTools=[['name':'JDK_local', 'url':'file:/var/jenkins_home/jdk-8u181-linux-x64.tar.gz', 'subdir':'jdk1.8.0_181']]

javaTools.each { javaTool ->

    println("Setting up tool: ${javaTool.name}")

    def installer = new ZipExtractionInstaller(javaTool.label as String, javaTool.url as String, javaTool.subdir as String);

    def jdk = new JDK(javaTool.name as String, null, [new InstallSourceProperty([installer])])

    installations.add(jdk)

}

descriptor.setInstallations(installations.toArray(new JDK[installations.size()]))

descriptor.save()
