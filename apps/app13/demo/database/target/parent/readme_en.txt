	Instructions for initializing and updating the database for "DigitalQ Platform"

	Requirements.

1. To initialize the database, you need to install one of the supported database servers:
	* MS SQL Server 2008 - 2016
	* Oracle 11g, 12c
	* PostgreSQL 9.5, 10.4, 12.1

Make sure case insensitive collation is selected when installing MS SQL Server.
It is important! The platform does not support case sensitive collations.

2. In Oracle, each microservice uses its own database and user to access it.
   During initialization, the database and the user can be created programmatically, or can be manually created by the administrator in advance.
   MS SQL Server and PostgreSQL use one common database manually created by the administrator.
   Each microservice uses its own schema in the specified database and user to access the specified schema.
   During initialization, the schema and the user can be created programmatically, or can be manually created by the administrator in advance.

   To programmatically create the database and user in the case of Oracle or the database and user schema (and delete them if necessary)
   You need to know the login and password of the database administrator, he must have the db_owner role.

3. Before updating the database, it is recommended to make a full backup of all data.

4. The user on Oracle must have the rights to execute DBMS_LOCK (if the user is created by the DB Administrator, then he must have the right to grant this privilege to the object).

5. Operationg order

To initialize the database under "DigitalQ Platform", run the dm.bat file (or dm.sh in the linux operating system)
Command line format:

dm.bat [commands] [options]

The init script understands the following commands:

	-d or drop - drops an existing database (Oracle) or database schema (MS SQL Server and PostgreSQL)
	-c or create - creates database and user (Oracle) or schema and user (MS SQL Server and PostgreSQL)
	-i or init - initializes the database (creates tables, indexes, etc.)
	-u or update - updates the database structure to the current version.
	-v or validate - checks the compliance of the database structure with the current version. This command is the default.

The following options must be passed to the initialization script:

	--url = <url> - sets the JDBC URL to access the database
	--driver = <driverClassname> - sets the name of the JDBC driver class for accessing the database (you can omit it for supported ones)
	--username = <username> - sets the name of the user who will be created and which should be used to connect to the database
	--password = <password> - sets the user's password, by default: the same as the username
	--admin = <username> - specifies the name of the superuser who has rights to create databases, tables, etc.
	--adminPassword = <password> - sets the superuser password.
	--database = <databaseName> - specifies the name of the database to create, delete, check or initialize (for Oracle, database name = schema name = username)
	--schema = <schemaName> - sets the name of the database schema (for MS SQL Server and PostgreSQL)
	--sqlFile = <file> - specifies the name of the file into which the SQL script will be written for execution. The database will not be changed.
	--sqlFileEncoding = <encoding> - encoding for a file with SQL script, UTF-8 encoding is used by default
	--logLevel = <all | finest | finer | fine | info | warning | severe | off> - sets the log level
	--logFile = <file> - sets the file name for saving logs. By default, logs are output to the console.
	--locale = <locale> - sets the alpha code of the locale to install the distribution data (by default ru)
	-Dmastername = <sys> - schema name for MSSQL, if the name is different from sys, in the master database (for example -Dmastername = dbo)
	-Ddefaulttablespace = <users> - default tablespace for Oracle, you must specify if the name is different from users (for example -Ddefaulttablespace = myuser)
	-Dtemptablespace = <temp> - temp tablespace for Oracle, must be specified if the name is different from temp (for example -Dtemptablespace = mytemp)
	-D <propertyName> = <propertyValue> - set additional parameters required for initializing or updating the database

If the script works successfully, you will receive a corresponding message at the end.
Otherwise, you will receive an error message.

6. Examples.

Oracle:

        Create and initialize a fresh DB, if the database already exists, delete it:

	dm.bat -d -c -i --url=jdbc:oracle:thin:@OracleHost:1521:OracleSID --database=example1 --username=example --password=examplepass  --admin=system --adminPassword=secret

	Upgrade an existing database to the current version:

	dm.bat -u --url=jdbc:oracle:thin:@OracleHost:1521:OracleSID --database=example1 --username=example --password=examplepass

* Note that in Oracle the username and the database name are the same,
therefore the username option has no effect, the program will create a user with the name given by the database option.

* Note that for Orcale to create a database, the admin login must have administrative rights,
but not equal to SYS
	
MSSQL:

	Create and initialize the database schema "from scratch", if the database schema already exists, delete it:
	
	dm.bat -d -c -i --url=jdbc:jtds:sqlserver://MSSQLHost:1433 --database=example1 --schema=example2 --username=exowner1 --password=exownerpass1 --admin=sa --adminPassword=secret  -Dmastername=dbo
	
	Upgrade an existing database to the current version:

	dm.bat -u --url=jdbc:jtds:sqlserver://MSSQLHost:1433/example1 --database=example1 --schema=example2 --username=sa --password=secret 	

* Please note that the creation of the database is performed in advance by the administrator.

PostgreSQL:

	Create and initialize the database schema "from scratch", if the database schema already exists, delete it:
	
	dm.bat -d -c -i --url=jdbc:postgresql://PostgreSQLHost:5432 --database=example1 --schema=example2 --username=exowner1 --password=exownerpass1 --admin=postgres --adminPassword=secret --driver=org.postgresql.Driver

	Initialize the database schema from scratch *:

	dm.bat -i --url=jdbc:postgresql://PostgreSQLHost:5432 --database=example1 --schema=example2 --username=exowner1 --password=exownerpass1 --driver=org.postgresql.Driver

	Update the existing database schema to the current version:

	dm.bat -u --url=jdbc:postgresql://PostgreSQLHost:5432 --database=example1 --schema=example2 --username=exowner1 --password=exownerpass1 --driver=org.postgresql.Driver

* Please note that the name of the database, schema and username must be set in lowercase

* Please note that the creation of the database is performed in advance by the administrator.

* Please note that administrator credentials (admin and adminPassword) are required to create and delete a database schema and user.
  If the DB schema and the user are created by the administrator in advance, then to create schema elements (tables, indexes, stored procedures and functions)
  just execute the initialization (-i) or update (-u) command
