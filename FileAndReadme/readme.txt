���������� �� ��������� web ���������� IGP (ImproveGroupProject)

��� ��������� ��������� IGP, ��������� ���� IGP.war � ����� webapps � ���������� ������� tomcate. 
����� �����, ����� ��������� ������ cmd, ��������� � bin ���������� tomcat. 
��� ����� � cmd ��������, �������� cd C:\����\apache-tomcat-7.0.64\bin. 
����� ����� ������� � ��������� ������ cmd �������� catalina run. 
����� ����� ������ � ���������� � �������� ����� ��������, ����� � �������� ������ localehost:8080/IGP. 
���� ���� � tomcate �� 3306, ��� ����� �������� � ����� jdbc. ��� ��� ������� �������� ����. 
�� ��������� ��� ��������� ���� ������ � ��������, � ������� ����� ���������� �� ���������� ������� prod. 
��� ������ �� ����� ������� ������� ��������� ������, � ������ �������� ������.
� ���������� �� ��������� ������������ ���� ������ MySQL, � ��������� UTF-8. ��� ������������ pricelistclient, ������ 12345, ��� ���� ������ pricelistclient. 
��� ��������� ���� ���������� � ���������� ����� �������� � ����� webapps � tomcate. 
����� �������� �� ���� IGP\WEB-INF\classes, �������� ���� jdbc � �������� ��������������� ���������.
���������� jdbc �� ���������:
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.dialect=org.hibernate.dialect.MySQL5Dialect
jdbc.databaseurl=jdbc:mysql://localhost:3306-����/pricelistclient-��� ���� ������?autoReconnect=true&useEncoding=true&characterEncoding=UTF-8
jdbc.username=pricelistclient-��� ������������
jdbc.password=12345-������
