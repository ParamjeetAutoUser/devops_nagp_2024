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
          bat 'mvn sonar:sonar'
        }
      }
    }
    stage("Upload to Artifactory"){
      steps{
        rtMavenDeployer(
            id:'deployer',
            serverId: '3145614@artifactory',
            releaseRepo: 'nagp.session.2024',
            snapshotRepo: 'nagp.session.2024'
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
