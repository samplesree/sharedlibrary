def call(ip,warfile,creds){
   //  install ssh agent plugin
   sshagent(['tomcat-dev']) {
  // copy war file to tomcat-dev server
  sh "scp -o StrictHostKeyChecking=no target/${warfile} ec2-user@${ip}:/opt/apache9/webapps"
  // restart tomcat 
  sh "ssh ec2-user@${ip} /opt/apache9/bin/shutdown.sh"
  sh "ssh ec2-user@${ip} /opt/apache9/bin/startup.sh"
   }
}
