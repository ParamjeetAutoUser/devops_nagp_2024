pipeline{
  agent any
  tools{
     maven 'MAVEN_HOME'
  }
  stages{
    stage("Checkout"){
      steps{
        checkout scm
      }
    }
    stage("Build"){
      steps{
       bat 'mvn clean'
      }
    }
    stage("Test"){
      steps{
       bat 'mvn test'
      }
    }
    stage("TestNGReport"){
      steps{
       testNG()
      }
    }
    stage("SonarQube"){
      steps{
        withSonarQubeEnv("Test_SonarQube"){
          bat "mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.8.0.2131:sonar" 
        }
      }
    }    
    stage("Upload to Artifactory"){
      steps{
        rtMavenDeployer(
            id:'deployer',
            serverId: '3145614@artifactory',
            releaseRepo: 'nagp.session.2025',
            snapshotRepo: 'nagp.session.2025'
        )
        rtMavenRun(
            pom:'pom.xml',
            goals: 'clean install',
            deployerId: 'deployer'
        )
        rtPublishBuildInfo(
            serverId:'3145614@artifactory'
        )
      }
    }
  }
 }
