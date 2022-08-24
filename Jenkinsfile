pipeline {
  agent any
  stages {
    stage('检出') {
      steps {
        echo '开始检出...'
        checkout([
          $class: 'GitSCM',
          branches: [[name: env.GIT_BUILD_REF]],
          userRemoteConfigs: [[url: env.GIT_REPO_URL, credentialsId: env.CREDENTIALS_ID]]
        ])
        echo '结束检出...'
      }
    }

    stage('推送部署GITEE') {
      steps {
        echo '正在推送文件到GITEE...'
        //项目稳定后创建目录树的方法执行一次就可以了
        //sh 'chmod +x ./createTreeMD.sh'
        //sh 'bash ./createTreeMD.sh'
        sh 'git fetch https://lingwh1995:${GITEE_TOKEN}@gitee.com/lingwh1995/springcloud-eureka.git'
        sh 'git push -f https://lingwh1995:${GITEE_TOKEN}@gitee.com/lingwh1995/springcloud-eureka.git HEAD:master'
        //sh 'git fetch https://lingwh1995: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@github.com/lingwh1995/springcloud-eureka.git'
        //sh 'git push -f https://lingwh1995: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@github.com/lingwh1995/springcloud-eureka.git HEAD:master'
        echo '完成文件推送到GITEE...'
      }
    }

  }
}