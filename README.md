# Demo-for-jarsoft RU

##MySQL download

<http://www.mysql.ru/download/>

##initialization  

After you have downloaded and installed Mysql server.
File localserver\webapps\ROOT\WEB-INF\web.xml must be cofigured.
in order for sample data to be added, you need to change the value of the parameter "CREATE_SAMPLE_DATA" to Y.
The remaining parameters are not required to change.

..
     <filter>       
     
     <filter-name>ConnectionFilter</filter-name>
        <filter-class>jarsoft.filters.ConnectionFilter</filter-class>
        <init-param>
            <param-name>CREATE_SAMPLE_DATA</param-name>  //
            <param-value>Y</param-value>                 //N-> Y
        </init-param>
        <init-param>
            <param-name>DB_NAME</param-name>          //
            <param-value>db.shop.online</param-value> //
        </init-param>
        <init-param>
            <param-name>HOST_NAME</param-name>      //database location
            <param-value>localhost</param-value>
        </init-param>
        <init-param>
            <param-name>PORT</param-name>           //location of sqllistner
            <param-value>3306</param-value>
        </init-param>
        <init-param>
            <param-name>USER_NAME</param-name>      //user's name sql database 
            <param-value>root</param-value>
        </init-param>
        <init-param>
            <param-name>USER_PASSWORD</param-name>  //user's password 
            <param-value>root</param-value>
        </init-param>
        <init-param>
            <param-name>URL_CONNECTION</param-name>  //Mysql , already exists in project
            <param-value>jdbc:mysql://</param-value>
        </init-param>
    </filter> ...
    
##Start server
    
    From {project root}\localserver\bin 
  
     catalina.(bat/sh) run 
  
     it start the server on 8080 port with namelocal host
     
 
 ##Deploing application 
   
     From {project root} in command line 
     
     mvn tomcat7:deploy
     
##Undeploy

    mvn tomcat7:undeploy
     
##In browser 

Once server started and project deployd you can find the app in browser.

     

   url: <http://localhost:8080/demo>
 
 
 

my email: <konszhog@gmail.com>
