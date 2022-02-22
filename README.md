# MultiModuleDemo
Demo app to implement multiple modules. more than 2 apps with 1 common codebase

## Installation
```
1. Import maven repo in project gradle file

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  

2. add implementation in app lvel gradle file

dependencies {
	        implementation 'com.github.ahmerk-me:MultiModuleDemo:1.0.0'
	}
