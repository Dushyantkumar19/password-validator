pipeline{
	agent any
	stages {
	  stage ('Compile Stage') {
		steps {
		  withMaven(maven : 'apache-maven-3.5.0') {
			bat 'mvn clean compile'
		  }
		}
	  }
	  stage ('Testing Stage') {
		steps {
		  withMaven(maven : 'apache-maven-3.5.0') {
			bat 'mvn test'
		  }
		}
	  }
	  stage ('Deploy Stage') {
		steps {
		  withMaven(maven : 'apache-maven-3.5.0') {
			bat 'mvn deploy'
		  }
		}
	  }
	}
}
