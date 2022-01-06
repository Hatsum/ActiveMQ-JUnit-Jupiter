Welcome to ActiveMQ :: JUnit Jupiter
=======================================================================
*ActiveMQ :: JUnit Jupiter* is a fork of *Apache ActiveMQ :: JUnit Rule* that 
add support off JUnit 5 Jupiter.

:warning: Only the `EmbeddedActiveMQBroker` class has been tested.

Getting Started
===============

Embed an ActiveMQ broker into your tests with the following lines:
```java
    @RegisterExtension
    final public EmbeddedActiveMQBroker broker = new EmbeddedActiveMQBroker();
```

Licensing
=======================================================================

   This software is licensed under the terms you may find in the file 
   named "[LICENSE](./LICENSE)" in this directory.

   This distribution includes cryptographic software.  The country in 
   which you currently reside may have restrictions on the import, 
   possession, use, and/or re-export to another country, of 
   encryption software.  BEFORE using any encryption software, please 
   check your country's laws, regulations and policies concerning the
   import, possession, or use, and re-export of encryption software, to 
   see if this is permitted.  See <https://www.wassenaar.org/> for more
   information.

   The U.S. Government Department of Commerce, Bureau of Industry and
   Security (BIS), has classified this software as Export Commodity 
   Control Number (ECCN) 5D002.C.1, which includes information security
   software using or performing cryptographic functions with asymmetric
   algorithms.  The form and manner of this Apache Software Foundation
   distribution makes it eligible for export under the License Exception
   ENC Technology Software Unrestricted (TSU) exception (see the BIS 
   Export Administration Regulations, Section 740.13) for both object 
   code and source code.

   The following provides more details on the included cryptographic
   software:
   
   ActiveMQ supports the use of SSL TCP connections when used with 
   a JVM supporting the Java Cryptography extensions
   <https://www.oracle.com/java/technologies/javase/javase-tech-security.html>.
   ActiveMQ does not include these libraries itself, but is designed to use them.

