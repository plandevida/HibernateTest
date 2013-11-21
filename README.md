HibernateTest
=============

Prueba de concepto de hibernate, se puede ver como se configura hibernate y las entidades que se van a persistir.

Requisitos
----------

1) JDK 1.7
2) MySql 5.* instalado en el sistema.
3) Libreías de hibernate-4 (http://sourceforge.net/projects/hibernate/files/hibernate4/)

Instalación
-----------

1) Crear un usuario llamado 'hibernate' en MySql.
2) Ejecutar el script 'scriptBBDD.sql': 
    2.1) mysql -uhibernate < scriptBBDD.sql o utilizando MySql workbrenck (http://dev.mysql.com/downloads/tools/workbench/).
3) El el BuildPath del proyecto añadis todas las librerías de hibernate que están bajo el directorio 'dist' menos las de la carpeta de clustering.

Eclipse
-------

Importar el proyecto hibernateTest si se quiere ver un proyecto funcionando bajo hibernate (sin anotaciones).

Importar el proyecto jpaHibernate si se quiere ver un proyecto funcionando bajo jpa y hibernate (con anotaciones).

Omitir jpaEclipseLink.
