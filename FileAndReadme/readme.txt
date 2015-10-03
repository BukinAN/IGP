Инструкция по установке web приложения IGP (ImproveGroupProject)

Для установки программы IGP, поместите файл IGP.war в папку webapps в директории сервера tomcate. 
После этого, через командную строку cmd, перейдите в bin директорию tomcat. 
Для этого в cmd наберите, например cd C:\путь\apache-tomcat-7.0.64\bin. 
После этого введите в командную строку cmd комманду catalina run. 
После этого доступ к приложению в браузере можно получить, введя в адресную строку localehost:8080/IGP. 
Если порт в tomcate не 3306, его нужно изменить в файле jdbc. Как это сделать смотрите ниже. 
По умолчанию вам откроется меню поиска с таблицей, в которой будет отображено всё содержимое таблицы prod. 
Для поиска по этому перечню введите параметры поиска, с учётом регистра данных.
В приложении по умолчанию используется база данных MySQL, в кодировке UTF-8. Имя пользователя pricelistclient, пароль 12345, имя базы данных pricelistclient. 
Для изменения этих параметров и параметров порта пройдите в папку webapps в tomcate. 
Далее следуйте по пути IGP\WEB-INF\classes, откройте файл jdbc и замените соответствующие параметры.
Содержимое jdbc по умолчанию:
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.dialect=org.hibernate.dialect.MySQL5Dialect
jdbc.databaseurl=jdbc:mysql://localhost:3306-порт/pricelistclient-имя базы данных?autoReconnect=true&useEncoding=true&characterEncoding=UTF-8
jdbc.username=pricelistclient-имя пользователя
jdbc.password=12345-пароль
