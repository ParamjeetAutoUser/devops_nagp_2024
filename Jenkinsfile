pipeline{
    agent any
    tools{
        maven 'Maven'
    }
    stages{
        stage("code checkout"){
            steps{
            bat "echo codecheckout hello"
            }
        }   
        stage("code build"){
            steps{
            bat "mvn clean"
            }
        }
        stage("unit test"){
            steps{
            bat "mvn test"
            }
        }
        stage("Sonar Analysis"){
            steps{
            withSonarQubeEnv("Test_SonarQube")
                {
		    bat "echo Sonar Run"
                        bat "mvn org.sonarsource.scanner.maven:sonar-maven-plugin:4.0.0.4121:sonar"        
                }
            }
        }
	    stage("Publish to Artifactory"){
            steps{
                rtMavenDeployer(
                    id: 'deployer',
                    serverId: '3145614@artifactory',
                    releaseRepo: 'nagp.session.2024',
                    snapshotRepo: 'nagp.session.2024'
                )
                rtMavenRun(
                    pom: 'pom.xml',
                    goals: 'clean install',
                    deployerId: 'deployer'
                    )
                rtPublishBuildInfo(
                    serverId:'3145614@artifactory',
                )
            }        
        }
 
    }
    post{
        success{
            bat "echo success"
            }
        }
}