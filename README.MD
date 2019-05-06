## ATextUtils 

[![license](http://img.shields.io/badge/license-Apache2.0-brightgreen.svg?style=flat)](https://github.com/Pinned/ATextUtils/blob/master/LICENSE) [![](https://jitpack.io/v/Pinned/ATextUtils.svg)](https://jitpack.io/#Pinned/ATextUtils) 

Android Logcat formatted data in a table format.



## Usage

1. Add it in your root build.gradle at the end of repositories:

   ```groovy
   allprojects {
   		repositories {
   			...
   			maven { url 'https://jitpack.io' }
   		}
   	}	
   ```

2. add dependences

   ```groovy
   dependencies {
   	        implementation 'com.github.Pinned:ATextUtils:1.0.0'
   	}
   ```

3. add the logic in the code

   ```java
   LogTable logTable = new LogTable();
   logTable.headers("A", "B", "C", "D", "E");
   logTable.rows("1", "2", "3", "4.3879146986541").end()
     .rows("1", "2.89132748", "3.43124", "4.3879146986541").end()
     .rows("1", "2", "3.84207187").end()
     .rows("1.1", "2", "3", "4.3879146986541").end();
   logTable.log();
   ```

