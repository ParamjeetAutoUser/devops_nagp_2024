node{
    try{
        stage('Checkout'){
            echo 'Cloning the repo'
            git branch: 'master', url:'https://github.com/ParamjeetAutoUser/devops_nagp_2024.git'
        }
        stage('Build'){
            echo 'Building out code'
            bat 'mvn install'
        }
        stage('Test'){
            echo 'Testing out code'
            bat 'mvn clean test'
        }
        echo 'Build Success !!!'
    }
    catch(Exception e){
        echo 'Build got failed'
    }
    finally{
        echo 'This block is always going to execute'
    }
}