# Demo-for-jarsoft RU

##Инициализация 

В файле localserver\webapps\ROOT\WEB-INF\web.xml


..
     <filter>       
     
     <filter-name>ConnectionFilter</filter-name>
        <filter-class>jarsoft.filters.ConnectionFilter</filter-class>
        <init-param>
            <param-name>CREATE_SAMPLE_DATA</param-name>  //Изменить значение на Y, для создание демо данных
            <param-value>Y</param-value>                 //N-> Y
        </init-param>
        <init-param>
            <param-name>DB_NAME</param-name>          //Имя базы данных
            <param-value>db.shop.online</param-value> //рекомендую изменить на свое
        </init-param>
        <init-param>
            <param-name>HOST_NAME</param-name>        //Расположение базы
            <param-value>localhost</param-value>
        </init-param>
        <init-param>
            <param-name>PORT</param-name>           //Изменить если отличается от действительного
            <param-value>3306</param-value>
        </init-param>
        <init-param>
            <param-name>USER_NAME</param-name>      //Пользователь бд
            <param-value>root</param-value>
        </init-param>
        <init-param>
            <param-name>USER_PASSWORD</param-name>  //Пароль 
            <param-value>root</param-value>
        </init-param>
        <init-param>
            <param-name>URL_CONNECTION</param-name>  //Mysql , драйвер уже добавлен в приложение
            <param-value>jdbc:mysql://</param-value>
        </init-param>
    </filter> ...

 
##Компиляция
    
    Выполнить команду ant build.xml из корня приложения.
    
   
##Запуск приложения
    
    Выпонить команду catalina.(bat/sh) run из .\localserver\bin 
    
    
##Перейти в браузер

   localhost:8080
 
