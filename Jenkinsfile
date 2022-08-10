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
    stage('推送部署') {
      steps {
        echo '正在推送文件...'
        echo '${GIT_COMMIT_MSG}'
        sh 'git fetch https://lingwh1995:${GITEE_TOKEN}@gitee.com/lingwh1995/springcloud-eureka.git'
        sh 'git push -f https://lingwh1995:${GITEE_TOKEN}@gitee.com/lingwh1995/springcloud-eureka.git HEAD:master'
        //sh 'git fetch https://lingwh1995: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@github.com/lingwh1995/springcloud-eureka.git'
        //sh 'git push -f https://lingwh1995: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@github.com/lingwh1995/springcloud-eureka.git HEAD:master'
        echo '完成文件推送...'
      }
    }

    stage('触发books项目自动拉取代码') {
      steps {
        echo '开始触发books项目自动拉取代码...'
        echo '${GIT_COMMIT_MSG}'
        sh 'curl -u pt240hr5ts6t:df61408cd010ca57dd252761885b64830c389c05 \
                   -v -X POST  'https://lingwh.coding.net/api/cci/job/1474425/trigger' \
                   -H 'Content-Type: application/json' \
                   -d '
                    {
                    "ref": "master",
                    "envs": [
                        {
                            "name": "GITEE_TOKEN",
                            "value": "04cacc5f135e93b1ed679462a55260b7",
                            "sensitive": 0
                        }
                    ]
                }''
        echo '完成触发books项目自动拉取代码...'
      }
    }


  }
}